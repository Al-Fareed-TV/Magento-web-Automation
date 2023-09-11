package magento.last.five;

import actions.FindElements;
import actions.PageActions;
import driver.PageWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class UserAccountPage {
    private WebDriver driver = null;

    public UserAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    PageActions action = PageActions.getActionsObject();
    PageWaits pageWaits = PageWaits.getPageWaitsObject(driver);
    FindElements elements = FindElements.getInstance(driver);

    private void goToAccountPage() throws InterruptedException {
        action.navigateTo(driver,"https://magento.softwaretestingboard.com/customer/account/");
        pageWaits.waitForTitleToBeChanged("My Account");
    }
    private void goToEditProfile()throws InterruptedException{
        goToAccountPage();
        WebElement edit = pageWaits.waitUntilElementFoundByPartialLink("Edit");
        action.clickElement(edit);
    }

    public void editProfile()throws InterruptedException{
        goToEditProfile();
        pageWaits.waitForTitleToBeChanged("Account Information");
        WebElement firstname = pageWaits.waitUntilElementFoundByID("firstname");
        action.type(firstname,"Munna");

        WebElement saveButton = elements.findElementByCSS("#form-validate > div > div.primary > button > span");
        action.clickElement(saveButton);
    }

    public String myOrders(){
        WebElement MyOrders = pageWaits.waitUntilElementFoundByCSS("#block-collapsible-nav > ul > li:nth-child(2) > a");
        action.clickElement(MyOrders);

        pageWaits.waitForTitleToBeChanged("My Orders");

        WebElement itemCount = pageWaits.waitUntilElementFoundByCSS("#maincontent > div.columns > div.column.main > div.order-products-toolbar.toolbar.bottom > div > p > span");
        return itemCount.getText();
    }
}
