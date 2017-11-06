package ScreenObjects;

import ScreenFactories.FacebookLogInScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class FacebookLogInScreen extends BaseTest {

    public static FacebookLogInScreenFactory facebookLogInScreenFactory = new FacebookLogInScreenFactory();

    public FacebookLogInScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), facebookLogInScreenFactory);
        waitForElementToLoad(facebookLogInScreenFactory.logIntoAnotherAccount);
    }

    public void clickLogIntoAnotherAccount() {
        facebookLogInScreenFactory.logIntoAnotherAccount.click();
    }

    public void enterFacebookLogInEmail(String email) {
        waitForElementToLoad(facebookLogInScreenFactory.facebookEmailInputField);
        facebookLogInScreenFactory.facebookEmailInputField.click();
        facebookLogInScreenFactory.facebookEmailInputField.clear();
        facebookLogInScreenFactory.facebookEmailInputField.sendKeys(email);
//        driver.hideKeyboard();
    }

    public void enterFacebookLogInPassword(String password) {
        waitForElementToLoad(facebookLogInScreenFactory.facebookPasswordInputField);
        facebookLogInScreenFactory.facebookPasswordInputField.click();
        facebookLogInScreenFactory.facebookPasswordInputField.clear();
        facebookLogInScreenFactory.facebookPasswordInputField.sendKeys(password);
//        driver.hideKeyboard();
    }

    public OnboardingUserTypeScreen clickLogInButton() {
        waitForElementToLoad(facebookLogInScreenFactory.facebookLogInButton);
        facebookLogInScreenFactory.facebookLogInButton.click();
        return new OnboardingUserTypeScreen();
    }
}
