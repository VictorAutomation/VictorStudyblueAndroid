package ScreenObjects;

import ScreenFactories.GoogleLogInScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GoogleLogInScreen extends BaseTest{


    public static GoogleLogInScreenFactory googleLogInScreenFactory = new GoogleLogInScreenFactory();

    public GoogleLogInScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), googleLogInScreenFactory);
        waitForElementToLoad(googleLogInScreenFactory.googleEmailLogInField);
    }
    public void enterGoogleLogInEmail(String email) {
        googleLogInScreenFactory.googleEmailLogInField.clear();
        googleLogInScreenFactory.googleEmailLogInField.sendKeys(email);
    }

    public void clickNextButtonToEnterPassword() {
        googleLogInScreenFactory.emailNextButton.click();
    }

    public void enterGoogleLogInPassword(String password) {
        googleLogInScreenFactory.googlePasswordLogInField.clear();
        googleLogInScreenFactory.googlePasswordLogInField.sendKeys(password);
    }

    public OnboardingUserTypeScreen clickNextButton() {
        googleLogInScreenFactory.passwordNextButton.click();
        return new OnboardingUserTypeScreen();
    }

}
