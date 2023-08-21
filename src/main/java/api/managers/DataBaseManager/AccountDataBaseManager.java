package api.managers.DataBaseManager;

import api.models.controllers.AccountModel;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static constants.ApiDataBase.*;

public class AccountDataBaseManager extends DataBaseAbstractManager<AccountModel> {

    @SneakyThrows
    @Override
    public List<String> getAll() {
        resultSet = executeQuery(SQL_SELECT_ALL_FROM_ACCOUNT);
        while (resultSet.next()) {
            allIds.add(String.valueOf(extractFromResultSet(resultSet)));
        }
        return allIds;
    }

    @Override
    public void update(AccountModel entity) {

    }

    public void deleteAccount(String id) {
        executeUpdate(String.format(SQL_DELETE_ACCOUNT_BY_ID, id));
    }

    @Override
    public void create(AccountModel entity) {

    }

    @Override
    public AccountModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return AccountModel.builder()
                .id(resultSet.getString("id"))
                .accountNumber(resultSet.getString("account_number"))
                .ownerId(resultSet.getString("owner_id"))
                .openDate(resultSet.getString("open_date"))
                .closeDate(resultSet.getString("close_date"))
                .currency(resultSet.getString("currency"))
                .bankName(resultSet.getString("bank_name"))
                .balance(Integer.parseInt(resultSet.getString("balance")))
                .build();
    }

    @Override
    public int getMaxId() {
        return 0;
    }
}