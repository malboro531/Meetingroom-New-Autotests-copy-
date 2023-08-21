package api.managers.DataBaseManager;

import api.models.controllers.UserModel;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static constants.ApiAddressData.API_EMAIL;
import static constants.ApiAddressData.API_PHONE;
import static constants.ApiDataBase.*;
import static constants.ApiPassportData.*;

public class UserDataBaseManager extends DataBaseAbstractManager<UserModel> {

    @SneakyThrows
    @Override
    public List<String> getAll() {
        resultSet = executeQuery(SQL_SELECT_ALL_FROM_USERS);
        while (resultSet.next()) {
            allIds.add(String.valueOf(extractFromResultSet(resultSet)));
        }
        return allIds;
    }

    @SneakyThrows
    @Override
    public void update(UserModel user) {
        executeUpdate(sqlInsert(user));
        resultSet = executeQuery(sqlSelect(user));
        while (resultSet.next()) {
            String id = resultSet.getString(API_ID);
            addId(id);
            logger.info("Row from user table with id " + id + " was updated in user DB");
        }
    }

    @Override
    public void delete() {
        for (String id : allIds) {
            executeUpdate(String.format(SQL_DELETE_FROM_USERS, id));
            logger.info("Row with id " + id + " was deleted from users DB");
        }
    }

    @SneakyThrows
    @Override
    public void create(UserModel user) {
        executeUpdate(sqlInsert(user));
        resultSet = executeQuery(sqlSelect(user));
        while (resultSet.next()) {
            String id = resultSet.getString(API_ID);
            addId(id);
            logger.info("Row from user table with id " + id + " was created in users DB");
        }
    }

    @Override
    public UserModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return UserModel.builder()
                .id(resultSet.getString(API_ID))
                .firstName(resultSet.getString(API_FIRST_NAME))
                .lastName(resultSet.getString(API_LAST_NAME))
                .patronymic(resultSet.getString(API_PATRONYMIC))
                .email(resultSet.getString(API_EMAIL))
                .phone(resultSet.getString(API_PHONE))
                .build();
    }

    @SneakyThrows
    @Override
    public int getMaxId() {
        resultSet = executeQuery(SQL_SELECT_MAX_ID_FROM_PASSPORT);
        return resultSet.getInt(API_ID);
    }

    public static String sqlInsert(UserModel user) {
        return String.format(SQL_INSERT_INTO_USERS,
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPatronymic(),
                user.getEmail(),
                user.getPhone());
    }

    public String sqlSelect(UserModel user) {
        return String.format(SQL_SELECT_FROM_USERS, user.getId());
    }
}
