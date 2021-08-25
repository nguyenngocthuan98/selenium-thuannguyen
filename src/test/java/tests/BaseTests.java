package tests;

import helpers.Constants;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    @BeforeMethod
    public void beforeMethod() {
        System.setProperty(Constants.TYPE_DRIVER, Constants.CHROME_DRIVER_LOCATIONS);
        Constants.WEBDRIVER = new ChromeDriver();
        Constants.WEBDRIVER.get(Constants.BASE_URL);
    }

    @AfterMethod
    public void afterMethod() {
        Constants.WEBDRIVER.quit();
    }
}
