package api.managers.DataBaseManager;

import api.models.controllers.RegularPaymentModel;
import lombok.SneakyThrows;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static constants.ApiDataBase.*;
import static constants.GlobalData.COUNT;

public class RegularPaymentDataBaseManager extends DataBaseAbstractManager<RegularPaymentModel> {

    @SneakyThrows
    @Override
    public List<String> getAll() {
        throw new NotImplementedException();
    }

    @SneakyThrows
    public Integer getCountAll() {
        int count = 0;
        resultSet = executeQuery(SQL_SELECT_ALL_REGULAR_PAYMENTS_COUNT);
        while (resultSet.next()) {
            count = resultSet.getInt(COUNT);
        }
        return count;
    }

    @SneakyThrows
    @Override
    public void update(RegularPaymentModel entity) {
        throw new NotImplementedException();
    }

    @SneakyThrows
    @Override
    public void create(RegularPaymentModel entity) {
        throw new NotImplementedException();
    }

    public void deleteRegularPayment(String id) {
        if (id != null && !id.isEmpty()) {
            executeUpdate(String.format(SQL_DELETE_REGULAR_PAYMENT_BY_ID, id));
        } else {
            logger.info("Payment can not be deleted: id is empty");
        }
    }

    @Override
    public RegularPaymentModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return RegularPaymentModel.builder()
                .id(resultSet.getString("id"))
                .description(resultSet.getString("payment_description"))
                .startDate(resultSet.getString("start_date"))
                .nextDate(resultSet.getString("next_date"))
                .sourceCardId(resultSet.getString("source_card_id"))
                .recipientCardId(resultSet.getString("recipient_card_id"))
                .amount(resultSet.getInt("amount"))
                .frequency(resultSet.getString("frequency"))
                .active(resultSet.getBoolean("is_active"))
                .build();
    }

    @SneakyThrows
    @Override
    public int getMaxId() {
        throw new NotImplementedException();
    }
}
