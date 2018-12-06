package by.bsu.likhanova.step;

import by.bsu.likhanova.page.DestinationsPage;

public class DestinationsPageStep {
    private DestinationsPage destinationPage;

    public DestinationsPageStep() {
        destinationPage = new DestinationsPage();
    }

    public boolean searchDestinationsInDiapason() {
        destinationPage.selectAirport();
        destinationPage.selectTransitOption();
        destinationPage.selectBudgetEqualsFiftyEuro();
        //choose budget less than 40
        return true;
    }
}
