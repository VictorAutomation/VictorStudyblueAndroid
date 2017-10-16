package ScreenObjects;

import ScreenFactories.HelloScreenFactory;
import ScreenFactories.OnboardingSchoolSelectScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class OnboardingSchoolSelectScreen extends BaseTest {

    public static OnboardingSchoolSelectScreenFactory onboardingSchoolSelectScreenFactory = new OnboardingSchoolSelectScreenFactory();

    public OnboardingSchoolSelectScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), onboardingSchoolSelectScreenFactory);
        waitForElementToLoad(onboardingSchoolSelectScreenFactory.iconSchool);
        waitForElementToLoad(onboardingSchoolSelectScreenFactory.schoolInputField);
    }

    public OnboardingClassSelectScreen enterSchoolName(String schoolName) {
        onboardingSchoolSelectScreenFactory.schoolInputField.clear();
        onboardingSchoolSelectScreenFactory.schoolInputField.sendKeys(schoolName);
        driver.hideKeyboard();
        onboardingSchoolSelectScreenFactory.firstSchoolInList.click();
        return new OnboardingClassSelectScreen();
    }
}
