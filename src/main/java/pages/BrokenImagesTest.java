package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenImagesTest {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/broken-image");
    }

    @Test
    public void testBrokenImage() {
        // Find the image elements using locators
        WebElement image1 = driver.findElement(By.xpath("//img[@src='https://www.lambdatest.com/404/image1.jpg']"));
        WebElement image2 = driver.findElement(By.xpath("//img[@src='https://www.lambdatest.com/404/image2.jpg']"));
        WebElement image3 = driver.findElement(By.xpath("//img[@src='https://www.lambdatest.com/404/image3.jpg']"));

        // Perform assertions or further actions with the located elements
    }
}
