package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleCheckboxText {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
    }

    @Test
    public void testMultipleCheckboxDemo() {
        // Find the checkbox elements

        // Example: Select the checkbox with value "Option 1"
        WebElement option1Checkbox = driver.findElement(By.cssSelector("input[value='Option 1']"));
        option1Checkbox.click();

        // Example: Select the checkbox with value "Option 2"
        WebElement option2Checkbox = driver.findElement(By.cssSelector("input[value='Option 2']"));
        option2Checkbox.click();

        // Example: Select the checkbox with value "Option 3"
        WebElement option3Checkbox = driver.findElement(By.cssSelector("input[value='Option 3']"));
        option3Checkbox.click();

        // Perform assertions or further actions based on the checkbox selections
    }
}

