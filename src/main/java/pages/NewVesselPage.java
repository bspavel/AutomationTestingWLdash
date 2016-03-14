package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewVesselPage extends MainPage {
    @FindBy(id = "vessel-nodeid")
    public WebElement fieldNodeId;

    @FindBy(id = "vessel-parentcustomerid")
    public WebElement fieldParentCustomerId;

    @FindBy(id = "vessel-suspflag")
    public WebElement checkboxSuspFlag;

    @FindBy(id = "vessel-vesselname")
    public WebElement fieldVesselName;

    @FindBy(id = "vessel-mmsi")
    public WebElement fieldMmsi;

    @FindBy(id="vessel-callsign")
    public WebElement fieldCallSing;

    @FindBy(id="vessel-vesselcountry")
    public WebElement listVesselCountry;

    @FindBy(id="vessel-vesseltype")
    public WebElement listVesselType;

    @FindBy(id="vessel-tonnage")
    public WebElement fieldTonnage;

    @FindBy(id="vessel-imo_number")
    public WebElement fieldImoNumber;

    @FindBy(id="vessel-personsonboard")
    public WebElement fieldPersonsOnBoard;

    @FindBy(id="vessel-aaicid")
    public WebElement listAaicid;

    @FindBy(id = "vessel-seagoingflag")
    public WebElement listSeaGoingFlag;

    @FindBy(id="vessel-selfpropflag")
    public WebElement listSelfProFlag;

    @FindBy(id="vessel-over100grtflag")
    public WebElement listOver100QrtFlag;

    @FindBy(id="vessel-portofregistry")
    public WebElement fieldPortoFregistry;

    @FindBy(id="vessel-yearofbuild")
    public WebElement fieldYearOfBuild;

    @FindBy(id="'vessel-homeport")
    public WebElement fieldHomePort;

}
