package api.managers.DataBaseManager;

import api.models.controllers.CreditAccountsModel;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static constants.ApiDataBase.*;
import static constants.GlobalData.COUNT;

public class CreditAccountDataBaseManager extends DataBaseAbstractManager<CreditAccountsModel> {
    @Override
    public List<String> getAll() {
        throw new NotImplementedException();
    }

    @Override
    public void update(CreditAccountsModel entity) {
        throw new NotImplementedException();
    }

    @Override
    public void create(CreditAccountsModel entity) {
        throw new NotImplementedException();
    }

    @Override
    public CreditAccountsModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return CreditAccountsModel.builder()
                .id(resultSet.getString("id"))
                .ownerId(resultSet.getString("owner_id"))
                .openDate(resultSet.getString("open_date"))
                .closeDate(resultSet.getString("close_date"))
                .bankName(resultSet.getString("bank_name"))
                .accountNumber(resultSet.getString("account_number"))
                .currencyName(resultSet.getString("currency"))
                .balance(resultSet.getInt("balance"))
                .borrowingLimit(resultSet.getInt("borrowing_limit"))
                .nextDateTemp(resultSet.getString("next_date_temp"))
                .build();
    }

    @Override
    public int getMaxId() {
        throw new NotImplementedException();
    }

    public Integer getCountAll() {
        int count = 0;
        try {
            resultSet = executeQuery(SQL_SELECT_CREDIT_ACCOUNTS_COUNT);
            while (resultSet.next()) {
                count = resultSet.getInt(COUNT);
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return count;
    }

    public Integer getCountAllById(String id) {
        int count = 0;
        try {
            resultSet = executeQuery(String.format(SQL_SELECT_CREDIT_ACCOUNTS_ID_COUNT, id));
            while (resultSet.next()) {
                count = resultSet.getInt(COUNT);
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return count;
    }

    public Integer getCountAllByOwnerIdUser(String owner_id) {
        int count = 0;
        try {
            resultSet = executeQuery(String.format(SQL_SELECT_CREDIT_ACCOUNTS_COUNT_BY_OWNER_ID_USER, owner_id));
            while (resultSet.next()) {
                count = resultSet.getInt(COUNT);
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return count;
    }
}
