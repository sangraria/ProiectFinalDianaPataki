package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

public class BootstrapDualListBoxTest extends BasePage {

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
    public void testDualListBoxSelection() {
        // Open the URL
        driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-dual-list-box-demo");

        // Get the select elements for both lists
        Select availableList = new Select(driver.findElement(By.xpath("//select[@class='form-control dual-listbox-available']")));
        Select selectedList = new Select(driver.findElement(By.xpath("//select[@class='form-control dual-listbox-selected']")));

        // Select items from the available list
        availableList.selectByVisibleText("Option 2");
        availableList.selectByVisibleText("Option 4");
        availableList.selectByVisibleText("Option 6");

        // Move selected items to the selected list
        WebElement addButton = driver.findElement(By.xpath("//button[@class='btn btn-default dual-listbox-add btn-sm']"));
        addButton.click();

        // Get all selected items from the selected list
        java.util.List<WebElement> selectedItems = selectedList.getOptions();

        // Verify the selected items in the selected list
        Assert.assertEquals(selectedItems.size(), 3);
        Assert.assertEquals(selectedItems.get(0).getText(), "Option 2");
        Assert.assertEquals(selectedItems.get(1).getText(), "Option 4");
        Assert.assertEquals(selectedItems.get(2).getText(), "Option 6");
    }
}
