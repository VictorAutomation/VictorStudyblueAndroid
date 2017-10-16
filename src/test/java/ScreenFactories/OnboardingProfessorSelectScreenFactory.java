package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OnboardingProfessorSelectScreenFactory {

    @AndroidFindBy(id = "choose_instruct")
    public MobileElement chooseInstructor;

    @AndroidFindBy(xpath = "//android.widget.ListView[@index='2']/android.widget.TextView[contains(@resource-id,'text1') and @index='0']")
    public MobileElement firstInstructorInList;
}
