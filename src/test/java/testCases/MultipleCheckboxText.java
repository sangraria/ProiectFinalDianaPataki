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

public class MultipleCheckboxText extends BasePage {

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
    public void testMultipleCheckboxes() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");

        // Find the checkbox elements
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@value='option1']"));
        WebElement checkbox3 = driver.findElement(By.xpath("//input[@value='option2']"));
        WebElement checkbox4 = driver.findElement(By.xpath("//input[@value='option3']"));
        WebElement checkbox5 = driver.findElement(By.xpath("//input[@value='option4']"));

        // Verify initial checkbox state
        Assert.assertFalse(checkbox1.isSelected());
        Assert.assertFalse(checkbox2.isSelected());
        Assert.assertFalse(checkbox3.isSelected());
        Assert.assertFalse(checkbox4.isSelected());
        Assert.assertFalse(checkbox5.isSelected());

        // Select the checkboxes
        checkbox1.click();
        checkbox2.click();
        checkbox3.click();
        checkbox4.click();
        checkbox5.click();

        // Verify checkbox state after selection
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());
        Assert.assertTrue(checkbox3.isSelected());
        Assert.assertTrue(checkbox4.isSelected());
        Assert.assertTrue(checkbox5.isSelected());

        // Deselect the checkboxes
        checkbox1.click();
        checkbox2.click();
        checkbox3.click();
        checkbox4.click();
        checkbox5.click();

        // Verify checkbox state after deselection
        Assert.assertFalse(checkbox1.isSelected());
        Assert.assertFalse(checkbox2.isSelected());
        Assert.assertFalse(checkbox3.isSelected());
        Assert.assertFalse(checkbox4.isSelected());
        Assert.assertFalse(checkbox5.isSelected());
    }
}

