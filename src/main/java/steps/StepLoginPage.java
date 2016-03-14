package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.*;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

public class StepLoginPage extends ScenarioSteps {

    LoginPage loginPage;
   // MainPage mainPage;
    CompanyPage companyPage;
    RegisterNewCompanyPage registerNewCompanyPage;
    PersonalNewCompanyPage personalNewCompanyPage;


    @Step
    public void actionLogin(String username, String password){
        String expectedResult="#3c763d";
        loginPage.loginAs(username, password);
        //assertTrue();
    }

    @Step
    public void getMessageIncorrectData(String errorMessage){
        String expectedResult = errorMessage;
        String actualResult=loginPage.messageEmptyPasswordOrIncorrectData.getText();
        assertTrue("incorrect comparing with:" + errorMessage + " ", actualResult.equals(expectedResult));

    }

    @Step
    public void createNewCompany(String customerID, String parentID, String companyName, String dppersonId,
                                 String notifEmail,String emergencyEmail){
        registerNewCompanyPage.inputDataInFieldNewCompany(customerID, parentID, companyName, dppersonId,
                notifEmail, emergencyEmail);
    }
    @Step
    public void checkNewCompany(String message){
        String expectedResult=message;
        String actualResult =personalNewCompanyPage.successMessage.getText();
        assertTrue(expectedResult.equals(actualResult));

    }
}
