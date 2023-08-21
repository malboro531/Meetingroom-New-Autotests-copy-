package api.managers.DataBaseManager;

import api.models.controllers.CreditPenaltyModel;
import lombok.SneakyThrows;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static constants.ApiDataBase.*;
import static constants.GlobalData.COUNT;

public class CreditPenaltyDataBaseManager extends DataBaseAbstractManager<CreditPenaltyModel> {


    @Override
    public List<String> getAll() {
        throw new NotImplementedException();
    }

    @Override
    public void update(CreditPenaltyModel entity) {
        throw new NotImplementedException();
    }

    @Override
    public void create(CreditPenaltyModel entity) {
        throw new NotImplementedException();
    }

    @Override
    public CreditPenaltyModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return CreditPenaltyModel.builder()
                .id(resultSet.getString("id"))
                .name(resultSet.getString("name_penalty"))
                .percent(resultSet.getDouble("percent_penalty"))
                .amountMin(resultSet.getInt("amount_min_penalty"))
                .maxPercent(resultSet.getDouble("max_percent_penalty"))
                .amountMax(resultSet.getInt("amount_max_penalty"))
                .isPenny(resultSet.getBoolean("type_penalty"))
                .build();
    }

    @Override
    public int getMaxId() {
        throw new NotImplementedException();
    }
}
