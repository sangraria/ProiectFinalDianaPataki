package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavascriptAlertBoxTest {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
    }

    @Test
    public void testAlertBox() {
        // Find the "Click me!" button using locators
        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click me!']"));

        // Perform click action on the button
        clickMeButton.click();

        // Switch to the alert dialog
        driver.switchTo().alert();

        // Perform assertions or further actions with the alert dialog

        // Accept the alert
        driver.switchTo().alert().accept();
    }
}

