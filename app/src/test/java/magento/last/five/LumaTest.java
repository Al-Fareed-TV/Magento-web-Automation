/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package magento.last.five;

import driver.DriverCreator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LumaTest {
    private WebDriver driver = null;

    @BeforeClass
    public void setup() {
        String browser = "firefox";
        driver = DriverCreator.instantiateDriver(browser);
    }

    @Test
    public void shouldLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
    }

    @Test
    public void AddToCart(){
        shouldLogin();
        OrderProduct order = new OrderProduct(driver);
        order.AddToCart();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        sleep(2500);
        driver.quit();
    }

}
