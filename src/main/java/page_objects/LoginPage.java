package page_objects;

import helpers.Constants;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    //Locators
    private final By emailField = By.cssSelector("li.username input#username");
    private final By passwordField = By.cssSelector("li.password input#password");
    private final By btnSubmit = By.cssSelector("input[type='submit']");
    private final By topErrorMessages = By.cssSelector("p[class='message error LoginForm']");
    private final By emailErrorMessage = By.cssSelector("li.username label.validation-error");
    private final By passwordErrorMessage = By.cssSelector("li.password label.validation-error");
    private final By linkRegisterPage = By.cssSelector("li a[href='Register.cshtml']");
    private final By linkForgotPassword = By.cssSelector("li a[href='/Account/ForgotPassword.cshtml']");
    private final By btnSendingInstruction = By.xpath("//p[@class='form-actions']/input[@value='Send Instructions']");

    //Elements
    private WebElement emailFieldElement() {
        return Constants.WEBDRIVER.findElement(emailField);
    }

    private WebElement passwordFieldElement() {
        return Constants.WEBDRIVER.findElement(passwordField);
    }

    private WebElement btnLoginElement() {
        return Constants.WEBDRIVER.findElement(btnSubmit);
    }

    private WebElement topErrorMessageElement() {
        return Constants.WEBDRIVER.findElement(topErrorMessages);
    }

    private WebElement emailErrorMessageElement() {
        return Constants.WEBDRIVER.findElement(emailErrorMessage);
    }

    private WebElement passwordErrorMessageElement() {
        return Constants.WEBDRIVER.findElement(passwordErrorMessage);
    }

    private WebElement linkRegisterPageElement() {
        return Constants.WEBDRIVER.findElement(linkRegisterPage);
    }

    private WebElement linkForgotPasswordElement() {
        return Constants.WEBDRIVER.findElement(linkForgotPassword);
    }

    private WebElement btnSendInstructionElement() {
        return Constants.WEBDRIVER.findElement(btnSendingInstruction);
    }


    //Methods
    public void goToRegisterPage() {
        linkRegisterPageElement().click();
    }

    public String getTopErrorMessage(){
        return topErrorMessageElement().getText();
    }

    public String getEmailErrorMessage(){
        return emailErrorMessageElement().getText();
    }

    public String getPasswordErrorMessage(){
        return passwordErrorMessageElement().getText();
    }

    public void login(String email, String password) {
        ElementHelper.scrollTo(emailFieldElement());
        emailFieldElement().clear();
        emailFieldElement().sendKeys(email);
        passwordFieldElement().clear();
        passwordFieldElement().sendKeys(password);
        btnLoginElement().click();
    }
}
