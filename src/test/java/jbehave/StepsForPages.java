package jbehave;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pages.*;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


public class StepsForPages {
    MainPage mainPage;
    LoginPage loginPage;
    CompanyPage companyPage;
    VesselPage vesselPage;
    RegisterNewCompanyPage registerNewCompanyPage;

    //given
    @Given("go to Main page site")
    public void openPage() {
        loginPage.openLoginPage();
    }

    //when
    @When("as an $role input login")
    public void setLoginAsUserPage(String user) throws InterruptedException {
        switch (user) {
            case "user":
                loginPage.loginAs("tester", "qwertyuiop");

                break;
            case "admin":
                loginPage.loginAs("pavel", "qwertyuiop");

                break;
            case "validation":
                loginPage.loginAs("", "");
                break;
            case "validation2":
                loginPage.loginAs("123", "123");
        }
        // Thread.sleep(2000);
    }

    @When("go to Register Company page")
    public void goToRegisterCompany() {
        mainPage.openCompanyPage();
        companyPage.clickBtnRegisterCompany(); //тут внесла изминение
        //registerNewCompanyPage.clickButtonCreateCompany();
    }

    @When("go to Register Vessel page")
    public void goToRegisterVessel() {
        mainPage.openVesselPage();
        vesselPage.clickBtnRegisterVessel();
    }

    @When("input data $customerID and $parentID and $companyName and $dppersonId and $country and $notifEmail and $emergencyEmail")
    public void setNewCompany(String customerID, String parentID, String companyName, String dppersonId, String country,
                              String notifEmail, String emergencyEmail) {
        registerNewCompanyPage.inputDataInFieldNewCompany(customerID, parentID, companyName, dppersonId, country, notifEmail,
                emergencyEmail);
    }

    @When("to enter data in fields")
    public void setNewCompany(){

    }

    //then
    @Then("link Logout is displayed")
    public void checkIsLogin() {
        loginPage.logoutPersonal();
    }

    @Then("get error message $expectedResult near Username and Password fields")
    public void getErrorMessage(String expectedResult) {
        String expectedResult1 = expectedResult;
        String actualResult = loginPage.messageEmptyPasswordOrIncorrectData.getText();
        assertTrue("incorrect comparing with:" + expectedResult1 + " ", actualResult.equals(expectedResult));
    }




    @Then("get success $message")
    public void checkIsCreatedNewCompany(String message) {
        registerNewCompanyPage.confirmSuccess(message);

    }
}
