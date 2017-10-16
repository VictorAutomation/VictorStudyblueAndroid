package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignUpChannelsScreenFactory {

    @AndroidFindBy(id = "signupEmailButton")
    public MobileElement signUpWithEmailButton;

    @AndroidFindBy(id = "signupGoogleButton")
    public MobileElement signUpWithGoogleButton;

    @AndroidFindBy(id = "signupFacebookButton")
    public MobileElement signUpWithFacebookButton;
}
