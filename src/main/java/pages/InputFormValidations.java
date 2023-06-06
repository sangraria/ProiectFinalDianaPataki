package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InputFormValidations {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
    }

    @Test
    public void testInputForm() {
        // Find the first name input field using locators
        WebElement firstNameInput = driver.findElement(By.name("first_name"));

        // Find the last name input field using locators
        WebElement lastNameInput = driver.findElement(By.name("last_name"));

        // Find the email input field using locators
        WebElement emailInput = driver.findElement(By.name("email"));

        // Find the phone input field using locators
        WebElement phoneInput = driver.findElement(By.name("phone"));

        // Perform assertions or further actions with the located elements
    }
}

