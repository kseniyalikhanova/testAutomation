package by.bsu.likhanova.page;

import by.bsu.likhanova.driver.DriverProvider;
import by.bsu.likhanova.step.HomePageStep;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FarePageTest {
    private HomePageStep homePageSteps;
    private FarePage farePage;

    @BeforeClass
    public void setUp() {
       farePage = new FarePage();
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
    public void testCheckFlight() {
        homePageSteps.fillFormAndGoToSelectFlight();
        farePage.selectLowFare();
        Assert.assertTrue(farePage.checkFlight());
    }
}