package magento.last.five;

import actions.PageActions;
import driver.PageWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FilterProduct {
    WebDriver driver = null;

    public FilterProduct(WebDriver driver) {
        this.driver = driver;
    }

    PageActions action = PageActions.getActionsObject();
    PageWaits pageWaits = PageWaits.getPageWaitsObject(driver);

    private void goToPage(){
        action.navigateTo(driver,"https://magento.softwaretestingboard.com/");
        pageWaits.waitForTitleToBeChanged("Home Page");
        WebElement MenCategory = pageWaits.waitUntilElementFoundByPartialLink("Men");
        Actions mouseAction = new Actions(driver);
        mouseAction.moveToElement(MenCategory).perform();

        WebElement Tops = pageWaits.waitUntilElementFoundByPartialLink("Tops");
        mouseAction.moveToElement(Tops).perform();

        WebElement Jackets = pageWaits.waitUntilElementFoundByPartialLink("Jackets");
        action.clickElement(Jackets);
    }
    public void filterPage(){
        goToPage();
        pageWaits.waitForTitleToBeChanged("Jackets - Tops - Men");
        WebElement sortButton = pageWaits.waitUntilElementFoundByCSS("#sorter");
        Select dropdown = new Select(sortButton);
        dropdown.selectByValue("Product Name");

        WebElement colorOfProduct = pageWaits.waitUntilElementFoundByCSS("#narrow-by-list > div.filter-options-item.allow.active > div.filter-options-title");
        action.clickElement(colorOfProduct);

        WebElement whiteColor = pageWaits.waitUntilElementFoundByCSS("#narrow-by-list > div.filter-options-item.allow.active > div.filter-options-content > div > div > a:nth-child(8) > div");
        action.clickElement(whiteColor);
    }
}
