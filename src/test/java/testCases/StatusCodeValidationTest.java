package testCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

public class StatusCodeValidationTest extends BasePage {

    @Test
    public void testStatusCodeValidation() {
        String url = "https://www.lambdatest.com/selenium-playground/status-code";

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int statusCode = connection.getResponseCode();
            Assert.assertEquals(statusCode, 200, "Expected status code: 200");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

