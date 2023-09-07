package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageActions {
    public void clickElement(WebElement element){
        element.click();
    }
    public void enterKeys(WebElement element,String values){
        element.sendKeys(values);
    }
    public void Maximize(WebDriver driver){
        driver.manage().window().fullscreen();
    }
    public void navigateTo(WebDriver driver,String url){
        driver.get(url);
    }
}
