package by.bsu.likhanova.page;

import by.bsu.likhanova.driver.DriverProvider;
import by.bsu.likhanova.step.FlightStatusPageStep;
import by.bsu.likhanova.step.HomePageStep;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlightStatusPageTest {
    private HomePageStep homePageSteps;
    private FlightStatusPageStep flightStatusPageSteps;

    @BeforeClass
    public void setUp() {
        homePageSteps = new HomePageStep();
        flightStatusPageSteps = new FlightStatusPageStep();
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
    public void testIsDisplayedMsgAboutSuccessSubscribing() {
        homePageSteps.goToFlightStatus();
        flightStatusPageSteps.selectFlightDirectionAndTomorrowDate();
        Assert.assertTrue(flightStatusPageSteps.isDisplayedMsgAboutSuccessSubscribing("295794281"));
    }
}
