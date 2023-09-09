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

    private static WebDriver driver = null;

    private DriverCreator(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                DriverCreator.driver =  new FirefoxDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                DriverCreator.driver =   new SafariDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                DriverCreator.driver =   new ChromeDriver();
                break;
            default:
                DriverCreator.driver =   createDefaultBrowser();
        }
    }

    public static WebDriver instantiateDriver(String browser){
        if(driver == null){
         new DriverCreator(browser);
        }
        return DriverCreator.driver;
    }

    public static WebDriver createDefaultBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
