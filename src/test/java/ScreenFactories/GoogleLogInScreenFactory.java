package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GoogleLogInScreenFactory {

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Email or phone']")
    public MobileElement googleEmailLogInField;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'identifierNext')]")
    public MobileElement emailNextButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your password']")
    public MobileElement googlePasswordLogInField;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'passwordNext')]")
    public MobileElement passwordNextButton;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'signinconsentNext')]")
    public MobileElement iAgreeButton;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'com.google.android.gms:id/accept_button')]")
    public MobileElement allowButton;
}
