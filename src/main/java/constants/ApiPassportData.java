package constants;

public class ApiPassportData {

    public static final String REQUEST_PASSPORT_ID = "select * from passport where id = %s";
    public static final String REQUEST_PASSPORT_BY_USER_ID = "select * from passport where user_id = '%s'";
    public static final String API_ID = "id";
    public static final String API_USER_ID = "user_id";
    public static final String API_ADDRESS_ID = "address_id";
    public static final String API_SERIAL_NUMBER = "serial_number";
    public static final String API_PASSPORT_CODE = "passport_code";
    public static final String API_BIRTHDAY = "birthday";
    public static final String API_DATE_ISSUE = "date_issue";
    public static final String API_TERMINATION_DATE = "termination_date";
    public static final String API_FIRST_NAME = "first_name";
    public static final String API_LAST_NAME = "last_name";
    public static final String API_PATRONYMIC = "patronymic";
    public static final String API_BORN_PLACE = "born_place";
    public static final String API_DEPARTMENT_ISSUED = "department_issued";
    public static final String COUNT_MSG = "Passports count from API and database does not equals";
    public static final String ASC_SORT = "asc";
    public static final String DATE_ISSUE_DATE ="2018-04-13";
    public static final String TERMINATION_DATE = "2028-04-13";
    public static final String ERROR_NULL_BODY_MSG = "Response body returns null";
 }