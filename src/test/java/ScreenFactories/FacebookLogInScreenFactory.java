package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FacebookLogInScreenFactory {

    @AndroidFindBy(id = "com.facebook.katana:id/login_add_account_group")
    public MobileElement logIntoAnotherAccount;

    @AndroidFindBy(id = "com.facebook.katana:id/login_username")
    public MobileElement facebookEmailInputField;

    @AndroidFindBy(id = "com.facebook.katana:id/login_password")
    public MobileElement facebookPasswordInputField;

    @AndroidFindBy(id = "com.facebook.katana:id/login_login")
    public MobileElement facebookLogInButton;
}
