package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EmailLogInScreenFactory {

    @AndroidFindBy(id = "emailSigninEmail")
    public MobileElement emailInputField;

    @AndroidFindBy(id = "emailSigninPassword")
    public MobileElement passwordInputField;

    @AndroidFindBy(id = "emailSigninButton")
    public MobileElement goButton;
}