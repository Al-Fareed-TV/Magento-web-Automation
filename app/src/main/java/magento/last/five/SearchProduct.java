package magento.last.five;

import actions.FindElements;
import actions.PageActions;
import driver.PageWaits;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchProduct {
    private WebDriver driver = null;

    public SearchProduct(WebDriver driver) {
        this.driver = driver;
    }

    PageActions action = PageActions.getActionsObject();
    PageWaits pageWaits = PageWaits.getPageWaitsObject(driver);
    FindElements elements = FindElements.getInstance(driver);

    private void searchProduct(String productName) {
        WebElement searchBar = pageWaits.waitUntilElementFoundByID("search");
        action.type(searchBar, productName);
        action.enterKey(searchBar);
    }

    public int verifyListOfSearchElements(String productName) {
        searchProduct(productName);
        Boolean titleToBeChanged = pageWaits.waitForTitleToBeChanged("Search results for: '" + productName + "'");
        if (titleToBeChanged) {
            WebElement listOfProducts = pageWaits.waitUntilElementFoundByCSS("#toolbar-amount > span");
            return Integer.parseInt(listOfProducts.getText());
        }
        return 0;
    }
}
