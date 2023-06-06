package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class BrokenImagesTest extends BasePage {

    private WebDriver driver;

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
    public void testBrokenImages() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/broken-image");

        // Find all images on the page
        List<WebElement> images = driver.findElements(By.tagName("img"));

        // List to store the broken images
        List<String> brokenImages = new ArrayList<>();

        // Iterate through each image and check if it is broken
        for (WebElement image : images) {
            if (image.getAttribute("naturalWidth").equals("0")) {
                brokenImages.add(image.getAttribute("src"));
            }
        }

        // Assert that there are no broken images
        Assert.assertTrue(brokenImages.isEmpty(), "The following images are broken: " + brokenImages);
    }
}

