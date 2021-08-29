package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ElementHelper {
    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Constants.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void selectOption(WebElement element, String option) {
        (new Select(element)).selectByVisibleText(option);
    }

    public static SimpleDateFormat formatDate() {
        return new SimpleDateFormat("M/d/yyyy");
    }

    public static String departDay(int indexDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DataHelper.getCurrentDate());

        calendar.add(Calendar.DATE, 3 + indexDay);

        return formatDate().format(calendar.getTime());
    }
}
