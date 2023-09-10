package magento.last.five;

import actions.FindElements;
import actions.PageActions;
import driver.PageWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
        action.enterKeys(address,"any address");

        WebElement city = elements.findElementByXPath("//*[@id=\"N1UKLMU\"]");
        action.enterKeys(city,"Bangalore");

        WebElement countriesDropdown = elements.findElementByXPath("//*[@id=\"B3RO8S2\"]");
        Select dropdown = new Select(countriesDropdown);
        dropdown.selectByValue("India");


        WebElement stateDropdown = elements.findElementByXPath("//*[@id=\"OLFRC9Q\"]");
        dropdown = new Select(stateDropdown);
        dropdown.selectByValue("Karnataka");

    }

}
