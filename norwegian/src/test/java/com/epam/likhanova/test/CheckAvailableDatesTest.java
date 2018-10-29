package com.epam.likhanova.test;

import com.epam.likhanova.driver.DriverProvider;
import com.epam.likhanova.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckAvailableDatesTest {

   @BeforeMethod
   public void openWebPage(){
       DriverProvider.getDriver().get("https://www.norwegian.com/en/");
   }

    @Test
    public void checkAvalabilityOfDates() {
        MainPage mainPage = new MainPage();
        mainPage.filFlyFromField();
        mainPage.clickOnWarsawOptionButton();
        mainPage.filFlyToField();
        mainPage.clickOnTenerifeAllOptionButton();
        mainPage.clickOnOneWayCheckBox();
        mainPage.clickOnCalendarIcon();
        for (int i = 0; i < 13; i++) {
            mainPage.clickOnNextMonthButton();
        }
        Assert.assertTrue(mainPage.IsOnNextMonthButtonPresent());
    }

    @AfterMethod
    public void closeDriver(){
        DriverProvider.closeDriver();
    }
}
