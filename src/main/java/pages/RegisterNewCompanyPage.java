package pages;


import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @FindBy(id = "select2-Country-select-container")
    public WebElement inputCountry;

    @FindBy(id = "select2-State-select-container")
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

    @FindBy(xpath = ".//input[@id='company-notifemail']")
    public WebElementFacade fieldNotificationsEmail;

    @FindBy(xpath = ".//input[@id='company-emergencyemail']")
    public WebElementFacade fieldEmergencyEmail;

    @FindBy(id = "btncrtcom")
    public WebElement btnCreate;

    @FindBy(linkText = "Cancel")
    public WebElement btnCancel;

    @FindBy(xpath = "//ul/li[3]")
    public WebElement headerCreateNewCompanyPage;

    @FindBy(id = "btnsbm")
    public WebElementFacade btnSubmit;

    @FindBy(className = "alert-success alert fade in")
    public WebElementFacade confirmationMessage;

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

    public void selectFromStateList(String value){
        inputState.click();
        inputState.sendKeys(Keys.ENTER);
        inputState.sendKeys(Keys.ARROW_DOWN);
        inputState.sendKeys(Keys.ENTER);
        WebElement inputVal;
        try {
            inputVal = getDriver().findElement(By.xpath(".//input[@class='select2-search__field']"));
            inputVal.sendKeys(value);
            inputVal.sendKeys(Keys.ENTER);
        } catch (Exception io) {
            io.printStackTrace();
        }


    }

    public void selectFromCustomerList(String value){
        Select select = new Select(listCustomerType);
        select.selectByVisibleText(value);

    }

    public void selectFromCountryList(String value){
        inputCountry.click();
        inputCountry.sendKeys(Keys.ENTER);
        inputCountry.sendKeys(Keys.ARROW_DOWN);
        inputCountry.sendKeys(Keys.ENTER);
        WebElement inputVal;
        try {
            inputVal = getDriver().findElement(By.xpath(".//input[@class='select2-search__field']"));
            inputVal.sendKeys(value);
            inputVal.sendKeys(Keys.ENTER);
        } catch (Exception io) {
            io.printStackTrace();
        }
    }

    public void confirmSuccess(String message){
        String actual=confirmationMessage.getText();
        assert(actual.equals(message));
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
        selectFromCountryList("ZZZ");
        selectFromStateList("Chubut");
        fieldNotificationsEmail.type(notifEmail);
        fieldEmergencyEmail.type(emergencyEmail);
        btnSubmit.click();

    }

}
