package helpers;

import api.managers.DataBaseManager.AddressDataBaseManager;
import api.managers.DataBaseManager.PassportDataBaseManager;
import api.models.controllers.*;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;

import static constants.ApiDataBase.PATRONYMIC_FOR_GENERATOR;
import static constants.ApiPassportData.DATE_ISSUE_DATE;
import static constants.ApiPassportData.TERMINATION_DATE;
import static constants.CardProductData.PAYMENT_SYSTEM;
import static constants.CardProductData.TYPE_NAME;
import static constants.GlobalData.*;
import static constants.enums.Currency.RUB;
import static constants.enums.Currency.USD;
import static java.util.concurrent.TimeUnit.DAYS;

public class FakeGenerator {

    private static Faker faker = new Faker();

    public static String getUserName() {
        return faker.bothify("111######");
    }

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getFakeCurrency() {
        return faker.currency().code();
    }

    public static String getNameGivenLength(String nameMask, int numberOfCharacters) {
        return faker.bothify(String.format("%" + numberOfCharacters + "s", "").replace(" ", nameMask));
    }

    public static String getModifiedName(String name, String replacementSymbol, boolean replaceTheFirstOrLastCharacter) {
        Random rand = new Random();
        int randomIndex = replaceTheFirstOrLastCharacter ? rand.nextInt(0, name.length()) : rand.nextInt(1, name.length() - 1);
        return (name.substring(0, randomIndex) + replacementSymbol + name.substring(randomIndex));
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmail() {
        return faker.bothify("????##@gmail.com");
    }

    public static String getEmail(String emailMask) {
        return faker.bothify(emailMask);
    }

    public static String getPhoneNumber(int length) {
        return faker.phoneNumber().subscriberNumber(length);
    }

    public static String getPhoneNumber() {
        return getPhoneNumber((int) (Math.random() * 3 + 10));
    }

    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }

    public static String getUserId() {
        return "ff90179d-87ff-4691-bfc1-ce4216e5accc";
    }

    public static UserModel generateFakeUser() {
        return UserModel.builder()
                .username(getUserName())
                .firstName(getFirstName())
                .lastName(getLastName())
                .patronymic(PATRONYMIC_FOR_GENERATOR)
                .email(getEmail())
                .phone(getPhoneNumber())
                .build();
    }

    public static int getZipCode() {
        return Integer.parseInt(faker.number().digits(6));
    }

    public static String getCountry() {
        return faker.address().country();
    }

    public static String getRegion() {
        return faker.address().cityName();
    }

    public static String getLocation() {
        return faker.address().state();
    }

    public static String getCity() {
        return faker.address().city();
    }

    public static String getStreet() {
        return faker.address().streetName();
    }

    public static String getHouse() {
        return faker.number().digits(2);
    }

    public static String getBuilding() {
        return faker.number().digits(1);
    }

    public static String getFlat() {
        return faker.number().digits(2);
    }

    public static AddressModel generateFakeAddress() {
        return AddressModel.builder()
                .id(getAddressId())
                .userId(getUserId())
                .zipCode(getZipCode())
                .country(getCountry())
                .region(getRegion())
                .location(getLocation())
                .city(getCity())
                .street(getStreet())
                .house(getHouse())
                .building(getBuilding())
                .flat(getFlat())
                .build();
    }

    public static int getPassportId() {
        PassportDataBaseManager passportDataBaseManager = new PassportDataBaseManager();
        return passportDataBaseManager.getMaxId() + 1;
    }

    public static int getAddressId() {
        AddressDataBaseManager addressDataBaseManager = new AddressDataBaseManager();
        return addressDataBaseManager.getMaxId() + 1;
    }

    public static String getSerialNumber() {
        return faker.number().digits(2);
    }

    public static String getPassportCode() {
        return faker.number().digits(7);
    }

    public static String getBirthday() {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        return sdf.format(faker.date().birthday(18, 60));
    }

    public static String getDateIssue() {
        return DATE_ISSUE_DATE;
    }

    public static String getTerminationDate() {
        return TERMINATION_DATE;
    }

    public static String getBornPlace() {
        return faker.address().city();
    }

    public static String getDepartmentIssued() {
        return faker.address().state();
    }

    public static PassportModel generateFakePassport() {
        return PassportModel.builder()
                .id(getPassportId())
                .userId(getUserId())
                .addressId(getAddressId())
                .serialNumber(getSerialNumber())
                .passportCode(getPassportCode())
                .birthday(getBirthday())
                .dateIssue(getDateIssue())
                .terminationDate(getTerminationDate())
                .firstName(getFirstName())
                .lastName(getLastName())
                .patronymic(PATRONYMIC_FOR_GENERATOR)
                .departmentIssued(getDepartmentIssued())
                .bornPlace(getBornPlace())
                .build();
    }

    public static String getRandomString() {
        return faker.number().digits(46);
    }

    public static String getRandomAccountNumber() {
        return faker.number().digits(34);
    }

    public static String getRandomNumber() {
        return faker.number().digits(6);
    }

    public static String getDepositAmount() {
        return String.valueOf(faker.number().numberBetween(500, 50000));
    }

    public static String getPeriod() {
        return String.valueOf(faker.number().numberBetween(3, 36));
    }

    public static String getInvalidNumber() {
        return "invalid123";
    }

    public static String getInvalidConfirmCode() {
        return faker.number().digits(4);
    }

