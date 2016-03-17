package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CompanyPage extends MainPage {

    @FindBy(id = "btncrtcom")
    public WebElement btnCreateCompany;

    public void clickBtnRegisterCompany(){
        waitFor(ExpectedConditions.visibilityOf(btnCreateCompany));
        btnCreateCompany.click();
    }
}
