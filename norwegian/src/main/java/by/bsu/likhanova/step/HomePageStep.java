package by.bsu.likhanova.step;


import by.bsu.likhanova.page.HomePage;

public class HomePageStep {

    private static final int ADULTS_AMOUNT_FOR_GROUP_BOOKING = 10;
    private HomePage mainPage;

    public HomePageStep() {
        mainPage = new HomePage();
    }

    public void selectFlightDirection() {
        mainPage.selectAirportFrom();
        mainPage.selectAirportTo();
        mainPage.selectFlightOneWay();
    }

    public boolean checkUnavailabilityOfMonth() {
        mainPage.closeCookieButton();
        selectFlightDirection();
        return mainPage.checkUnavailabilityOfMonth();
    }

    public void beginBooking() {
        mainPage.closeCookieButton();
        selectFlightDirection();
        mainPage.selectFirstSundayNextMonth();
    }

    public void beginGroupBooking() {
        beginBooking();
        mainPage.selectFirstSundayNextMonth();
        mainPage.selectAdultsAmount(String.valueOf(ADULTS_AMOUNT_FOR_GROUP_BOOKING));
    }

    public void fillFormAndGoToSelectFlight() {
        beginBooking();
        mainPage.goToSearch();
    }

    public void fillFormAndGoToSelectFlightForGroup() {
        beginGroupBooking();
        mainPage.goToSearch();
    }

    public boolean isDisplayedMsgAboutGroupBooking() {
        beginGroupBooking();
        return mainPage.isDisplayedMsgAboutGroupBooking();
    }

    private void goToMenu() {
        mainPage.closeCookieButton();
        mainPage.goToMenu();
    }

    public void goToDestination() {
        goToMenu();
        mainPage.goToDestinations();
    }

    public void goToFlightStatus() {
        goToMenu();
        mainPage.goToFlightStatus();
    }

    public void signIn() {
        mainPage.closeCookieButton();
        mainPage.signIn();
    }
}
