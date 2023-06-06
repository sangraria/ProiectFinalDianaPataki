package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

import java.util.List;

public class SelectDropdownListTest extends BasePage {

    private WebDriver driver;

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
    public void testSelectSingleDropdownList() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");

        // Select an option from the single-select dropdown list
        WebElement dropdown = driver.findElement(By.id("select-demo"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Tuesday");

        // Get the selected option
        WebElement selectedOption = select.getFirstSelectedOption();
        String selectedValue = selectedOption.getText();

        // Verify the selected option
        Assert.assertEquals(selectedValue, "Tuesday");
    }

    @Test
    public void testSelectMultipleDropdownList() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");

        // Select multiple options from the multi-select dropdown list
        WebElement dropdown = driver.findElement(By.id("multi-select"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Florida");
        select.selectByVisibleText("Ohio");
        select.selectByVisibleText("Texas");

        // Get all selected options
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        int numberOfSelectedOptions = selectedOptions.size();

        // Verify the number of selected options
        Assert.assertEquals(numberOfSelectedOptions, 3);
    }
}

