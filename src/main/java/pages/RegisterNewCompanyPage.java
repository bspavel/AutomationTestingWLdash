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

    public void inputDataInFieldNewCompany(String file, int numSheet)throws IOException, InterruptedException{
            String temp = filePath;
            temp.replace("/", File.separator);

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

}
