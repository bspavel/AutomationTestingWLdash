package jbehave.locatorTest;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pages.*;
import xlsExtractor.ReadExcel;

import java.io.IOException;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


public class StepsForPages {
    MainPage mainPage;
    LoginPage loginPage;
    CompanyPage companyPage;
    VesselPage vesselPage;
    RegisterNewCompanyPage registerNewCompanyPage;
    ReadExcel readExcel;

    //Given
    @Given("go to Main page site")
    public void openPage() {
        loginPage.openLoginPage();
    }

    //When
    @When("as an $role input login")
    public void setLoginAsUserPage(String user) throws InterruptedException {
        switch (user) {
            case "user":
                loginPage.loginAs("tester","qwertyuiop");
                break;
            case "admin":
                loginPage.loginAs("pavel","qwertyuiop");
                break;
            case "validation":
                loginPage.loginAs("","");
                break;
            case "validation2":
                loginPage.loginAs("123","123");
        }
    }

    @When("go to Register Company page")
    public void goToRegisterCompany(){
        mainPage.openCompanyPage();
        companyPage.clickBtnRegisterCompany();
    }

    @When("go to Register Vessel page")
    public void goToRegisterVessel() {
        mainPage.openVesselPage();
        vesselPage.clickBtnRegisterVessel();
    }

//    @When("input data $customerID and $parentID and $companyName and $dppersonId and $country and $notifEmail and $emergencyEmail")
//    public void setNewCompany(String customerID, String parentID, String companyName, String dppersonId, String country,
//                              String notifEmail, String emergencyEmail) {
//        registerNewCompanyPage.inputDataInFieldNewCompany(customerID, parentID, companyName, dppersonId, country, notifEmail,
//                emergencyEmail);
//    }

    @When("to enter data $typePage in fields")
    public void setNewDataInFields(String typePage) throws InterruptedException {
        int numSheet=0;
        switch (typePage) {
            case "company":
                numSheet=0;
                break;
            case "vessel":
                numSheet=1;
                break;
        }
    }

    @When("input data from xsl $file and check")
    public void setNewCompany(String file, int numSheet) throws IOException, InterruptedException {
        registerNewCompanyPage.inputDataInFieldNewCompany(file);
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



    @Then("check value on company page")
    public void checkValueOnCompanyPage() {
//        List<String> customersCheck = registerNewCompanyPage.getCompanyIDs();
//        loginPage.openCompanyPage();
//        for (String element : customersCheck) {
//            companyPage.searchInput(element);
//            companyPage.clickCheckbox();
//            companyPage.submitSelected.click();
//            String actualResult=companyPage.messageConfirmation.getText();
//            Assert.assertThat(actualResult, CoreMatchers.containsString("Submit Ok"));
//        }
    }


    @Then("get success $message")
    public void checkIsCreatedNewCompany(String message) {
        registerNewCompanyPage.confirmSuccess(message);

    }
}
