package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OnboardingSchoolSelectScreenFactory {

    @AndroidFindBy(id = "icon_school")
    public MobileElement iconSchool;

    @AndroidFindBy(id = "hint_edittextvw3")
    public MobileElement schoolInputField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.CheckBox[@index='1']")
    public MobileElement firstSchoolInList;
}
