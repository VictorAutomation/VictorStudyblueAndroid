package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoggedInHomeScreenFactory {

    @AndroidFindBy(id = "action_bar")
    public MobileElement actionBar;
}
