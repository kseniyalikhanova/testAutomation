package by.bsu.likhanova.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewProfilePage extends Page {

    @FindBy(id = "username")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "passwordConfirm")
    private WebElement passwordConfirm;

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "gender")
    private WebElement gender;

    @FindBy(xpath = "//option[@label=\"Female\"]")
    private WebElement femaleOptionButton;

    @FindBy(xpath = "//select[@data-ng-model=\"vm.phonePrefixAndCountry\"]")
    private WebElement countriesMobilePrefix;

    @FindBy(xpath = "//option[contains(text(), \"Belarus (+375)\")]")
    private WebElement belarusMobilePrefix;

    @FindBy(xpath = "//input[@data-ng-model=\"vm.phoneNumber.number\"]")
    private WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-ng-click=\"vm.save(createProfileForm)\"]")
    private WebElement saveButton;

    @FindBy(xpath = "//h3[contains(text(), \"Ooops. Something went wrong!\")]")
    private WebElement errorMsgWhenIncorrectData;

    @FindBy(xpath = "//p[contains(text(), \"You have entered an invalid character. " +
            "Only the alphabet and the character '-' are valid.\")]")
    private WebElement errorMsgAboutInvalidCharacter;

    @FindBy(xpath = "//p[contains(text(), \"Input is not valid. Please try again with different input. \")]")
    private WebElement errorMsgAboutInvalidInput;

    public void fillContactInformation(final String newEmail, final String newPassword,
                                       final String newFirstName, final String newLastName) {
        email.sendKeys(newEmail);
        password.sendKeys(newPassword);
        passwordConfirm.sendKeys(newPassword);
        firstName.sendKeys(newFirstName);
        lastName.sendKeys(newLastName);
    }

    public void selectFemaleGender() {
        gender.click();
        femaleOptionButton.click();
    }

    public void fillMobileNumber(final String newMobileNumber) {
        countriesMobilePrefix.click();
        belarusMobilePrefix.click();
        mobileNumber.sendKeys(newMobileNumber);
    }

    public void createProfile() {
        saveButton.click();
    }

    public boolean isDisplayedMsgAboutIncorrectData() {
        return errorMsgWhenIncorrectData.isDisplayed()
                && errorMsgAboutInvalidCharacter.isDisplayed()
                && errorMsgAboutInvalidInput.isDisplayed();
    }
}
