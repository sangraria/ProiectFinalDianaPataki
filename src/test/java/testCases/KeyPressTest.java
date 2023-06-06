package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

public class KeyPressTest extends BasePage {

    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setUp() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() {
        // Quit the WebDriver instance
        driver.quit();
    }

    @Test
    public void testKeyPress() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/key-press");

        // Find the input field
        WebElement inputField = driver.findElement(By.id("keypress-input"));

        // Perform a key press
        actions.sendKeys(inputField, Keys.ENTER).perform();

        // Get the text in the input field
        String enteredText = inputField.getAttribute("value");

        // Verify the entered text
        Assert.assertEquals(enteredText, "ENTER key pressed");
    }
}


