package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CompanyPage extends MainPage {

    @FindBy(id = "btncrtcom")
    public WebElementFacade btnCreateCompany;

    public void registerCompany(){
        waitFor(ExpectedConditions.visibilityOf(btnCreateCompany));
        btnCreateCompany.click();
    }
}
