package ScreenObjects;

import ScreenFactories.LogInChannelsScreenFactory;
import ScreenFactories.SignUpChannelsScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

import static ScreenObjects.FacebookLogInScreen.facebookLogInScreenFactory;
import static java.lang.String.valueOf;

public class SignUpChannelsScreen extends BaseTest {

    public static SignUpChannelsScreenFactory signUpChannelsScreenFactory = new SignUpChannelsScreenFactory();

    public SignUpChannelsScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), signUpChannelsScreenFactory);
        waitForElementToLoad(signUpChannelsScreenFactory.signUpWithEmailButton);
        waitForElementToLoad(signUpChannelsScreenFactory.signUpWithGoogleButton);
        waitForElementToLoad(signUpChannelsScreenFactory.signUpWithFacebookButton);
    }

    public EmailSignUpScreen clickSignUpWithEmailButton() {
        signUpChannelsScreenFactory.signUpWithEmailButton.click();
        return new EmailSignUpScreen();
    }

    public ChooseGoogleAccountScreen clickSignUpWithGoogleButton() {
        signUpChannelsScreenFactory.signUpWithGoogleButton.click();
        return new ChooseGoogleAccountScreen();
    }

    public FacebookLogInScreen clickSignUpWithFacebookButton() {
        signUpChannelsScreenFactory.signUpWithFacebookButton.click();
        return new FacebookLogInScreen();
    }


    public void enterFacebookLogInEmail(String email) {
//        facebookLogInScreenFactory.facebookEmailOrPhoneInputField.clear();
            facebookLogInScreenFactory.facebookEmailInputField.clear();
            facebookLogInScreenFactory.facebookEmailInputField.sendKeys(email);
            driver.hideKeyboard();
    }
}
