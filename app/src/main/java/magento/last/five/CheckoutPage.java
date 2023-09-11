package magento.last.five;

import actions.FindElements;
import actions.PageActions;
import driver.PageWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.lang.Thread.sleep;

public class CheckoutPage {
    private WebDriver driver = null;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    PageActions action = PageActions.getActionsObject();
    PageWaits pageWaits = PageWaits.getPageWaitsObject(driver);
    FindElements elements = FindElements.getInstance(driver);

    private void proceedToCheckout() throws InterruptedException {
        sleep(4000);
        WebElement cartButton = pageWaits.waitUntilElementFoundByCSS("body > div.page-wrapper > header > div.header.content > div.minicart-wrapper > a");
        action.clickElement(cartButton);
        WebElement proceedToCheckoutButton = pageWaits.waitUntilElementFoundByCSS("#top-cart-btn-checkout");
        action.clickElement(proceedToCheckoutButton);
    }
    public void fillShippingAddress(){
//        proceedToCheckout();
        WebElement address = pageWaits.waitUntilElementFoundByXPath("//*[@id=\"N0NK716\"]");
        action.type(address,"any address");

        WebElement city = elements.findElementByXPath("//*[@id=\"N1UKLMU\"]");
        action.type(city,"Bangalore");

        WebElement countriesDropdown = elements.findElementByXPath("//*[@id=\"B3RO8S2\"]");
        Select dropdown = new Select(countriesDropdown);
        dropdown.selectByValue("India");


        WebElement stateDropdown = elements.findElementByXPath("//*[@id=\"OLFRC9Q\"]");
        dropdown = new Select(stateDropdown);
        dropdown.selectByValue("Karnataka");

    }
    public void placeOrder() throws InterruptedException {
        proceedToCheckout();
        pageWaits.waitForTitleToBeChanged("Checkout");
    }

}
