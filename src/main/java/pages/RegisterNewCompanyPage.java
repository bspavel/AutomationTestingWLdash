package pages;


import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterNewCompanyPage extends MainPage {

    private List <String> companyIDs;

    @FindBy(xpath = "//input[@id='company-customerid']")
    public WebElementFacade fieldCustomerId;

    @FindBy(id = "company-parentcustomerid")
    public WebElementFacade fieldParentId;

    @FindBy(id = "company-companyname")
    public WebElementFacade fieldCompanyName;

    @FindBy(xpath = ".//select[@id='company-customertype']")
    public WebElementFacade listCustomerType;

    @FindBy(id = "company-dppersonid")
    public WebElementFacade fieldDppersonID;

    @FindBy(id = "company-firstname")
    public WebElementFacade fieldFirstName;

    @FindBy(id = "company-lastname")
    public WebElementFacade fieldLastName;

    @FindBy(xpath = "//*[@id='w0']//div[10]//span[2]")
    public WebElementFacade btnSelectCountry;

    @FindBy(xpath = "//span/span/span[1]/input")
    public WebElementFacade searchFieldInListCountry;

    @FindBy(xpath = ".//select[@id='company-country']")
    public WebElementFacade listCountry;

    @FindBy(id = "company-address1")
    public WebElementFacade fieldAddress;

    @FindBy(xpath = ".//select[@id='company-state']")
    public WebElementFacade listState;

    @FindBy(id = "select2-Country-select-container")
    public WebElementFacade inputCountry;

    @FindBy(id = "select2-State-select-container")
    public WebElementFacade inputState;

    @FindBy(id = "company-zip")
    public WebElementFacade fieldZip;

    @FindBy(id = "company-city")
    public WebElementFacade fieldCity;

    @FindBy(id = "company-phonenumber")
    public WebElementFacade fieldPhoneNumber;

    @FindBy(id = "company-fax")
    public WebElementFacade fieldFax;

    @FindBy(id = "company-email")
    public WebElementFacade fieldEmail;

    @FindBy(xpath = ".//input[@id='company-notifemail']")
    public WebElementFacade fieldNotificationsEmail;

    @FindBy(xpath = ".//input[@id='company-emergencyemail']")
    public WebElementFacade fieldEmergencyEmail;

    @FindBy(id = "btncrtcom")
    public WebElementFacade btnCreate;

    @FindBy(linkText = "Cancel")
    public WebElementFacade btnCancel;

    @FindBy(xpath = "//ul/li[3]")
    public WebElementFacade headerCreateNewCompanyPage;

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
    public void selectFromList(String label, List<WebElementFacade> elemList){
        Select select = new Select((WebElementFacade) elemList);
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

    public void inputDataInFieldNewCompany(String filePath) throws IOException, InterruptedException {
        String temp = filePath;
        temp.replace("/",File.separator);

//        File src = new File(filePath);
        FileInputStream fis = new FileInputStream(new File(temp));

        XSSFWorkbook workbook = new XSSFWorkbook(fis); // load the workbook
        XSSFSheet schedule = workbook.getSheetAt(0);// get the sheet which you want to modify or create or read
        List <String> arrTemp = new ArrayList<>();

        for(int i=1;i<=schedule.getLastRowNum();i++){
            Thread.sleep(3000);
            openCompanyPage();
            clickButtonCreateCompany();
            String companyID= schedule.getRow(i).getCell(0).getStringCellValue();
            fieldCustomerId.type(companyID);
            arrTemp.add(companyID);
            fieldParentId.type(schedule.getRow(i).getCell(1).getStringCellValue());
            fieldCompanyName.type(schedule.getRow(i).getCell(2).getStringCellValue());
            selectFromCustomerList(schedule.getRow(i).getCell(3).getStringCellValue());
            fieldDppersonID.type(schedule.getRow(i).getCell(4).getStringCellValue());
            selectFromCountryList(schedule.getRow(i).getCell(5).getStringCellValue());
            selectFromStateList(schedule.getRow(i).getCell(6).getStringCellValue());
            fieldNotificationsEmail.type(schedule.getRow(i).getCell(7).getStringCellValue());
            fieldEmergencyEmail.type(schedule.getRow(i).getCell(8).getStringCellValue());
            btnSubmit.waitUntilClickable().click();
            Thread.sleep(1000);

        }
        setCompanyIDs(arrTemp);
    }

    public List<String> getCompanyIDs() {
        return companyIDs;
    }

    public void setCompanyIDs(List<String> companyIDs) {
        this.companyIDs = companyIDs;
    }
}
