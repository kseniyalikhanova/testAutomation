package by.bsu.likhanova.step;

import by.bsu.likhanova.page.FlightStatusPage;

public class FlightStatusPageStep {
    private FlightStatusPage flightStatusPage;

    public FlightStatusPageStep() {
        flightStatusPage = new FlightStatusPage();
    }

    public void selectFlightDirectionAndTomorrowDate() {
        flightStatusPage.selectTomorrowFlightDate();
        flightStatusPage.selectDirection();
        flightStatusPage.selectAirportFrom();
        flightStatusPage.selectAirportTo();
    }

    public boolean isDisplayedMsgAboutSuccessSubscribing(final String mobileNumber) {
        flightStatusPage.fillMobileNumber(mobileNumber);
        flightStatusPage.subscribe();
        return flightStatusPage.isDisplayedMsgAboutSuccessSubscribing();
    }
}
