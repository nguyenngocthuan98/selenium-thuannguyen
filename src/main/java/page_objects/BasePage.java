package page_objects;

import helpers.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    //Locates
    private final By greeting = By.cssSelector("div.account > strong");
    private final By tabLogout = By.linkText("Log out");
    private final By tabRegister = By.cssSelector("li a[href='/Account/Register.cshtml']");
    private final By tabLogin = By.cssSelector("li a[href='/Account/Login.cshtml']");
    private final By tabBookTicket = By.cssSelector("li a[href='/Page/BookTicketPage.cshtml']");
    private final By tabHome = By.cssSelector("li a[href='../']");
    private final By tabFAQ = By.cssSelector("li a[href='/Page/FAQ.cshtml']");
    private final By tabContacts = By.cssSelector("li a[href='/Page/Contact.cshtml']");
    private final By tabTimetables = By.cssSelector("li a[href='/Page/TrainTimeListPage.cshtml']");
    private final By tabTicketPrice = By.cssSelector("li a[href='/Page/TrainPriceListPage.cshtml']");
    private final By tabMyTicket = By.cssSelector("li a[href='/Page/ManageTicket.cshtml']");
    private final By tabChangePassword = By.cssSelector("li a[href='/Page/ChangePassword.cshtml']");
    private final By tabRegisterActive = By.xpath("//li[@class='selected']/a/span[text()='Register']");

    //Elements
    private WebElement greetingElement() {
        return Constants.WEBDRIVER.findElement(greeting);
    }

    private WebElement tabRegisterElement() {
        return Constants.WEBDRIVER.findElement(tabRegister);
    }

    private WebElement tabLogoutElement() {
        return Constants.WEBDRIVER.findElement(tabLogout);
    }

    private WebElement tabLoginElement() {
        return Constants.WEBDRIVER.findElement(tabLogin);
    }

    private WebElement tabBookTicketElement() {
        return Constants.WEBDRIVER.findElement(tabBookTicket);
    }

    private WebElement tabHomeElement() {
        return Constants.WEBDRIVER.findElement(tabHome);
    }

    private WebElement tabFAQElement() {
        return Constants.WEBDRIVER.findElement(tabFAQ);
    }

    private WebElement tabContactsElement() {
        return Constants.WEBDRIVER.findElement(tabContacts);
    }

    private WebElement tabTimetablesElement() {
        return Constants.WEBDRIVER.findElement(tabTimetables);
    }

    private WebElement tabMyTicketElement() {
        return Constants.WEBDRIVER.findElement(tabMyTicket);
    }

    private WebElement tabTicketPriceElement() {
        return Constants.WEBDRIVER.findElement(tabTicketPrice);
    }

    private WebElement tabChangePasswordElement() {
        return Constants.WEBDRIVER.findElement(tabChangePassword);
    }

    private WebElement tabRegisterPageActiveElement() {
        return Constants.WEBDRIVER.findElement(tabRegisterActive);
    }

    //Methods
    public void logout() {
        tabLogoutElement().click();
    }

    public String getGreeting() {
        return greetingElement().getText();
    }

    public void goToRegisterPage() {
        tabRegisterElement().click();
    }

    public void goToLoginPage() {
        tabLoginElement().click();
    }

    public void goToBookTicketPage() {
        tabBookTicketElement().click();
    }
}
