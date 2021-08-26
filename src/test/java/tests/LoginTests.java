package tests;

import helpers.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.LoginPage;

public class LoginTests extends BaseTests {
    private final LoginPage loginPage = new LoginPage();

    String generalLoginErrorMsg;
    String emailErrorMsg;
    String passwordErrorMsg;
    String wrong_email_format = "test@railway.";
    String not_exist_email = "testnotexist@railway.co";
    String wrong_password = "this is wrong password";
    String expectedAllFieldSpecifyMsg = "There was a problem with your login and/or errors exist in your form.";
    String expectedInvalidDataMsg = "Invalid email or password. Please try again.";
    String expectedEmailSpecifyMsg = "You must specify a email.";
    String expectedEmailFormMsg = "Invalid email form.";
    String expectedPasswordSpecifyMsg = "You must specify a password.";

    @BeforeMethod
    public void beforeLoginTests() {
        loginPage.goToLoginPage();
    }

    @Test(testName = "User can login with valid account")
    public void loginTest() {
        loginPage.login(Constants.EMAIL, Constants.PASSWORD);

        Assert.assertEquals("Welcome " + Constants.EMAIL, loginPage.getGreeting(),
                "Greeting doesn't display as expected");
    }

    @Test(testName = "Error message displays when user login with blank fields data")
    public void blankAllFieldTest() {
        loginPage.login("", "");

        generalLoginErrorMsg = loginPage.getTopErrorMessage();
        emailErrorMsg = loginPage.getEmailErrorMessage();
        passwordErrorMsg = loginPage.getPasswordErrorMessage();

        Assert.assertEquals(expectedAllFieldSpecifyMsg, generalLoginErrorMsg,
                "Error message at the top of form doesn't display as expected");
        Assert.assertEquals(expectedEmailSpecifyMsg, emailErrorMsg,
                "Error message next to Email field doesn't display as expected");
        Assert.assertEquals(expectedPasswordSpecifyMsg, passwordErrorMsg,
                "Error message next to Password field doesn't display as expected");
    }

    @Test(testName = "Error message displays when user login with incorrect email format")
    public void incorrectEmailFormatTest() {
        loginPage.login(wrong_email_format, Constants.PASSWORD);

        generalLoginErrorMsg = loginPage.getTopErrorMessage();
        emailErrorMsg = loginPage.getEmailErrorMessage();

        Assert.assertEquals(expectedInvalidDataMsg, generalLoginErrorMsg,
                "Error message at the top of form doesn't display as expected");
        Assert.assertEquals(expectedEmailFormMsg, emailErrorMsg,
                "Error message next to Email field doesn't display as expected");
    }

    @Test(testName = "Error message displays when user login with NOT existing email")
    public void notExistEmailTest() {
        loginPage.login(not_exist_email, Constants.PASSWORD);

        generalLoginErrorMsg = loginPage.getTopErrorMessage();

        Assert.assertEquals(expectedInvalidDataMsg, generalLoginErrorMsg,
                "Error message at the top of form doesn't display as expected");
    }

    @Test(testName = "Error message displays when user login with wrong password")
    public void wrongPasswordTest() {
        loginPage.login(Constants.EMAIL, wrong_password);

        generalLoginErrorMsg = loginPage.getTopErrorMessage();

        Assert.assertEquals(expectedInvalidDataMsg, generalLoginErrorMsg,
                "Error message at the top of form doesn't display as expected");
    }

    @Test(testName = "Error message displays when user login with blank password field")
    public void blankPasswordTest() {
        loginPage.login(Constants.EMAIL, "");

        generalLoginErrorMsg = loginPage.getTopErrorMessage();
        passwordErrorMsg = loginPage.getPasswordErrorMessage();

        Assert.assertEquals(expectedAllFieldSpecifyMsg, generalLoginErrorMsg,
                "Error message at the top of form doesn't display as expected");
        Assert.assertEquals(expectedPasswordSpecifyMsg, passwordErrorMsg,
                "Error message next to Password field doesn't display as expected");
    }

    @Test(testName = "Error message displays when user login with blank email field")
    public void blankEmailFieldTest() {
        loginPage.login("", Constants.PASSWORD);

        generalLoginErrorMsg = loginPage.getTopErrorMessage();
        emailErrorMsg = loginPage.getEmailErrorMessage();

        Assert.assertEquals(expectedAllFieldSpecifyMsg, generalLoginErrorMsg,
                "Error message at the top of form doesn't display as expected");
        Assert.assertEquals(expectedEmailSpecifyMsg, emailErrorMsg,
                "Error message next to Email field doesn't display as expected");
    }
}
