package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HelloScreenFactory {

    @AndroidFindBy(id = "signinButton")
    public MobileElement signInButton;

    @AndroidFindBy(id = "signupButton")
    public MobileElement signUpButton;
}
