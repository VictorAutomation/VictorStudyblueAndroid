package ScreenObjects;

import ScreenFactories.HelloScreenFactory;
import ScreenFactories.LogInChannelsScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LogInChannelsScreen extends BaseTest{

    public static LogInChannelsScreenFactory logInChannelsScreenFactory = new LogInChannelsScreenFactory();

    public LogInChannelsScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), logInChannelsScreenFactory);
        waitForElementToLoad(logInChannelsScreenFactory.signInWithEmailButton);
        waitForElementToLoad(logInChannelsScreenFactory.signInWithGoogleButton);
        waitForElementToLoad(logInChannelsScreenFactory.signInWithFacebookButton);
    }

    public EmailLogInScreen clickSignInWithEmailButton() {
        logInChannelsScreenFactory.signInWithEmailButton.click();
        return new EmailLogInScreen();
    }

    public ChooseGoogleAccountScreen clickSignInWithGoogleButton() {
        logInChannelsScreenFactory.signInWithGoogleButton.click();
        return new ChooseGoogleAccountScreen();
    }

    public LoggedInHomeScreen clickSignInWithFacebookButton() {
        logInChannelsScreenFactory.signInWithFacebookButton.click();
        return new LoggedInHomeScreen();
    }
}
