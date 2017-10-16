package ScreenObjects;

import ScreenFactories.HelloScreenFactory;
import ScreenFactories.OnboardingProfessorSelectScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class OnboardingProfessorSelectScreen extends BaseTest {

    public static OnboardingProfessorSelectScreenFactory onboardingProfessorSelectScreenFactory = new OnboardingProfessorSelectScreenFactory();

    public OnboardingProfessorSelectScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), onboardingProfessorSelectScreenFactory);
        waitForElementToLoad(onboardingProfessorSelectScreenFactory.chooseInstructor);
        waitForElementToLoad(onboardingProfessorSelectScreenFactory.firstInstructorInList);
    }

    public ProAwarenessScreen chooseProfessor() {
        onboardingProfessorSelectScreenFactory.firstInstructorInList.click();
        return new ProAwarenessScreen();
    }
}
