package pages;


import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PersonalNewCompanyPage {
    @FindBy(id="w3-success-0")
    public WebElementFacade successMessage;

    @FindBy(linkText = "Update")
    public WebElementFacade btnUpdate;

    @FindBy(xpath="//*[@id='w0']//tr/th")
    public List<WebElementFacade> listPersonalCompanyPageField;

    @FindBy(xpath="//*[@id='w0']//tr/td")
    public List<WebElementFacade> listPersonalCompanyPageData;
}
