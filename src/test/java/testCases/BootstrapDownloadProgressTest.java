package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

public class BootstrapDownloadProgressTest extends BasePage {

    private WebDriver driver;
    private JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void tearDown() {
        // Quit the WebDriver instance
        driver.quit();
    }

    @Test
    public void testBootstrapDownloadProgress() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-download-progress-demo");

        // Click the "Download" button
        WebElement downloadButton = driver.findElement(By.id("circle-btn"));
        downloadButton.click();

        // Wait for the download progress to reach 100%
        waitUntilDownloadComplete();

        // Verify if the download progress is complete
        WebElement downloadProgress = driver.findElement(By.id("progressBar"));
        String progressText = downloadProgress.getText();
        Assert.assertEquals(progressText, "100% Complete!");

        // Verify if the "Download Complete" message is displayed
        WebElement downloadCompleteMsg = driver.findElement(By.id("downloadComplete"));
        Assert.assertTrue(downloadCompleteMsg.isDisplayed());
    }

    private void waitUntilDownloadComplete() {
        while (true) {
            // Check if the progress bar has reached 100%
            boolean isDownloadComplete = (Boolean) js.executeScript("return document.getElementById('progressBar').innerText === '100% Complete!'");
            if (isDownloadComplete) {
                break;
            }

            // Wait for a short period before checking again
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

