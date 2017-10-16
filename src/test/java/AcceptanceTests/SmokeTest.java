package AcceptanceTests;

import ScreenObjects.*;
import Utils.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @DataProvider(name = "validEmailLogInCredentials")
    public Object[][] createDataForEmailLogIn() {
        return new Object[][]{
                {"kidaisuda@yahoo.com", "qweqwe"}
        };
    }

    @DataProvider(name = "validEmailSigUpCredentials")
    public Object[][] createDataForEmailGignUp() {
        return new Object[][]{
                {"NOV", "11", "1990", "student", "Hogwarts School of Witchcraft and Wizardry", "Potions"}
        };
    }

    @BeforeMethod
    private void studyBlueHelloScreenIsLoaded() {
        System.out.println("StudyBlue hello Screen is loaded");
        Assert.assertTrue(driver.findElementById("splash_image").isDisplayed());
    }

    @AfterMethod
    public void afterEachTest() {
        System.out.println("Resetting App");
        driver.resetApp();
    }

    @Test(dataProvider = "validEmailLogInCredentials")
    private void emailLogInWithValidCredentials(String email, String password) {
        HelloScreen helloScreen = new HelloScreen();
        LogInChannelsScreen logInChannelsScreen = helloScreen.clickSignInButton();
        EmailLogInScreen emailLogInScreen = logInChannelsScreen.clickSignInWithEmailButton();
        emailLogInScreen.enterValidLogInEmail(email);
        emailLogInScreen.enterValidLogInPassword(password);
        LoggedInHomeScreen loggedInHomeScreen = emailLogInScreen.clickGoButton();

        Assert.assertTrue(loggedInHomeScreen.findActionBar().isDisplayed());
    }

    @Test
    private void googleLogInWithValidCredentials() {
        HelloScreen helloScreen = new HelloScreen();
        LogInChannelsScreen logInChannelsScreen = helloScreen.clickSignInButton();
        ChooseGoogleAccountScreen chooseGoogleAccountScreen = logInChannelsScreen.clickSignInWithGoogleButton();
        chooseGoogleAccountScreen.chooseFirstAvailableGoogleAccount();
        LoggedInHomeScreen loggedInHomeScreen = chooseGoogleAccountScreen.clickOkButton();

        Boolean result = elementIsNotPresent(By.id("com.android.packageinstaller:id/permission_allow_button"));
        if (!result) {
            //driver.switchTo().alert().accept(); DOES NOT WORK!!!!
            driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        }

        Assert.assertTrue(loggedInHomeScreen.findActionBar().isDisplayed());
    }

    @Test
    private void facebookLogInWithValidCredentials() {
        HelloScreen helloScreen = new HelloScreen();
        LogInChannelsScreen logInChannelsScreen = helloScreen.clickSignInButton();
        LoggedInHomeScreen loggedInHomeScreen = logInChannelsScreen.clickSignInWithFacebookButton();

        Assert.assertTrue(loggedInHomeScreen.findActionBar().isDisplayed());
    }

    @Test(dataProvider = "validEmailSigUpCredentials")
    private void emailSignUp(String month, String day, String year, String userType, String schoolName, String className) {
        HelloScreen helloScreen = new HelloScreen();
        SignUpChannelsScreen signUpChannelsScreen = helloScreen.clickSignUpButton();
        EmailSignUpScreen emailSignUpScreen = signUpChannelsScreen.clickSignUpWithEmailButton();
        emailSignUpScreen.enterValidFirstName();
        emailSignUpScreen.enterValidLastName();
        emailSignUpScreen.enterValidEmail();
        emailSignUpScreen.enterValidPassword();
        DateOfBirthSignUpScreen dateOfBirthSignUpScreen = emailSignUpScreen.clickOnDOBInputField();
        dateOfBirthSignUpScreen.enterValidBirthMonth(month);
        dateOfBirthSignUpScreen.enterValidBirthDay(day);
        dateOfBirthSignUpScreen.enterValidBirthYear(year);
        EmailSignUpScreen emailSignUpScreen1 = dateOfBirthSignUpScreen.clickOkButton();
        OnboardingUserTypeScreen onboardingUserTypeScreen = emailSignUpScreen1.clickGetStartedButton();
        OnboardingSchoolSelectScreen onboardingSchoolSelectScreen = onboardingUserTypeScreen.chooseUserType(userType);
        OnboardingClassSelectScreen onboardingClassSelectScreen = onboardingSchoolSelectScreen.enterSchoolName(schoolName);
        OnboardingProfessorSelectScreen onboardingProfessorSelectScreen = onboardingClassSelectScreen.enterClassName(className);
        ProAwarenessScreen proAwarenessScreen = onboardingProfessorSelectScreen.chooseProfessor();
        LoggedInHomeScreen loggedInHomeScreen = proAwarenessScreen.clickFreeOption();

        Assert.assertTrue(loggedInHomeScreen.findActionBar().isDisplayed());
    }

    @Test
    private void googleSignUp() {

    }

    @Test
    private void facebookSignUp() {

    }
}