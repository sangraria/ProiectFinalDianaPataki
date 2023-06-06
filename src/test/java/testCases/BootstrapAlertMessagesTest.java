package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

public class BootstrapAlertMessagesTest extends BasePage {

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
    public void testAutoclosableBootstrapAlertMessage() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-alert-messages-demo");

        // Find the autoclosable alert message element
        WebElement autoclosableAlert = driver.findElement(By.id("autoclosable-alert"));

        // Verify the text of the autoclosable alert message
        String autoclosableAlertText = autoclosableAlert.getText();
        Assert.assertEquals(autoclosableAlertText, "I will close in 5 seconds");

        // Wait for the autoclosable alert message to disappear
        wait.until(ExpectedConditions.invisibilityOf(autoclosableAlert));
    }

    @Test
    public void testNormalBootstrapAlertMessage() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-alert-messages-demo");

        // Find the normal alert message element
        WebElement normalAlert = driver.findElement(By.id("normal-alert"));

        // Verify the text of the normal alert message
        String normalAlertText = normalAlert.getText();
        Assert.assertEquals(normalAlertText, "Normal alert message - keep it open until user closes it.");

        // Close the normal alert message
        WebElement closeButton = driver.findElement(By.xpath("//div[@id='normal-alert']//button[@class='close']"));
        closeButton.click();

        // Verify that the normal alert message is closed
        wait.until(ExpectedConditions.invisibilityOf(normalAlert));
    }
}

