package constants;

public class ApiDataBase {

    public static final String BASE_URL = "http://172.17.1.21:30101/";

    public static final String CLIENT_ID_KEYCLOAK = "gateway-user-management";
    public static final String GRANT_TYPE_KEYCLOAK = "password";
    public static final String USERNAME_KEYCLOAK = "user-management-admin";
    public static final String PASSWORD_KEYCLOAK = "admin";
    public static final String URL_KEYCLOAK = "http://172.17.1.21:30001/auth/realms/Meetingroom-New/protocol/openid-connect/token";
    public static final String CONTENT_TYPE_KEYCLOAK = "application/x-www-form-urlencoded";
    public static final String BEARER = "Bearer ";

    public static final String DB_URL = "jdbc:postgresql://172.17.1.21:30000/postgres";
    public static final String DB_USER = "psqluser";
    public static final String DB_PASS = "PoSPa$$woRd";
    public static final String USER_AUTHENTICATION = "api/v1/auth";
    public static final String USER_LOGOUT = "api/v1/auth/logout";

    public static final String PATRONYMIC_FOR_GENERATOR = "Automator";

    public static final String ERROR_MESSAGE_INVALID_FIRST_NAME = "Invalid first name.";
    public static final String ERROR_MESSAGE_INVALID_LAST_NAME = "Invalid last name.";
    public static final String ERROR_MESSAGE_INVALID_PATRONYMIC = "Invalid patronymic.";
    public static final String ERROR_MESSAGE_INVALID_EMAIL = "Invalid email.";
    public static final String ERROR_MESSAGE_INVALID_PHONE_NUMBER = "Invalid phone number.";

    public static final String ERROR_MESSAGE_USER_FIRST_NAME_CANT_BE_NULL = "User first name can't be null.";
    public static final String ERROR_MESSAGE_USERNAME_CANT_BE_NULL = "Username can't be null.";
    public static final String ERROR_MESSAGE_USER_LAST_NAME_CANT_BE_NULL = "User last name can't be null.";
    public static final String ERROR_MESSAGE_EMAIL_CANT_BE_NULL = "email can't be null";
    public static final String ERROR_MESSAGE_PHONE_NUMBER_CANT_BE_NULL = "Phone number can't be null.";

    public static final String ERROR_MESSAGE_USER_WITH_PROVIDED_EMAIL_ALREADY_EXISTS = "User with provided email already exists";
    public static final String ERROR_MESSAGE_INVALID_CURRENCY_NAME = "Invalid currency name.";
    public static final String ERROR_MESSAGE_INVALID_CARD_STATUS = "Invalid card status.";

    public static final int CODE_SUCCESS_OK = 200;
    public static final int CODE_CLIENT_ERROR_BAD_REQUEST = 400;
    public static final int CODE_CLIENT_ERROR_NOT_FOUND = 404;
    public static final String REQUEST_ADDRESS_ID = "select * from address where id = %s";
    public static final String REQUEST_ADDRESS_USER_ID = "select * from address where user_id = %s";

    public static final String BAD_RESPONSE = "Bad response code";

    public static final String TABLE_NAME_USERS = "users";

    public static final String TABLE_NAME_PASSPORT = "passport";

    public static final String TABLE_NAME_ADDRESS = "address";

    public static final String SQL_INSERT_INTO_USERS = "insert into users (first_name, last_name, patronymic, email, phone) values ('%s', '%s', '%s', '%s', '%s')";

    public static final String SQL_SELECT_FROM_USERS = "select id from users where email = '%s'";

    public static final String SQL_INSERT_INTO_PASSPORT = "insert into passport (" +
            "id, user_id, address_id, serial_number, passport_code, birthday, " +
            "date_issue, termination_date, first_name, last_name, patronymic, born_place, department_issued) " +
            "values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s','%s', '%s', '%s', '%s')";

    public static final String SQL_SELECT_FROM_PASSPORT = "select id from passport where user_id = '%s'";

    public static final String SQL_INSERT_INTO_ADDRESS = "insert into address (" +
            "id, user_id, zip_code, country, region, location, city, street, house, building, flat) " +
            "values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s','%s', '%s')";

    public static final String SQL_SELECT_FROM_ADDRESS = "select id from address where user_id = '%s'";

