package ScreenObjects;

import ScreenFactories.DateOfBirthSignUpScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class DateOfBirthSignUpScreen extends BaseTest {


    public static DateOfBirthSignUpScreenFactory dateOfBirthSignUpScreenFactory = new DateOfBirthSignUpScreenFactory();

    public DateOfBirthSignUpScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), dateOfBirthSignUpScreenFactory);
        waitForElementToLoad(dateOfBirthSignUpScreenFactory.monthInputField);
        waitForElementToLoad(dateOfBirthSignUpScreenFactory.dayInputField);
        waitForElementToLoad(dateOfBirthSignUpScreenFactory.yearInputField);
    }

    public void enterValidBirthMonth(String month) {
        dateOfBirthSignUpScreenFactory.monthInputField.click();
        dateOfBirthSignUpScreenFactory.monthInputField.sendKeys(month);
        driver.hideKeyboard();
    }

    public void enterValidBirthDay(String day) {
        dateOfBirthSignUpScreenFactory.dayInputField.click();
        dateOfBirthSignUpScreenFactory.dayInputField.sendKeys(day);
        driver.hideKeyboard();
    }

    public void enterValidBirthYear(String year) {
        dateOfBirthSignUpScreenFactory.yearInputField.click();
        dateOfBirthSignUpScreenFactory.yearInputField.sendKeys(year);
        driver.hideKeyboard();
    }

    public EmailSignUpScreen clickOkButton() {
        dateOfBirthSignUpScreenFactory.okButton.click();
        return new EmailSignUpScreen();
    }
}
