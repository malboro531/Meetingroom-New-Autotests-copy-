package api.managers.DataBaseManager.util;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultSetParser {

    @SneakyThrows
    public static JSONObject getJSONFromResultSet(String sql) {
        List<JSONObject> jsonListFromResultSet = getJSONListFromResultSet(sql);
        return jsonListFromResultSet.get(jsonListFromResultSet.size() - 1);
    }

    @SneakyThrows
    public static <T> T castToObject(String sql, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(getJSONFromResultSet(sql).toString(), clazz);
    }

    @SneakyThrows
    public static List<JSONObject> getJSONListFromResultSet(String sql) {
        List<JSONObject> listJsonObjects = new ArrayList<>();
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                JSONObject jsonObject = new JSONObject();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i);
                    Object columnValue = resultSet.getObject(i);
                    jsonObject.put(columnName, columnValue);
                }
                listJsonObjects.add(jsonObject);
            }
        }
        return listJsonObjects;
    }

    @SneakyThrows
    public static <T> List<T> castToListObjects(String sql, Class<T> clazz) {
        Gson gson = new Gson();
        return getJSONListFromResultSet(sql)
                .stream()
                .map(jsonObject -> gson.fromJson(jsonObject.toString(), clazz))
                .collect(Collectors.toList());
    }
}
