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

    @DataProvider(name = "validEmailSigUpCredentials")
    public Object[][] createDataForEmailGignUp() {
        return new Object[][]{
                {"Sep", "11", "1990", "student", "Hogwarts School of Witchcraft and Wizardry", "Potions"}
        };
    }

    @DataProvider(name = "validEmailLogInCredentials")
    public Object[][] createDataForEmailLogIn() {
        return new Object[][]{
                {"kidaisuda@yahoo.com", "qweqwe"}
        };
    }

    @DataProvider(name = "validFacebookSignUpCredentials")
    public Object[][] createDataForFacebookLogIn() {
        return new Object[][]{
                {"testingstudyblue@gmail.com", "firefly!2002", "student", "Hogwarts School of Witchcraft and Wizardry", "Potions"}
        };
    }

    @DataProvider(name = "validGoogleSignUpCredentials")
    public Object[][] createDataForGoogleLogIn() {
        return new Object[][]{
                {"test3@studyblue.com", "firefly!2002", "student", "Hogwarts School of Witchcraft and Wizardry", "Potions"}
        };
    }

    @BeforeMethod(groups = "acceptance")
    private void studyBlueHelloScreenIsLoaded() {
        System.out.println("StudyBlue hello Screen is loaded");
        Assert.assertTrue(driver.findElementById("splash_image").isDisplayed());
        driver.findElementById("api_server").clear();
        driver.hideKeyboard();
        driver.findElementById("api_server").sendKeys("https://openapi-mobile.dev.studyblue.com/");
    }

    @AfterMethod(groups = "acceptance")
    public void afterEachTest() {
        System.out.println("Resetting App");
        driver.resetApp();
    }


    @Test(groups = "acceptance", dataProvider = "validEmailSigUpCredentials")
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
        OnboardingSuggestedClassesScreen onboardingSuggestedClassesScreen = onboardingProfessorSelectScreen.chooseProfessor();
        ProAwarenessScreen proAwarenessScreen = onboardingSuggestedClassesScreen.clickNextButton();
        LoggedInHomeScreen loggedInHomeScreen = proAwarenessScreen.clickFreeOption();

        Assert.assertTrue(loggedInHomeScreen.findActionBar().isDisplayed());
    }

    @Test(groups = "acceptance", dataProvider = "validEmailLogInCredentials")
    private void emailLogIn(String email, String password) {
        HelloScreen helloScreen = new HelloScreen();
        LogInChannelsScreen logInChannelsScreen = helloScreen.clickSignInButton();
        EmailLogInScreen emailLogInScreen = logInChannelsScreen.clickSignInWithEmailButton();
        emailLogInScreen.enterValidLogInEmail(email);
        emailLogInScreen.enterValidLogInPassword(password);
        LoggedInHomeScreen loggedInHomeScreen = emailLogInScreen.clickGoButton();

        Assert.assertTrue(loggedInHomeScreen.findActionBar().isDisplayed());
    }

    @Test(groups = "acceptance", dataProvider = "validGoogleSignUpCredentials")
    private void googleSignUp(String email, String password, String userType, String schoolName, String className) {
        HelloScreen helloScreen = new HelloScreen();
        SignUpChannelsScreen signUpChannelsScreen = helloScreen.clickSignUpButton();
        ChooseGoogleAccountScreen chooseGoogleAccountScreen = signUpChannelsScreen.clickSignUpWithGoogleButton();
        chooseGoogleAccountScreen.clickAddAccountRadioButton();
        GoogleLogInScreen googleLogInScreen = chooseGoogleAccountScreen.clickOkButtonToAddNewAccount();
        googleLogInScreen.enterGoogleLogInEmail(email);
        googleLogInScreen.clickNextButtonToEnterPassword();
        googleLogInScreen.enterGoogleLogInPassword(password);
        googleLogInScreen.clickNextButton();
        googleLogInScreen.agreeToTermsOfService();
        OnboardingUserTypeScreen onboardingUserTypeScreen = googleLogInScreen.allowToUseYourInformation();
        OnboardingSchoolSelectScreen onboardingSchoolSelectScreen = onboardingUserTypeScreen.chooseUserType(userType);
        OnboardingClassSelectScreen onboardingClassSelectScreen = onboardingSchoolSelectScreen.enterSchoolName(schoolName);
        OnboardingProfessorSelectScreen onboardingProfessorSelectScreen = onboardingClassSelectScreen.enterClassName(className);
        OnboardingSuggestedClassesScreen onboardingSuggestedClassesScreen = onboardingProfessorSelectScreen.chooseProfessor();
        ProAwarenessScreen proAwarenessScreen = onboardingSuggestedClassesScreen.clickNextButton();
        LoggedInHomeScreen loggedInHomeScreen = proAwarenessScreen.clickFreeOption();

        Assert.assertTrue(loggedInHomeScreen.findActionBar().isDisplayed());
    }

    @Test(groups = "acceptance")
    private void googleLogIn() {
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

    @Test(groups = "acceptance", dataProvider = "validFacebookSignUpCredentials")
    private void facebookSignUp(String email, String password, String userType, String schoolName, String className) {
        HelloScreen helloScreen = new HelloScreen();
        SignUpChannelsScreen signUpChannelsScreen = helloScreen.clickSignUpButton();
        FacebookLogInScreen facebookLogInScreen = signUpChannelsScreen.clickSignUpWithFacebookButton();
//        facebookLogInScreen.switchToWebwiewContext();
        facebookLogInScreen.clickLogIntoAnotherAccount();
        facebookLogInScreen.enterFacebookLogInEmail(email);
        facebookLogInScreen.enterFacebookLogInPassword(password);
        OnboardingUserTypeScreen onboardingUserTypeScreen = facebookLogInScreen.clickLogInButton();
        OnboardingSchoolSelectScreen onboardingSchoolSelectScreen = onboardingUserTypeScreen.chooseUserType(userType);
        OnboardingClassSelectScreen onboardingClassSelectScreen = onboardingSchoolSelectScreen.enterSchoolName(schoolName);
        OnboardingProfessorSelectScreen onboardingProfessorSelectScreen = onboardingClassSelectScreen.enterClassName(className);
        OnboardingSuggestedClassesScreen onboardingSuggestedClassesScreen = onboardingProfessorSelectScreen.chooseProfessor();
        ProAwarenessScreen proAwarenessScreen = onboardingSuggestedClassesScreen.clickNextButton();
        LoggedInHomeScreen loggedInHomeScreen = proAwarenessScreen.clickFreeOption();

        Assert.assertTrue(loggedInHomeScreen.findActionBar().isDisplayed());
    }

    @Test(groups = "acceptance")
    private void facebookLogIn() {
        HelloScreen helloScreen = new HelloScreen();
        LogInChannelsScreen logInChannelsScreen = helloScreen.clickSignInButton();
        LoggedInHomeScreen loggedInHomeScreen = logInChannelsScreen.clickSignInWithFacebookButton();

        Assert.assertTrue(loggedInHomeScreen.findActionBar().isDisplayed());
    }
}