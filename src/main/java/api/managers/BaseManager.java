package api.managers;

import api.models.ErrorMessageModel;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static constants.Messages.RESPONSE_IS_EMPTY;

public abstract class BaseManager {

    private static final Logger logger = LogManager.getLogger(BaseManager.class);

    protected static Retrofit initialise(String URL) {
        return new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public <T> String getErrorMessage(Response<T> response) {
        if (response.body() == null) {
            if (response.errorBody() == null) {
                logger.info(RESPONSE_IS_EMPTY);
            } else {
                try {
                    String responseBodyString = response.errorBody().string();
                    if (!isJsonValid(responseBodyString)) {
                        return responseBodyString;
                    } else {
                        ErrorMessageModel errorMessageModel = new Gson().fromJson(responseBodyString, ErrorMessageModel.class);
                        return errorMessageModel.getMessage();
                    }
                } catch (IOException e) {
                    logger.error(e);
                }
            }
        }
        return Strings.EMPTY;
    }

    public <T> Response<T> getResponse(Call<T> call) {
        Response<T> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            logger.error(e);
        }
        return response;
    }

    private boolean isJsonValid(String jsonString) {
        Gson gson = new Gson();
        try {
            gson.fromJson(jsonString, ErrorMessageModel.class);
            return true;
        } catch (JsonSyntaxException ex) {
            return false;
        }
    }
}
