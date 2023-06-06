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

public class DateRangePickerTest extends BasePage {

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
    public void testDateRangePicker() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/jquery-date-picker-demo");

        // Click on the "From" input field
        WebElement fromDateInput = driver.findElement(By.id("from"));
        fromDateInput.click();

        // Select the "From" date
        WebElement fromDate = driver.findElement(By.cssSelector("td[data-handler='selectDay']:not(.ui-state-disabled) a"));
        fromDate.click();

        // Click on the "To" input field
        WebElement toDateInput = driver.findElement(By.id("to"));
        toDateInput.click();

        // Select the "To" date
        WebElement toDate = driver.findElement(By.cssSelector("td[data-handler='selectDay']:not(.ui-state-disabled) a"));
        toDate.click();

        // Get the selected date range
        WebElement selectedRange = driver.findElement(By.id("output"));

        // Verify the selected date range
        Assert.assertTrue(selectedRange.getText().contains("Selected Date Range"));

        // Wait for the date picker to close
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-datepicker")));

        // Click on the "Submit" button
        WebElement submitButton = driver.findElement(By.id("apply"));
        submitButton.click();

        // Get the result message
        WebElement resultMessage = driver.findElement(By.id("result"));

        // Verify the result message
        Assert.assertEquals(resultMessage.getText(), "Date Range Submitted");
    }
}
