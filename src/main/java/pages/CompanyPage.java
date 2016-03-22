package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;


public class CompanyPage extends MainPage {

    @FindBy(id = "btncrtcom")
    public WebElementFacade btnCreateCompany;

    @FindBy(id = "smtBtn")
    public  WebElementFacade submitSelected;

    @FindBy(className = "alert-success alert fade in")
    public WebElementFacade messageConfirmation;

    @FindBy(id = "companysearch-gsearch")
    public WebElementFacade searchField;

    @FindBy(id = "srchbtn")
    public WebElementFacade searchBtn;

    @FindBy(className = "empty")
    public WebElementFacade errorDataEmpty;

    @FindBy(className = "select-on-check-all")
    public WebElementFacade checkBoxAll;


    public void searchInput(String value){
        searchField.type(value);
        searchBtn.waitUntilClickable().click();
    }




    public void registerCompany(){
        btnCreateCompany.waitUntilVisible().click();
    }
}
