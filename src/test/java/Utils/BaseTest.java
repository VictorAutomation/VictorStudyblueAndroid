package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Listeners({Utils.Listeners.class})
public class BaseTest {

    protected static AppiumDriver driver;

    protected boolean elementIsNotPresent(By by) {
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return driver.findElements(by).isEmpty();
        } finally {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
    }

    protected void waitForElementToLoad(MobileElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(id));
    }

    protected static boolean waitForAttributeToBeVisible(By by, String attribute, String textToWait) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(ExpectedConditions.attributeToBe(by, attribute, textToWait));
    }

    private void killUiAutomatorServer() throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("adb uninstall io.appium.uiautomator2.server");
        process.waitFor();
        Process process2 = Runtime.getRuntime().exec("adb uninstall io.appium.uiautomator2.server.test");
        process2.waitFor();
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException, InterruptedException {
        //start Appium server
        AppiumServer.startAppiumServer();
        killUiAutomatorServer();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S7 edge");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN, "true");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.studyblue");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.studyblue.ui.mainactivity.SbMainActivity");
        capabilities.setCapability("autoGrantPermissions", "true"); //grant permission to system dialogues such as location
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/app/studyblue-5.49_web_debug_test-b1-v163_5.46-169-gb68b5e7-google_play-signedDebug.apk");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println(".......Starting Appium driver");
    }

    @AfterSuite
    public void tearDown() throws IOException, InterruptedException {
        System.out.println(".......Stopping Appium driver");
        driver.quit();
        AppiumServer.stopAppiumServer();
    }
}
