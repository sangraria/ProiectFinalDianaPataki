package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablePagination {

    public static void main(String[] args) {
        // Set up the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the webpage
        driver.get("https://www.lambdatest.com/selenium-playground/table-pagination-demo");

        // Use various locators to locate elements
        WebElement nextButton = driver.findElement(By.xpath("//a[@class='next_link']"));
        WebElement previousButton = driver.findElement(By.xpath("//a[@class='prev_link']"));
        WebElement currentPage = driver.findElement(By.xpath("//span[@class='current']"));

        // Perform actions on the elements
        String current = currentPage.getText();
        System.out.println("Current page: " + current);

        nextButton.click();
        current = currentPage.getText();
        System.out.println("Current page: " + current);

        previousButton.click();
        current = currentPage.getText();
        System.out.println("Current page: " + current);

        // Close the browser
        driver.quit();
    }
}

