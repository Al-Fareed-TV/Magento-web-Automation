package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.SafariDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverCreator {
    public static WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            default:
                return createDefaultBrowser();
        }
    }

    public static WebDriver createDefaultBrowser() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
