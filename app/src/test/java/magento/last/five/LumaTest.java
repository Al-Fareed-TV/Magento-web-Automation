/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package magento.last.five;

import driver.DriverCreator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;

public class LumaTest {
    private WebDriver driver = null;

    @BeforeClass
    public void setup() {
        String browser = "firefox";
        driver = DriverCreator.instantiateDriver(browser);
    }

    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
    }

    int initialCountOfCart = 0;

    public void addToCartTest() {
        loginTest();
        OrderProduct order = new OrderProduct(driver);
        initialCountOfCart = order.AddToCart();
    }

    @Test
    public void verifyCount() throws InterruptedException {
        addToCartTest();
        System.out.println("Initial count : " + initialCountOfCart);
        ConfirmOrder confirmOrder = new ConfirmOrder(driver);
        int count = confirmOrder.checkCart();
        System.out.println("Present count of cart : " + count);
        Assert.assertEquals(count, (initialCountOfCart + 2));
    }

    @Test
    public void testCheckoutPage() throws InterruptedException {
        verifyCount();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillShippingAddress();
    }

    @Test
    public void testUserAccountPage() throws InterruptedException {
        UserAccountPage userAccountPage = new UserAccountPage(driver);
        userAccountPage.editProfile();
        String items = userAccountPage.myOrders();
        Assert.assertEquals(items, "1 Item");
    }

    @Test
    public void testWishListPage() {
        loginTest();
        WishList wishList = new WishList(driver);
        int countOfItemsInWishList = wishList.verifyWishList();
        Assert.assertEquals(countOfItemsInWishList, 1);
    }

    @Test
    public void testSearchProduct() {
        SearchProduct searchProduct = new SearchProduct(driver);
        int countOfListedProducts = searchProduct.verifyListOfSearchElements("shirt");
        Assert.assertEquals(countOfListedProducts, 5);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
