package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDropdownList {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the webpage
        driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");

        // Find the dropdown element by ID
        WebElement dropdown = driver.findElement(By.id("select-option"));

        // Select an option by visible text
        dropdown.sendKeys("Friday");

        // Close the browser
        driver.quit();
    }
}

