package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

public class ContextMenuTest extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        // Quit the WebDriver instance
        driver.quit();
    }

    @Test
    public void testContextMenu() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/context-menu");

        // Locate the context menu element
        WebElement contextMenu = driver.findElement(By.id("hot-spot"));

        // Right-click on the context menu element
        Actions actions = new Actions(driver);
        actions.contextClick(contextMenu).perform();

        // Wait for the alert to appear
        wait.until(ExpectedConditions.alertIsPresent());

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Get the text from the alert
        String alertText = alert.getText();

        // Verify the alert text
        Assert.assertEquals(alertText, "You selected a context menu");

        // Accept the alert
        alert.accept();
    }
}

