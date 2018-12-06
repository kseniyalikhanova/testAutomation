package by.bsu.likhanova.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeatReservationPage extends Page {
    @FindBy(xpath = "//div[@id=\"ctl00_MainContent_ipcResMakeSeating_upnlResSelection\"]" +
            "//td[contains(text(), \"Blabla BlaBlaBla\")]")
    private WebElement firstAndLastName;

    @FindBy(xpath = "//div[@id=\"ctl00_MainContent_ipcResMakeSeating_upnlResSelection\"]" +
            "//div[contains(text(), \"blablabla\")]")
    private WebElement login;

    @FindBy(xpath = "//div[@id=\"ctl00_MainContent_ipcResMakeSeating_upnlResSelection\"]" +
            "//wbr[wbr[contains(text(), \"@mail.com\")]]")
    private WebElement domain;

    public boolean checkPassenger() {
        return firstAndLastName.isDisplayed()
                && login.isDisplayed()
                && domain.isDisplayed();
    }
}
