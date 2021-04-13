package BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static resources.Config.baseUrl;


public class Base {


    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public Base() {
        super();
    }

    // Navigate to url
    public void visit(String url) {
        if (url.contains("http"))  {
            driver.get(url);
        } else {
            driver.get(baseUrl + url);
        }
    }

    // Get element or elements on a page
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locators){
        return driver.findElements(locators);
    }

    // Click elements
    public void click(By locator) {
        find(locator).click();
    }

    // Enter information e.g. Name
    public void type(String inputText, By locator) {
        find(locator).sendKeys(inputText);
    }

    // Validating elements on screen, including elements that needs a wait
    public Boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException exception){
            return false;
        }

    }

    public Boolean isDisplayed(By locator, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout).getSeconds());
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

}
