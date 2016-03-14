package jbehave;


import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import steps.StepCompanyPage;
import steps.StepLoginPage;
import steps.StepMainPage;


public class StepsForPages {
    @Steps
    StepMainPage stepMainPage;
    StepLoginPage stepLoginPage;
    StepCompanyPage stepCompanyPage;

    //given
    @Given("go to Main page site")
    public void openPage() {
        stepMainPage.openLoginPage();
    }

   //when
    @When("as an admin input data $username and $password")
    public void setLoginPage(String username, String password) {
        stepLoginPage.actionLogin(username, password);
    }

    @When("as an user input data $username and $password")
    public void setLoginAsUserPage(String username, String password) {
        stepLoginPage.actionLogin(username, password);
    }

    //then

    @Then("link Logout is displayed")
    public void checkIsLogin() {
        stepMainPage.clickLogoutPage();
    }

    @Then("get error message $expectedResult near Username and Password fields")
    public void getErrorMessage(String expectedResult) {
        stepLoginPage.getMessageIncorrectData(expectedResult);
    }

    @When("go to Register Company page")
    public void goToRegisterCompany() {
    //    stepLoginPage.goToNewCompanyPage();
    }


    @When("input data $customerID and $parentID and $companyName and $dppersonId and $notifEmail " +
            "and $emergencyEmail")
    public void setNewCompany(String customerID, String parentID, String companyName, String dppersonId,
                              String notifEmail, String emergencyEmail) {
        stepLoginPage.createNewCompany(customerID, parentID, companyName, dppersonId, notifEmail,
                emergencyEmail);
    }
    @Then ("get success $message")
    public void checkIsCreatedNewCompany(String message){
        stepLoginPage.checkNewCompany(message);

    }
}
