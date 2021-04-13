package tests;

import org.junit.Before;
import org.junit.Test;
import pageObjects.Login;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestLogin extends BaseTest {

    private Login login;

    @Before
    public void setUp() {

        login = new Login(driver);

    }

    @Test
    public void succeededLogin() {

        /* Started with this but now implemented a POM structure
        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button")).click();*/

        login.with("tomsmith", "SuperSecretPassword!");

        /* Started with this but now implemented a POM structure
        assertTrue("success message not present",
                driver.findElement(By.cssSelector(".flash.success")).isDisplayed());*/

        assertTrue("success message not present",
                login.successMessagePresent());
    }

    @Test
    public void failedLogin() {
        login.with("tomsmith", "bad password");
        assertTrue("failure message wasn't present after providing bogus credentials",
                login.failureMessagePresent());
    }

    @Test
    public void failedLoginUsingBaseMethod() {
        login.with("tomsmith", "bad password");
        assertFalse("failure message wasn't present after providing bogus credentials",
                login.successMessagePresent());
    }

}
