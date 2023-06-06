package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

public class HoverDemoTest extends BasePage {

    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setUp() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() {
        // Quit the WebDriver instance
        driver.quit();
    }

    @Test
    public void testHoverOnButton() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/hover-demo");

        // Find the button element
        WebElement button = driver.findElement(By.cssSelector(".btn"));

        // Perform mouse hover on the button
        actions.moveToElement(button).perform();

        // Verify that the button's background color changes
        String buttonColor = button.getCssValue("background-color");
        Assert.assertEquals(buttonColor, "rgba(255, 255, 0, 1)"); // Change this value as per your expected color

        // Perform mouse hover outside the button
        actions.moveByOffset(0, 0).perform();

        // Verify that the button's background color returns to the default
        buttonColor = button.getCssValue("background-color");
        Assert.assertEquals(buttonColor, "rgba(0, 123, 255, 1)"); // Change this value as per your default color
    }

    @Test
    public void testHoverOnImage() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/hover-demo");

        // Find the image element
        WebElement image = driver.findElement(By.cssSelector(".img-thumbnail"));

        // Perform mouse hover on the image
        actions.moveToElement(image).perform();

        // Verify that the image's opacity changes
        String imageOpacity = image.getCssValue("opacity");
        Assert.assertEquals(imageOpacity, "0.5"); // Change this value as per your expected opacity

        // Perform mouse hover outside the image
        actions.moveByOffset(0, 0).perform();

        // Verify that the image's opacity returns to the default
        imageOpacity = image.getCssValue("opacity");
        Assert.assertEquals(imageOpacity, "1.0"); // Change this value as per your default opacity
    }
}

