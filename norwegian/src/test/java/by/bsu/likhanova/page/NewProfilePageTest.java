package by.bsu.likhanova.page;

import by.bsu.likhanova.driver.DriverProvider;
import by.bsu.likhanova.step.HomePageStep;
import by.bsu.likhanova.step.NewProfilePageStep;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewProfilePageTest {
    private HomePageStep homePageSteps;
    private MyTravelsPage travelsPage;
    private NewProfilePage newProfilePage;
    private NewProfilePageStep newProfilePageSteps;

    @BeforeClass
    public void setUp() {
        homePageSteps = new HomePageStep();
        travelsPage = new MyTravelsPage();
        newProfilePage = new NewProfilePage();
        newProfilePageSteps = new NewProfilePageStep();
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
    public void testRegisterWithNumberInFirstNameAndLastName() {
        homePageSteps.signIn();
        travelsPage.register();
        newProfilePage.selectFemaleGender();
        newProfilePageSteps.fillContactInformation("blablabla2@mail.com", "norwegian2",
                                                   "Blabla2", "Blablabla2",
                                                   "295794285");
        newProfilePage.createProfile();
        Assert.assertTrue(newProfilePage.isDisplayedMsgAboutIncorrectData());
    }
}
