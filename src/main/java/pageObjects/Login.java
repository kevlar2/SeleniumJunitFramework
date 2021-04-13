package pageObjects;

import BasePage.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;


public class Login extends Base {

    By usernameLocator  = By.id("username");
    By passwordLocator  = By.id("password");
    By submitButton     = By.cssSelector("button");
    By successMessageLocator = By.cssSelector(".flash.success");
    By failureMessageLocator = By.cssSelector(".flash.error");
    By loginFormLocator = By.id("login");

    public Login(WebDriver driver) {

        /*
        * Inheriting from the Base Page – To establish inheritance, you use the extends keyword when declaring the
        * class (example;class Login extends Base,and call super from the constructor, super(driver).
        * This passes the instance of the Selenium webdriver to the base page object, and
        * makes all of the base page object's methods available to our login page object and any
        * other page objects you eventually create).*/

        super(driver);
        visit("http://the-internet.herokuapp.com/login");
        assertTrue("The login form is not present",
                driver.findElement(loginFormLocator).isDisplayed());
    }

    public Login(){
        super();
    }

    public Login with(String username, String password) {
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(submitButton);

        return new Login();
    }

    public Boolean successMessagePresent() {
        return isDisplayed(successMessageLocator);
    }

    public Boolean failureMessagePresent() {
        return isDisplayed(failureMessageLocator);
    }

}
