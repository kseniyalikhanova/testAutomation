package by.bsu.likhanova.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInOrCreateNewProfilePage extends Page {

    @FindBy(id = "ctl00_MainContent_ipcResMakeLogin_IpcResUnregisteredUserBox_btnContinue")
    private WebElement continueUnregisteredButton;

    public void selectUnregistered() {
        continueUnregisteredButton.click();
    }
}
