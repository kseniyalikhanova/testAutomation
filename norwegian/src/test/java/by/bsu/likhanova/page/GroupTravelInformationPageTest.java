package by.bsu.likhanova.page;

import by.bsu.likhanova.driver.DriverProvider;
import by.bsu.likhanova.step.GroupTravelInformationPageStep;
import by.bsu.likhanova.step.HomePageStep;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupTravelInformationPageTest {
    private GroupTravelInformationPageStep groupTravelInformationPageSteps;
    private HomePageStep homePageSteps;
    private SelectFlightPage selectFlightPage;

    @BeforeClass
    public void setUp() {
        groupTravelInformationPageSteps = new GroupTravelInformationPageStep();
        homePageSteps = new HomePageStep();
        selectFlightPage = new SelectFlightPage();
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
    public void testIsDisplayedMsgAboutBlankFields() {
        homePageSteps.fillFormAndGoToSelectFlightForGroup();
        selectFlightPage.goToGroupTravelInformation();
        Assert.assertTrue(
                groupTravelInformationPageSteps.isDisplayedMsgAboutBlankFields(
                    "Adventures", "Blabla",
                    "Blablabla", "blablabla@mail.com", "295794285",
                    "Abra", "", "16", "23456",
                    "10"
        ));
    }
}