package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BootstrapAlertMessages {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-alert-messages-demo");
    }

    @Test
    public void testBootstrapAlertMessages() {
        // Find the alert elements using locators
        WebElement successAlert = driver.findElement(By.className("Autocloseable success message"));
        WebElement infoAlert = driver.findElement(By.className("Normal success message"));
        WebElement warningAlert = driver.findElement(By.className("Autocloseable info message"));
        WebElement dangerAlert = driver.findElement(By.className("Normal info message"));

        // Perform assertions or further actions with the located elements
    }
}
