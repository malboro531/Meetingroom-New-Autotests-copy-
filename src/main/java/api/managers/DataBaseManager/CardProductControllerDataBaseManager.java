package api.managers.DataBaseManager;

import api.models.controllers.CardProductModel;
import lombok.SneakyThrows;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static constants.ApiDataBase.*;
import static constants.GlobalData.COUNT;

public class CardProductControllerDataBaseManager extends DataBaseAbstractManager <CardProductModel> {

    @Override
    public List<String> getAll() {
        throw new NotImplementedException();
    }

    @SneakyThrows
    public Integer getCountAllById() {
        int count = 0;
        resultSet = executeQuery(SQL_SELECT_CARD_PRODUCT_COUNT_BY_ID);
        while (resultSet.next()) {
            count = resultSet.getInt(COUNT);
        }
        return count;
    }

    @SneakyThrows
    public Integer getCountAllByLimits() {
        int count = 0;
        resultSet = executeQuery(SQL_SELECT_CARD_PRODUCT_COUNT_BY_LIMITS);
        while (resultSet.next()) {
            count = resultSet.getInt(COUNT);
        }
        return count;
    }

    @Override
    public void update(CardProductModel entity) {
        throw new NotImplementedException();
    }

    @Override
    public void create(CardProductModel entity) {
        throw new NotImplementedException();
    }

    @Override
    public CardProductModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return CardProductModel.builder()
                .cashback(resultSet.getInt("cashback"))
                .price(resultSet.getInt("price"))
                .advantages(resultSet.getString("advantages"))
                .bankPartners(resultSet.getString("bank_partners"))
                .loyaltyProgram(resultSet.getString("loyalty_program"))
                .maintenanceCost(resultSet.getInt("maintenance_cost"))
                .minSumBalance(resultSet.getInt("min_sum_balance"))
                .currency(resultSet.getString("currency"))
                .limits(resultSet.getString("limits"))
                .id(resultSet.getString("id"))
                .build();

    }

    @Override
    public int getMaxId() {
        throw new NotImplementedException();
    }
}
