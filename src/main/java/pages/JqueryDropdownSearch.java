package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JqueryDropdownSearch {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo");
    }

    @Test
    public void testDropdownSearch() {
        // Find the dropdown input element
        WebElement dropdownInput = driver.findElement(By.className("dropdown-search__input"));

        // Find the dropdown options container element
        WebElement dropdownOptionsContainer = driver.findElement(By.className("dropdown-search__menu"));

        // Find a specific option in the dropdown
        WebElement option = dropdownOptionsContainer.findElement(By.xpath("//div[contains(text(), 'Option 1')]"));

        // Perform actions with the dropdown input and options

        // Example: Enter text into the dropdown input
        dropdownInput.sendKeys("Search Text");

        // Example: Click on the dropdown input to show the options
        dropdownInput.click();

        // Example: Click on a specific option
        option.click();

        // Example: Get the text of a selected option
        String selectedOptionText = dropdownInput.getAttribute("value");

        // Perform assertions or further actions with the selected option

        // Wait for the dropdown options to load
        // Example: You can use explicit or implicit wait to wait for the options to be visible
    }
}

