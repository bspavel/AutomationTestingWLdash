package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class MainPage extends PageObject {
    @FindBy(linkText = "Company")
    public WebElement linkCompany;

    @FindBy(linkText = "Vessel")
    public WebElement linkVessel;

    @FindBy(linkText = "Login")
    public WebElement linkSingIn;

    @FindBy(id="logout")
    public WebElement linkLogOut;

    public boolean isElementPresent(WebElement webElement) {
        try {
            webElement.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void openLoginPage(){
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
        getDriver().get("http://project.loc");
        waitFor(ExpectedConditions.visibilityOf(linkSingIn));
        linkSingIn.click();
    }
    public void logoutPersonal(){
        waitFor(ExpectedConditions.visibilityOf(linkLogOut));
        linkLogOut.click();
    }
    public void openCompanyPage(){
        waitFor(ExpectedConditions.visibilityOf(linkCompany));
        linkCompany.click();
    }
    public void openVesselPage(){
        waitFor(ExpectedConditions.visibilityOf(linkVessel));
        linkVessel.click();
    }
}
