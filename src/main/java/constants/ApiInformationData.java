package constants;

import java.util.List;

import static java.util.Arrays.asList;

public class ApiInformationData {
    public static final int API_VALID_ID = 1;
    public static final int API_INVALID_ID = 0;
    public static final int API_DEFAULT_PAGE = 0;
    public static final int API_DEFAULT_SIZE = 20;
    public static final String API_DEFAULT_SORT = "";
    public static final boolean API_DEFAULT_FALSE_ONLY_WITH_BRANCHES = false;
    public static final boolean API_DEFAULT_FALSE_SINGLE_PAGE = false;
    public static final String ERROR_MESSAGE_NOT_EQUAL = "Lists of countries are not equal";

    public static final List<String> LIST_EXPECTED_COUNTRIES = asList(
            "Germany", "France", "Lithuania", "Austria",
            "Belgium", "Bulgaria", "Czech Republic", "Denmark",
            "Estonia", "Finland", "Greece", "Hungary", "Ireland",
            "Italy", "Luxembourg", "Latvia", "Malta", "Netherlands",
            "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden");

}
