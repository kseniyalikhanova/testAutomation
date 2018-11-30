package by.bsu.likhanova.step;


import by.bsu.likhanova.page.MainPage;

public class MainPageStep {
    private MainPage mainPage;

    public MainPageStep(){
        mainPage = new MainPage();
    }

    public void chooseFlightDirection() {
        mainPage.chooseAirportFrom();
        mainPage.chooseAirportTo();
        mainPage.chooseFlightOneWay();
    }

    public boolean checkUnavailabilityOfMonth(){
        mainPage.closeCookieButton();
        chooseFlightDirection();
        return mainPage.checkUnavailabilityOfMonth();
    }

    public void beginBooking() {
        mainPage.closeCookieButton();
        chooseFlightDirection();
        mainPage.chooseFirstSundayNextMonth();
    }

    public void beginGroupBooking() {
        beginBooking();
        mainPage.chooseGroupBooking();
    }

    public boolean isDisplayedMsgAboutGroupBooking() {
        beginGroupBooking();
        return mainPage.isDisplayedMsgAboutGroupBooking();
    }
}
