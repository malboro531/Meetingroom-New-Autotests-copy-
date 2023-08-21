package constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersonalDetails {

    public static final String GIVEN_NAME = "Warden";
    public static final String SURNAME = "Jonson";
    public static final String DATE_OF_BIRTH = "13 April 2000";
    public static final String PASSPORT_SERIES = "12";
    public static final String PASSPORT_NUMBER = "1234567";
    public static final String AUTHORITY = "Moscow Taganskiy district";
    public static final String DATE_OF_ISSUE = "13 April 2018";
    public static final String DATE_OF_EXPIRY = "13 April 2028";
    public static final String PHONE_PASSPORT = "1234567000";
    public static final String EMAIL_PASSPORT = "s.satnichenka@astondevs.ru";
    public static final String COUNTRY = "Belarus";
    public static final String CITY = "Minsk";
    public static final String STREET = "Komsomolskaya";
    public static final String HOUSE = "22";
    public static final String BUILDING = "2";
    public static final String FLAT = "11";
    public static final String CURRENCY = "USD";
    public static final String ACCOUNT = "Debit Account";
    public static final String OWNER = "Warden Jonson";
    public static final String BANK = "Betta-Bank";
    public static final String DATE = DateTimeFormatter.ofPattern("dd.MM.YY").format(LocalDateTime.now());
    public static final String ANDROID_PATH = "/storage/emulated/0/Download/";
    public static final String COMP_PATH_DOWNLOAD = "target/download/";
    public static final String COMP_PATH_ORIGINAL = "src/test/resources/createAccountDocs/";
    public static final String TARIFF = "Tariffs for individuals who have concluded the BSA.pdf";
    public static final String TERMS_OF_COMPREHENSIVE_BANKING = "Terms of comprehensive banking services for individuals by the bank.pdf";
    public static final String APPLICATION_FORM_WITH_CONCERT = "Application for a comprehensive banking.pdf";
}