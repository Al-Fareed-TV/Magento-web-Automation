package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElements {
    private static FindElements elements = null;
    WebDriver driver = null;
    public FindElements(WebDriver driver) {
        this.driver = driver;
    }
    public static FindElements getInstance(WebDriver driver){
        if(FindElements.elements == null){
            FindElements.elements = new FindElements(driver);
        }
        return FindElements.elements;
    }
    public WebElement findElementByCSS(String cssLocator){
        return driver.findElement(By.cssSelector(cssLocator));
    }
    public WebElement findElementByID(String idLocator){
        return driver.findElement(By.id(idLocator));
    }
    public WebElement findElementByClass(String className){
        return driver.findElement(By.className(className));
    }
    public WebElement findElementByXPath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
    public List<WebElement> findListOfElementsByCSS(String cssLocator){
        return driver.findElements(By.cssSelector(cssLocator));
    }

}