    public static final String SQL_DELETE_FROM_ADDRESS = "delete from address where id = '%s'";

    public static final String SQL_DELETE_FROM_PASSPORT = "delete from passport where id = '%s'";

    public static final String SQL_DELETE_FROM_USERS = "delete from users where id = '%s'";

    public static final String SQL_SELECT_ALL_FROM_ADDRESS = "select * from address";

    public static final String SQL_SELECT_ALL_FROM_PASSPORT = "select * from passport";

    public static final String SQL_SELECT_ALL_FROM_USERS = "select * from users";

    public static final String SQL_SELECT_ADDRESS_BY_USER_ID = """
            select a.* from address a join passport p on a.id = p.address_id where a.user_id = '%s'
            """;
    public static final String SQL_SELECT_ADDRESS_COUNT = "select count(id) from address";

    public static final String SQL_SELECT_PASSPORT_BY_USER_ID = """
            select p.* from passport p join address a on a.id = p.address_id where a.user_id = '%s'
            """;
    public static final String SQL_SELECT_USER_BY_ID = "select * from users where id = '%s'";

    public static final String SQL_SELECT_MAX_ID_FROM_ADDRESS = "select max(id) as id from address";

    public static final String SQL_SELECT_MAX_ID_FROM_PASSPORT = "select id from passport order by id asc";

    public static final String SQL_SELECT_ALL_FROM_ACCOUNT = "select * from payment_service.account order by id desc";

    public static final String SQL_SELECT_ACCOUNT_BY_ID = "select * from payment_service.account where id = '%s'";

    public static final String SQL_DELETE_ACCOUNT_BY_ID = "delete from payment_service.account where id = '%s'";

    public static final String SQL_SELECT_ACCOUNTS_WITH_OWNER_ID = "select * from payment_service.account where owner_id = '%s' order by id desc";

    public static final String SQL_SELECT_ACCOUNT_BY_ACCOUNT_NUMBER = "select * from payment_service.account where account_number = '%s'";

    public static final String SQL_SELECT_ACCOUNT_BY_BANK_NAME_AND_CURRENCY =
            "select * from payment_service.account where owner_id = '%s' and bank_name = '%s' and currency = '%s'";

    public static final String SQL_SELECT_DEPOSIT_PRODUCT_BY_ID = "select dp.deposit_name, dp.min_term_months, dp.max_term_months, " +
            "dp.min_amount, dp.max_amount, dp.fixed_interest, dp.subsequent_replenishment, " +
            "dp.early_withdrawal, dp.capitalization, dp.is_revocable, dp.is_customizable, dp.is_active, dp.id, " +
            "dp.deposit_type_id, dp.currency_id, dp.withdrawal_interest_rate, dpd.id as id_description, dpd.short_description, " +
            "dpd.full_description, dt.\"name\" as deposit_type_name, c.\"name\" as currency_name " +
            "from deposit_service.deposit_products dp " +
            "join deposit_service.deposit_product_descriptions dpd on dp.id = dpd.deposit_product_id " +
            "join deposit_service.currencies c on dp.currency_id = c.id " +
            "join deposit_service.deposit_types dt on dp.deposit_type_id = dt.id where dp.id = '%s'";
    public static final String SQL_SELECT_ALL_DEPOSIT_PRODUCT = "select * from deposit_service.deposit_products";
    public static final String SQL_SELECT_ALL_DEPOSIT_PRODUCT_WITH_NAME_AND_CURRENCY =
            "select * from deposit_service.deposit_products dp inner join deposit_service.currencies c" +
                    " on dp.currency_id = c.id where name like '%s' and deposit_name like '%s'";
    public static final String SQL_DELETE_DEPOSIT_PRODUCT_BY_ID = "delete from deposit_service.deposit_products where id = '%s'";

    public static final String SQL_SELECT_DEPOSIT_BY_ID = "select dp.id, dp.deposit_number, dp.deposit_product_id," +
                                                          " deposit_type_id, dt.name, currency_id, c.\"name\" as currency_name, user_id, term_months, open_date, \n" +
                                                          "close_date, amount, interest_rate, fixed_interest, subsequent_replenishment, capitalization," +
                                                          " early_withdrawal, interest_withdrawal, is_revocable, is_active from deposit_service.deposits dp \n" +
                                                          "join deposit_service.deposit_types dt on dp.deposit_type_id = dt.id\n" +
                                                          "join deposit_service.currencies c on dp.currency_id = c.id where dp.id = '%s'";

