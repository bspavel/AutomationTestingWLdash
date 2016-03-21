package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VesselPage extends MainPage {
    @FindBy(id="btncrtves")
    public WebElementFacade btnRegisterVessel;

    public void registerVessel(){
        waitFor(ExpectedConditions.visibilityOf(btnRegisterVessel));
        btnRegisterVessel.click();
    }
}
