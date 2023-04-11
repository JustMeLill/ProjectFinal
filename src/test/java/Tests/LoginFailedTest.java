package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginFailedTest {

    public WebDriver driver;
    ChromeOptions chromeOptions = new ChromeOptions();

    @Test
    public void MetodaTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        chromeOptions.addArguments("window-size=1200,1080");
        chromeOptions.addArguments("--no-sandbox");

        WebElement login = driver.findElement(By.className("ico-login"));
        login.click();

        WebElement emailLogin = driver.findElement(By.id("Email"));
        String emailLoginValue = "dutescu_lilly@yahoo.com";
        emailLogin.sendKeys(emailLoginValue);

        WebElement passwordLogin = driver.findElement(By.id("Password"));
        String passwordLoginValue = "TestPassword24!WRONG";
        passwordLogin.sendKeys(passwordLoginValue);

        WebElement loginButton = driver.findElement(By.cssSelector(".fieldset>form>div>button"));
        loginButton.click();

        WebElement loginFailedMessage = driver.findElement(By.className("message-error"));
        String expectedLoginFailedMessage = "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect";
        String actualLoginFailedMessage = loginFailedMessage.getText();
        Assert.assertEquals(actualLoginFailedMessage, expectedLoginFailedMessage);

    }
}