    public static final String SQL_DELETE_DEPOSIT_BY_ID = "delete from deposit_service.deposits where id = '%s'";
    public static final String SQL_SELECT_CREDIT_PRODUCT_BY_ID = """
            select credit_products.* from credit_service.credit_products where credit_products.id ='%s'
            """;
    public static final String SQL_SELECT_CREDIT_PRODUCTS_COUNT = "select count(id) from credit_service.credit_products";
    public static final String SQL_SELECT_CREDIT_ACCOUNT_BY_ID = "select * from credit_service.credit_account where id = '%s'";
    public static final String SQL_SELECT_All_CREDIT_ACCOUNTS = "select * from credit_service.credit_account";
    public static final String SQL_SELECT_CREDIT_ACCOUNTS_COUNT = "select count(id) from credit_service.credit_account";
    public static final String SQL_SELECT_CREDIT_ACCOUNTS_COUNT_BY_OWNER_ID_USER = "select count(id) from credit_service.credit_account where owner_id = '%s'";
    public static final String SQL_SELECT_CREDIT_ACCOUNTS_ID_COUNT = "select count(id) from credit_service.credit_account where owner_id = '%s'";
    public static final String SQL_SELECT_CARD_PRODUCT_COUNT_BY_ID = "select count(id) from payment_service.card_product";
    public static final String SQL_SELECT_CARD_PRODUCT_COUNT_BY_LIMITS = "select count(limits) from payment_service.card_product";
    public static final String SQL_DELETE_CREDIT_PRODUCT_BY_ID = "delete from credit_service.credit_products where id = '%s'";
    public static final String SQL_SELECT_CARD_PRODUCT_BY_ID = """
            select cp.id, cp.cashback, cp.price, cp.advantages, cp.bank_partners, cp.loyalty_program, cp.maintenance_cost,
            cp.min_sum_balance, cp.currency, cp.limits, tc.payment_system, tc.type_name
            from payment_service.card_product cp
            join payment_service.type_card tc on cp.type_card_id = tc.id
            join payment_service.currency c on cp.currency = c.name
            where cp.id = '%s'
            """;
    public static final String SQL_SELECT_CARD_PRODUCT_BY_LIMITS =
            """
                     select card_product.*, type_card.payment_system, type_card.type_name from payment_service.card_product
                     join payment_service.type_card on card_product.type_card_id=type_card.id where limits = '%s'
                    """;
    public static final String SQL_SELECT_All_CARD_COUNT = "select count(id) from payment_service.card";
    public static final String SQL_SELECT_CARDS_BY_ID_COUNT = "select count(card.id) from payment_service.card join payment_service.account on card.account_id = account.id where owner_id = '%s'";
    public static final String SQL_SELECT_ALL_TRANSFERS_FOR_USER_COUNT = "select count(*) from transfer_service.transfer_new where user_id = '%s'";
    public static final String SQL_SELECT_REGULAR_PAYMENT_BY_ID = "select * from payment_service.regular_payment where id = '%s'";
    public static final String SQL_SELECT_ALL_REGULAR_PAYMENTS_COUNT = "select count(id) from payment_service.regular_payment";
    public static final String SQL_DELETE_REGULAR_PAYMENT_BY_ID = "delete from payment_service.regular_payment where id = '%s'";
    public static final String SQL_SELECT_CARD_BY_ID = """
            select c.id, c.account_id, c.card_product_id, c.holder_name, c.last_four_numbers, c.first_twelve_numbers,
            c.valid_from_date, c.expire_date, c.is_active, c.is_main, c.contract_id, c.card_status, tc.payment_system,
            tc.type_name, a.balance, a.currency, cp.limits from payment_service.card c
            join payment_service.account a on c.account_id = a.id
            join payment_service.card_product cp on c.card_product_id = cp.id
            join payment_service.type_card tc on cp.type_card_id = tc.id
            where c.id = '%s';
            """;
    public static final String SQL_SELECT_CARD_BY_ACCOUNT_ID = """
            select card.* from payment_service.card
            join payment_service.account on card.account_id = account.id
            join payment_service.card_product on card.card_product_id = card_product.id
            join payment_service.type_card on card_product.type_card_id = type_card.id
            where card.account_id = '%s';
            """;
    public static final String SQL_SELECT_CARD_BY_CREATE_STATUS = """
                select card.* from payment_service.card
                join payment_service.account on payment_service.card.account_id = payment_service.account.id 
            where owner_id  = '%s' and card_status = 'CREATED'
            """;
    public static final String SQL_SELECT_CARD_BY_READY_STATUS = "select card.* from payment_service.card join payment_service.account \n" +
                                                                 " on payment_service.card.account_id = payment_service.account.id where owner_id  = '%s' and card_status = 'READY'";
    public static final String SQL_SELECT_CARD_BY_ACTIVE_STATUS = "select card.* from payment_service.card join payment_service.account \n" +
                                                                  " on payment_service.card.account_id = payment_service.account.id where owner_id  = '%s' and card_status = 'ACTIVE'";
    public static final String SQL_SELECT_CARD_BY_BLOCKED_STATUS = "select card.* from payment_service.card join payment_service.account \n" +
                                                                   " on payment_service.card.account_id = payment_service.account.id where owner_id  = '%s' and card_status = 'BLOCKED'";
    public static final String SQL_SELECT_CARD_BY_CLOSED_STATUS = "select card.* from payment_service.card join payment_service.account \n" +
                                                                  " on payment_service.card.account_id = payment_service.account.id where owner_id  = '%s' and card_status = 'CLOSED'";
    public static final String SQL_DELETE_CARD_BY_ID = "delete from payment_service.card where id = '%s'";
    public static final String SQL_SELECT_CREDIT_CARD_PRODUCT_BY_ID = "select * from credit_service.credit_card_products where id = '%s'";
    public static final String SQL_SELECT_CREDIT_CARD_PRODUCTS_COUNT = "select count(id) from credit_service.credit_card_products";
    public static final String SQL_DELETE_CREDIT_CARD_PRODUCT_BY_ID = "delete from credit_service.credit_card_products where id = '%s'";
    public static final String SQL_DELETE_CREDIT_CARD_BY_ID = "delete from credit_service.credit_cards where id = '%s'";
    public static final String SQL_SELECT_CREDIT_CARD_PRODUCTS_WITH_CURRENCY = "select * from credit_service.credit_card_products where currency like '%s'";
    public static final String SQL_SELECT_CREDIT_CARD_BY_ID = "select * from credit_service.credit_cards where id = '%s'";
    public static final String SQL_SELECT_CREDIT_CARDS_COUNT = "select count(id) from credit_service.credit_cards";
    public static final String SQL_SELECT_CREDIT_CARDS_BY_ID_COUNT = "select count(credit_service.credit_cards.id)  \n" +
            "from credit_service.credit_cards \n" +
            "join credit_service.credit_account\n" +
            "on  credit_service.credit_cards.account_id = credit_service.credit_account.id \n" +
            "where owner_id  = '%s'";
    public static final String SQL_GET_ALL_CREDIT_ACCOUNTS_BY_OWNER_ID_AND_CURRENCY = "select * from credit_service.credit_account where owner_id = '%s' and currency = '%s'";
    public static final String SQL_SELECT_CREDIT_ORDER_BY_ID = "select * from credit_service.credit_order where id = '%s'";
    public static final String SQL_DELETE_CREDIT_ORDER_BY_ID = "delete from credit_service.credit_order where id = '%s'";
    public static final String SQL_SELECT_CREDIT_ORDERS_BY_OWNER_ID_COUNT = "select count(id) from credit_service.credit_order where owner_id = '%s'";
    public static final String SQL_SELECT_CREDIT_ORDERS = "select count(id) from credit_service.credit_order";
    public static final String SQL_SELECT_CREDIT_ORDERS_BY_STATUS = "select * from credit_service.credit_order where status like '%s'";
    public static final String SQL_SELECT_CREDIT_PENALTY_BY_ID = "select * from credit_service.penalty where id = '%s'";
    public static final String SQL_DELETE_CREDIT_PENALTY_BY_ID = "delete from credit_service.penalty where id = '%s'";
}
