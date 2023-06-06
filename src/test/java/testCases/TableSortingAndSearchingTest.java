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

public class TableSortingAndSearchingTest extends BasePage {

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
    public void testTableSortAndSearch() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/table-sort-search-demo");

        // Sort the table by the "Name" column
        WebElement nameColumnHeader = driver.findElement(By.xpath("//th[contains(text(), 'Name')]"));
        nameColumnHeader.click();

        // Wait for the table sorting to finish
        WebElement tableBody = driver.findElement(By.xpath("//tbody"));
        wait.until(ExpectedConditions.stalenessOf(tableBody));

        // Verify that the table is sorted in ascending order by the "Name" column
        WebElement firstRowName = driver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
        WebElement lastRowName = driver.findElement(By.xpath("//tbody/tr[last()]/td[1]"));
        Assert.assertTrue(firstRowName.getText().compareTo(lastRowName.getText()) <= 0);

        // Search for a specific value in the "Position" column
        WebElement searchInput = driver.findElement(By.id("search"));
        searchInput.sendKeys("Developer");

        // Wait for the search results to appear
        wait.until(ExpectedConditions.textToBePresentInElement(tableBody, "Developer"));

        // Verify that the search results match the searched value in the "Position" column
        WebElement searchedRows = driver.findElement(By.xpath("//td[text()='Developer']"));
        Assert.assertTrue(searchedRows.isDisplayed());
    }
}

