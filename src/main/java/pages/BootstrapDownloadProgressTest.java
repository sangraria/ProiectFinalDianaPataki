package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BootstrapDownloadProgressTest {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-download-progress-demo");
    }

    @Test
    public void testBootstrapDownloadProgress() {
        // Find the download button and progress bar elements using locators
        WebElement downloadButton = driver.findElement(By.id("start download-btn"));
        WebElement progressBar = driver.findElement(By.className("progress-bar"));

        // Perform assertions or further actions with the located elements
    }
}
