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

import java.util.Set;

public class WindowPopupModalTest extends BasePage {

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
    public void testWindowPopupModal() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");

        // Get the main window handle
        String mainWindowHandle = driver.getWindowHandle();

        // Click the "Follow On Twitter" button
        WebElement followOnTwitterButton = driver.findElement(By.id("followall"));
        followOnTwitterButton.click();

        // Switch to the new window
        switchToNewWindow(mainWindowHandle);

        // Verify the new window title
        String newWindowTitle = driver.getTitle();
        Assert.assertEquals(newWindowTitle, "LambdaTest (@LambdaTest) / Twitter");

        // Close the new window
        driver.close();

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);

        // Click the "Like Us On Facebook" button
        WebElement likeOnFacebookButton = driver.findElement(By.id("likeall"));
        likeOnFacebookButton.click();

        // Switch to the modal dialog
        switchToModalDialog();

        // Verify the modal dialog text
        WebElement modalDialogText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModal")));
        String modalText = modalDialogText.getText();
        Assert.assertEquals(modalText, "You Successfully Liked on Facebook.");

        // Close the modal dialog
        WebElement closeButton = driver.findElement(By.className("close"));
        closeButton.click();
    }

    private void switchToNewWindow(String mainWindowHandle) {
        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Find the new window handle
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    private void switchToModalDialog() {
        // Switch to the active element within the main window
        WebElement activeElement = driver.switchTo().activeElement();

        // Switch to the modal dialog frame
        driver.switchTo().frame(activeElement);
    }
}

