package by.bsu.likhanova.page;

import by.bsu.likhanova.driver.DriverProvider;
import by.bsu.likhanova.step.HomePageStep;
import by.bsu.likhanova.step.PassengerPageStep;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeatReservationPageTest {
    private HomePageStep homePageSteps;
    private FarePage farePage;
    private LogInOrCreateNewProfilePage logInOrCreateNewProfilePage;
    private PassengerPage passengerPage;
    private PassengerPageStep passengerPageSteps;
    private SeatReservationPage seatReservationPage;


    @BeforeClass
    public void setUp() {
        homePageSteps = new HomePageStep();
        farePage = new FarePage();
        logInOrCreateNewProfilePage = new LogInOrCreateNewProfilePage();
        passengerPage = new PassengerPage();
        passengerPageSteps = new PassengerPageStep();
        seatReservationPage = new SeatReservationPage();
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
    public void testCheckPassenger() {
        homePageSteps.fillFormAndGoToSelectFlight();
        farePage.selectLowFare();
        farePage.goToReservation();
        logInOrCreateNewProfilePage.selectUnregistered();
        passengerPage.selectFemaleGender();
        passengerPage.selectHandBaggageOnly();
        passengerPageSteps.fillPassengerForm("Blabla", "Blablabla",
                                             "blablabla@mail.com", "295794285");
        passengerPage.continueReservation();
        Assert.assertTrue(seatReservationPage.checkPassenger());
    }
}
