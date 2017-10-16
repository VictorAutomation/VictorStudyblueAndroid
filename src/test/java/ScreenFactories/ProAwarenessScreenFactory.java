package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProAwarenessScreenFactory {

    @AndroidFindBy(id = "button_free")
    public MobileElement buttonFree;

    @AndroidFindBy(id = "button_paid")
    public MobileElement buttonPro;
}
