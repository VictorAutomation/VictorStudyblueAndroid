package ScreenObjects;

import ScreenFactories.HelloScreenFactory;
import ScreenFactories.ProAwarenessScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ProAwarenessScreen extends BaseTest {


    public static ProAwarenessScreenFactory proAwarenessScreenFactory = new ProAwarenessScreenFactory();

    public ProAwarenessScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), proAwarenessScreenFactory);
        waitForElementToLoad(proAwarenessScreenFactory.buttonFree);
        waitForElementToLoad(proAwarenessScreenFactory.buttonPro);
    }
    public LoggedInHomeScreen clickFreeOption() {
        proAwarenessScreenFactory.buttonFree.click();
        return new LoggedInHomeScreen();
    }
}
