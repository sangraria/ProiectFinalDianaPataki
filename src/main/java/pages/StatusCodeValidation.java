package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StatusCodeValidation {

    public static void main(String[] args) {
        // Set up the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the webpage
        driver.get("https://www.lambdatest.com/selenium-playground/status-code");

        // Use various locators to locate elements
        WebElement statusCodeInput = driver.findElement(By.id("status_code"));
        WebElement sendRequestButton = driver.findElement(By.id("send_request"));
        WebElement responseOutput = driver.findElement(By.id("output"));

        // Perform actions on the elements
        statusCodeInput.sendKeys("200");
        sendRequestButton.click();

        String response = responseOutput.getText();
        System.out.println("Response: " + response);

        // Close the browser
        driver.quit();
    }
}
