package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BootstrapDatePickers {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-date-picker-demo");
    }

    @Test
    public void testBootstrapDatePickers() {
        // Find the date picker elements using locators
        WebElement datePicker = driver.findElement(By.id("select date"));
        WebElement rangeDatePicker = driver.findElement(By.id("select date range"));

        // Perform assertions or further actions with the located elements
    }
}

