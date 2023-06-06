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

public class BootstrapModalTest extends BasePage {

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
    public void testBootstrapModal() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-modal-demo");

        // Find and click the "Launch modal" button
        WebElement launchModalButton = driver.findElement(By.id("myModal"));
        launchModalButton.click();

        // Wait for the modal dialog to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModalDialog")));

        // Find and click the "Save changes" button within the modal dialog
        WebElement saveChangesButton = driver.findElement(By.xpath("//div[@id='myModalDialog']//button[text()='Save changes']"));
        saveChangesButton.click();

        // Wait for the modal dialog to close
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("myModalDialog")));

        // Verify that the modal dialog is closed
        Assert.assertFalse(driver.findElement(By.id("myModalDialog")).isDisplayed());
    }
}

