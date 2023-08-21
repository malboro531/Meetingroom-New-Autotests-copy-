package api.managers.DataBaseManager;

import api.models.controllers.CreditCardModel;
import lombok.SneakyThrows;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static constants.ApiDataBase.*;
import static constants.GlobalData.COUNT;

public class CreditCardDataBaseManager extends DataBaseAbstractManager<CreditCardModel> {
    @Override
    public List<String> getAll() {
        throw new NotImplementedException();
    }

    @Override
    public void update(CreditCardModel entity) {
        throw new NotImplementedException();
    }

    @Override
    public void create(CreditCardModel entity) {
        throw new NotImplementedException();
    }

    @Override
    public CreditCardModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return CreditCardModel.builder()
                .id(resultSet.getString("id"))
                .accountId(resultSet.getString("account_id"))
                .firstTwelveNumbers(resultSet.getString("first_twelve_numbers"))
                .lastFourNumbers(resultSet.getString("last_four_numbers"))
                .validFromDate(resultSet.getString("valid_from_date"))
                .expireDate(resultSet.getString("expire_date"))
                .holderName(resultSet.getString("holder_name"))
                .isActive(resultSet.getBoolean("is_active"))
                .securityCode(resultSet.getString("security_code"))
                .cardProductId(resultSet.getString("credit_card_product_id"))
                .build();
    }

    @Override
    public int getMaxId() {
        throw new NotImplementedException();
    }

    public Integer getCountAll() {
        int count = 0;
        try {
            resultSet = executeQuery(SQL_SELECT_CREDIT_CARDS_COUNT);
            while (resultSet.next()) {
                count = resultSet.getInt(COUNT);
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return count;
    }

    @SneakyThrows
    public Integer getCountAllById(String id) {
        int count = 0;
        resultSet = executeQuery(String.format(SQL_SELECT_CREDIT_CARDS_BY_ID_COUNT, id));
        while (resultSet.next()) {
            count = resultSet.getInt(COUNT);
        }
        return count;
    }
}
