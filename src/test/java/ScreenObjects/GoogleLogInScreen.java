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
//        googleLogInScreenFactory.googlePasswordLogInField.clear();
        googleLogInScreenFactory.googlePasswordLogInField.sendKeys(password);
    }

    public void clickNextButton() {
        googleLogInScreenFactory.passwordNextButton.click();
    }

    public void agreeToTermsOfService() {
        try {
            waitForElementToLoad(googleLogInScreenFactory.iAgreeButton);
            googleLogInScreenFactory.iAgreeButton.click();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public OnboardingUserTypeScreen allowToUseYourInformation() {
        try {
            waitForElementToLoad(googleLogInScreenFactory.allowButton);
            googleLogInScreenFactory.allowButton.click();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new OnboardingUserTypeScreen();
    }
}
