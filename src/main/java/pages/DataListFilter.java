package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataListFilter {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/data-list-filter-demo");
    }

    @Test
    public void testDataListFilter() {
        // Find the company name input element using locators
        WebElement companyNameInput = driver.findElement(By.id("company"));

        // Find the name input element using locators
        WebElement nameInput = driver.findElement(By.id("name"));

        // Find the title input element using locators
        WebElement titleInput = driver.findElement(By.id("title"));

        // Perform assertions or further actions with the located elements
    }
}

