package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;


public class CompanyPage extends MainPage {

    @FindBy(id = "btncrtcom")
    public WebElementFacade btnCreateCompany;

    @FindBy(id = "smtBtn")
    public  WebElementFacade submitSelected;

    @FindBy(id = "w5-success-0")
    public WebElementFacade messageConfirmation;

    @FindBy(id = "companysearch-gsearch")
    public WebElementFacade searchField;

    @FindBy(id = "srchbtn")
    public WebElementFacade searchBtn;

    @FindBy(className = "empty")
    public WebElementFacade errorDataEmpty;

    @FindBy(xpath = "//input[@name='selection_all']")
    public WebElementFacade checkBoxAll;


    public void searchInput(String value){
        searchField.type(value);
        searchBtn.waitUntilClickable().click();
    }

    public void clickCheckbox(){
        if(checkBoxAll.isDisplayed()) {
            if (!checkBoxAll.isSelected()) {
                checkBoxAll.click();
            }
        }else{
            System.out.println("element not found");
        }
    }



    public void registerCompany(){
        btnCreateCompany.waitUntilVisible().click();
    }
}
