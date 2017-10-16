package ScreenObjects;

import ScreenFactories.HelloScreenFactory;
import ScreenFactories.OnboardingUserTypeScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.fail;

public class OnboardingUserTypeScreen extends BaseTest {

    public static OnboardingUserTypeScreenFactory onboardingUserTypeScreenFactory = new OnboardingUserTypeScreenFactory();

    public OnboardingUserTypeScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), onboardingUserTypeScreenFactory);
        waitForElementToLoad(onboardingUserTypeScreenFactory.studentOption);
        waitForElementToLoad(onboardingUserTypeScreenFactory.teacherOption);
        waitForElementToLoad(onboardingUserTypeScreenFactory.learnerOption);
    }

    public OnboardingSchoolSelectScreen chooseUserType(String userType) {
        switch (userType) {
            case "student":
                onboardingUserTypeScreenFactory.studentOption.click();
                break;
            case "teacher":
                onboardingUserTypeScreenFactory.teacherOption.click();
                break;
            case "learner":
                onboardingUserTypeScreenFactory.learnerOption.click();
                break;
            default:
                fail("Can not click on any option");
        }
        return new OnboardingSchoolSelectScreen();
    }
}
