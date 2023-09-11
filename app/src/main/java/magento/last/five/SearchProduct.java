package magento.last.five;

import actions.FindElements;
import actions.PageActions;
import driver.PageWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchProduct {
    private WebDriver driver = null;

    public SearchProduct(WebDriver driver) {
        this.driver = driver;
    }

    PageActions action = PageActions.getActionsObject();
    PageWaits pageWaits = PageWaits.getPageWaitsObject(driver);
    FindElements elements = FindElements.getInstance(driver);

    private void searchProduct(String productName) {
        WebElement searchBar = pageWaits.waitUntilElementFoundByCSS("#search");
        action.type(searchBar, productName);
        action.enterKey(searchBar);
    }

    public int verifyListOfSearchElements(String productName) {
        searchProduct(productName);
        pageWaits.waitForTitleToBeChanged("Search results for: '" + productName + "'");

        WebElement listOfProducts = pageWaits.waitUntilElementFoundByCSS("#toolbar-amount > span");
        return Integer.parseInt(listOfProducts.getText());

    }
}
