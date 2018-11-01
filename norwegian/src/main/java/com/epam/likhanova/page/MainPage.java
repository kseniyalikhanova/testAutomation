package com.epam.likhanova.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {

    private static final int AVAILABLE_MONTH_AMOUNT = 13;

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

    public boolean checkAvailabilityOfDates(){
        flyFromField.clear();
        flyFromField.sendKeys("Warsaw");
        warsawOptionButton.click();
        flyToField.sendKeys("Tenerife");
        tenerifeAllOptionButton.click();
        oneWayCheckBox.click();
        calendarIcon.click();
        for (int i = 0; i < AVAILABLE_MONTH_AMOUNT; i++) {
            nextMonthButton.click();
        }
        return nextMonthButtonDisabled.isEnabled();
    }
}