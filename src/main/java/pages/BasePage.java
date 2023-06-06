package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BasePage {
    protected WebDriver driver;

    private String baseUrl = "http//www.lambdatest.com/selenium-playground/";

    public BasePage() {
            }
            public BasePage(WebDriver driver) {
                this.driver = driver;
            }

            @BeforeClass
            public void setUp(){
                System.setProperty("web-driver.chrome.driver", "C://Users//diana//Desktop/chromedriver_win32/chrome.exe");
                driver = new ChromeDriver();
                driver.get(baseUrl);
            }

            @AfterMethod
            public void tearDown(){

        driver.quit();
            }

        }
