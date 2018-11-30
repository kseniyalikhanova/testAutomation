package by.bsu.likhanova.page;


import by.bsu.likhanova.driver.DriverProvider;
import by.bsu.likhanova.step.MainPageStep;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest {

    private MainPageStep mainPageSteps;
    private static final int AVAILABLE_MONTH_AMOUNT = 11;

    @BeforeMethod
    public void openWebPage(){
        DriverProvider.getDriver().get("https://www.norwegian.com/en/");
        mainPageSteps = new MainPageStep();
    }

    @Test
    public void testCheckUnavailabilityOfDates() {
        Assert.assertTrue(mainPageSteps.checkUnavailabilityOfMonth());
    }

    @Test
    public void testCheckChoicePossibilityOfGroupBooking() {
        Assert.assertTrue(mainPageSteps.isDisplayedMsgAboutGroupBooking());
    }

    @AfterMethod
    public void closeDriver(){
        DriverProvider.closeDriver();
    }
}
