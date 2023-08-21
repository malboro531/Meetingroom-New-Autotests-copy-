package steps;

import api.pages.FilterScreen;
import io.qameta.allure.Step;

public class FilterStep {

    protected FilterScreen filterScreen;

    @Step("On 'Filter' screen")
    public void onFilterScreen() {
        filterScreen = new FilterScreen();
    }
}
