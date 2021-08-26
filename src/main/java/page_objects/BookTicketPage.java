package page_objects;

import helpers.Constants;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends BasePage {
    //Locators
    private final By btnSubmit = By.cssSelector("input[type='submit']");
    private final By departFrom = By.cssSelector("select[name='DepartStation']");
    private final By arriveAt = By.cssSelector("select[name='ArriveStation']");
    private final By seatType = By.cssSelector("select[name='SeatType']");
    private final By titleOfPage = By.cssSelector("div#content h1[align='center']");
    private final By PIDOnPage = By.xpath("//strong[text()[contains(.,'123123123')]]"); //re-catch xpath for PID, PID must be a variable.
    private final By valueOfDepartFrom =
            By.xpath("//tr/td[count(//th)-count(//th[text()='Depart Station']/following-sibling::th)]");
    private final By valueOfArriveAt =
            By.xpath("//tr/td[count(//th)-count(//th[text()='Arrive Station']/following-sibling::th)]");
    private final By valueOfSeatType =
            By.xpath("//tr/td[count(//th)-count(//th[text()='Seat Type']/following-sibling::th)]");

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

    private WebElement arriveAtElement() {
        return Constants.WEBDRIVER.findElement(arriveAt);
    }

    private WebElement seatTypeElement() {
        return Constants.WEBDRIVER.findElement(seatType);
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

    //Methods
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

    public void bookTicket(String departFromOption, String arriveAtOption, String seatTypeOption) {
        ElementHelper.scrollTo(departFromElement());
        ElementHelper.selectOption(departFromElement(), departFromOption);
        ElementHelper.selectOption(arriveAtElement(), arriveAtOption);
        ElementHelper.selectOption(seatTypeElement(), seatTypeOption);
        btnSubmitElement().click();
    }
}
