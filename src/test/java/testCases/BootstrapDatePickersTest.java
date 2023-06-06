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

public class BootstrapDatePickersTest extends BasePage {

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
    public void testSingleDateSelection() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-date-picker-demo");

        // Click on the input field to open the date picker
        WebElement datePickerInput = driver.findElement(By.id("datepicker1"));
        datePickerInput.click();

        // Select a date from the date picker
        WebElement date = driver.findElement(By.xpath("//td[@class='day' and text()='25']"));
        date.click();

        // Get the selected date
        String selectedDate = datePickerInput.getAttribute("value");

        // Verify the selected date
        Assert.assertEquals(selectedDate, "06/25/2023");
    }

    @Test
    public void testDateRangeSelection() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-date-picker-demo");

        // Click on the "From" input field to open the date picker
        WebElement fromDateInput = driver.findElement(By.id("datepicker2"));
        fromDateInput.click();

        // Select a "From" date
        WebElement fromDate = driver.findElement(By.xpath("//td[@class='day' and text()='10']"));
        fromDate.click();

        // Click on the "To" input field to open the date picker
        WebElement toDateInput = driver.findElement(By.id("datepicker3"));
        toDateInput.click();

        // Select a "To" date
        WebElement toDate = driver.findElement(By.xpath("//td[@class='day' and text()='15']"));
        toDate.click();

        // Get the selected date range
        String selectedFromDate = fromDateInput.getAttribute("value");
        String selectedToDate = toDateInput.getAttribute("value");

        // Verify the selected date range
        Assert.assertEquals(selectedFromDate, "06/10/2023");
        Assert.assertEquals(selectedToDate, "06/15/2023");
    }
}

