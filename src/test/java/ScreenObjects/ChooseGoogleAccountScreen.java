package ScreenObjects;

import ScreenFactories.ChooseGoogleAccountScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ChooseGoogleAccountScreen extends BaseTest {

    public static ChooseGoogleAccountScreenFactory chooseGoogleAccountScreenFactory = new ChooseGoogleAccountScreenFactory();

    public ChooseGoogleAccountScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), chooseGoogleAccountScreenFactory);
        waitForElementToLoad(chooseGoogleAccountScreenFactory.firstAvailableAccountRadioButton);
    }


    public void chooseFirstAvailableGoogleAccount() {
        chooseGoogleAccountScreenFactory.firstAvailableAccountRadioButton.click();
    }

    public LoggedInHomeScreen clickOkButton() {
        chooseGoogleAccountScreenFactory.okButton.click();
        return new LoggedInHomeScreen();
    }
}
