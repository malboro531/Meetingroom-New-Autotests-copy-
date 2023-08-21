package constants;

public class ApiEndpoints {

    public static final String USER_AUTHENTICATION = "api/v1/auth";

    public static final String SEND_EMAIL_NOTIFICATION = "api/v1/notifications/email";
    public static final String CONFIRM_EMAIL_NOTIFICATION = "api/v1/notifications/email";
    public static final String GET_EMAIL_NOTIFICATION = "api/v1/notifications/email/notification";
    public static final String CHECK_EMAIL = "api/v1/notifications/email/blocked";
    public static final String SEND_PUSH_NOTIFICATION = "api/v1/notifications/push/token";

    public static final String GET_USER_PERSONAL_DATA = "api/v1/users/data";
    public static final String GET_USER_PERSONAL_DATA_BY_PHONE = "api/v1/users/data/{phone}";
    public static final String GET_USER_PERSONAL_DATA_BY_USER_ID = "api/v1/users/{userId}/data";
    public static final String GET_USER_INFORMATION_BY_ENTRY_DATA = "api/v1/users/data/entryData";
    public static final String DELETE_USER_BY_ID = "api/v1/users/{id}";
    public static final String GET_ALL_USERS = "api/v1/users";
    public static final String GET_USER_BY_ID = "api/v1/users/find/{id}";
    public static final String CREATE_USER = "api/v1/users";
    public static final String UPDATE_USER_BY_ID = "api/v1/users/{id}";
    public static final String GET_USER = "api/v1/users/find";
    public static final String GET_USER_INFO_BY_PHONE_NUMBER = "api/v1/users/{phone}";

    public static final String GET_ALL_ADDRESSES = "api/v1/addresses";
    public static final String GET_ADDRESSES_BY_ID = "api/v1/addresses/{id}";
    public static final String GET_ADDRESSES_BY_USER_ID = "api/v1/addresses/user/{id}";
    public static final String UPDATE_ADDRESSES = "api/v1/addresses";

    public static final String DELETE_PASSPORT_BY_ID = "api/v1/passport/{id}";
    public static final String GET_PASSPORT_INFO_BY_ID = "api/v1/passport/{id}";
    public static final String GET_PASSPORT_INFO_BY_USER_ID = "api/v1/passport/user/{id}";
    public static final String GET_ALL_PASSPORT_INFO = "api/v1/passport/all";
    public static final String GET_PASSPORT_INFO_BY_ADDRESS_ID = "api/v1/passport/address/{id}";
    public static final String CREATE_PASSPORT = "api/v1/passport";
    public static final String UPDATE_PASSPORT = "api/v1/passport";

    public static final String GET_ALL_FILE_INFO_DTO = "api/v1/files";

    public static final String GET_ALL_COUNTRIES = "api/v1/information/country";
    public static final String GET_ALL_CITIES_BY_COUNTRY_ID = "api/v1/information/country/{id}/city";
    public static final String GET_ALL_STREETS_BY_CITY_ID = "api/v1/information/city{id}/street";
    public static final String GET_ALL_BANK_BRANCHES_BY_CITY_ID = "api/v1/information/city{id}/branch";
    public static final String GET_ALL_TIMETABLES_BY_BRANCH_ID = "api/v1/information/branch/{id}/timetable";

    public static final String GET_ALL_ACCOUNTS = "api/v1/accounts/";
    public static final String GET_ACCOUNT_BY_ID = "api/v1/accounts/{id}";
    public static final String GET_ACCOUNTS_WITH_OWNER_ID = "api/v1/accounts/owners/{owner_id}";
    public static final String GET_ACCOUNT_BY_ACCOUNT_NUMBER = "api/v1/accounts/numbers/{accountNumber}";
    public static final String CREATE_ACCOUNT = "/api/v1/accounts/";
    public static final String PUT_UPDATE_ACCOUNT = "/api/v1/accounts/";

