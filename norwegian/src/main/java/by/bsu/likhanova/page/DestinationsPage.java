package by.bsu.likhanova.page;

import by.bsu.likhanova.action.SecondaryAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DestinationsPage extends Page {
    @FindBy(xpath = "//a[@class=\"link-departure\"]")
    private WebElement flyFromField;

    @FindBy(xpath = "//i[@aria-label=\"Remove\"]")
    private WebElement clearFlyFromAreaButton;

    @FindBy(xpath = "//strong[contains(text(), \"Warsaw (WAW)\")]")
    private WebElement warsawOptionButton;

    @FindBy(xpath = "//span[@data-options=\"filters.transitOptions\"]")
    private WebElement transitOptions;

    @FindBy(xpath = "//option[contains(text(), \"direct only\")]")
    private WebElement directOnlyOptionButton;

    @FindBy(xpath = "//span[@class=\"slider__value\"]")
    private WebElement fiftyEuro;

    @FindBy(xpath = "//div[@class=\"slider__slide\"]")
    private WebElement budgetSlider;

    public void chooseAirport() {
        Actions actions = new Actions(driver);
        actions.moveToElement(flyFromField).click().perform();
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", clearFlyFromAreaButton);
        clearFlyFromAreaButton.click();
        flyFromField.sendKeys("Warsaw (WAW)");
        warsawOptionButton.click();
    }

    public void chooseTransitOption() {
        transitOptions.click();
        directOnlyOptionButton.click();
    }

    public void chooseBudgetEqualsFiftyEuro() {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                        budgetSlider, "style",
                        SecondaryAction.changedPositionValueOfSlider(fiftyEuro, budgetSlider));

    }
}
