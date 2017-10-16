package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ChooseGoogleAccountScreenFactory {

    @AndroidFindBy(id = "android:id/text1")
    public MobileElement firstAvailableAccountRadioButton;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement okButton;
}
