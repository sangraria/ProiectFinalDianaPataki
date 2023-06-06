package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

import java.io.File;

public class FileDownloadTest extends BasePage {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");

        // Configure ChromeOptions to set download directory
        ChromeOptions options = new ChromeOptions();
        String downloadDir = "C:\\Users\\diana\\desktop";
        options.addArguments("download.default_directory=" + downloadDir);

        // Create ChromeDriver instance with configured options
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown() {
        // Quit the WebDriver instance
        driver.quit();
    }

    @Test
    public void testFileDownload() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/generate-file-to-download-demo");

        // Click the "Generate File" button
        driver.findElement(By.id("generate")).click();

        // Wait for the file to download (add appropriate waiting mechanism if needed)
        try {
            Thread.sleep(5000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify if the file is downloaded
        String fileName = "download.txt"; // Replace with the expected file name
        File downloadedFile = new File("C:\\Users\\diana\\desktop" + fileName);
        // Replace with the path to the download directory and the expected file name
        Assert.assertTrue(downloadedFile.exists(), "File is not downloaded successfully.");

        // Additional assertions or verification logic can be added here based on the content or properties of the downloaded file
    }
}

