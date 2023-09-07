/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package magento.last.five;

import actions.PageActions;
import driver.DriverCreator;
import driver.PageWaits;
import org.openqa.selenium.By;
import data.Credentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.*;


public class LoginPage {
    public void login() {

//        1.Arrange
        String browser = "firefox";
        WebDriver driver = DriverCreator.createDriver(browser);
        PageActions action = new PageActions();
        PageWaits pageWaits = new PageWaits();
        String url = "https://magento.softwaretestingboard.com/";
//        2.Act
        action.Maximize(driver);
        action.navigateTo(driver,url);
        By signInButton = partialLinkText("Sign In");
        WebElement signInElement = pageWaits.waitUntilElementFound(driver, signInButton);
        action.clickElement(signInElement);

        By emailId = id("email");
        WebElement emailElement = pageWaits.waitUntilElementFound(driver, emailId);
        action.enterKeys(emailElement, Credentials.emailId());

        By passwordId = id("pass");
        WebElement passwordElement = pageWaits.waitUntilElementFound(driver, passwordId);
        action.enterKeys(passwordElement,Credentials.password());

        By submitButton = className("primary");
        WebElement submitButtonElement = pageWaits.findTheElement(driver, submitButton);
        action.clickElement(submitButtonElement);

    }
}