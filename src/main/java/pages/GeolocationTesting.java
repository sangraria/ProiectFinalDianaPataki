package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GeolocationTesting {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/geolocation-testing");
    }

    @Test
    public void testGeolocation() {
        // Find the "Get Geolocation" button element using locators
        WebElement getGeolocationButton = driver.findElement(By.id("get-location"));

        // Perform assertions or further actions with the located element
    }
}

