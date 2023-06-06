package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowPopupModal {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Set up the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");

        // Create a new instance of ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void windowPopupTest() {
        // Navigate to the webpage
        driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");

        // Use various locators to locate elements
        WebElement twitterButton = driver.findElement(By.xpath("//button[text()='Follow On Twitter']"));
        WebElement facebookButton = driver.findElement(By.xpath("//button[text()='Like On Facebook']"));

        // Perform actions on the elements
        twitterButton.click();
        facebookButton.click();

        // Perform actions in the pop-up window (if applicable)

        // Close the pop-up window (if applicable)

        // Switch back to the main window (if applicable)

        // Perform further actions on the main window (if applicable)
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

