package ScreenObjects;

import ScreenFactories.HelloScreenFactory;
import ScreenFactories.OnboardingClassSelectScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class OnboardingClassSelectScreen extends BaseTest {

    public static OnboardingClassSelectScreenFactory onboardingClassSelectScreenFactory = new OnboardingClassSelectScreenFactory();

    public OnboardingClassSelectScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), onboardingClassSelectScreenFactory);
        waitForElementToLoad(onboardingClassSelectScreenFactory.iconClass);
        waitForElementToLoad(onboardingClassSelectScreenFactory.classInputField);

    }

    public OnboardingProfessorSelectScreen enterClassName(String className) {
        onboardingClassSelectScreenFactory.classInputField.clear();
        onboardingClassSelectScreenFactory.classInputField.sendKeys(className);
        driver.hideKeyboard();
        onboardingClassSelectScreenFactory.firstClassInList.click();
        return new OnboardingProfessorSelectScreen();
    }
}
