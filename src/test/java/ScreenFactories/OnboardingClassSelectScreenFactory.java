package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OnboardingClassSelectScreenFactory {

    @AndroidFindBy(id = "square_blue2")
    public MobileElement iconClass;

    @AndroidFindBy(id = "hint_edittextvw3")
    public MobileElement classInputField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.Button[@index='1']")
    public MobileElement firstClassInList;
}