    public static final String CREATE_DEPOSIT_PRODUCT = "/api/v1/products/";
    public static final String GET_DEPOSIT_PRODUCT_BY_ID = "/api/v1/products/{id}";
    public static final String GET_All_DEPOSIT_PRODUCTS = "/api/v1/products/";
    public static final String GET_DEPOSIT_PRODUCT_BY_NAME_AND_CURRENCY = "/api/v1/products/search";
    public static final String UPDATE_DEPOSIT_PRODUCT = "/api/v1/products";
    public static final String DELETE_DEPOSIT_PRODUCT_BY_ID = "/api/v1/products/{id}";
    public static final String GET_ALL_CURRENCIES_FOR_DEPOSIT_PRODUCTS = "/api/v1/products/currencies";
    public static final String GET_ALL_TYPES_FOR_DEPOSIT_PRODUCTS = "/api/v1/products/types";
    public static final String GET_FILTERED_DEPOSIT_PRODUCTS = "/api/v1/products/filter";

    public static final String CREATE_DEPOSIT = "/api/v1/deposits/";
    public static final String GET_DEPOSIT_BY_ID = "/api/v1/deposits/{id}";
    public static final String DELETE_DEPOSIT_BY_ID = "/api/v1/deposits/{id}";

    public static final String GET_CREDIT_PRODUCT_BY_ID = "/api/v1/credit-products/{id}";
    public static final String GET_ALL_CREDIT_ACCOUNTS = "/api/v1/credit-accounts";
    public static final String GET_CREDIT_ACCOUNT_BY_ID = "/api/v1/credit-accounts/{id}";
    public static final String GET_CREDIT_ACCOUNTS_BY_OWNER_ID = "/api/v1/credit-accounts/owners/{id}";
    public static final String GET_TRANSFER_INFO_BY_CREDIT_ACCOUNT_NUMBER = "/api/v1/credit-accounts/transfer/{creditAccountNumber}";
    public static final String GET_ALL_CREDIT_PRODUCTS = "/api/v1/credit-products";
    public static final String GET_ALL_ACTIVE_CREDIT_PRODUCT = "/api/v1/credit-products/active";
    public static final String CREATE_CREDIT_PRODUCT = "/api/v1/credit-products";
    public static final String UPDATE_CREDIT_PRODUCT = "/api/v1/credit-products/{id}";

