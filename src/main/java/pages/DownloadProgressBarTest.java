package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadProgressBarTest {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/jquery-download-progress-bar-demo");
    }

    @Test
    public void testDownloadProgressBar() {
        // Find the "Start Download" button
        WebElement startDownloadButton = driver.findElement(By.id("downloadButton"));

        // Click the "Start Download" button
        startDownloadButton.click();

        // Find the progress bar element
        WebElement progressBar = driver.findElement(By.id("progressBar"));

        // Perform assertions or further actions with the progress bar

        // Wait for the download to complete
        // Example: You can use explicit or implicit wait to wait for the download to complete
    }
}