    public static String getInvalidAccountNumber() {
        return faker.number().digits(20);
    }

    public static long getRandomBalance() {
        return faker.number().randomNumber();
    }

    public static String getOpenDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        return sdf.format(faker.date().past(80, DAYS));
    }

    public static String getCloseDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        return sdf.format(faker.date().future(80, DAYS));
    }

    public static String getRandomBank() {
        return faker.company().name();
    }

    public static AccountModel generateFakeAccount() {
        return AccountModel.builder()
                .id(generateUuid())
                .accountNumber(getInvalidAccountNumber())
                .openDate(getOpenDate())
                .closeDate(getCloseDate())
                .ownerId(generateUuid())
                .currency(getFakeCurrency())
                .bankName(getRandomBank())
                .balance(getRandomBalance())
                .active(true)
                .build();
    }

    public static CardModel generateFakeCard() {
        return CardModel.builder()
                .accountId(generateUuid())
                .cardProductId(generateUuid())
                .holderName(getFirstName())
                .build();
    }

    public static int getRandomNumberInt() {
        return faker.number().randomDigitNotZero();
    }

    public static int getRandomNumberMinSum() {
        return faker.number().numberBetween(10, 20);
    }

    public static int getRandomNumberMaxSum() {
        return faker.number().numberBetween(121, 200);
    }

    public static double getFakeDouble() {
        return faker.number().randomDouble(1, 10, 20);
    }

    public static double getFakeMinPercent() {
        return faker.number().randomDouble(2, 0, 1);
    }

    public static CardProductModel generateFakeCardProduct() {
        return CardProductModel.builder()
                .cashback(getRandomNumberInt())
                .price(getRandomNumberInt())
                .advantages(getRandomString())
                .bankPartners(getRandomString())
                .loyaltyProgram(getRandomString())
                .maintenanceCost(getRandomNumberInt())
                .minSumBalance(getRandomNumberInt())
                .currency(EUR)
                .limits(getRandomNumber())
                .paymentSystem(PAYMENT_SYSTEM)
                .typeName(TYPE_NAME)
                .id(generateUuid())
                .build();
    }

    public static RegularPaymentModel generateFakeRegularPayment() {
        return RegularPaymentModel.builder()
                .description(getFirstName())
                .startDate(getTerminationDate())
                .sourceCardId(VALID_USER_SOURCE_CARD)
                .recipientCardId(VALID_ADMIN_SOURCE_CARD)
                .amount(getRandomNumberInt())
                .frequency(FREQUENCY)
                .build();
    }

    public static RegularPaymentModel generateFakeAdminRegularPayment() {
        return RegularPaymentModel.builder()
                .description(getFirstName())
                .startDate(getTerminationDate())
                .sourceCardId(VALID_ADMIN_SOURCE_CARD)
                .recipientCardId(VALID_USER_SOURCE_CARD)
                .amount(getRandomNumberInt())
                .frequency(FREQUENCY)
                .build();
    }

    public static CreditModel generateFakeCreditProduct() {
        return CreditModel.builder()
                .creditName(getRandomString())
                .minSum(getRandomNumberMinSum())
                .maxSum(getRandomNumberMaxSum())
                .multiplicityOfSum(getRandomNumberInt())
                .currency(String.valueOf(RUB))
                .loanRate(getFakeDouble())
                .minTerm(getRandomNumberMinSum())
                .maxTerm(getRandomNumberMinSum())
                .multiplicityOfTemp(getRandomNumberMinSum())
                .description(getRandomString())
                .penaltyId(PENALTY_ID)
                .build();
    }

    public static CreditCardProductModel generateFakeCreditCardProduct() {
        return CreditCardProductModel.builder()
                .typeCardId(VALID_CREDIT_CARD_TYPE)
                .cashback(getRandomNumberMinSum())
                .price(getFakeDouble())
                .advantages(getFirstName())
                .bankPartners(getFirstName())
                .loyaltyProgram(getFirstName())
                .maintenanceCost(getRandomNumberMinSum())
                .minSumBalance(getRandomNumberMaxSum())
                .currency(String.valueOf(USD))
                .build();
    }

    public static CreditCardModel generateFakeCreditCardWithCurrencyUSD() {
        return CreditCardModel.builder()
                .accountId(VALID_CREDIT_ACCOUNT_ID_WITH_CURRENCY_USD_FOR_ADMIN)
                .cardProductId(generateUuid())
                .holderName(String.valueOf(USD))
                .build();
    }

    public static CreditOrderModel generateFakeCreditOrder() {
        return CreditOrderModel.builder()
                .ownerId(generateUuid())
                .creditProductId(generateUuid())
                .amount(getRandomNumberInt())
                .tempCredit(getRandomNumberMinSum())
                .loanRate(getRandomNumberMaxSum())
                .averageMonthlyIncome(getZipCode())
                .averageMonthlyExpenditure(getRandomNumberMaxSum())
                .employerId(VALID_CREDIT_EMPLOYER_IDENTIFICATION_ID)
                .build();
    }

    public static CreditPenaltyModel generateFakePenalty() {
        return CreditPenaltyModel.builder()
                .name(getFirstName())
                .percent(getFakeMinPercent())
                .amountMin(getRandomNumberMinSum())
                .maxPercent(getFakeDouble())
                .amountMax(getRandomNumberMaxSum())
                .build();
    }
}