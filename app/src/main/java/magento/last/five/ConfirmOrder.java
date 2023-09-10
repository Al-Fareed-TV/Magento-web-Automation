package magento.last.five;

import actions.FindElements;
import actions.PageActions;
import driver.PageWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class ConfirmOrder {
    WebDriver driver = null;

    public ConfirmOrder(WebDriver driver) {
        this.driver = driver;
    }

    PageActions action = PageActions.getActionsObject();
    PageWaits pageWaits = PageWaits.getPageWaitsObject(driver);
    FindElements elements = FindElements.getInstance(driver);

    public int checkCart() throws InterruptedException {
        WebElement cartButton = elements.findElementByCSS("body > div.page-wrapper > header > div.header.content > div.minicart-wrapper > a > span.counter.qty");
        sleep(2000);
        action.clickElement(cartButton);
        pageWaits.waitUntilElementFoundByCSS("#ui-id-1");
        String itemCount = pageWaits.waitUntilElementFoundByCSS("#minicart-content-wrapper > div.block-content > div.items-total > span.count").getText();
        return Integer.parseInt(itemCount);
    }
}
