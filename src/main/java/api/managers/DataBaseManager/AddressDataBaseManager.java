package api.managers.DataBaseManager;

import api.models.controllers.AddressModel;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static constants.ApiAddressData.*;
import static constants.ApiDataBase.*;
import static constants.ApiPassportData.API_ID;
import static constants.ApiPassportData.API_USER_ID;
import static constants.GlobalData.COUNT;

public class AddressDataBaseManager extends DataBaseAbstractManager<AddressModel> {

    @SneakyThrows
    @Override
    public List<String> getAll() {
        resultSet = executeQuery(SQL_SELECT_ALL_FROM_ADDRESS);
        while (resultSet.next()) {
            allIds.add(String.valueOf(extractFromResultSet(resultSet)));
        }
        return allIds;
    }

    @SneakyThrows
    //@Override
    public Integer getCountAll() {
        int count = 0;
        resultSet = executeQuery(SQL_SELECT_ADDRESS_COUNT);
        while (resultSet.next()) {
            count = resultSet.getInt(COUNT);
        }
        return count;
    }

    @SneakyThrows
    @Override
    public void update(AddressModel address) {
        executeUpdate(sqlInsert(address));
        resultSet = executeQuery(sqlSelect(address));
        while (resultSet.next()) {
            String id = resultSet.getString(API_ID);
            addId(id);
            logger.info("Row from address table with id " + id + " was updated in DB");
        }
    }

    @Override
    public void delete() {
        for (String id : allIds) {
            executeUpdate(String.format(SQL_DELETE_FROM_ADDRESS, id));
            logger.info("Row with id " + id + " was deleted from address DB");
        }
    }

    @SneakyThrows
    @Override
    public void create(AddressModel address) {
        executeUpdate(sqlInsert(address));
        resultSet = executeQuery(sqlSelect(address));
        while (resultSet.next()) {
            String id = resultSet.getString(API_ID);
            addId(id);
            logger.info("Row from address table with id " + id + " was created in DB");
        }
    }

    @Override
    public AddressModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return AddressModel.builder()
                .id(Integer.parseInt(resultSet.getString(API_ID)))
                .userId(resultSet.getString(API_USER_ID))
                .zipCode(Integer.parseInt(resultSet.getString(API_ZIP_CODE)))
                .country(resultSet.getString(API_COUNTRY))
                .region(resultSet.getString(API_REGION))
                .location(resultSet.getString(API_LOCATION))
                .city(resultSet.getString(API_CITY))
                .street(resultSet.getString(API_STREET))
                .house(resultSet.getString(API_HOUSE))
                .building(resultSet.getString(API_BUILDING))
                .flat(resultSet.getString(API_FLAT))
                .build();
    }

    @SneakyThrows
    @Override
    public int getMaxId() {
        int id = 0;
        resultSet = executeQuery(SQL_SELECT_MAX_ID_FROM_ADDRESS);
        while (resultSet.next()) {
            id = resultSet.getInt(API_ID);
        }
        return id;
    }

    public static String sqlInsert(AddressModel address) {
        return String.format(SQL_INSERT_INTO_ADDRESS,
                address.getId(),
                address.getUserId(),
                address.getZipCode(),
                address.getCountry(),
                address.getRegion(),
                address.getLocation(),
                address.getCity(),
                address.getStreet(),
                address.getHouse(),
                address.getBuilding(),
                address.getFlat());
    }

    public String sqlSelect(AddressModel address) {
        return String.format(SQL_SELECT_FROM_ADDRESS, address.getUserId());
    }
}