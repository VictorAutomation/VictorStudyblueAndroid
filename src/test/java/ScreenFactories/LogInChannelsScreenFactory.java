package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LogInChannelsScreenFactory {

    @AndroidFindBy(id = "signinEmailButton")
    public MobileElement signInWithEmailButton;

    @AndroidFindBy(id = "signinGoogleButton")
    public MobileElement signInWithGoogleButton;

    @AndroidFindBy(id = "signinFacebookButton")
    public MobileElement signInWithFacebookButton;
}
