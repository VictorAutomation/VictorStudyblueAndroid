package ScreenObjects;

import ScreenFactories.OnboardingSuggestedClassesScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class OnboardingSuggestedClassesScreen extends BaseTest {

    public static OnboardingSuggestedClassesScreenFactory onboardingSuggestedClassesScreenFactory = new OnboardingSuggestedClassesScreenFactory();

    public OnboardingSuggestedClassesScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), onboardingSuggestedClassesScreenFactory);

        waitForElementToLoad(onboardingSuggestedClassesScreenFactory.nextButton);
    }

    public ProAwarenessScreen clickNextButton() {
        onboardingSuggestedClassesScreenFactory.nextButton.click();
        return new ProAwarenessScreen();
    }
}
