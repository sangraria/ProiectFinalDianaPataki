package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RandomUserTest {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/dynamic-data-loading-demo");
    }

    @Test
    public void testGetRandomUser() {
        // Find the "Get Random User" button element using locators
        WebElement getRandomUserButton = driver.findElement(By.cssSelector("#random_user"));

        // Perform actions with the located element, such as clicking the button
        getRandomUserButton.click();

        // Perform assertions or further actions after clicking the button
    }
}
