package com.epam.likhanova.test;

import com.epam.likhanova.driver.DriverProvider;
import com.epam.likhanova.step.MainPageSteps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest {

    private MainPageSteps mainPageSteps;

   @BeforeMethod
   public void openWebPage(){
       DriverProvider.getDriver().get("https://www.norwegian.com/en/");
       mainPageSteps = new MainPageSteps();
   }

    @Test
    public void testCheckAvailabilityOfDates() {
        Assert.assertTrue(mainPageSteps.checkAvailabilityOfMonth());
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
