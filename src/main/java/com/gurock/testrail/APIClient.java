/**
 * TestRail API binding for Java (API v2, available since TestRail 3.0)
 * Updated for TestRail 5.7
 * <p>
 * Learn more:
 * <p>
 * http://docs.gurock.com/testrail-api2/start
 * http://docs.gurock.com/testrail-api2/accessing
 * <p>
 * Copyright Gurock Software GmbH. See license.md for details.
 */

package com.gurock.testrail;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

import static org.asynchttpclient.util.HttpConstants.Methods.GET;
import static org.asynchttpclient.util.HttpConstants.Methods.POST;

public class APIClient {

    private String m_user;
    private String m_password;
    private String m_url;

    public APIClient(String base_url) {
        if (!base_url.endsWith("/")) {
            base_url += "/";
        }
        this.m_url = base_url + "index.php?/api/v2/";
    }

    /**
     * Get/Set User
     * <p>
     * Returns/sets the user used for authenticating the API requests.
     */
    public String getUser() {
        return m_user;
    }

    public void setUser(String user) {
        this.m_user = user;
    }

    /**
     * Get/Set Password
     * <p>
     * Returns/sets the password used for authenticating the API requests.
     */
    public String getPassword() {
        return m_password;
    }

    public void setPassword(String password) {
        this.m_password = password;
    }

    /**
     * Send Get
     * <p>
     * Issues a GET request (read) against the API and returns the result
     * (as Object, see below).
     * <p>
     * Arguments:
     * <p>
     * uri                  The API method to call including parameters
     * (e.g. get_case/1)
     * <p>
     * Returns the parsed JSON response as standard object which can
     * either be an instance of JSONObject or JSONArray (depending on the
     * API method). In most cases, this returns a JSONObject instance which
     * is basically the same as java.util.Map.
     * <p>
     * If 'get_attachment/:attachment_id', returns a String
     */
    public Object sendGet(String uri, String data) throws MalformedURLException, IOException, APIException {
        return sendRequest(GET, uri, data);
    }

    public Object sendGet(String uri) throws MalformedURLException, IOException, APIException {
        return sendRequest(GET, uri, null);
    }

    /**
     * Send POST
     * <p>
     * Issues a POST request (write) against the API and returns the result
     * (as Object, see below).
     * <p>
     * Arguments:
     * <p>
     * uri                  The API method to call including parameters
     * (e.g. add_case/1)
     * data                 The data to submit as part of the request (e.g.,
     * a map)
     * If adding an attachment, must be the path
     * to the file
     * <p>
     * Returns the parsed JSON response as standard object which can
     * either be an instance of JSONObject or JSONArray (depending on the
     * API method). In most cases, this returns a JSONObject instance which
     * is basically the same as java.util.Map.
     */
    public Object sendPost(String uri, Object data) throws MalformedURLException, IOException, APIException {
        return sendRequest(POST, uri, data);
    }

    private Object sendRequest(String method, String uri, Object data) throws MalformedURLException, IOException, APIException {
        URL url = new URL(this.m_url + uri);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        String auth = getAuthorization(this.m_user, this.m_password);
        conn.addRequestProperty("Authorization", "Basic " + auth);

        if (method.equals(POST)) {
            conn.setRequestMethod(POST);
            if (data != null) {
                if (uri.startsWith("add_attachment")) {
                    String boundary = "TestRailAPIAttachmentBoundary";
                    File uploadFile = new File((String) data);

                    conn.setDoOutput(true);
                    conn.addRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

                    OutputStream ostreamBody = conn.getOutputStream();
                    BufferedWriter bodyWriter = new BufferedWriter(new OutputStreamWriter(ostreamBody));

                    bodyWriter.write("\n\n--" + boundary + "\r\n");
                    bodyWriter.write("Content-Disposition: form-data; name=\"attachment\"; filename=\"" + uploadFile.getName() + "\"");
                    bodyWriter.write("\r\n\r\n");
                    bodyWriter.flush();

                    InputStream istreamFile = new FileInputStream(uploadFile);
                    int bytesRead;
                    byte[] dataBuffer = new byte[1024];
                    while ((bytesRead = istreamFile.read(dataBuffer)) != -1) {
                        ostreamBody.write(dataBuffer, 0, bytesRead);
                    }

                    ostreamBody.flush();

                    bodyWriter.write("\r\n--" + boundary + "--\r\n");
                    bodyWriter.flush();

                    istreamFile.close();
                    ostreamBody.close();
                    bodyWriter.close();
                } else {
                    conn.addRequestProperty("Content-Type", "application/json");
                    byte[] block = JSONValue.toJSONString(data).getBytes("UTF-8");

                    conn.setDoOutput(true);
                    OutputStream ostream = conn.getOutputStream();
                    ostream.write(block);
                    ostream.close();
                }
            }
        } else {
            conn.addRequestProperty("Content-Type", "application/json");
        }

        int status = conn.getResponseCode();

        InputStream istream;
        if (status != 200) {
            istream = conn.getErrorStream();
            if (istream == null) {
                throw new APIException("TestRail API return HTTP " + status + " (No additional error message received)");
            }
        } else {
            istream = conn.getInputStream();
        }

        if ((istream != null) && (uri.startsWith("get_attachment/"))) {
            FileOutputStream outputStream = new FileOutputStream((String) data);

            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = istream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            istream.close();
            return (String) data;
        }

        String text = "";
        if (istream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(istream, "UTF-8"));

            String line;
            while ((line = reader.readLine()) != null) {
                text += line;
                text += System.getProperty("line.separator");
            }

            reader.close();
        }

        Object result;
        if (!text.equals("")) {
            result = JSONValue.parse(text);
        } else {
            result = new JSONObject();
        }

        if (status != 200) {
            String error = "No additional error message received";
            if (result != null && result instanceof JSONObject) {
                JSONObject obj = (JSONObject) result;
                if (obj.containsKey("error")) {
                    error = '"' + (String) obj.get("error") + '"';
                }
            }

            throw new APIException("TestRail API returned HTTP " + status + "(" + error + ")");
        }

        return result;
    }

    private static String getAuthorization(String user, String password) {
        try {
            return new String(Base64.getEncoder().encode((user + ":" + password).getBytes()));
        } catch (IllegalArgumentException e) {
        }
        return "";
    }
}
