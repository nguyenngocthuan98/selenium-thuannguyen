package tests;

import helpers.DataHelper;
import org.testng.annotations.Test;
import page_objects.BasePage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class BookTicketTests extends BaseTests {
    private final RegisterPage registerPage = new RegisterPage();
    private final BasePage basePage = new BasePage();
    private final LoginPage loginPage = new LoginPage();

    private final String email = DataHelper.getRandomEmail();
    private final String password = DataHelper.getRandomPassword();
    private final String pid = DataHelper.getRandomNumber();

    @Test(testName = "User can book ticket successfully")
    public void bookTicketTest() {
        String departFrom = "Sài Gòn";
        String arriveAt = "Huế";
        String seatType = "Soft bed";

        basePage.goToRegisterPage();
        registerPage.register(email, password, pid);
        basePage.goToLoginPage();
        loginPage.login(email, password);
        basePage.goToBookTicketPage();

        System.out.println("choose data and commit\ncheck values before and after submit");
    }
}
