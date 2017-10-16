package ScreenObjects;

import ScreenFactories.FacebookLogInScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class FacebookLogInScreen extends BaseTest {

    public static FacebookLogInScreenFactory facebookLogInScreenFactory = new FacebookLogInScreenFactory();

    public FacebookLogInScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), facebookLogInScreenFactory);
        waitForElementToLoad(facebookLogInScreenFactory.logIntoAnotherAccountButton);
    }

    public void clickLogIntoAnotherAccount() {
        facebookLogInScreenFactory.logIntoAnotherAccountButton.click();
    }

    public void enterFacebookLogInEmail(String email) {
        facebookLogInScreenFactory.facebookEmailOrPhoneInputField.clear();
        facebookLogInScreenFactory.facebookEmailInputField.clear();
        facebookLogInScreenFactory.facebookEmailInputField.sendKeys(email);
        driver.hideKeyboard();
    }

    public void enterFacebookLogInPassword(String password) {
        facebookLogInScreenFactory.facebookPasswordInputField.clear();
        facebookLogInScreenFactory.facebookPasswordInputField.sendKeys(password);
        driver.hideKeyboard();
    }

    public OnboardingUserTypeScreen clickLogInButton() {
        waitForElementToLoad(facebookLogInScreenFactory.facebookLogInButton);
        facebookLogInScreenFactory.facebookLogInButton.click();
        return new OnboardingUserTypeScreen();
    }
}
