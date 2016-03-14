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

    @FindBy(xpath = "//*[@id='company-customertype']/@value['RESELLER']")
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

    @FindBy(xpath = "//*[@id='company-country']")
    public List<WebElement> listCountry;

    @FindBy(id = "company-address1")
    public WebElement fieldAddress;

    @FindBy(xpath = "//*[@id='company-state']/@label['Brazil']")
    public WebElement listState;

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

    @FindBy(id = "btnsbm")
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
        isElementPresent(fieldDppersonID);
        fieldDppersonID.clear();
        fieldDppersonID.sendKeys(dppersonId);
        btnSelectCountry.click();
        //searchFieldInListCountry.sendKeys(country);
      //  selectFromList(country, listCountry);
       // searchFieldInListCountry.submit();
       // searchFieldInListCountry.submit();
//        isElementPresent(listCountry);
//        selectFromList(country, listCountry);
        fieldNotificationsEmail.clear();
        fieldNotificationsEmail.sendKeys(notifEmail);
        isElementPresent(fieldEmergencyEmail);
        fieldEmergencyEmail.clear();
        fieldEmergencyEmail.sendKeys(emergencyEmail);
    }

}
