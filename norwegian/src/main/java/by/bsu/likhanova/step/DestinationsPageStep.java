package by.bsu.likhanova.step;

import by.bsu.likhanova.page.DestinationsPage;
import by.bsu.likhanova.page.MainPage;

public class DestinationsPageStep {
    private MainPage mainPage;
    private DestinationsPage destinationPage;

    public DestinationsPageStep() {
        mainPage = new MainPage();
        destinationPage = new DestinationsPage();
    }

    public boolean searchDestinationsInDiapason() {
        mainPage.closeCookieButton();
        mainPage.goToMenu();
        mainPage.goToDestinations();
        destinationPage.chooseAirport();
        destinationPage.chooseTransitOption();
        destinationPage.chooseBudgetEqualsFiftyEuro();
        //choose budget less than 40
        return true;
    }
}
