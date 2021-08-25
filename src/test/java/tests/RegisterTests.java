package tests;

import helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BasePage;
import page_objects.RegisterPage;

public class RegisterTests extends BaseTests {
    private final RegisterPage registerPage = new RegisterPage();
    private final BasePage basePage = new BasePage();
    private final String email = DataHelper.getRandomEmail();
    private final String password = DataHelper.getRandomPassword();
    private final String pid = DataHelper.getRandomNumber();

    @Test(testName = "User can create new account with valid data")
    public void registerTest() {
        basePage.goToRegisterPage();
        registerPage.register(email, password, pid);

        Assert.assertEquals(registerPage.getContentRegisterSuccess(), "You're here", "Register fail");
    }
}
