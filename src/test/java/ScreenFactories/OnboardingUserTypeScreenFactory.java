package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OnboardingUserTypeScreenFactory {

    @AndroidFindBy(id = "student_lay")
    public MobileElement studentOption;

    @AndroidFindBy(id = "teacher_lay")
    public MobileElement teacherOption;

    @AndroidFindBy(id = "nonstudent_lay")
    public MobileElement learnerOption;
}
