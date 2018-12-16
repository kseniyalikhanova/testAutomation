package by.bsu.likhanova.page;


import by.bsu.likhanova.driver.DriverProvider;
import by.bsu.likhanova.step.HomePageStep;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {

    private HomePage homePage;
    private HomePageStep homePageSteps;

    @BeforeMethod
    public void openWebPage() {
        homePage = new HomePage();
        homePageSteps = new HomePageStep();
        DriverProvider.getDriver().get("https://www.norwegian.com/en/");
    }

    @AfterMethod
    public void closeDriver() {
        DriverProvider.closeDriver();
        homePage = null;
        homePageSteps = null;
    }

    @Test
    public void testCheckUnavailabilityOfMonth() {
        Assert.assertTrue(homePageSteps.checkUnavailabilityOfMonth());
    }

    @Test
    public void testCheckChoicePossibilityOfGroupBooking() {
        Assert.assertTrue(homePageSteps.isDisplayedMsgAboutGroupBooking());
    }

    @Test
    public void testCheckUnavailableValuesOfAdultsAmount() {
        homePageSteps.beginBooking();
        Assert.assertFalse(homePage.checkAvailableValueOfAdultsAmount("-1"));
        Assert.assertFalse(homePage.checkAvailableValueOfAdultsAmount("11"));
    }
}
