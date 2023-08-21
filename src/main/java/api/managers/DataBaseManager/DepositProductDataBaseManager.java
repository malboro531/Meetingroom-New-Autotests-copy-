package api.managers.DataBaseManager;

import api.models.controllers.deposit.*;
import lombok.SneakyThrows;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static constants.ApiDataBase.*;

public class DepositProductDataBaseManager extends DataBaseAbstractManager<DepositProductModel>{

    @SneakyThrows
    @Override
    public List<String> getAll() {
        resultSet = executeQuery(SQL_SELECT_ALL_DEPOSIT_PRODUCT);
        while (resultSet.next()) {
            allIds.add(String.valueOf(extractFromAllResultSet(resultSet)));
        }
        return allIds;
    }

    @SneakyThrows
    public List<String> getAllWithNameAndCurrency(String currencyName, String depositProductName) {
        List<String> allIdsWithNameAndCurrency = new ArrayList<>();
        resultSet = executeQuery(String.format(SQL_SELECT_ALL_DEPOSIT_PRODUCT_WITH_NAME_AND_CURRENCY,
                currencyName, depositProductName));
        while (resultSet.next()) {
            allIdsWithNameAndCurrency.add(String.valueOf(extractFromAllResultSet(resultSet)));
        }
        return allIdsWithNameAndCurrency;
    }

    @Override
    public void update(DepositProductModel entity) {
        //TODO
    }

    @Override
    public void create(DepositProductModel entity) {
        //TODO
    }

    @Override
    public DepositProductModel extractFromResultSet(ResultSet resultSet) throws SQLException {
        return DepositProductModel.builder()
                .depositName(resultSet.getString("deposit_name"))
                .id(resultSet.getString("id"))
                .minTermMonths(resultSet.getInt("min_term_months"))
                .maxTermMonths(resultSet.getInt("max_term_months"))
                .minAmount(resultSet.getInt("min_amount"))
                .maxAmount(resultSet.getInt("max_amount"))
                .fixedInterest(resultSet.getBoolean("fixed_interest"))
                .subsequentReplenishment(resultSet.getBoolean("subsequent_replenishment"))
                .earlyWithdrawal(resultSet.getBoolean("early_withdrawal"))
                .capitalization(resultSet.getBoolean("capitalization"))
                .isRevocable(resultSet.getBoolean("is_revocable"))
                .isCustomizable(resultSet.getBoolean("is_customizable"))
                .isActive(resultSet.getBoolean("is_active"))
                .type(new Type(resultSet.getString("deposit_type_id"), resultSet.getString("deposit_type_name")))
                .currency(new Currency(resultSet.getString("currency_id"), resultSet.getString("currency_name")))
                .interestWithdrawalRate(resultSet.getDouble("withdrawal_interest_rate"))
                .descriptions(List.of(new Description(resultSet.getString("short_description"), resultSet.getString("full_description"))))
                .build();
    }

    public PojoDepositProductModel extractFromAllResultSet(ResultSet resultSet) throws SQLException {
        return PojoDepositProductModel.builder()
                .depositName(resultSet.getString("deposit_name"))
                .id(resultSet.getString("id"))
                .minTermMonths(resultSet.getInt("min_term_months"))
                .maxTermMonths(resultSet.getInt("max_term_months"))
                .minAmount(resultSet.getInt("min_amount"))
                .maxAmount(resultSet.getInt("max_amount"))
                .fixedInterest(resultSet.getBoolean("fixed_interest"))
                .subsequentReplenishment(resultSet.getBoolean("subsequent_replenishment"))
                .earlyWithdrawal(resultSet.getBoolean("early_withdrawal"))
                .capitalization(resultSet.getBoolean("capitalization"))
                .isRevocable(resultSet.getBoolean("is_revocable"))
                .isCustomizable(resultSet.getBoolean("is_customizable"))
                .isActive(resultSet.getBoolean("is_active"))
                .interestWithdrawalRate(resultSet.getDouble("withdrawal_interest_rate"))
                .build();
    }

    @Override
    public int getMaxId() {
        //TODO
        return 0;
    }
}