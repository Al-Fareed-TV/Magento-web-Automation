package actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageActions {
    private static PageActions actions = null;

    private PageActions() {}

    public static PageActions getActionsObject() {
        if (PageActions.actions == null) {
            PageActions.actions = new PageActions();
        }
        return PageActions.actions;
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String values) {
        element.clear();
        element.sendKeys(values);
    }
    public void enterKey(WebElement element){
        element.sendKeys(Keys.ENTER);
    }

    public void Maximize(WebDriver driver) {
        driver.manage().window().fullscreen();
    }

    public void navigateTo(WebDriver driver, String url) {
        driver.get(url);
    }

    public void scrollWindow(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }

}
