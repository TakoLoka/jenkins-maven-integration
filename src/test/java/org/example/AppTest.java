package org.example;

import Pages.HeaderPage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.hamcrest.Matchers.equalTo;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void firstTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.qaenglishcentral.com");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickSignInButton();
        headerPage.enterEmail("tarik.demirtas+280324@englishcentral.com");
        headerPage.enterPassword("12345");
        driver.manage().window().minimize();
        headerPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("myclass"));
        driver.quit();
    }

    @Test
    public void secondTest(){
        Response response = RestAssured.when().get("https://api.coindesk.com/v1/bpi/currentPrice.json");
        response.then().statusCode(200);
        response.then().body("chartName", equalTo("Bitcoin"));
    }
}
