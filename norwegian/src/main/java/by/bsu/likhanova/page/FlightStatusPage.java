package by.bsu.likhanova.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FlightStatusPage extends Page {
    @FindBy(id = "delayInfoDirection")
    private WebElement direction;

    @FindBy(xpath = "//select/option[@label=\"departures\"]")
    private WebElement departures;

    @FindBy(xpath = "//i[@aria-label=\"Remove\"]")
    private WebElement clearFlyFromAreaButton;

    @FindBy(id = "airports")
    private WebElement flyFromField;

    @FindBy(xpath = "//ul[@id=\"airports-list\"]//strong[contains(text(), \"Warsaw (WAW)\")]")
    private WebElement warsawOptionButton;

    @FindBy(id = "flightDate")
    private WebElement flightDate;

    @FindBy(xpath = "//option[@label=\"tomorrow\"]")
    private WebElement tomorrowFlightDate;

    @FindBy(id = "resultAirports")
    private WebElement flyToField;

    @FindBy(xpath = "//ul[@id=\"resultAirports-list\"]//a/strong[contains(text(), \"Oslo-Gardermoen (OSL)\")]")
    private WebElement osloOptionButton;

    @FindBy(xpath = "//a/span[@data-translate=\"ReservationDetailsFlightDetails\"]")
    private WebElement reservationDetails;

    @FindBy(xpath = "//select[@data-ng-model=\"vm.phonePrefixAndCountry\"]")
    private WebElement countryMobilePrefix;

    @FindBy(xpath = "//option[contains(text(), \"Belarus (+375)\")]")
    private WebElement belarusMobilePrefix;

    @FindBy(xpath = "//input[@data-ng-model=\"vm.phoneNumber.number\"]")
    private WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-translate=\"FlightTrackerSmsSubscribeButton\"]")
    private WebElement subscribeButton;

    @FindBy(xpath = "//h3[@data-translate=\"FlightTrackerSmsSignupSuccessTitle\"]")
    private WebElement titleAboutSuccessSubscribing;

    @FindBy(xpath = "//p[@data-translate=\"FlightTrackerSmsSignupSuccess\"]")
    private WebElement msgAboutSuccessSubscribing;

    public void selectDirection() {
        direction.click();
        new Actions(driver).moveToElement(departures).click();
    }

    public void selectAirportFrom() {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", clearFlyFromAreaButton);
        clearFlyFromAreaButton.click();
        flyFromField.sendKeys("Warsaw (WAW)");
        warsawOptionButton.click();
    }

    public void selectTomorrowFlightDate() {
        flightDate.click();
        tomorrowFlightDate.click();
    }

    public void selectAirportTo() {
        flyToField.click();
        flyToField.sendKeys("Oslo-Gardermoen (OSL)");
        osloOptionButton.click();
    }

    public void fillMobileNumber(final String newMobileNumber) {
        reservationDetails.click();
        countryMobilePrefix.click();
        belarusMobilePrefix.click();
        mobileNumber.sendKeys(newMobileNumber);
    }

    public void subscribe() {
        subscribeButton.click();
    }

    public boolean isDisplayedMsgAboutSuccessSubscribing() {
        return titleAboutSuccessSubscribing.isDisplayed()
                && msgAboutSuccessSubscribing.isDisplayed();
    }

}
