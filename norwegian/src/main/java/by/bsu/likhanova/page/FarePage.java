package by.bsu.likhanova.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FarePage extends Page {

    @FindBy(id = "FlightSelectOutboundStandardLowFare0")
    private WebElement lowFare;

    @FindBy(xpath = "//div[@id=\"ctl00_MainContent_ipcAvaDay_upnlResSelection\"]" +
            "//td[contains(text(), \"Warsaw - Oslo-Gardermoen\")]")
    private WebElement outboundFirstFlight;

    @FindBy(xpath = "//div[@id=\"ctl00_MainContent_ipcAvaDay_upnlResSelection\"]" +
            "//td[contains(text(), \"Oslo-Gardermoen - Tenerife-Sout\")]")
    private WebElement outboundSecondFlight;

    //@FindBy(id = "ctl00_MainContent_ipcAvaDay_lbtContinue")
    @FindBy(xpath = "//a[contains(text(), \"Start reservation\")]")
    private WebElement startReservationButton;

    public void selectLowFare() {
        new Actions(driver).click(lowFare).perform();
    }

    public boolean checkFlight() {
        return outboundFirstFlight.isDisplayed()
                && outboundSecondFlight.isDisplayed();
    }

    public void goToReservation() {
        new Actions(driver).moveToElement(startReservationButton).click(startReservationButton).build().perform();
    }
}
