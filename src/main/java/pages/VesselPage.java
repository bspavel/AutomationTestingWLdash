package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VesselPage extends MainPage {
    @FindBy(id="btncrtves")
    public WebElement btnRegisterVessel;

    public void registerVessel(){
        waitFor(ExpectedConditions.visibilityOf(btnRegisterVessel));
        btnRegisterVessel.click();
    }
}
