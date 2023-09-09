package magento.last.five;

import actions.FindElements;
import actions.PageActions;
import driver.PageWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderProduct {
    private WebDriver driver = null;

    public OrderProduct(WebDriver driver) {
        this.driver = driver;
    }
    PageActions action = PageActions.getActionsObject();
    PageWaits pageWaits = PageWaits.getPageWaitsObject(driver);
    FindElements elements = FindElements.getInstance(driver);

    public WebElement scrollToElement(){
        WebElement product = pageWaits.waitUntilElementFoundByCSS("#maincontent > div.columns > div > div.widget.block.block-static-block > div.block.widget.block-products-list.grid > div > div > ol > li:nth-child(3)");
        action.scrollWindow(driver,product);
        return product;
    }

    public void AddToCart() {
        WebElement product = scrollToElement();
        action.clickElement(product);
        WebElement productSize = pageWaits.waitUntilElementFoundByCSS("#option-label-size-143-item-169");
        action.clickElement(productSize);

        WebElement qtyElement = elements.findElementByID("qty");
        action.enterKeys(qtyElement,"2");

        WebElement colorElement = elements.findElementByCSS("#option-label-color-93-item-52");
        action.clickElement(colorElement);

        WebElement submitButton = elements.findElementByID("product-addtocart-button");
        action.clickElement(submitButton);
    }
}
