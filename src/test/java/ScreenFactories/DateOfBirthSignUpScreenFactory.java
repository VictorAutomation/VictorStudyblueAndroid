package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DateOfBirthSignUpScreenFactory {

    @AndroidFindBy(xpath = "//android.widget.NumberPicker[@index='0']/android.widget.EditText[@index='1']")
    public MobileElement monthInputField;

    @AndroidFindBy(xpath = "//android.widget.NumberPicker[@index='1']/android.widget.EditText[@index='1']")
    public MobileElement dayInputField;

    @AndroidFindBy(xpath = "//android.widget.NumberPicker[@index='2']/android.widget.EditText[@index='1']")
    public MobileElement yearInputField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK' and @index='1']")
    public MobileElement okButton;
}
