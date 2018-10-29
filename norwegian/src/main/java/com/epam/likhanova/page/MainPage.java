package com.epam.likhanova.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {

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

    public void filFlyFromField() {
        flyFromField.clear();
        flyFromField.sendKeys("Warsaw");
    }

    public void clickOnWarsawOptionButton(){
        warsawOptionButton.click();
    }

    public void filFlyToField() {
        flyToField.sendKeys("Tenerife");
    }

    public void clickOnTenerifeAllOptionButton(){
        tenerifeAllOptionButton.click();
    }

    public void clickOnOneWayCheckBox(){
        oneWayCheckBox.click();
    }

    public void clickOnCalendarIcon(){
        calendarIcon.click();
    }

    public void clickOnNextMonthButton(){
        nextMonthButton.click();
    }

    public boolean IsOnNextMonthButtonPresent(){
       return nextMonthButtonDisabled.isEnabled();
    }
}
