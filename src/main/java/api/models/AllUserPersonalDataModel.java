package api.models;

import api.models.controllers.AddressModel;
import api.models.controllers.PassportModel;
import api.models.controllers.UserModel;
import lombok.Getter;

@Getter
public class AllUserPersonalDataModel {

    private UserModel user;
    private PassportModel passport;
    private AddressModel address;
}
