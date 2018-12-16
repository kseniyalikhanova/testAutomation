package by.bsu.likhanova.page;

import by.bsu.likhanova.driver.DriverProvider;
import by.bsu.likhanova.step.HomePageStep;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectFlightPageTest {

    private HomePageStep homePageSteps;
    private SelectFlightPage selectFlightPage;

    @BeforeClass
    public void setUp() {
        homePageSteps = new HomePageStep();
        selectFlightPage = new SelectFlightPage();
    }

    @BeforeMethod
    public void openWebPage() {
        DriverProvider.getDriver().get("https://www.norwegian.com/en/");
    }

    @AfterMethod
    public void closeDriver() {
        DriverProvider.closeDriver();
    }

    @Test
    public void testCheckTermContentWhenGroupBooking() {
        homePageSteps.fillFormAndGoToSelectFlightForGroup();
        Assert.assertTrue(selectFlightPage.checkTermContentWhenGroupBooking());
    }
}