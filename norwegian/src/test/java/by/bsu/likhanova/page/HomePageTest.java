package by.bsu.likhanova.page;


import by.bsu.likhanova.driver.DriverProvider;
import by.bsu.likhanova.step.HomePageStep;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {

    private HomePageStep homePageSteps;

    @BeforeClass
    public void setUp() {
        homePageSteps = new HomePageStep();
    }
    @BeforeMethod
    public void openWebPage(){
        DriverProvider.getDriver().get("https://www.norwegian.com/en/");
    }

    @AfterMethod
    public void closeDriver(){
        DriverProvider.closeDriver();
    }

    @Test
    public void testCheckUnavailabilityOfMonth() {
        Assert.assertTrue(homePageSteps.checkUnavailabilityOfMonth());
    }

    @Test
    public void testCheckChoicePossibilityOfGroupBooking() {
        Assert.assertTrue(homePageSteps.isDisplayedMsgAboutGroupBooking());
    }
}
