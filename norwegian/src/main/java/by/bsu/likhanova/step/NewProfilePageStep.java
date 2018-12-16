package by.bsu.likhanova.step;

import by.bsu.likhanova.page.NewProfilePage;

public class NewProfilePageStep {
    private NewProfilePage newProfilePage;

    public NewProfilePageStep() {
        newProfilePage = new NewProfilePage();
    }

    public void fillContactInformation(final String email, final String password,
                                       final String firstName, final String lastName,
                                       final String mobileNumber) {
        newProfilePage.fillContactInformation(email, password, firstName, lastName);
        newProfilePage.fillMobileNumber(mobileNumber);
    }
}
