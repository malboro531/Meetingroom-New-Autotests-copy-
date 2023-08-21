package steps.api;

import api.managers.PassportManager;
import api.models.controllers.AllPassportModel;
import api.models.controllers.PassportModel;
import io.qameta.allure.Step;
import retrofit2.Response;
import verification.VerifySoft;

import static constants.ApiPassportData.*;

public class PassportApiStep {

    private PassportManager passportManager = new PassportManager();

    @Step("Get passport data by passport id")
    public Response<PassportModel> getPassportInfoByPassportId(int id) {
        return passportManager.getPassportInfoByPassportId(id);
    }

    @Step("Get passport by user id")
    public Response<PassportModel> getPassportInfoByUserId(String user_id) {
        return passportManager.getPassportInfoByUserId(user_id);
    }

    @Step("Get all passports")
    public Response<AllPassportModel> getAllPassportInfo(int page, int size, String sort) {
        return passportManager.getAllPassportInfo(page, size, sort);
    }

    @Step("Get passport by address id")
    public Response<PassportModel> getPassportByAddressId(int addressId){
        return passportManager.getPassportInfoByAddressId(addressId);
    }

    @Step("Create passport")
    public Response<Void> createPassport(PassportModel passport){
        return passportManager.createPassport(passport);
    }

    @Step("Delete passport")
    public Response<PassportModel> deletePassport(int id){
        return passportManager.deletePassportById(id);
    }

    @Step("Update passport")
    public Response<Void> updatePassport(PassportModel id){
        return passportManager.updatePassport(id);
    }

    @Step("Compare passports")
    public void checkPassport(PassportModel passport, PassportModel passportModelSql) {
        VerifySoft.verifyEqualsSoft(passport.getId(), passportModelSql.getId(), API_ID);
        VerifySoft.verifyEqualsSoft(passport.getUserId(), passportModelSql.getUserId(), API_USER_ID);
        VerifySoft.verifyEqualsSoft(passport.getAddressId(), passportModelSql.getAddressId(), API_ADDRESS_ID);
        VerifySoft.verifyEqualsSoft(passport.getSerialNumber(), passportModelSql.getSerialNumber(), API_SERIAL_NUMBER);
        VerifySoft.verifyEqualsSoft(passport.getPassportCode(), passportModelSql.getPassportCode(), API_PASSPORT_CODE);
        VerifySoft.verifyEqualsSoft(passport.getBirthday(), passportModelSql.getBirthday(), API_BIRTHDAY);
        VerifySoft.verifyEqualsSoft(passport.getDateIssue(), passportModelSql.getDateIssue(), API_DATE_ISSUE);
        VerifySoft.verifyEqualsSoft(passport.getTerminationDate(), passportModelSql.getTerminationDate(), API_TERMINATION_DATE);
        VerifySoft.verifyEqualsSoft(passport.getFirstName(), passportModelSql.getFirstName(), API_FIRST_NAME);
        VerifySoft.verifyEqualsSoft(passport.getLastName(), passportModelSql.getLastName(), API_LAST_NAME);
        VerifySoft.verifyEqualsSoft(passport.getPatronymic(), passportModelSql.getPatronymic(), API_PATRONYMIC);
        VerifySoft.verifyEqualsSoft(passport.getBornPlace(), passportModelSql.getBornPlace(), API_BORN_PLACE);
        VerifySoft.verifyEqualsSoft(passport.getDepartmentIssued(), passportModelSql.getDepartmentIssued(), API_DEPARTMENT_ISSUED);
    }
}
