package api.managers.DataBaseManager;

import api.models.controllers.CreditCardProductModel;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static constants.ApiDataBase.SQL_SELECT_CREDIT_CARD_PRODUCTS_COUNT;
import static constants.GlobalData.COUNT;

public class CreditCardProductDataBaseManager extends DataBaseAbstractManager<CreditCardProductModel> {

    @Override
    public List<String> getAll() {
        throw new NotImplementedException();
    }

    @Override
    public void update(CreditCardProductModel entity) {
        throw new NotImplementedException();
    }

    @Override
    public void create(CreditCardProductModel entity) {
        throw new NotImplementedException();
    }

    @Override
    public CreditCardProductModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return CreditCardProductModel.builder()
                .id(resultSet.getString("id"))
                .cashback(resultSet.getInt("cashback"))
                .price(resultSet.getDouble("price"))
                .advantages(resultSet.getString("advantages"))
                .bankPartners(resultSet.getString("bank_partners"))
                .loyaltyProgram(resultSet.getString("loyalty_program"))
                .maintenanceCost(resultSet.getInt("maintenance_cost"))
                .minSumBalance(resultSet.getInt("min_sum_balance"))
                .currency(resultSet.getString("currency"))
                .typeCardId(resultSet.getString("type_card_id"))
                .build();
    }

    @Override
    public int getMaxId() {
        throw new NotImplementedException();
    }

    public Integer getCountAll() {
        int count = 0;
        try {
            resultSet = executeQuery(SQL_SELECT_CREDIT_CARD_PRODUCTS_COUNT);
            while (resultSet.next()) {
                count = resultSet.getInt(COUNT);
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return count;
    }
}
