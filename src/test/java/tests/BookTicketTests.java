package tests;

import entities.Ticket;
import helpers.DataHelper;
import helpers.ElementHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class BookTicketTests extends BaseTests {
    private final RegisterPage registerPage = new RegisterPage();
    private final LoginPage loginPage = new LoginPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final Ticket ticket = new Ticket();

    private final String email = DataHelper.getRandomEmail();
    private final String password = DataHelper.getRandomPassword();
    private final String pid = DataHelper.getRandomNumber();

    @BeforeMethod
    public void preconditions() {
        bookTicketPage.goToRegisterPage();
        registerPage.register(email, password, password, pid);
        bookTicketPage.goToLoginPage();
        loginPage.login(email, password);
        bookTicketPage.goToBookTicketPage();
    }

    @Test(testName = "User can book ticket successfully")
    public void tc01_BookTicketTest() {
        int indexOfDepartDay = 3;
        String departFrom = "Sài Gòn";
        String arriveAt = "Huế";
        String seatType = "Soft bed";
        String ticketAmount = "1";

        String departDate = ElementHelper.departDay(indexOfDepartDay);
        String expiredDate = ElementHelper.departDay(indexOfDepartDay - 1);
        String bookDate = ElementHelper.formatDate().format(DataHelper.getCurrentDate());

        ticket.setDepartFrom(departFrom);
        ticket.setArriveAt(arriveAt);
        ticket.setSeatType(seatType);
        ticket.setDepartDate(departDate);
        ticket.setAmounts(ticketAmount);

        bookTicketPage.bookTicket(ticket);

        Assert.assertEquals(bookTicketPage.getTitleOfPage(), "Ticket Booked Successfully!",
                "Title of page doesn't display as expected");
        Assert.assertNotNull(bookTicketPage.getPIDOnPage(pid), "PID displays wrong so can't find");
        Assert.assertEquals(bookTicketPage.getValueOfDepartFrom(), ticket.getDepartFrom(),
                "Depart Station displays wrong");
        Assert.assertEquals(bookTicketPage.getValueOfArriveAt(), ticket.getArriveAt(),
                "Arrive Station displays wrong");
        Assert.assertEquals(bookTicketPage.getValueOfSeatType(), ticket.getSeatType(),
                "Seat Type displays wrong");
        Assert.assertEquals(bookTicketPage.getValueOfDepartDate(), ticket.getDepartDate(),
                "Depart date displays wrong");
        Assert.assertEquals(bookTicketPage.getValueOfBookDate(), bookDate, "Book date displays wrong");
        Assert.assertEquals(bookTicketPage.getValueOfBookDate(), expiredDate, "Expired date displays wrong");
        Assert.assertEquals(bookTicketPage.getValueOfTicketAmount(), ticket.getAmounts(),
                "Ticket Amount displays wrong");
    }
}
