package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenu {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/context-menu");
    }

    @Test
    public void testContextMenu() {
        // Find the context menu element using locators
        WebElement contextMenu = driver.findElement(By.id("after element"));

        // Perform assertions or further actions with the located element
    }
}

