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

public class JqueryDropdownSearchTest extends BasePage {

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
    public void testJqueryDropdownSearch() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo");

        // Click the dropdown button
        WebElement dropdownButton = driver.findElement(By.xpath("//div[@id='jqDropdown']//button"));
        dropdownButton.click();

        // Enter the search text
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='jqDropdown']//input")));
        searchInput.sendKeys("C++");

        // Select the option
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='jqDropdown']//ul//li[text()='C++']")));
        option.click();

        // Get the selected value
        WebElement selectedValue = driver.findElement(By.xpath("//div[@id='jqDropdown']//button//span"));
        String selectedOption = selectedValue.getText();

        // Verify the selected option
        Assert.assertEquals(selectedOption, "C++");
    }
}
