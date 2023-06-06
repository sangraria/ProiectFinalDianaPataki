package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButtonTest {

    private WebDriver driver;

    @BeforeTest
    public void setUpBeforeTest() {
        // Set up WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
    }

    @Test
    public void testRadioButtonDemo() {
        // Find the radio button elements

        // Example: Select the radio button with value "Male"
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='Male']"));
        maleRadioButton.click();

        // Example: Select the radio button with value "Female"
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='Female']"));
        femaleRadioButton.click();

        WebElement age0To5Field = driver.findElement(By.xpath("//input[@value='0 - 5']"));
        WebElement age5To15Field = driver.findElement(By.xpath("//input[@value='5 - 15']"));
        WebElement age15To50Field = driver.findElement(By.xpath("//input[@value='15 - 50']"));


        // Perform assertions or further actions based on the radio button selections
    }
}

