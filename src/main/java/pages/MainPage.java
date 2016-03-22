package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class MainPage extends PageObject {
    @FindBy(linkText = "Company")
    public WebElementFacade linkCompany;

    @FindBy(linkText = "Vessel")
    public WebElementFacade linkVessel;

    @FindBy(linkText = "Login")
    public WebElementFacade linkSingIn;

    @FindBy(id="logout")
    public WebElementFacade linkLogOut;

    public boolean isElementPresent(WebElement webElement) {
        try {
            webElement.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void openLoginPage(){
        getDriver().get("http://project.loc");
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();

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
        linkVessel.waitUntilClickable().click();
    }
}
