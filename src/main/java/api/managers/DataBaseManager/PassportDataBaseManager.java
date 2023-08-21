package api.managers.DataBaseManager;

import api.models.controllers.PassportModel;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static constants.ApiDataBase.*;
import static constants.ApiPassportData.*;

public class PassportDataBaseManager extends DataBaseAbstractManager<PassportModel> {

    @SneakyThrows
    @Override
    public List<String> getAll() {
        resultSet = executeQuery(SQL_SELECT_ALL_FROM_PASSPORT);
        while (resultSet.next()) {
            allIds.add(String.valueOf(extractFromResultSet(resultSet)));
        }
        return allIds;
    }

    @SneakyThrows
    @Override
    public void update(PassportModel passport) {
        executeUpdate(sqlInsert(passport));
        resultSet = executeQuery(sqlSelect(passport));
        while (resultSet.next()) {
            String id = resultSet.getString(API_ID);
            addId(id);
            logger.info("Row from passport table with id " + id + " was updated in passport DB");
        }
    }

    @Override
    public void delete() {
        for (String id : allIds) {
            executeUpdate(String.format(SQL_DELETE_FROM_PASSPORT, id));
            logger.info("Row with id " + id + " was deleted from passport DB");
        }
    }

    @SneakyThrows
    @Override
    public void create(PassportModel passport) {
        executeUpdate(sqlInsert(passport));
        resultSet = executeQuery(sqlSelect(passport));
        while (resultSet.next()) {
            String id = resultSet.getString(API_ID);
            addId(id);
            logger.info("Row from passport table with id " + id + " was created in DB");
        }
    }

    @Override
    public PassportModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return PassportModel.builder()
                .id(Integer.parseInt(resultSet.getString(API_ID)))
                .userId(resultSet.getString(API_USER_ID))
                .addressId(Integer.parseInt(resultSet.getString(API_ADDRESS_ID)))
                .serialNumber(resultSet.getString(API_SERIAL_NUMBER))
                .passportCode(resultSet.getString(API_PASSPORT_CODE))
                .birthday(resultSet.getString(API_BIRTHDAY))
                .dateIssue(resultSet.getString(API_DATE_ISSUE))
                .terminationDate(resultSet.getString(API_TERMINATION_DATE))
                .firstName(resultSet.getString(API_FIRST_NAME))
                .lastName(resultSet.getString(API_LAST_NAME))
                .patronymic(resultSet.getString(API_PATRONYMIC))
                .bornPlace(resultSet.getString(API_BORN_PLACE))
                .departmentIssued(resultSet.getString(API_DEPARTMENT_ISSUED))
                .build();
    }

    @SneakyThrows
    @Override
    public int getMaxId() {
        resultSet = executeQuery(SQL_SELECT_MAX_ID_FROM_PASSPORT);
        return resultSet.findColumn(API_ID);
    }

    public static String sqlInsert(PassportModel passport) {
        return String.format(SQL_INSERT_INTO_PASSPORT,
                passport.getId(),
                passport.getUserId(),
                passport.getAddressId(),
                passport.getSerialNumber(),
                passport.getPassportCode(),
                passport.getBirthday(),
                passport.getDateIssue(),
                passport.getTerminationDate(),
                passport.getFirstName(),
                passport.getLastName(),
                passport.getPatronymic(),
                passport.getBornPlace(),
                passport.getDepartmentIssued());
    }

    public String sqlSelect(PassportModel passport) {
        return String.format(SQL_SELECT_FROM_PASSPORT, passport.getUserId());
    }
}
