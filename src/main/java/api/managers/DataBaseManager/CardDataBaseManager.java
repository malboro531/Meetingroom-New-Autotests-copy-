package api.managers.DataBaseManager;

import api.models.controllers.CardModel;
import lombok.SneakyThrows;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static constants.ApiDataBase.*;

public class CardDataBaseManager extends DataBaseAbstractManager<CardModel> {

    @Override
    public List<String> getAll() {
        throw new NotImplementedException();
    }

    @Override
    public void update(CardModel entity) {
        throw new NotImplementedException("Method implementation not defined");
    }

    @Override
    public void create(CardModel entity) {
        throw new NotImplementedException("Method implementation not defined");
    }

    @Override
    public CardModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return CardModel.builder()
                .id(resultSet.getString("id"))
                .accountId(resultSet.getString("account_id"))
                .firstTwelveNumbersHash(resultSet.getString("first_twelve_numbers"))
                .lastFourNumbers(resultSet.getString("last_four_numbers"))
                .validFromDate(resultSet.getString("valid_from_date"))
                .expireDate(resultSet.getString("expire_date"))
                .holderName(resultSet.getString("holder_name"))
                .cardProductId(resultSet.getString("card_product_id"))
                .isActive(resultSet.getBoolean("is_active"))
                .cardStatus(resultSet.getString("card_status"))
                .isMain(resultSet.getBoolean("is_main"))
                .contractId(resultSet.getString("contract_id"))
                .build();
    }

    @Override
    public int getMaxId() {
        throw new NotImplementedException("Method implementation not defined");
    }
}
