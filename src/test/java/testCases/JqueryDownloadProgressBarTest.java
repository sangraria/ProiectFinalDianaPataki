package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class JqueryDownloadProgressBarTest extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsExecutor;

    @BeforeMethod
    public void setUp() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        jsExecutor = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void tearDown() {
        // Quit the WebDriver instance
        driver.quit();
    }

    @Test
    public void testJQueryDownloadProgress() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/jquery-download-progress-bar-demo");

        // Find and click the "Start Download" button
        WebElement startDownloadButton = driver.findElement(By.id("downloadButton"));
        startDownloadButton.click();

        // Wait for the download progress bar to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("progressBar")));

        // Wait for the download progress bar to reach 100%
        wait.until(ExpectedConditions.attributeToBe(By.id("progressBar"), "aria-valuenow", "100"));

        // Verify that the download is complete
        WebElement downloadStatus = driver.findElement(By.id("downloadStatus"));
        String statusText = downloadStatus.getText();
        Assert.assertEquals(statusText, "Download Complete");
    }
}

