package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

public class DynamicDataLoadingTest extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

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
    public void testDynamicDataLoading() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/dynamic-data-loading-demo");

        // Find and click the "Get New User" button
        WebElement getNewUserButton = driver.findElement(By.id("save"));
        getNewUserButton.click();

        // Wait for the loading spinner to disappear
        WebElement loadingSpinner = driver.findElement(By.id("loading"));
        wait.until(ExpectedConditions.invisibilityOf(loadingSpinner));

        // Get the dynamically loaded user data
        WebElement userData = driver.findElement(By.id("loadedUser"));

        // Verify that the user data is not empty
        Assert.assertFalse(userData.getText().isEmpty());

        // Extract and verify random user information
        String name = driver.findElement(By.id("name")).getText();
        String email = driver.findElement(By.id("email")).getText();
        String username = driver.findElement(By.id("username")).getText();

        Assert.assertFalse(name.isEmpty());
        Assert.assertFalse(email.isEmpty());
        Assert.assertFalse(username.isEmpty());
    }
}

