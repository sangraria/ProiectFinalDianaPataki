package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

public class FileUploadTest extends BasePage {

    private WebDriver driver;

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
    public void testFileUpload() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/upload-file-demo");

        // Find the "Choose File" button
        WebElement chooseFileButton = driver.findElement(By.id("chooseFile"));

        // Specify the path of the file to upload
        String filePath = "C:\\Users\\diana\\desktop\\file.txt";

        // Send the file path to the "Choose File" button
        chooseFileButton.sendKeys(filePath);

        // Find the uploaded file name element
        WebElement uploadedFileName = driver.findElement(By.id("uploadedFileName"));

        // Get the text of the uploaded file name
        String uploadedFileNameText = uploadedFileName.getText();

        // Verify the uploaded file name
        Assert.assertEquals(uploadedFileNameText, "file.txt");
    }
}

