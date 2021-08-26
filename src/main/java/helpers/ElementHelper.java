package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementHelper {
    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Constants.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void selectOption(WebElement element, String option) {
        (new Select(element)).selectByVisibleText(option);
    }
}
