package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FacebookLogInScreenFactory {

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='5']")
    public MobileElement logIntoAnotherAccountButton;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='3']/android.widget.RelativeLayout[@index='1']/android.widget.EditText[contains(@resource-id,'login_username') and @index='0']")
    public MobileElement facebookEmailOrPhoneInputField;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='4']/android.widget.RelativeLayout[@index='1']/android.widget.EditText[contains(@resource-id,'login_username') and @index='0']")
    public MobileElement facebookEmailInputField;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='4']/android.widget.RelativeLayout[@index='2']/android.widget.EditText[contains(@resource-id,'login_password') and @index='0']")
    public MobileElement facebookPasswordInputField;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='3']/android.widget.Button[contains(@resource-id,'login_login') and @index='3']")
    public MobileElement facebookLogInButton;
}
