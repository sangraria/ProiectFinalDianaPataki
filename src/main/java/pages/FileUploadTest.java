package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadTest {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/upload-file-demo");
    }

    @Test
    public void testFileUpload() {
        // Find the "Choose File" button element using locators
        WebElement chooseFileButton = driver.findElement(By.cssSelector("#file-upload"));

        // Find the "Upload" button element using locators
        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));

        // Perform assertions or further actions with the located elements
    }
}
