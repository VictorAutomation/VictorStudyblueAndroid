package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EmailSignUpScreenFactory {

    @AndroidFindBy(id = "emailSignupFirstName")
    public MobileElement fistNameInputField;

    @AndroidFindBy(id = "emailSignupLastName")
    public MobileElement lastNameInputField;

    @AndroidFindBy(id = "emailSignupEmail")
    public MobileElement emailInputField;

    @AndroidFindBy(id = "emailSignupPassword")
    public MobileElement passwordInputField;

    @AndroidFindBy(id = "dateOfBirthEditText")
    public MobileElement dateOfBirthInputField;

    @AndroidFindBy(id = "emailSignupButton")
    public MobileElement getStartedButton;
}
