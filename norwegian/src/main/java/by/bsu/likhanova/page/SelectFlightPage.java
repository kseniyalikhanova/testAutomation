package by.bsu.likhanova.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectFlightPage extends Page {

    @FindBy(id = "ctl00_MainContent_ipcGroupTravelAvaDay_lbtContinue")
    private WebElement continueButton;

    public boolean checkTermContentWhenGroupBooking() {
        return !driver.findElements(
                    By.id("ctl00_MainContent_ipcGroupTravelAvaDay_ipcGroupTravelSelection_lblConditionsTitle"))
                .isEmpty();
    }

    public void goToGroupTravelInformation() {
        continueButton.click();
    }
}
