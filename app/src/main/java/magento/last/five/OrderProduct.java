package magento.last.five;

import actions.FindElements;
import actions.PageActions;
import driver.PageWaits;
import org.openqa.selenium.NoSuchElementException;
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

    public WebElement scrollToElement() {
        WebElement product = pageWaits.waitUntilElementFoundByCSS("#maincontent > div.columns > div > div.widget.block.block-static-block > div.block.widget.block-products-list.grid > div > div > ol > li:nth-child(3)");
        action.scrollWindow(driver, product);
        return product;
    }

    public int getInitialCountOfItemsInCart() {
        try {
            WebElement elementByCSS = elements.findElementByCSS("body > div.page-wrapper > header > div.header.content > div.minicart-wrapper > a > span.counter.qty > span.counter-number");
            String countText = elementByCSS.getText().trim();

            if (countText.isEmpty()) {
                return 0;
            }
            return Integer.parseInt(countText);
        } catch (NoSuchElementException e) {
            System.out.println("Didn't find the element");
            return 0;
        }
    }


    public int AddToCart() {

        WebElement product = scrollToElement();
        action.clickElement(product);
        WebElement productSize = pageWaits.waitUntilElementFoundByCSS("#option-label-size-143-item-169");
        action.clickElement(productSize);

        WebElement qtyElement = elements.findElementByID("qty");
        action.type(qtyElement, "2");

        WebElement colorElement = elements.findElementByCSS("#option-label-color-93-item-52");
        action.clickElement(colorElement);

        int initialCountOfItemsInCart = getInitialCountOfItemsInCart();

        WebElement submitButton = elements.findElementByID("product-addtocart-button");
        action.clickElement(submitButton);

        return initialCountOfItemsInCart;
    }
}
