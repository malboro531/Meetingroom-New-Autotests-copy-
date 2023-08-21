package api.managers.DataBaseManager;

import api.models.controllers.CreditOrderModel;
import lombok.SneakyThrows;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static constants.ApiDataBase.SQL_SELECT_CREDIT_ORDERS;
import static constants.ApiDataBase.SQL_SELECT_CREDIT_ORDERS_BY_OWNER_ID_COUNT;
import static constants.GlobalData.COUNT;

public class CreditOrderDataBaseManager extends DataBaseAbstractManager<CreditOrderModel> {


    @Override
    public List<String> getAll() {
        throw new NotImplementedException();
    }

    @Override
    public void update(CreditOrderModel entity) {
        throw new NotImplementedException();
    }

    @Override
    public void create(CreditOrderModel entity) {
        throw new NotImplementedException();
    }

    @Override
    public CreditOrderModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return CreditOrderModel.builder()
                .id(resultSet.getString("id"))
                .ownerId(resultSet.getString("owner_id"))
                .creditProductId(resultSet.getString("credit_products_id"))
                .status(resultSet.getString("status"))
                .creationDate(resultSet.getString("creation_date"))
                .amount(resultSet.getInt("amount"))
                .tempCredit(resultSet.getInt("temp_credit"))
                .loanRate(resultSet.getDouble("loan_rate"))
                .averageMonthlyIncome(resultSet.getInt("average_monthly_income"))
                .averageMonthlyExpenditure(resultSet.getInt("average_monthly_expenditure"))
                .employerId(resultSet.getString("employer_identification_id"))
                .build();
    }

    @Override
    public int getMaxId() {
        throw new NotImplementedException();
    }

    @SneakyThrows
    public Integer getCountAllByOwnerId(String id) {
        int count = 0;
        resultSet = executeQuery(String.format(SQL_SELECT_CREDIT_ORDERS_BY_OWNER_ID_COUNT, id));
        while (resultSet.next()) {
            count = resultSet.getInt(COUNT);
        }
        return count;
    }

    @SneakyThrows
    public Integer getCountAll() {
        int count = 0;
        resultSet = executeQuery(String.format(SQL_SELECT_CREDIT_ORDERS));
        while (resultSet.next()) {
            count = resultSet.getInt(COUNT);
        }
        return count;
    }
}
