package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

public class ClickToTriggerARedirrect extends BasePage {

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
    public void testRedirection() {
        // Open the initial URL
        driver.get("https://www.lambdatest.com/selenium-playground/redirection");

        // Trigger the redirection
        driver.findElement(By.id("redirect")).click();


        // Get the current URL after redirection
        String redirectedUrl = driver.getCurrentUrl();

        // Verify the redirection
        Assert.assertEquals(redirectedUrl, "https://www.lambdatest.com/selenium-playground/");
        // Replace with your expected redirected URL
    }
}


