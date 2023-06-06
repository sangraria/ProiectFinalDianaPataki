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

public class RadioButtonTest extends BasePage {

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
    public void testGetSelectedValue() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");

        // Find the radio buttons
        WebElement maleRadio = driver.findElement(By.xpath("//input[@value='male']"));
        WebElement femaleRadio = driver.findElement(By.xpath("//input[@value='female']"));

        // Verify initial radio button state
        Assert.assertFalse(maleRadio.isSelected());
        Assert.assertFalse(femaleRadio.isSelected());

        // Select the "Male" radio button
        maleRadio.click();

        // Click the "Get Checked Value" button
        driver.findElement(By.id("buttoncheck")).click();

        // Get the selected value
        String selectedValue = driver.switchTo().alert().getText();

        // Verify the selected value
        Assert.assertEquals(selectedValue, "Radio button 'Male' is checked");

        // Accept the alert
        driver.switchTo().alert().accept();

        // Select the "Female" radio button
        femaleRadio.click();

        // Click the "Get Checked Value" button
        driver.findElement(By.id("buttoncheck")).click();

        // Get the selected value
        selectedValue = driver.switchTo().alert().getText();

        // Verify the selected value
        Assert.assertEquals(selectedValue, "Radio button 'Female' is checked");

        // Accept the alert
        driver.switchTo().alert().accept();
    }
}

