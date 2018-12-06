package by.bsu.likhanova.step;

import by.bsu.likhanova.page.GroupTravelInformationPage;

public class GroupTravelInformationPageStep {
    private GroupTravelInformationPage groupTravelInformationPage;

    public GroupTravelInformationPageStep() {
        groupTravelInformationPage = new GroupTravelInformationPage();
    }

    private void fillGroupForm(final String groupName, final String firstName,
                               final String lastName, final String email,
                               final String phoneNumber, final String companyName,
                               final String invoiceAddress, final String zipCode,
                               final String postalArea, final String passengersAmountWithoutInfants) {
        groupTravelInformationPage.fillPhoneNumber(phoneNumber);
        groupTravelInformationPage.selectBelarus();
        groupTravelInformationPage.fillGroupData(groupName, firstName, lastName, email,
                                                 companyName, invoiceAddress, zipCode,
                                                 postalArea, passengersAmountWithoutInfants);
    }

    private void sendRequest() {
        groupTravelInformationPage.confirm();
        groupTravelInformationPage.sendRequest();
    }

    public boolean isDisplayedMsgAboutBlankFields(
                        final String groupName, final String firstName,
                        final String lastName, final String email,
                        final String phoneNumber, final String companyName,
                        final String invoiceAddress, final String zipCode,
                        final String postalArea, final String passengersAmountWithoutInfants) {

        fillGroupForm(groupName, firstName, lastName, email,
                      phoneNumber, companyName, invoiceAddress, zipCode,
                      postalArea, passengersAmountWithoutInfants);
        sendRequest();
        return groupTravelInformationPage.isDisplayedMsgAboutBlankFields();
    }
}
