package ScreenObjects;

import ScreenFactories.EmailLogInScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class EmailLogInScreen extends BaseTest{

    public static EmailLogInScreenFactory emailLogInScreenFactory = new EmailLogInScreenFactory();

    public EmailLogInScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), emailLogInScreenFactory);
        waitForElementToLoad(emailLogInScreenFactory.emailInputField);
        waitForElementToLoad(emailLogInScreenFactory.passwordInputField);
        waitForElementToLoad(emailLogInScreenFactory.goButton);
    }

    public void enterValidLogInEmail(String email) {
        emailLogInScreenFactory.emailInputField.clear();
        emailLogInScreenFactory.emailInputField.sendKeys(email);
        driver.hideKeyboard();
    }

    public void enterValidLogInPassword(String password) {
        emailLogInScreenFactory.passwordInputField.clear();
        emailLogInScreenFactory.passwordInputField.sendKeys(password);
        driver.hideKeyboard();
    }

    public LoggedInHomeScreen clickGoButton() {
        emailLogInScreenFactory.goButton.click();
        return new LoggedInHomeScreen();
    }
}
