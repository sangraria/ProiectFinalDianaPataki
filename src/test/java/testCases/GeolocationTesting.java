package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

public class GeolocationTesting extends BasePage {

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
    public void testGeolocation() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/geolocation-testing");

        // Find the IP address input field
        WebElement ipAddressInput = driver.findElement(By.id("ip"));

        // Enter the provided IP address
        ipAddressInput.sendKeys("5.15.152.243");

        // Find and click the "Get Geolocation" button
        WebElement getGeolocationButton = driver.findElement(By.id("submit"));
        getGeolocationButton.click();

        // Find the geolocation information elements
        WebElement countryName = driver.findElement(By.id("country_name"));
        WebElement countryCode = driver.findElement(By.id("country_code"));
        WebElement latitude = driver.findElement(By.id("latitude"));
        WebElement longitude = driver.findElement(By.id("longitude"));

        // Verify the geolocation information
        Assert.assertEquals(countryName.getText(), "Romania");
        Assert.assertEquals(countryCode.getText(), "RO");
        Assert.assertEquals(latitude.getText(), "44.4914");
        Assert.assertEquals(longitude.getText(), "26.0602");
    }
}

