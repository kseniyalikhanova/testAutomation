package by.bsu.likhanova.step;


import by.bsu.likhanova.page.HomePage;

public class HomePageStep {
    private HomePage mainPage;

    public HomePageStep(){
        mainPage = new HomePage();
    }

    public void selectFlightDirection() {
        mainPage.selectAirportFrom();
        mainPage.selectAirportTo();
        mainPage.selectFlightOneWay();
    }

    public boolean checkUnavailabilityOfMonth(){
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
        mainPage.selectGroupBooking();
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

    public void goToDestination() {
        mainPage.closeCookieButton();
        mainPage.goToMenu();
        mainPage.goToDestinations();
    }

    public void goToFlightStatus() {
        mainPage.closeCookieButton();
        mainPage.goToMenu();
        mainPage.goToFlightStatus();
    }
}
