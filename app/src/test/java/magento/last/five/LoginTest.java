/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package magento.last.five;

import org.testng.annotations.Test;

public class LoginTest {
@Test
    public void shouldLogin(){
    LoginPage loginPage = new LoginPage();
    loginPage.login();
}

}