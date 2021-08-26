package tests;

import helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BasePage;
import page_objects.BookTicketPage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class BookTicketTests extends BaseTests {
    private final RegisterPage registerPage = new RegisterPage();
    private final LoginPage loginPage = new LoginPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();

    private final String email = DataHelper.getRandomEmail();
    private final String password = DataHelper.getRandomPassword();
    private final String pid = DataHelper.getRandomNumber();

    @BeforeMethod
    public void preconditions(){
        bookTicketPage.goToRegisterPage();
        registerPage.register(email, password, password, pid);
        bookTicketPage.goToLoginPage();
        loginPage.login(email, password);
        bookTicketPage.goToBookTicketPage();
    }

    @Test(testName = "User can book ticket successfully")
    public void bookTicketTest() {
        String departFrom = "Sài Gòn";
        String arriveAt = "Huế";
        String seatType = "Soft bed";

        bookTicketPage.bookTicket(departFrom, arriveAt, seatType);

        Assert.assertEquals(bookTicketPage.getValueOfDepartFrom(), departFrom, "Depart Station displays wrong");
        Assert.assertEquals(bookTicketPage.getValueOfArriveAt(), arriveAt, "Arrive Station displays wrong");
        Assert.assertEquals(bookTicketPage.getValueOfSeatType(), seatType, "Seat Type displays wrong");
        Assert.assertEquals(bookTicketPage.getTitleOfPage(), "Ticket Booked Successfully!",
                "Title of page doesn't display as expected");

        //Need to assert more cases like: Depart Date, Book Date, Expired Date, Amount, PID
    }
}
