package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class PageWaits {
    private FluentWait<WebDriver> waitForElement(WebDriver driver){
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }
    public WebElement waitUntilElementFound(WebDriver driver, By by){
       return waitForElement(driver).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public WebElement findTheElement(WebDriver driver,By by){
        return driver.findElement(by);
    }

}
