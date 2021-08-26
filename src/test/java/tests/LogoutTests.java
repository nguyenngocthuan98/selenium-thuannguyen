package tests;

import helpers.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BasePage;
import page_objects.LoginPage;

public class LogoutTests extends BaseTests {
    private final LoginPage loginPage = new LoginPage();
    private final BasePage basePage = new BasePage();

    @Test(testName = "User can logout successfully")
    public void logoutTest() {
        basePage.goToLoginPage();
        loginPage.login(Constants.EMAIL, Constants.PASSWORD);
        basePage.logout();

        Assert.assertEquals("Welcome guest!", basePage.getGreeting(), "Login fail");
    }
}
