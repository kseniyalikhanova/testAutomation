package com.epam.likhanova.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {

    private static final int AVAILABLE_MONTH_AMOUNT = 13;
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

    //@FindBy(id = "datepicker-391-9601-6")
    @FindBy(xpath = "//*[@id = \"outboundDate\"]//descendant::tr[1]//td[contains(@headers, \"6-day\")]")
    private WebElement firstSunday;

    @FindBy(id = "adultCount"   )
    private WebElement addAdult;

    @FindBy(xpath = "//ul[@data-ng-if=\"vm.model.userSelection.isGroupBooking\"]")
    private WebElement msgAboutGroupBooking;

    public void chooseFlightDirection(){
        flyFromField.clear();
        flyFromField.sendKeys("Warsaw");
        warsawOptionButton.click();
        flyToField.sendKeys("Tenerife");
        tenerifeAllOptionButton.click();
        oneWayCheckBox.click();
    }

    public boolean checkAvailabilityOfMonth(){
        calendarIcon.click();
        for (int i = 0; i < AVAILABLE_MONTH_AMOUNT; i++) {
            nextMonthButton.click();
        }
        return nextMonthButtonDisabled.isEnabled();
    }

    public void chooseFlightData() {
        calendarIcon.click();
        nextMonthButton.click();
        firstSunday.click();
    }

    public void chooseGroupBooking(){
        addAdult.sendKeys(new StringBuilder(ADULTS_AMOUNT_FOR_GROUP_BOOKING));
    }

    public boolean isDisplayedMsgAboutGroupBooking(){
        return msgAboutGroupBooking.isDisplayed();
    }
}
