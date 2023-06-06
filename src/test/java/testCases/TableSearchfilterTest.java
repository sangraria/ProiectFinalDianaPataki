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

public class TableSearchfilterTest extends BasePage {

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
    public void testTableSearchFilter() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/table-search-filter-demo");

        // Enter the search keyword
        WebElement searchInput = driver.findElement(By.id("search-box"));
        searchInput.sendKeys("Developer");

        // Wait for the table to filter based on the search keyword
        WebElement tableBody = driver.findElement(By.xpath("//tbody"));
        wait.until(ExpectedConditions.textToBePresentInElement(tableBody, "Developer"));

        // Verify that the filtered table rows contain the search keyword
        WebElement searchedRows = driver.findElement(By.xpath("//td[contains(text(), 'Developer')]"));
        Assert.assertTrue(searchedRows.isDisplayed());
    }
}

