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

public class DataListFilterTest extends BasePage {

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
    public void testDataListFilterByCompanyName() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/data-list-filter-demo");

        // Enter the company name to filter
        WebElement companyFilterInput = driver.findElement(By.id("company-filter"));
        companyFilterInput.sendKeys("Oakes Ltd");

        // Wait for the data list to be filtered
        WebElement dataList = driver.findElement(By.id("data-list"));
        wait.until(ExpectedConditions.textToBePresentInElement(dataList, "Oakes Ltd"));

        // Verify the presence of the specific name and title
        Assert.assertTrue(dataList.getText().contains("Jonathan Oakes"));
        Assert.assertTrue(dataList.getText().contains("Founder"));
    }
}

