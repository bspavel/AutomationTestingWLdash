package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MainPage {

    @FindBy(id = "loginform-username")
    public WebElement fieldUsername;

    @FindBy(id = "loginform-password")
    public WebElement fieldPassword;

    @FindBy(name = "login-button")
    public WebElement buttonLogin;

    @FindBy(xpath = "//*[@id='login-form']/div[2]//p")
    public WebElement messageEmptyPasswordOrIncorrectData;

    @FindBy(xpath="//div[@class='site-login']//h1")
    public WebElement titleWayLoginPage;

//    @FindBy(id = "loginform-rememberme")
//    public WebElement checkBoxRememberMe;

//    @FindBy(xpath = "//*[@id='login-form']/div[1]//p")
//    public WebElement messageEmptyUsernameField;



    public void loginAs(String username, String password) {
        fieldUsername.clear();
        fieldUsername.sendKeys(username);
        fieldPassword.clear();
        fieldPassword.sendKeys(password);
        buttonLogin.click();
    }
}
