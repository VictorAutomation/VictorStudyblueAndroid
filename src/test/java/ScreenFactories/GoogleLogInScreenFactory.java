package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GoogleLogInScreenFactory {

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Email or phone']")
    public MobileElement googleEmailLogInField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your password']")
    public MobileElement googlePasswordLogInField;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'identifierNext')]") // and @text='5'   @text='Enter your password'
    public MobileElement emailNextButton;

    @AndroidFindBy(id = "passwordNext")
    public MobileElement passwordNextButton;
}
