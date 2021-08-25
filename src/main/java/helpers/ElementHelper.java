package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ElementHelper {
    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Constants.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
