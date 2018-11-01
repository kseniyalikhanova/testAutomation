package com.epam.likhanova.test;

import com.epam.likhanova.driver.DriverProvider;
import com.epam.likhanova.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest {

   @BeforeMethod
   public void openWebPage(){
       DriverProvider.getDriver().get("https://www.norwegian.com/en/");
   }

    @Test
    public void testCheckAvailabilityOfDates() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.checkAvailabilityOfDates());
    }

    @AfterMethod
    public void closeDriver(){
        DriverProvider.closeDriver();
    }
}
