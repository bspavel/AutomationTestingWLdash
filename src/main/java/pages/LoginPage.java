package pages;


import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MainPage {

    @FindBy(id = "loginform-username")
    public WebElementFacade fieldUsername;

    @FindBy(id = "loginform-password")
    public WebElementFacade fieldPassword;

    @FindBy(name = "login-button")
    public WebElementFacade buttonLogin;

    @FindBy(xpath = "//*[@id='login-form']/div[2]//p")
    public WebElementFacade messageEmptyPasswordOrIncorrectData;

    @FindBy(xpath="//div[@class='site-login']//h1")
    public WebElementFacade titleWayLoginPage;

//    @FindBy(id = "loginform-rememberme")
//    public WebElementFacade checkBoxRememberMe;

//    @FindBy(xpath = "//*[@id='login-form']/div[1]//p")
//    public WebElementFacade messageEmptyUsernameField;




    public void loginAs(String username, String password) {
        fieldUsername.clear();
        fieldUsername.sendKeys(username);
        fieldPassword.clear();
        fieldPassword.sendKeys(password);
        buttonLogin.click();

    }
}
