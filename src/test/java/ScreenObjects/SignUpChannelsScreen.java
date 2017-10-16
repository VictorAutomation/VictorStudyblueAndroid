package ScreenObjects;

import ScreenFactories.LogInChannelsScreenFactory;
import ScreenFactories.SignUpChannelsScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

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
}
