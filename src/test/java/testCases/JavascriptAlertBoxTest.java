package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

public class JavascriptAlertBoxTest extends BasePage {

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
    public void testJavascriptAlertBox() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");

        // Click the "Click the button to display an alert box" button
        WebElement alertButton = driver.findElement(By.xpath("//button[text()='Click the button to display an alert box']"));
        alertButton.click();

        // Switch to the alert box
        Alert alert = driver.switchTo().alert();

        // Get the text of the alert box
        String alertText = alert.getText();

        // Verify the alert box text
        Assert.assertEquals(alertText, "I am an alert box!");

        // Accept the alert (click OK)
        alert.accept();
    }
}

