package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KeyPressTest {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/key-press");
    }

    @Test
    public void testKeyPress() {
        // Find the target element
        WebElement targetElement = driver.findElement(By.id("target"));

        // Simulate key press event by sending specific keys to the target element

        // Example: Send ENTER key
        targetElement.sendKeys(Keys.ENTER);

        // Example: Send TAB key
        targetElement.sendKeys(Keys.TAB);

        // Example: Send SPACE key
        targetElement.sendKeys(Keys.SPACE);

        // Example: Send ESCAPE key
        targetElement.sendKeys(Keys.ESCAPE);

        // Perform assertions or further actions based on the key press events
    }
}


