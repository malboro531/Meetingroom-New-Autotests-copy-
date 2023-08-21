package api.managers.DataBaseManager;

import api.models.controllers.CreditModel;
import lombok.SneakyThrows;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static constants.ApiDataBase.*;
import static constants.GlobalData.COUNT;

public class CreditProductDataBaseManager extends DataBaseAbstractManager<CreditModel> {
    @SneakyThrows
    @Override
    public List<String> getAll() {
        throw new NotImplementedException();
    }

    @SneakyThrows
    @Override
    public void update(CreditModel entity) {
            throw new NotImplementedException();
        }

    @Override
    public void create(CreditModel entity)  {
        throw new NotImplementedException();
    }

    @Override
    public CreditModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return CreditModel.builder()
                .id(resultSet.getString("id"))
                .creditName(resultSet.getString("product_name"))
                .minSum(resultSet.getInt("min_sum"))
                .maxSum(resultSet.getInt("max_sum"))
                .currency(resultSet.getString("currency"))
                .loanRate(resultSet.getDouble("loan_rate"))
                .needQuarantee(resultSet.getBoolean("need_guarantee"))
                .earlyRepayment(resultSet.getBoolean("early_repayment"))
                .minTerm(resultSet.getInt("min_term"))
                .maxTerm(resultSet.getInt("max_term"))
                .multiplicityOfSum(resultSet.getInt("multiplicity_of_sum"))
                .multiplicityOfTemp(resultSet.getInt("multiplicity_of_temp"))
                .description(resultSet.getString("description"))
                .penaltyId(resultSet.getString("penalty"))
                .needIncomeStatement(resultSet.getBoolean("need_income_statement"))
                .active(resultSet.getBoolean("is_active"))
                .build();
    }

    @Override
    public int getMaxId()  {
        throw new NotImplementedException();
    }

    @SneakyThrows
    public Integer getCountAllCreditProducts() {
        int count = 0;
        resultSet = executeQuery(SQL_SELECT_CREDIT_PRODUCTS_COUNT);
        while (resultSet.next()) {
            count = resultSet.getInt(COUNT);
        }
        return count;
    }
}
