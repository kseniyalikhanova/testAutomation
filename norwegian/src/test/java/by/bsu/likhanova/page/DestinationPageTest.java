package by.bsu.likhanova.page;

import by.bsu.likhanova.driver.DriverProvider;
import by.bsu.likhanova.step.DestinationsPageStep;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DestinationPageTest {
    private DestinationsPageStep destinationsPageSteps;

    @BeforeMethod
    public void openWebPage(){
        DriverProvider.getDriver().get("https://www.norwegian.com/en/");
        destinationsPageSteps = new DestinationsPageStep();
    }

    @Test
    public void testSearchDestinationsInDiapason() {
        Assert.assertTrue(destinationsPageSteps.searchDestinationsInDiapason());
    }

    @AfterMethod
    public void closeDriver(){
        DriverProvider.closeDriver();
    }
}
