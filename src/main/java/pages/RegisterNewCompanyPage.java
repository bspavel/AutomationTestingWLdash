package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterNewCompanyPage extends MainPage {
    @FindBy(xpath = "//input[@id='company-customerid']")
    public WebElement fieldCustomerId;

    @FindBy(id = "company-parentcustomerid")
    public WebElement fieldParentId;

    @FindBy(id = "company-companyname")
    public WebElement fieldCompanyName;

    @FindBy(xpath = ".//select[@id='company-customertype']")
    public WebElement listCustomerType;

    @FindBy(id = "company-dppersonid")
    public WebElement fieldDppersonID;

    @FindBy(id = "company-firstname")
    public WebElement fieldFirstName;

    @FindBy(id = "company-lastname")
    public WebElement fieldLastName;

    @FindBy(xpath = "//*[@id='w0']//div[10]//span[2]")
    public WebElement btnSelectCountry;

    @FindBy(xpath = "//span/span/span[1]/input")
    public WebElement searchFieldInListCountry;

    @FindBy(xpath = ".//select[@id='company-country']")
    public WebElement listCountry;

    @FindBy(id = "company-address1")
    public WebElement fieldAddress;

    @FindBy(xpath = ".//select[@id='company-state']")
    public WebElement listState;

    @FindBy(xpath = ".//select[@id='Country-select']")
    public WebElement inputCountry;

    @FindBy(xpath = ".//select[@id='State-select']")
    public WebElement inputState;

    @FindBy(id = "company-zip")
    public WebElement fieldZip;

    @FindBy(id = "company-city")
    public WebElement fieldCity;

    @FindBy(id = "company-phonenumber")
    public WebElement fieldPhoneNumber;

    @FindBy(id = "company-fax")
    public WebElement fieldFax;

    @FindBy(id = "company-email")
    public WebElement fieldEmail;

    @FindBy(id = "company-notifemail1")
    public WebElement fieldNotificationsEmail;

    @FindBy(id = "company-emergencyemail")
    public WebElement fieldEmergencyEmail;

    @FindBy(id = "btncrtcom")
    public WebElement btnCreate;

    @FindBy(linkText = "Cancel")
    public WebElement btnCancel;

    @FindBy(xpath = "//ul/li[3]")
    public WebElement headerCreateNewCompanyPage;

    public void clickButtonCreateCompany(){
        waitFor(ExpectedConditions.visibilityOf(btnCreate));
        btnCreate.click();
    }
    public void clickWebElement(WebElement element){
        waitFor(ExpectedConditions.visibilityOf(element));
       element.clear();
    }
    public void selectFromList(String label, List<WebElement> elemList){
        Select select = new Select((WebElement) elemList);
        //select.selectByVisibleText(label);
        select.selectByValue(label);

    }

    public void selectFromCountryList(String value){
        inputCountry.clear();
        inputCountry.sendKeys(value);


    }

    public void selectFromCustomerList(String value){
        Select select = new Select(listCustomerType);
        select.selectByVisibleText(value);

    }

    public void selectFromState(String value){
        inputState.clear();
        inputState.sendKeys();

    }
    public void inputDataInFieldNewCompany(String customerID,String parentID,String companyName,String dppersonId,
                                          String notifEmail,String emergencyEmail){
        clickWebElement(fieldCustomerId);
        fieldCustomerId.sendKeys(customerID);
        isElementPresent(fieldParentId);
        fieldParentId.clear();
        fieldParentId.sendKeys(parentID);
        isElementPresent(fieldCompanyName);
        fieldCompanyName.clear();
        fieldCompanyName.sendKeys(companyName);
        selectFromCustomerList("AIRCRAFT");
        isElementPresent(fieldDppersonID);
        fieldDppersonID.clear();
        fieldDppersonID.sendKeys(dppersonId);
        selectFromCountryList("AND");
        selectFromState("Chubut");
        fieldNotificationsEmail.clear();
        fieldNotificationsEmail.sendKeys(notifEmail);
        isElementPresent(fieldEmergencyEmail);
        fieldEmergencyEmail.clear();
        fieldEmergencyEmail.sendKeys(emergencyEmail);
    }

}
