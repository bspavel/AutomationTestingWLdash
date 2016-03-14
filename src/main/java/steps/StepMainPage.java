package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.*;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

public class StepMainPage extends ScenarioSteps {
    MainPage mainPage;
    LoginPage loginPage;

    @Step
    public void openLoginPage(){
        String expectedResult="Login";
        String actualResult=loginPage.titleWayLoginPage.getText();
        mainPage.openLoginPage();
        assertTrue(actualResult.equals(expectedResult));
    }

    @Step
    public void clickLogoutPage(){
        mainPage.logoutPersonal();
    }
}




