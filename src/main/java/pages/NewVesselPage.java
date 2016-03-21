package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class NewVesselPage extends MainPage {
    @FindBy(id = "vessel-nodeid")
    public WebElementFacade fieldNodeId;

    @FindBy(id = "vessel-parentcustomerid")
    public WebElementFacade fieldParentCustomerId;

    @FindBy(id = "vessel-suspflag")
    public WebElementFacade checkboxSuspFlag;

    @FindBy(id = "vessel-vesselname")
    public WebElementFacade fieldVesselName;

    @FindBy(id = "vessel-mmsi")
    public WebElementFacade fieldMmsi;

    @FindBy(id="vessel-callsign")
    public WebElementFacade fieldCallSing;

    @FindBy(id="vessel-vesselcountry")
    public WebElementFacade listVesselCountry;

    @FindBy(id="vessel-vesseltype")
    public WebElementFacade listVesselType;

    @FindBy(id="vessel-tonnage")
    public WebElementFacade fieldTonnage;

    @FindBy(id="vessel-imo_number")
    public WebElementFacade fieldImoNumber;

    @FindBy(id="vessel-personsonboard")
    public WebElementFacade fieldPersonsOnBoard;

    @FindBy(id="vessel-aaicid")
    public WebElementFacade listAaicid;

    @FindBy(id = "vessel-seagoingflag")
    public WebElementFacade listSeaGoingFlag;

    @FindBy(id="vessel-selfpropflag")
    public WebElementFacade listSelfProFlag;

    @FindBy(id="vessel-over100grtflag")
    public WebElementFacade listOver100QrtFlag;

    @FindBy(id="vessel-portofregistry")
    public WebElementFacade fieldPortoFregistry;

    @FindBy(id="vessel-yearofbuild")
    public WebElementFacade fieldYearOfBuild;

    @FindBy(id="'vessel-homeport")
    public WebElementFacade fieldHomePort;

}
