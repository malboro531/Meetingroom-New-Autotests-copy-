package api.managers.DataBaseManager;

import api.models.controllers.deposit.*;
import lombok.SneakyThrows;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepositDataBaseManager extends DataBaseAbstractManager<DepositModel> {

    @SneakyThrows
    @Override
    public List<String> getAll() {
        throw new NotImplementedException("Method implementation not defined");
    }

    @Override
    public void update(DepositModel entity) {
        throw new NotImplementedException("Method implementation not defined");
    }

    @Override
    public void create(DepositModel entity) {
        throw new NotImplementedException("Method implementation not defined");
    }

    @Override
    public DepositModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return DepositModel.builder()
                .id(resultSet.getString("id"))
                .depositNumber(resultSet.getString("deposit_number"))
                .depositProductId(resultSet.getString("deposit_product_id"))
                .userId(resultSet.getString("user_id"))
                .type(new Type(resultSet.getString("deposit_type_id"), resultSet.getString("name")))
                .currency(new Currency(resultSet.getString("currency_id"), resultSet.getString("currency_name")))
                .termMonths(resultSet.getInt("term_months"))
                .openDate(resultSet.getString("open_date"))
                .closeDate(resultSet.getString("close_date"))
                .amount(resultSet.getInt("amount"))
                .interestRate(resultSet.getDouble("interest_rate"))
                .fixedInterest(resultSet.getBoolean("fixed_interest"))
                .subsequentReplenishment(resultSet.getBoolean("subsequent_replenishment"))
                .capitalization(resultSet.getBoolean("capitalization"))
                .isActive_status(resultSet.getBoolean("is_active"))
                .earlyWithdrawal(resultSet.getBoolean("early_withdrawal"))
                .interestWithdrawal(resultSet.getBoolean("interest_withdrawal"))
                .isRevocable(resultSet.getBoolean("is_revocable"))
                .build();
    }

    @Override
    public int getMaxId() {
        throw new NotImplementedException("Method implementation not defined");
    }
}
