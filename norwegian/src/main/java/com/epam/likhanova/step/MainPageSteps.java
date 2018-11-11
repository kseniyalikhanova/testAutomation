package com.epam.likhanova.step;

import com.epam.likhanova.page.MainPage;

public class MainPageSteps {
    private MainPage mainPage;

    public MainPageSteps(){
        mainPage = new MainPage();
    }

    public boolean checkAvailabilityOfMonth(){
        mainPage.chooseFlightDirection();
        return mainPage.checkAvailabilityOfMonth();
    }

    public boolean isDisplayedMsgAboutGroupBooking() {
        mainPage.chooseFlightDirection();
        mainPage.chooseFlightData();
        mainPage.chooseGroupBooking();
        return mainPage.isDisplayedMsgAboutGroupBooking();
    }
}
