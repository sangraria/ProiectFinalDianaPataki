package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileDownloadTest {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/generate-file-to-download-demo");
    }

    @Test
    public void testFileDownload() {
        // Find the "Generate File" button element using locators
        WebElement generateFileButton = driver.findElement(By.cssSelector("#generator"));

        // Find the link to download the generated file using locators
        WebElement downloadLink = driver.findElement(By.cssSelector("#link-to-download"));

        // Perform assertions or further actions with the located elements
    }
}