    public static final String CREATE_CARD = "/api/v1/cards/";
    public static final String CREATE_CARD_PRODUCT = "/api/v1/card_products/";
    public static final String GET_ALL_CARDS_COUNT = "/api/v1/cards/";
    public static final String GET_CARDS_OF_CURRENT_USER = "/api/v1/cards/user";
    public static final String GET_CARD_BY_CARD_ID = "/api/v1/cards/{id}";
    public static final String GET_CARD_STATUS_BY_CARD_NUMBER = "/api/v1/cards/status";
    public static final String GET_CARDS_CURRENCY = "/api/v1/cards/currency";
    public static final String GET_ALL_CARDS_BY_TYPE_CARD = "/api/v1/cards/search/";
    public static final String PUT_UPDATE_CARD_PRODUCT = "/api/v1/card_products/";
    public static final String CET_ALL_CARD_PRODUCT = "/api/v1/card_products/";
    public static final String GET_CARD_PRODUCT_BY_ID = "/api/v1/card_products/{id}";
    public static final String DELETE_CARD_PRODUCT = "/api/v1/card_products/{id}";
    public static final String DELETE_CREDIT_PRODUCT = "/api/v1/credit-products/{id}";
    public static final String DEACTIVATE_CARD = "/api/v1/cards/{id}";
    public static final String GET_CARDS_HASHED_NUMBERS = "/api/v1/cards/hashed_numbers";
    public static final String GET_CARDS_NUMBERS = "/api/v1/cards/numbers";
    public static final String GET_ALL_CARDS_BY_ACCOUNT_ID = "/api/v1/cards/accounts/{id}";
    public static final String GET_ACCOUNT_BY_CARD_NUMBER = "/api/v1/cards/account/cardNumber";
    public static final String SET_CARD_STATUS_READY = "/api/v1/card-status/ready/{id}";
    public static final String SET_CARD_STATUS_ACTIVE = "/api/v1/card-status/active/{id}";
    public static final String SET_CARD_STATUS_BLOCKED = "/api/v1/card-status/blocked/{id}";
    public static final String SET_CARD_STATUS_CLOSED = "/api/v1/card-status/closed/{id}";
    public static final String SET_ALL_CARDS_OF_ACCOUNT_STATUS_CLOSED_BY_ACCOUNT_ID = "/api/v1/card-status/closed-all/account/{id}";
    public static final String UPDATE_CARD_BY_PARAMS = "/api/v1/cards/{id}";
    public static final String GET_EXTENDED_CARD_INFORMATION_BY_ID = "/api/v1/cards/extended/{id}";
    public static final String REQUEST_ON_TRANSFER_MONEY = "/api/v1/transfer";
    public static final String CREATE_REGULAR_PAYMENT = "/api/v1/payments/regular/";
    public static final String GET_REGULAR_PAYMENT_BY_ID = "/api/v1/payments/regular/{id}";
    public static final String GET_ALL_REGULAR_PAYMENTS = "/api/v1/payments/regular/";
    public static final String DELETE_REGULAR_PAYMENT = "/api/v1/payments/regular/{id}";
    public static final String UPDATE_REGULAR_PAYMENT = "/api/v1/payments/regular/";
    public static final String GET_ACCOUNT_BY_BANK_NAME_AND_CURRENCY = "/api/v1/accounts/bank/";
    public static final String CREATE_CREDIT_CARD_PRODUCT = "/api/v1/credit-card-products";
    public static final String GET_ALL_CREDIT_CARD_PRODUCTS = "/api/v1/credit-card-products";
    public static final String GET_CREDIT_CARD_PRODUCT_BY_ID = "/api/v1/credit-card-products/{id}";
    public static final String DELETE_CREDIT_CARD_PRODUCT_BY_ID = "/api/v1/credit-card-products/{id}";
    public static final String UPDATE_CREDIT_CARD_PRODUCT = "/api/v1/credit-card-products/{id}";
    public static final String CREATE_CREDIT_CARD = "/api/v1/credit-cards";
    public static final String UPDATE_CREDIT_CARD = "/api/v1/credit-cards/{id}";
    public static final String GET_ALL_CREDIT_CARDS_OF_CURRENT_USER = "/api/v1/credit-cards/user";
    public static final String GET_CREDIT_CARD_BY_ID = "/api/v1/credit-cards/{id}";
    public static final String DEACTIVATE_CREDIT_CARD_BY_ID = "/api/v1/credit-cards/{id}";
    public static final String ACTIVATE_CREDIT_CARD_BY_ID = "/api/v1/credit-cards/{id}";
    public static final String CREATE_CREDIT_ORDER = "/api/v1/credit-order";
    public static final String GET_CREDIT_ORDER_BY_ID = "/api/v1/credit-order/{id}";
    public static final String GET_ALL_CREDIT_ORDERS_BY_OWNER_ID = "/api/v1/credit-order/owner/{id}";
    public static final String GET_ALL_CREDIT_ORDERS = "/api/v1/credit-order";
    public static final String UPDATE_CREDIT_ORDER = "/api/v1/credit-order";
    public static final String DELETE_CREDIT_ORDER = "/api/v1/credit-order/{id}";
    public static final String CHANGE_CREDIT_ORDER_STATUS = "/api/v1/credit-order/{id}/status";
    public static final String APPROVE_CREDIT_ORDER_BY_ID = "/api/v1/credit-order/{id}";
    public static final String BLOCK_CREDIT_ORDER_BY_ID = "api/v1/credit-order/status-block/{id}";
    public static final String PREPARE_CREDIT_ORDER_BY_ID = "api/v1/credit-order/status-prepared/{id}";
    public static final String CREATE_CREDIT_PENALTY = "/api/v1/credit-penalties";
    public static final String UPDATE_CREDIT_PENALTY_BY_ID = "/api/v1/credit-penalties/{id}";
    public static final String GET_CREDIT_PENALTY_BY_ID = "/api/v1/credit-penalties/{id}";
}
