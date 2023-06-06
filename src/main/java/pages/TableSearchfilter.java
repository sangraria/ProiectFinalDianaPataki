package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableSearchfilter {

    public static void main(String[] args) {
        // Set up the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diana\\Desktop\\chromedriver_win32\\chrome.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the webpage
        driver.get("https://www.lambdatest.com/selenium-playground/table-search-filter-demo");

        // Use various locators to locate elements
        WebElement searchInput = driver.findElement(By.id("task-table-filter"));
        WebElement firstRowName = driver.findElement(By.xpath("//table[@id='task-table']/tbody/tr[1]/td[1]"));
        WebElement firstRowAge = driver.findElement(By.xpath("//table[@id='task-table']/tbody/tr[1]/td[2]"));
        WebElement firstRowEmail = driver.findElement(By.xpath("//table[@id='task-table']/tbody/tr[1]/td[3]"));

        // Perform actions on the elements
        searchInput.sendKeys("Tiger");
        String name = firstRowName.getText();
        String age = firstRowAge.getText();
        String email = firstRowEmail.getText();

        System.out.println("Name: " + name);
        System.out.println("Position: " + age);
        System.out.println("Office: " + email);

        // Close the browser
        driver.quit();
    }
}

