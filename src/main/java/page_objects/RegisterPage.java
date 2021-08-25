package page_objects;

import helpers.Constants;
import helpers.ElementHelper;
import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    //Locates
    private final By emailField = By.cssSelector("input#email");
    private final By passwordField = By.cssSelector("input#password");
    private final By confirmPasswordField = By.cssSelector("input#confirmPassword");
    private final By pidField = By.cssSelector("input#pid");
    private final By btnRegister = By.cssSelector("input[type='submit']");
    private final By contentRegisterSuccess = By.cssSelector("div#content p");

    //Element
    private WebElement emailFieldElement() {
        return Constants.WEBDRIVER.findElement(emailField);
    }

    private WebElement passwordFieldElement() {
        return Constants.WEBDRIVER.findElement(passwordField);
    }

    private WebElement confirmPasswordFieldElement() {
        return Constants.WEBDRIVER.findElement(confirmPasswordField);
    }

    private WebElement pidFieldElement() {
        return Constants.WEBDRIVER.findElement(pidField);
    }

    private WebElement btnRegisterElement() {
        return Constants.WEBDRIVER.findElement(btnRegister);
    }

    private WebElement contentRegisterSuccessElement() {
        return Constants.WEBDRIVER.findElement(contentRegisterSuccess);
    }

    //Methods
    public String getContentRegisterSuccess() {
        Wait.untilElementExist(contentRegisterSuccess, Constants.TIME_WAIT, Constants.WEBDRIVER);
        return contentRegisterSuccessElement().getText();
    }

    public void register(String email, String password, String pid) {
        ElementHelper.scrollTo(emailFieldElement());
        emailFieldElement().clear();
        emailFieldElement().sendKeys(email);
        passwordFieldElement().clear();
        passwordFieldElement().sendKeys(password);
        confirmPasswordFieldElement().clear();
        confirmPasswordFieldElement().sendKeys(password);
        pidFieldElement().clear();
        pidFieldElement().sendKeys(pid);
        btnRegisterElement().click();
    }
}
