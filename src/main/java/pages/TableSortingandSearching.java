package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableSortingandSearching {

    public static void main(String[] args) {
        // Set up the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the webpage
        driver.get("https://www.lambdatest.com/selenium-playground/table-sort-search-demo");

        // Use various locators to locate elements
        WebElement searchInput = driver.findElement(By.id("task-table-filter"));
        WebElement firstRowName = driver.findElement(By.xpath("//table[@id='task-table']/tbody/tr[1]/td[2]"));
        WebElement firstRowStatus = driver.findElement(By.xpath("//table[@id='task-table']/tbody/tr[1]/td[4]"));

        // Perform actions on the elements
        searchInput.sendKeys("Wireframes");
        String name = firstRowName.getText();
        String status = firstRowStatus.getText();

        System.out.println("Name: " + name);
        System.out.println("Status: " + status);

        // Close the browser
        driver.quit();
    }
}

