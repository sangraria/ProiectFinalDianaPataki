package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragandDrop {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
    }

    @Test
    public void testDragAndDrop() {
        // Find the source element to drag using locators
        WebElement sourceElement = driver.findElement(By.id("drag1"));

        // Find the target element to drop using locators
        WebElement targetElement = driver.findElement(By.id("div2"));

        // Perform the drag and drop action
        // You can use Actions class to perform drag and drop:
        // Actions  = new Actions(driver);
        // actions.dragAndDrop(sourceElement, targetElement).build().perform();

        // Alternatively, you can use JavaScript executor for drag and drop:
        // JavaScriptExecutor js = (JavaScriptExecutor) driver;
        // js.executeScript("function simulateDragDrop(sourceNode, destinationNode) { /* implementation omitted */ }");
        // js.executeScript("simulateDragDrop(arguments[0], arguments[1])", sourceElement, targetElement);

        // Perform assertions or further actions after the drag and drop
    }
}
