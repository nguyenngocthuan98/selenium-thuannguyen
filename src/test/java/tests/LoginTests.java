package tests;

import helpers.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BasePage;
import page_objects.LoginPage;

public class LoginTests extends BaseTests {
    private final LoginPage loginPage = new LoginPage();
    private final BasePage basePage = new BasePage();

    private final String generalLoginErrorMsg = loginPage.generalLoginErrorMsg();
    private final String emailErrorMsg = loginPage.errorEmailMsg();
    private final String passwordErrorMsg = loginPage.errorPasswordMsg();

    String expectedAllFieldSpecifyMsg = "There was a problem with your login and/or errors exist in your form.";
    String expectedInvalidDataMsg = "Invalid email or password. Please try again.";
    String expectedEmailSpecifyMsg = "You must specify a email.";
    String expectedEmailFormMsg = "Invalid email form.";
    String expectedPasswordSpecifyMsg = "You must specify a password.";

    @Test(testName = "User can login with valid account")
    public void loginTest() {
        basePage.goToLoginPage();
        loginPage.login(Constants.EMAIL, Constants.PASSWORD);

        Assert.assertEquals("Welcome " + Constants.EMAIL, basePage.getGreeting(), "Login fail");
    }

    @Test(testName = "Error message displays when user login with blank fields data")
    public void blankAllFieldTest() {
        basePage.goToLoginPage();
        loginPage.login("", "");

        Assert.assertEquals(expectedAllFieldSpecifyMsg, generalLoginErrorMsg, "generalLoginErrorMsg doesn't display as expected");
        Assert.assertEquals(expectedEmailSpecifyMsg, emailErrorMsg, "emailErrorMsg doesn't display as expected");
        Assert.assertEquals(expectedPasswordSpecifyMsg, passwordErrorMsg, "passwordErrorMsg doesn't display as expected");
    }

    @Test(testName = "Error message displays when user login with blank email field")
    public void blankEmailFieldTest() {
        basePage.goToLoginPage();
        loginPage.login("", Constants.PASSWORD);

        Assert.assertEquals(expectedAllFieldSpecifyMsg, generalLoginErrorMsg, "generalLoginErrorMsg doesn't display as expected");
        Assert.assertEquals(expectedEmailSpecifyMsg, emailErrorMsg, "emailErrorMsg doesn't display as expected");
    }

    @Test(testName = "Error message displays when user login with incorrect email format")
    public void incorrectEmailFormatTest() {
        basePage.goToLoginPage();
        loginPage.login(loginPage.WRONG_EMAIL_FORMAT, Constants.PASSWORD);

        Assert.assertEquals(expectedInvalidDataMsg, generalLoginErrorMsg, "generalLoginErrorMsg doesn't display as expected");
        Assert.assertEquals(expectedEmailFormMsg, emailErrorMsg, "emailErrorMsg doesn't display as expected");
    }

    @Test(testName = "Error message displays when user login with NOT existing email")
    public void notExistEmailTest() {
        basePage.goToLoginPage();
        loginPage.login(loginPage.NOT_EXIST_EMAIL, Constants.PASSWORD);

        Assert.assertEquals(expectedInvalidDataMsg, generalLoginErrorMsg, "generalLoginErrorMsg doesn't display as expected");
    }

    @Test(testName = "Error message displays when user login with wrong password")
    public void wrongPasswordTest() {
        basePage.goToLoginPage();
        loginPage.login(Constants.EMAIL, loginPage.WRONG_PASSWORD);

        Assert.assertEquals(expectedInvalidDataMsg, generalLoginErrorMsg, "generalLoginErrorMsg doesn't display as expected");
    }

    @Test(testName = "Error message displays when user login with blank password field data")
    public void blankPasswordTest() {
        basePage.goToLoginPage();
        loginPage.login(Constants.EMAIL, "");

        Assert.assertEquals(expectedAllFieldSpecifyMsg, generalLoginErrorMsg, "generalLoginErrorMsg doesn't display as expected");
        Assert.assertEquals(expectedPasswordSpecifyMsg, emailErrorMsg, "emailErrorMsg doesn't display as expected");
    }
}
