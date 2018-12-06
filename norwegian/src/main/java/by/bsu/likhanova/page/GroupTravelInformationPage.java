package by.bsu.likhanova.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GroupTravelInformationPage extends Page {

    @FindBy(id = "ctl00_MainContent_ipcGroupTravelForm_ipcGroupTravelInfo_txtGroupName")
    private WebElement groupName;

    @FindBy(id = "ctl00_MainContent_ipcGroupTravelForm_ipcGroupTravelInfo_txtFirstName")
    private WebElement firstName;

    @FindBy(id = "ctl00_MainContent_ipcGroupTravelForm_ipcGroupTravelInfo_txtLastName")
    private WebElement lastName;

    @FindBy(id = "ctl00_MainContent_ipcGroupTravelForm_ipcGroupTravelInfo_txtEmail")
    private WebElement email;

    @FindBy(id = "ctl00_MainContent_ipcGroupTravelForm_ipcGroupTravelInfo_ipcCountriesPhonePrefix_ddlDropdownList")
    private WebElement countriesPhonePrefix;

    @FindBy(xpath = "//option[contains(text(), \"Belarus\")]")
    private WebElement belarusPhonePrefix;

    @FindBy(id = "ctl00_MainContent_ipcGroupTravelForm_ipcGroupTravelInfo_txtPhoneNumber")
    private WebElement phoneNumber;

    @FindBy(id = "ctl00_MainContent_ipcGroupTravelForm_ipcGroupTravelInfo_txtCompanyName")
    private WebElement companyName;

    @FindBy(id = "ctl00_MainContent_ipcGroupTravelForm_ipcGroupTravelInfo_txtInvoiceAddress")
    private WebElement invoiceAddress;

    @FindBy(id = "ctl00_MainContent_ipcGroupTravelForm_ipcGroupTravelInfo_txtZipCode")
    private WebElement zipCode;

    @FindBy(id = "ctl00_MainContent_ipcGroupTravelForm_ipcGroupTravelInfo_txtPostalArea")
    private WebElement postalArea;

    @FindBy(id = "ctl00_MainContent_ipcGroupTravelForm_ipcGroupTravelInfo_ipcCountry")
    private WebElement country;

    @FindBy(xpath = "//option[contains(text(), \"Belarus (EUR)\")]")
    private WebElement belarusOptionButton;

    @FindBy(id = "ctl00_MainContent_ipcGroupTravelForm_ipcGroupTravelInfo_txtNumberOfPax")
    private WebElement passengersAmountWithoutInfants;

    @FindBy(id = "checkboxConfirm")
    private WebElement checkboxConfirm;

    @FindBy(id = "ctl00_MainContent_ipcGroupTravelForm_ipcContinueButtonBar_lnkContinue")
    private WebElement sendRequestButton;

    @FindBy(id = "ctl00_MainContent_ipcGroupTravelForm_ipcMessageBoard_lblHeader")
    private WebElement msgAboutBlankFields;

    @FindBy(xpath = "//div[@id=\"ctl00_MainContent_ipcGroupTravelForm_ipcMessageBoard_pnlMessageBox\"]" +
            "/li[@class=\"messageitem\"]")
    private WebElement blankInvoiceAddress;

    public void fillPhoneNumber(final String newPhoneNumber) {
        countriesPhonePrefix.click();
        belarusPhonePrefix.click();
        phoneNumber.sendKeys(newPhoneNumber);
    }

    public void selectBelarus() {
        country.click();
        belarusOptionButton.click();
    }

    public void fillGroupData(final String newGroupName, final String newFirstName,
                              final String newLastName, final String newEmail,
                              final String newCompanyName, final String newInvoiceAddress,
                              final String newZipCode, final String newPostalArea,
                              final String newPassengersAmountWithoutInfants) {
        groupName.sendKeys(newGroupName);
        firstName.sendKeys(newFirstName);
        lastName.sendKeys(newLastName);
        email.sendKeys(newEmail);
        companyName.sendKeys(newCompanyName);
        invoiceAddress.sendKeys(newInvoiceAddress);
        zipCode.sendKeys(newZipCode);
        postalArea.sendKeys(newPostalArea);
        passengersAmountWithoutInfants.sendKeys(newPassengersAmountWithoutInfants);
    }

    public void confirm() {
        checkboxConfirm.click();
    }

    public void sendRequest() {
        sendRequestButton.click();
    }

    public boolean isDisplayedMsgAboutBlankFields() {
        List<WebElement> blankFields = driver.findElements(By.xpath("//ul[@class=\"messagelist\"]/li"));
        return msgAboutBlankFields.isDisplayed()
                && blankFields.size() == 1
                && blankFields.get(0).getText().trim().equals("Invoice address is missing.");
    }

}
