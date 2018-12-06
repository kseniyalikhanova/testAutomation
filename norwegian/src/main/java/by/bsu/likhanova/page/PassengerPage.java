package by.bsu.likhanova.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PassengerPage extends Page {

    @FindBy(id = "ctl00_MainContent_ipcResMakePax_ipcPaxBox_rptTravellers_ctl01_txtFirstName")
    private WebElement firstName;

    @FindBy(id = "ctl00_MainContent_ipcResMakePax_ipcPaxBox_rptTravellers_ctl01_txtLastName")
    private WebElement lastName;

    @FindBy(id = "ctl00_MainContent_ipcResMakePax_ipcPaxBox_rptTravellers_ctl01_ddlGender")
    private WebElement gender;

    @FindBy(xpath = "//option[@value=\"FEMALE\"]")
    private WebElement femaleOptionButton;

    @FindBy(id = "ctl00_MainContent_ipcResMakePax_ipcPaxBox_rptTravellers_ctl01_ddlOutboundLuggage")
    private WebElement baggageOutbound;

    @FindBy(xpath = "//option[contains(text(), \"Hand baggage only\")]")
    private WebElement handBaggageOnlyOptionButton;

    @FindBy(id = "ctl00_MainContent_ipcResMakePax_ipcContactInfo_ipcCountriesMobilePrefix_ddlDropdownList")
    private WebElement countriesMobilePrefix;

    @FindBy(xpath = "//option[contains(text(), \"Belarus\")]")
    private WebElement belarusMobilePrefix;

    @FindBy(id = "ctl00_MainContent_ipcResMakePax_ipcContactInfo_txtMobileNumber")
    private WebElement mobileNumber;

    @FindBy(id = "ctl00_MainContent_ipcResMakePax_ipcContactInfo_txtEmailPrivate")
    private WebElement email;

    @FindBy(id = "ctl00_MainContent_ipcResMakePax_ipcContinueButtonBar_lnkContinue")
    private WebElement continueReservationButton;

    public void fillMobileNumber(final String newMobileNumber) {
        countriesMobilePrefix.click();
        belarusMobilePrefix.click();
        mobileNumber.sendKeys(newMobileNumber);
    }

    public void selectFemaleGender() {
        gender.click();
        femaleOptionButton.click();
    }

    public void selectHandBaggageOnly() {
        baggageOutbound.click();
        handBaggageOnlyOptionButton.click();
    }

    public void fillPassengerData(final String newFirstName,
                                  final String newLastName,
                                  final String newEmail) {
        firstName.sendKeys(newFirstName);
        lastName.sendKeys(newLastName);
        email.sendKeys(newEmail);
    }

    public void continueReservation() {
        new Actions(driver).click(continueReservationButton).perform();

    }
}
