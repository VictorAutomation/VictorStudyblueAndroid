package ScreenObjects;

import ScreenFactories.EmailSignUpScreenFactory;
import Utils.BaseTest;
import Utils.RandomGenerator;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class EmailSignUpScreen extends BaseTest{

    public static EmailSignUpScreenFactory emailSignUpScreenFactory = new EmailSignUpScreenFactory();

    public EmailSignUpScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), emailSignUpScreenFactory);
        waitForElementToLoad(emailSignUpScreenFactory.fistNameInputField);
        waitForElementToLoad(emailSignUpScreenFactory.lastNameInputField);
        waitForElementToLoad(emailSignUpScreenFactory.emailInputField);
        waitForElementToLoad(emailSignUpScreenFactory.passwordInputField);
        waitForElementToLoad(emailSignUpScreenFactory.dateOfBirthInputField);
        waitForElementToLoad(emailSignUpScreenFactory.getStartedButton);
    }

    public void enterValidFirstName() {
        String firstName = RandomGenerator.generateAlphabetStrings(1, 8, false).iterator().next();
        emailSignUpScreenFactory.fistNameInputField.clear();
        emailSignUpScreenFactory.fistNameInputField.sendKeys(firstName);
        driver.hideKeyboard();
    }

    public void enterValidLastName() {
        String lastName = RandomGenerator.generateAlphabetStrings(1, 8, false).iterator().next();
        emailSignUpScreenFactory.lastNameInputField.clear();
        emailSignUpScreenFactory.lastNameInputField.sendKeys(lastName);
        driver.hideKeyboard();
    }

    public void enterValidEmail() {
        String emailAddress = RandomGenerator.generateSimpleStrings(1, 10, false).iterator().next();
        emailSignUpScreenFactory.emailInputField.clear();
        emailSignUpScreenFactory.emailInputField.sendKeys("no-reply+AndroidAutoTest"+emailAddress.concat("@studyblue.com"));
        driver.hideKeyboard();
    }

    public void enterValidPassword() {
        String password = "qweqwe";
        emailSignUpScreenFactory.passwordInputField.clear();
        emailSignUpScreenFactory.passwordInputField.sendKeys(password);
        driver.hideKeyboard();
    }

    public DateOfBirthSignUpScreen clickOnDOBInputField() {
        emailSignUpScreenFactory.dateOfBirthInputField.click();
        return new DateOfBirthSignUpScreen();
    }

    public OnboardingUserTypeScreen clickGetStartedButton() {
        emailSignUpScreenFactory.getStartedButton.click();
        return new OnboardingUserTypeScreen();
    }
}
