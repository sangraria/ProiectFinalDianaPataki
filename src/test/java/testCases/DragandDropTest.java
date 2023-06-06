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

public class DragandDropTest extends BasePage {

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
    public void testDragAndDrop() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");

        // Find the source and target elements
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));

        // Perform the drag and drop operation
        actions.dragAndDrop(sourceElement, targetElement).build().perform();

        // Verify the text after the drag and drop
        WebElement droppedText = driver.findElement(By.id("droppableText"));
        Assert.assertEquals(droppedText.getText(), "Dropped!");
    }
}
