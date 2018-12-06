package by.bsu.likhanova.step;

import by.bsu.likhanova.page.PassengerPage;

public class PassengerPageStep {
    private PassengerPage passengerPage;

    public PassengerPageStep() {
        passengerPage = new PassengerPage();
    }

    public void fillPassengerForm(final String firstName, final String lastName,
                                  final String email, final String mobileNumber) {
        passengerPage.fillMobileNumber(mobileNumber);
        passengerPage.fillPassengerData(firstName, lastName, email);
    }
}
