package ScreenObjects;

import ScreenFactories.HelloScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class HelloScreen extends BaseTest {

    public static HelloScreenFactory helloScreenFactory = new HelloScreenFactory();

    public HelloScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), helloScreenFactory);
        waitForElementToLoad(helloScreenFactory.signInButton);
        waitForElementToLoad(helloScreenFactory.signUpButton);
    }

    public LogInChannelsScreen clickSignInButton() {
        helloScreenFactory.signInButton.click();
        return new LogInChannelsScreen();
    }

    public SignUpChannelsScreen clickSignUpButton() {
        helloScreenFactory.signUpButton.click();
        return new SignUpChannelsScreen();
    }
}
