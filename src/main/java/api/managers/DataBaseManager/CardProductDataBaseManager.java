package api.managers.DataBaseManager;

import api.models.controllers.CardModel;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static constants.ApiDataBase.*;
import static constants.GlobalData.COUNT;

public class CardProductDataBaseManager extends DataBaseAbstractManager<CardModel> {

    @Override
    public List<String> getAll() {
        return null;
    }

    @SneakyThrows
    public Integer getCountAll() {
        int count = 0;
        resultSet = executeQuery(SQL_SELECT_All_CARD_COUNT);
        while (resultSet.next()) {
            count = resultSet.getInt(COUNT);
        }
        return count;
    }

    @SneakyThrows
    public Integer getCountAllById(String id) {
        int count = 0;
        resultSet = executeQuery(String.format(SQL_SELECT_CARDS_BY_ID_COUNT, id));
        while (resultSet.next()) {
            count = resultSet.getInt(COUNT);
        }
        return count;
    }

    @Override
    public void update(CardModel entity) {
//TODO
    }

    @Override
    public void create(CardModel entity) {
//TODO
    }

    @Override
    public CardModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return CardModel.builder()
                .id(resultSet.getString("id"))
                .accountId(resultSet.getString("account_id"))
                .cardProductId(resultSet.getString("card_product_id"))
                .holderName(resultSet.getString("holder_name"))
                .build();
    }

    @Override
    public int getMaxId() {
        return 0;
    }
}