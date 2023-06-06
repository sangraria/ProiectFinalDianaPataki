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

public class AjaxFormSubmitTest extends BasePage {

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
    public void testAjaxFormSubmit() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");

        // Enter name and comment in the form
        WebElement nameInput = driver.findElement(By.id("title"));
        WebElement commentInput = driver.findElement(By.id("description"));
        nameInput.sendKeys("John Doe");
        commentInput.sendKeys("This is a test comment");

        // Submit the form
        WebElement submitButton = driver.findElement(By.id("btn-submit"));
        submitButton.click();

        // Wait for the form submission to complete
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-control")));

        // Verify the success message
        Assert.assertEquals(successMessage.getText(), "Form submited Successfully!");

        // Verify the submitted name and comment
        WebElement submittedName = driver.findElement(By.id("submitted-title"));
        WebElement submittedComment = driver.findElement(By.id("submitted-description"));
        Assert.assertEquals(submittedName.getText(), "Name: John Doe");
        Assert.assertEquals(submittedComment.getText(), "Comment: This is a test comment");
    }
}

