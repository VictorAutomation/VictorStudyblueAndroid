package ScreenObjects;

import ScreenFactories.HelloScreenFactory;
import ScreenFactories.LoggedInHomeScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoggedInHomeScreen extends BaseTest {

    public static LoggedInHomeScreenFactory loggedInHomeScreenFactory = new LoggedInHomeScreenFactory();

    public LoggedInHomeScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), loggedInHomeScreenFactory);
        waitForElementToLoad(loggedInHomeScreenFactory.actionBar);
    }

    public MobileElement findActionBar() {
        return loggedInHomeScreenFactory.actionBar;
        //return new driver.findElementById("action_bar");
    }

//    public LogInChannelsScreen clickSignInButton() {
//        helloScreenFactory.signInButton.click();
//        return new LogInChannelsScreen();
//    }


//    public static List<MobileElement> getListOfMainNavTabs() {
//        return (List<MobileElement>) driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
//    }
}
