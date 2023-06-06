package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BootstrapDualListBox {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-dual-list-box-demo");
    }

    @Test
    public void testBootstrapDualListBox() {
        // Find the select elements and buttons using locators
        WebElement leftSelect = driver.findElement(By.id("bootstrap-duallistbox-nonselected-list_duallistbox_demo2[]"));
        WebElement rightSelect = driver.findElement(By.id("bootstrap-duallistbox-selected-list_duallistbox_demo2[]"));
        WebElement addButton = driver.findElement(By.className("move-right"));
        WebElement addAllButton = driver.findElement(By.className("move-right-all"));
        WebElement removeButton = driver.findElement(By.className("move-left"));
        WebElement removeAllButton = driver.findElement(By.className("move-left-all"));

        // Perform assertions or further actions with the located elements
    }
}

