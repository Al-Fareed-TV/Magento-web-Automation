package magento.last.five;

import actions.FindElements;
import actions.PageActions;
import driver.PageWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage {
    private WebDriver driver = null;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    PageActions action = PageActions.getActionsObject();
    PageWaits pageWaits = PageWaits.getPageWaitsObject(driver);
    FindElements elements = FindElements.getInstance(driver);

    private void proceedToCheckout(){
        WebElement proceedToCheckoutButton = pageWaits.waitUntilElementFoundByCSS("#top-cart-btn-checkout");
        action.clickElement(proceedToCheckoutButton);
    }
    public void fillShippingAddress(){
        proceedToCheckout();
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
    public void placeOrder(){
        proceedToCheckout();
        pageWaits.waitForTitleToBeChanged("Checkout");
        WebElement radioButton = pageWaits.waitUntilElementFoundByXPath("document.querySelector(\"#checkout-shipping-method-load > table > tbody > tr > td:nth-child(1) > input\")");
        action.clickElement(radioButton);

        WebElement nextButton = pageWaits.waitUntilElementFoundByXPath("//*[@id=\"shipping-method-buttons-container\"]/div/button/span");
        action.clickElement(nextButton);

        WebElement proceedButton = pageWaits.waitUntilElementFoundByXPath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span");
        action.clickElement(proceedButton);
    }

}
