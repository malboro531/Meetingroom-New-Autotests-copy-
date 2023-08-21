package api.managers.DataBaseManager;

import api.models.controllers.TransferModel;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static constants.ApiDataBase.SQL_SELECT_ALL_TRANSFERS_FOR_USER_COUNT;
import static constants.GlobalData.COUNT;

public class TransferDataBaseManager extends DataBaseAbstractManager<TransferModel> {

    @Override
    public List<String> getAll() {
        return null;
    }

    @SneakyThrows
    public Integer getCountAll(String userId) {
        int count = 0;
        resultSet = executeQuery(String.format(SQL_SELECT_ALL_TRANSFERS_FOR_USER_COUNT, userId));
        while (resultSet.next()) {
            count = resultSet.getInt(COUNT);
        }
        return count;
    }

    @Override
    public void update(TransferModel entity) {
        //TODO
    }

    @Override
    public void create(TransferModel entity) {
        //TODO
    }

    @Override
    public TransferModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public int getMaxId() {
        return 0;
    }
}