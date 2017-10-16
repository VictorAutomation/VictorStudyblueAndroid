package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ChooseGoogleAccountScreenFactory {

    @AndroidFindBy(id = "android:id/text1")
    public MobileElement firstAvailableAccountRadioButton;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[contains(@resource-id,'text1') and @text='Add account']")
    public MobileElement addAccountRadioButton;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement okButton;
}
