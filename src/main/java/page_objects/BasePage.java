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

    private WebElement tabBookTicketElement(){
        return Constants.WEBDRIVER.findElement(tabBookTicket);
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
