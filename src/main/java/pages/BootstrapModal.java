package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BootstrapModal {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-modal-demo");
    }

    @Test
    public void testBootstrapModal() {
        // Find the modal elements using locators
        WebElement launchButton = driver.findElement(By.id("myModal"));
        WebElement modalTitle = driver.findElement(By.xpath("//div[@class='modal-content']//h4[@class='modal-title']"));
        WebElement closeButton = driver.findElement(By.xpath("//div[@class='modal-content']//button[@class='close']"));
        WebElement modalBody = driver.findElement(By.xpath("//div[@class='modal-body']"));
        WebElement saveChangesButton = driver.findElement(By.xpath("//div[@class='modal-footer']//button[@class='btn btn-primary']"));

        // Perform assertions or further actions with the located elements
    }
}

