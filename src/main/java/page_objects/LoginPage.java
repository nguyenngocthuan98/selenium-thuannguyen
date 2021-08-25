package page_objects;

import helpers.Constants;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public final String WRONG_EMAIL_FORMAT = "test@railway.";
    public final String NOT_EXIST_EMAIL = "testnotexist@railway.co";
    public final String WRONG_PASSWORD = "this is wrong password";

    //Locates
    private final By emailField = By.cssSelector("li.username input#username");
    private final By passwordField = By.cssSelector("li.password input#password");
    private final By btnSubmit = By.cssSelector("input[type='submit']");
    private final By topErrorMessages = By.cssSelector("p[class='message error LoginForm']");
    private final By emailErrorMessage = By.cssSelector("li.username>label.validation-error");
    private final By passwordErrorMessage = By.cssSelector("li.password>label.validation-error");
    private final By registerPageLink = By.cssSelector("li a[href='Register.cshtml']");
    private final By forgotPasswordLink = By.cssSelector("li a[href='/Account/ForgotPassword.cshtml']");
    private final By btnSendingInstruction = By.xpath("//p[@class='form-actions']/input[@value='Send Instructions']");
    private final By tabRegisterActive = By.xpath("//li[@class='selected']/a/span[text()='Register']");

    //Elements
    private WebElement getEmailFiled() {
        return Constants.WEBDRIVER.findElement(emailField);
    }

    private WebElement getPasswordFiled() {
        return Constants.WEBDRIVER.findElement(passwordField);
    }

    private WebElement getBtnLogin() {
        return Constants.WEBDRIVER.findElement(btnSubmit);
    }

    private WebElement getTopErrorMessage() {
        return Constants.WEBDRIVER.findElement(topErrorMessages);
    }

    private WebElement getEmailErrorMessage() {
        return Constants.WEBDRIVER.findElement(emailErrorMessage);
    }

    private WebElement getPasswordErrorMessage() {
        return Constants.WEBDRIVER.findElement(passwordErrorMessage);
    }

    private WebElement getRegisterPageLink() {
        return Constants.WEBDRIVER.findElement(registerPageLink);
    }

    private WebElement getForgotPasswordLink() {
        return Constants.WEBDRIVER.findElement(forgotPasswordLink);
    }

    private WebElement getBtnSendInstruction() {
        return Constants.WEBDRIVER.findElement(btnSendingInstruction);
    }

    private WebElement getTabRegisterPageActive() {
        return Constants.WEBDRIVER.findElement(tabRegisterActive);
    }


    //Methods
    public void goToRegisterPage() {
        getRegisterPageLink().click();
    }

    public String generalLoginErrorMsg(){
        return getTopErrorMessage().getText();
    }

    public String errorEmailMsg(){
        return getEmailErrorMessage().getText();
    }

    public String errorPasswordMsg(){
        return getPasswordErrorMessage().getText();
    }

    public void login(String email, String password) {
        ElementHelper.scrollTo(getEmailFiled());
        getEmailFiled().clear();
        getEmailFiled().sendKeys(email);
        getPasswordFiled().clear();
        getPasswordFiled().sendKeys(password);
        getBtnLogin().click();
    }
}
