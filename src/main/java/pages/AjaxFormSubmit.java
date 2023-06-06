package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AjaxFormSubmit {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
    }

    @Test
    public void testAjaxFormSubmit() {
        // Find the form fields and submit button using locators
        WebElement nameField = driver.findElement(By.id("name"));
        WebElement commentField = driver.findElement(By.id("message"));
        WebElement submitButton = driver.findElement(By.id("btn-submit"));

        // Fill in the form fields
        nameField.sendKeys("John Doe");
        commentField.sendKeys("This is a test comment");

        // Submit the form
        submitButton.click();

        // You can continue with further validations/assertions
    }
}
