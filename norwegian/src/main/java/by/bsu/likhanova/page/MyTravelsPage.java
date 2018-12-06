package by.bsu.likhanova.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyTravelsPage extends Page {

    @FindBy(xpath = "//a[@data-translate=\"LoginBoxRegister\"]")
    private WebElement registerLink;

    public void register() {
        registerLink.click();
    }
}
