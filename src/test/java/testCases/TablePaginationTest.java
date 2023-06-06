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

public class TablePaginationTest extends BasePage {

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
    public void testTablePagination() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/table-pagination-demo");

        // Find the dropdown for selecting number of rows
        WebElement numberOfRowsDropdown = driver.findElement(By.name("example_length"));

        // Select the desired number of rows (e.g., 50)
        numberOfRowsDropdown.sendKeys("50");

        // Wait for the table to reload with the selected number of rows
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("example_info"), "Showing 1 to 50 of"));

        // Find the table and verify that it contains the selected number of rows
        WebElement table = driver.findElement(By.id("example"));
        int rowCount = table.findElements(By.xpath(".//tbody/tr")).size();
        Assert.assertEquals(rowCount, 50);
    }
}

