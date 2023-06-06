package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HoverDemo {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/hover-demo");
    }

    @Test
    public void testHoverEffects() {
        // Find the button element using locators
        WebElement buttonElement = driver.findElement(By.id("button"));

        // Find the image element using locators
        WebElement imageElement = driver.findElement(By.id("image"));

        // Perform assertions or further actions with the located elements
    }
}

