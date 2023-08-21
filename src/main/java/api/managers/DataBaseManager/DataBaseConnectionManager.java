package api.managers.DataBaseManager;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static constants.ApiDataBase.*;

public class DataBaseConnectionManager {

    @Getter
    private static final Logger logger = LogManager.getLogger(DataBaseConnectionManager.class);

    private static Connection connection;

    private static Statement statement;

    protected static ResultSet resultSet;

    @Getter
    private static List<String> allIds = new ArrayList<>();

    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            statement = connection.createStatement();
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    public static void closeConnection() {
        try {
            allIds.clear();
            if (resultSet != null) {
                resultSet.close();
            }
            connection.close();
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    public static ResultSet executeQuery(String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public static int executeUpdate(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<String> getAllIds() {
        return allIds;
    }

    public static void addId(String id) {
        allIds.add(id);
    }

}