package api.managers;

import api.models.TestRailAccount;
import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.TestRail.PROJECT_ID;

public class TestRailManager {

    private final APIClient client = TestRailAccount.getTestRailAccount();
    private Map<String, Serializable> dataForTestRail;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private String currentDate = simpleDateFormat.format(new Date());
    private JSONObject response = null;

    public void resetData() {
        dataForTestRail = new HashMap<>();
    }

    public String getId(JSONObject response) {
        return String.valueOf(response.get("id"));
    }

    public JSONObject getCase(String caseId) {
        try {
            response = (JSONObject) client.sendGet("get_case/" + caseId);
        } catch (IOException | APIException e) {
            e.printStackTrace();
        }
        return response;
    }

    public JSONObject getRun(String runId) {
        try {
            response = (JSONObject) client.sendGet("get_run/" + runId);
        } catch (IOException | APIException e) {
            e.printStackTrace();
        }
        return response;
    }

    public JSONObject addRun(List<String> caseIds, String thisClass) {
        resetData();
        dataForTestRail.put("name", "Automated Test Run " + thisClass + " " + currentDate);
        dataForTestRail.put("include_all", false);
        dataForTestRail.put("case_ids", (Serializable) caseIds);
        try {
            response = (JSONObject) client.sendPost("add_run/" + PROJECT_ID, dataForTestRail);
        } catch (IOException | APIException e) {
            e.printStackTrace();
        }
        return response;
    }

    public JSONObject setStatus(String runId, String caseId, int status, String comment) {
        resetData();
        dataForTestRail.put("status_id", status);
        dataForTestRail.put("comment", comment);
        try {
            response = (JSONObject) client.sendPost("add_result_for_case/" + runId + "/" + caseId, dataForTestRail);
        } catch (IOException | APIException e) {
            e.printStackTrace();
        }
        return response;
    }

    public void setAttachment(File file, String resultId) {
        if (file.exists()) {
            try {
                client.sendPost("add_attachment_to_result/" + resultId, "allure-results\\screenshot.png");
            } catch (Exception e) {
                e.printStackTrace();
            }
//Fixme
            file.delete();
        }
    }
}
