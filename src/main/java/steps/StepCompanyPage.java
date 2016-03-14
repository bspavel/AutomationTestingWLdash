package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.CompanyPage;
import pages.MainPage;

public class StepCompanyPage extends ScenarioSteps {
    MainPage mainPage;
    CompanyPage companyPage;

    @Step
    public void goToNewCompanyPage(){
        mainPage.openCompanyPage();
        companyPage.registerCompany();
    }
}
