package jbehave.locatorTest;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pages.CompanyPage;
import pages.LoginPage;
import pages.RegisterNewCompanyPage;

import java.io.IOException;
import java.util.List;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


public class StepsForPages {

    CompanyPage companyPage;
    LoginPage loginPage;
    RegisterNewCompanyPage registerNewCompanyPage;

    //given
    @Given("go to Main page site")
    public void openPage() {
        loginPage.openLoginPage();
    }

    //when

    @When("as an $user input login")
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
        Thread.sleep(2000);
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

    @When("go to Register Company page")
    public void goToRegisterCompany() {
        loginPage.openCompanyPage();
        registerNewCompanyPage.clickButtonCreateCompany();
    }


    @When("input data from xsl $file and check")
    public void setNewCompany(String file) throws IOException, InterruptedException {
        registerNewCompanyPage.inputDataInFieldNewCompany(file);
    }

    @Then("check value on company page")
    public void checkValueOnCompanyPage() {
        List<String> customersCheck = registerNewCompanyPage.getCompanyIDs();
        loginPage.openCompanyPage();
        for (String element : customersCheck) {
            companyPage.searchInput(element);
            companyPage.checkBoxAll.click();
            companyPage.submitSelected.click();
            assertTrue(companyPage.messageConfirmation.getText().equals("Submit Ok"));
        }
    }

    @Then("get success $message")
    public void checkIsCreatedNewCompany(String message) {
        registerNewCompanyPage.confirmSuccess(message);

    }
}
