package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class PersonalNewCompanyPage {
    @FindBy(id="w3-success-0")
    public WebElement successMessage;

    @FindBy(linkText = "Update")
    public WebElement btnUpdate;

    @FindBy(xpath="//*[@id='w0']//tr/th")
    public List<WebElement> listPersonalCompanyPageField;

    @FindBy(xpath="//*[@id='w0']//tr/td")
    public List<WebElement> listPersonalCompanyPageData;
}
