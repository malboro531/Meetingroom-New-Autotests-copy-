package api.managers.DataBaseManager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static api.managers.DataBaseManager.util.PropertyUtil.getProperty;

public class ConnectionManager {

    private static final String URL = "database.url";
    private static final String USERNAME = "database.username";
    private static final String PASSWORD = "database.password";

    private ConnectionManager() {
    }

    public static Connection open() {
        try {
            return DriverManager.getConnection(getProperty(URL), getProperty(USERNAME), getProperty(PASSWORD));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
