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

public class InputFormValidationsTest extends BasePage {

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
    public void testInputFormValidations() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");

        // Enter invalid values in the input fields
        WebElement nameInput = driver.findElement(By.id("name"));
        nameInput.sendKeys("");

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("invalidemail");

        WebElement phoneInput = driver.findElement(By.id("phone"));
        phoneInput.sendKeys("123");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("pass");

        // Submit the form
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        // Wait for the form validation errors to appear
        WebElement formError = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        wait.until(ExpectedConditions.visibilityOf(formError));

        // Verify the form validation errors
        Assert.assertEquals(formError.getText(), "Please fill out this field.\nInvalid email address.\nPhone number must be 10 digits.\nPassword must be at least 6 characters.");

        // Clear the input fields
        nameInput.clear();
        emailInput.clear();
        phoneInput.clear();
        passwordInput.clear();

        // Enter valid values in the input fields
        nameInput.sendKeys("John Doe");
        emailInput.sendKeys("johndoe@example.com");
        phoneInput.sendKeys("1234567890");
        passwordInput.sendKeys("password123");

        // Submit the form again
        submitButton.click();

        // Wait for the success message to appear
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        wait.until(ExpectedConditions.visibilityOf(successMessage));

        // Verify the success message
        Assert.assertEquals(successMessage.getText(), "Form submitted successfully!");

        // Additional verifications or assertions can be performed as needed
    }
}

