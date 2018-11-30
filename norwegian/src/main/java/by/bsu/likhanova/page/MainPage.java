package by.bsu.likhanova.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {

    private static final int UNAVAILABLE_MONTH_AMOUNT = 13;
    private static final int ADULTS_AMOUNT_FOR_GROUP_BOOKING = 10;

    @FindBy(id = "airport-select-origin")
    private WebElement flyFromField;

    @FindBy(id = "airport-select-destination")
    private WebElement flyToField;

    @FindBy(xpath = "//span[contains(text(), \"Warsaw (WAW)\")]")
    private WebElement warsawOptionButton;

    @FindBy(xpath = "//span[contains(text(), \"Tenerife-All airports\")]")
    private WebElement tenerifeAllOptionButton;

    @FindBy(xpath = "//span[contains(text(), \"One-way\")]")
    private WebElement oneWayCheckBox;

    @FindBy(xpath = "//input[@data-ng-focus = \"focus()\"]")
    private WebElement calendarIcon;

    @FindBy(xpath = "//button/i[@class = \"glyphicon glyphicon-chevron-right\"]")
    private WebElement nextMonthButton;

    @FindBy(xpath = "//button[@disabled]/i[@class = \"glyphicon glyphicon-chevron-right\"]")
    private WebElement nextMonthButtonDisabled;

    @FindBy(xpath = "//button[@aria-label=\"Close\"][@data-ng-click=\"acceptCookie()\"]")
    private WebElement cookieCloseButton;

    @FindBy(xpath = "//tr[@ng-repeat=\"row in rows track by $index\"]/td[contains(@headers, \"6-day\")]/button")
    private WebElement firstSunday;
    //*[@id = \"outboundDate\"]/descendant::tr[1]"+"/td[contains(@headers, \"6-day\")/button]

    @FindBy(id = "adultCount")
    private WebElement addAdult;

    @FindBy(xpath = "//ul[@data-ng-if=\"vm.model.userSelection.isGroupBooking\"]")
    private WebElement msgAboutGroupBooking;

    @FindBy(id = "pageHeaderMenuLink")
    private WebElement menu;

    @FindBy(xpath = "//li/a[contains(text(), \"Destinations\")]")
    private WebElement destinations;

    public void closeCookieButton() {
        cookieCloseButton.click();
    }

    public void chooseAirportFrom() {
        flyFromField.clear();
        flyFromField.sendKeys("Warsaw");
        warsawOptionButton.click();
    }

    public void chooseAirportTo() {
        flyToField.sendKeys("Tenerife");
        tenerifeAllOptionButton.click();
    }

    public void chooseFlightOneWay() {
        oneWayCheckBox.click();
    }

    public boolean checkUnavailabilityOfMonth() {
        calendarIcon.click();
        for (int i = 0; i < UNAVAILABLE_MONTH_AMOUNT; i++) {
            nextMonthButton.click();
        }
        return nextMonthButtonDisabled.isEnabled();
    }

    public void chooseFirstSundayNextMonth() {
        calendarIcon.click();
        nextMonthButton.click();
        firstSunday.click();

    }

    public void chooseGroupBooking() {
        addAdult.clear();
        addAdult.sendKeys(String.valueOf(ADULTS_AMOUNT_FOR_GROUP_BOOKING));
    }

    public boolean isDisplayedMsgAboutGroupBooking() {
        return msgAboutGroupBooking.isDisplayed();
    }

    public void goToMenu() {
        menu.click();
    }

    public void goToDestinations() {
        new Actions(driver).click(destinations).perform();
    }
}
