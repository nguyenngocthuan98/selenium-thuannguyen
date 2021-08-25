package helpers;

import org.openqa.selenium.WebDriver;

public class Constants {
    public static WebDriver WEBDRIVER;
    public final static String BASE_URL = "http://railway2.somee.com/Page/HomePage.cshtml";
    public final static String CHROME_DRIVER_LOCATIONS = "src/test/resources/drivers/chromedriver.exe";
    public final static String TYPE_DRIVER = "webdriver.chrome.driver";

    public final static String EMAIL = "test@railway.com";
    public final static String PASSWORD = "123123123";
    public final static Integer TIME_WAIT = 30;

}
