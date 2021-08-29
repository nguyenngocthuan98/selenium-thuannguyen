package page_objects;

import entities.Ticket;
import helpers.Constants;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends BasePage {
    private final String xpathOfValuesInTableByColumn =
            "//table[@class='MyTable WideTable']/tbody/tr/td[count(//th)-count(//th[text()='%s']/following-sibling::th)]";
    String xpathOfPIDOnPage = "//strong[text()[contains(.,'%s')]]";

    //Locators
    private final By btnSubmit = By.cssSelector("input[type='submit']");
    private final By departFrom = By.cssSelector("select[name='DepartStation']");
    private final By departDate = By.cssSelector("select[name='Date']");
    private final By arriveAt = By.cssSelector("select[name='ArriveStation']");
    private final By seatType = By.cssSelector("select[name='SeatType']");
    private final By ticketAmount = By.cssSelector("select[name='TicketAmount']");
    private final By titleOfPage = By.cssSelector("div#content h1[align='center']");

    private final By valueOfDepartFrom = By.xpath(String.format(xpathOfValuesInTableByColumn, "Depart Station"));
    private final By valueOfArriveAt = By.xpath(String.format(xpathOfValuesInTableByColumn, "Arrive Station"));
    private final By valueOfSeatType = By.xpath(String.format(xpathOfValuesInTableByColumn, "Seat Type"));
    private final By valueOfDepartDate = By.xpath(String.format(xpathOfValuesInTableByColumn, "Depart Date"));
    private final By valueOfBookDate = By.xpath(String.format(xpathOfValuesInTableByColumn, "Book Date"));
    private final By valueOfExpiredDate = By.xpath(String.format(xpathOfValuesInTableByColumn, "Expired Date"));
    private final By valueOfAmount = By.xpath(String.format(xpathOfValuesInTableByColumn, "Amount"));
    private final By valueOfTotalPrice = By.xpath(String.format(xpathOfValuesInTableByColumn, "Total Price"));

    //Elements
    private WebElement btnSubmitElement() {
        return Constants.WEBDRIVER.findElement(btnSubmit);
    }

    private WebElement titleOfPageElement() {
        return Constants.WEBDRIVER.findElement(titleOfPage);
    }

    private WebElement departFromElement() {
        return Constants.WEBDRIVER.findElement(departFrom);
    }

    private WebElement departDateElement() {
        return Constants.WEBDRIVER.findElement(departDate);
    }

    private WebElement arriveAtElement() {
        return Constants.WEBDRIVER.findElement(arriveAt);
    }

    private WebElement seatTypeElement() {
        return Constants.WEBDRIVER.findElement(seatType);
    }

    private WebElement ticketAmountElement() {
        return Constants.WEBDRIVER.findElement(ticketAmount);
    }

    private WebElement PIDOnPageElement(String pid) {
        return Constants.WEBDRIVER.findElement(By.xpath(String.format(xpathOfPIDOnPage, pid)));
    }

    private WebElement valueOfDepartFromElement() {
        return Constants.WEBDRIVER.findElement(valueOfDepartFrom);
    }

    private WebElement valueOfArriveAtElement() {
        return Constants.WEBDRIVER.findElement(valueOfArriveAt);
    }

    private WebElement valueOfSeatTypeElement() {
        return Constants.WEBDRIVER.findElement(valueOfSeatType);
    }

    private WebElement valueOfDepartDateElement() {
        return Constants.WEBDRIVER.findElement(valueOfDepartDate);
    }

    private WebElement valueOfBookDateElement() {
        return Constants.WEBDRIVER.findElement(valueOfBookDate);
    }

    private WebElement valueOfExpiredDateElement() {
        return Constants.WEBDRIVER.findElement(valueOfExpiredDate);
    }

    private WebElement valueOfAmountElement() {
        return Constants.WEBDRIVER.findElement(valueOfAmount);
    }

    private WebElement valueOfTotalPriceElement() {
        return Constants.WEBDRIVER.findElement(valueOfTotalPrice);
    }

    //Methods
    public String getPIDOnPage(String pid) {
        return PIDOnPageElement(pid).getText();
    }

    public String getTitleOfPage() {
        return titleOfPageElement().getText();
    }

    public String getValueOfDepartFrom() {
        return valueOfDepartFromElement().getText();
    }

    public String getValueOfArriveAt() {
        return valueOfArriveAtElement().getText();
    }

    public String getValueOfSeatType() {
        return valueOfSeatTypeElement().getText();
    }

    public String getValueOfTicketAmount() {
        return valueOfAmountElement().getText();
    }

    public String getValueOfExpiredDate() {
        return valueOfExpiredDateElement().getText();
    }

    public String getValueOfDepartDate(){
        return valueOfDepartDateElement().getText();
    }

    public String getValueOfBookDate(){
        return valueOfBookDateElement().getText();
    }

    public void bookTicket(Ticket ticket) {
        ElementHelper.scrollTo(departDateElement());
        ElementHelper.selectOption(departDateElement(), ticket.getDepartDate());
        ElementHelper.selectOption(departFromElement(), ticket.getDepartFrom());
        ElementHelper.selectOption(arriveAtElement(), ticket.getArriveAt());
        ElementHelper.selectOption(seatTypeElement(), ticket.getSeatType());
        ElementHelper.selectOption(ticketAmountElement(), ticket.getAmounts());
        btnSubmitElement().click();
    }
}
