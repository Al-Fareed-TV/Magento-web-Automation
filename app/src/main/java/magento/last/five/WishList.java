package magento.last.five;

import actions.FindElements;
import actions.PageActions;
import driver.PageWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WishList {
    WebDriver driver = null;

    public WishList(WebDriver driver) {
        this.driver = driver;
    }
    PageActions action = PageActions.getActionsObject();
    PageWaits pageWaits = PageWaits.getPageWaitsObject(driver);
    FindElements elements = FindElements.getInstance(driver);
    private void selectProduct(){
        WebElement product = pageWaits.waitUntilElementFoundByCSS("#maincontent > div.columns > div > div.widget.block.block-static-block > div.block.widget.block-products-list.grid > div > div > ol > li:nth-child(1) > div > a > span > span > img");
        action.scrollWindow(driver, product);
        action.clickElement(product);
    }
    private void addToWishList(){
        selectProduct();
        WebElement wishListButton = pageWaits.waitUntilElementFoundByPartialLink("ADD TO WISH LIST");
        action.clickElement(wishListButton);
    }
    public int verifyWishList(){
        addToWishList();
        Boolean titleName = pageWaits.waitForTitleToBeChanged("My Wish List");
        if(titleName){
            List<WebElement> element = pageWaits.waitUntilListOfElementFoundByCss("#wishlist-view-form > div.products-grid.wishlist > ol");
            return element.size();
        }
        return 0;
    }
}
