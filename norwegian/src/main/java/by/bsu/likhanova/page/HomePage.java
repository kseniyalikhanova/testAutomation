package by.bsu.likhanova.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    private static final int UNAVAILABLE_MONTH_AMOUNT = 13;

    @FindBy(xpath = "//button[@aria-label=\"Close\"][@data-ng-click=\"acceptCookie()\"]")
    private WebElement cookieCloseButton;

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

    /*@FindBy(xpath = "//tr[@ng-repeat=\"row in rows track by $index\"]/td[contains(@headers, \"6-day\")]/button")
    private WebElement firstSunday;*/
    private By firstSunday = By.xpath("//td[@ng-repeat=\"dt in row track by dt.date\"]" +
                                          "[contains(@headers, \"6-day\")]/button");

    @FindBy(id = "adultCount")
    private WebElement adultCount;

    @FindBy(xpath = "//ul[@data-ng-if=\"vm.model.userSelection.isGroupBooking\"]")
    private WebElement msgAboutGroupBooking;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(id = "pageHeaderMenuLink")
    private WebElement menu;

    @FindBy(xpath = "//a[contains(text(), \"Destinations\")]")
    private WebElement destinations;

    @FindBy(xpath = "//a[contains(text(), \"Flight status\")]")
    private WebElement flightStatus;

    @FindBy(xpath = "//div[@id=\"profileHeaderBar\"]/a")
    private WebElement signInLink;

    public void closeCookieButton() {
        cookieCloseButton.click();
    }

    public void selectAirportFrom() {
        flyFromField.clear();
        flyFromField.sendKeys("Warsaw");
        warsawOptionButton.click();
    }

    public void selectAirportTo() {
        flyToField.sendKeys("Tenerife");
        tenerifeAllOptionButton.click();
    }

    public void selectFlightOneWay() {
        oneWayCheckBox.click();
    }

    public boolean checkUnavailabilityOfMonth() {
        calendarIcon.click();
        for (int i = 0; i < UNAVAILABLE_MONTH_AMOUNT; i++) {
            nextMonthButton.click();
        }
        return nextMonthButtonDisabled.isEnabled();
    }

    public boolean checkAvailableValueOfAdultsAmount(final String adultsAmount) {
        selectAdultsAmount(adultsAmount);
        return adultCount.getText().equals(adultsAmount);
    }

    public void selectFirstSundayNextMonth() {
        calendarIcon.click();
        nextMonthButton.click();
        driver.findElements(firstSunday).get(0).click();
    }

    public void selectAdultsAmount(final String adultsAmount) {
        adultCount.clear();
        adultCount.sendKeys(adultsAmount);
    }

    public void goToSearch() {
        new Actions(driver).click(searchButton).perform();
    }

    public boolean isDisplayedMsgAboutGroupBooking() {
        return msgAboutGroupBooking.isDisplayed();
    }

    public void goToMenu() {
        menu.click();
    }

    public void goToDestinations() {
        new Actions(driver).moveToElement(flightStatus).click(destinations).build().perform();
    }

    public void goToFlightStatus() {
        new Actions(driver).moveToElement(flightStatus).click(flightStatus).build().perform();
    }

    public void signIn() {
        signInLink.click();
    }
}
