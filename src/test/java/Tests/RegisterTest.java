package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest {
    public WebDriver driver;
    ChromeOptions chromeOptions = new ChromeOptions();

    @Test
    public void MetodaTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        chromeOptions.addArguments("window-size=1200,1080");
        chromeOptions.addArguments("--no-sandbox");

        WebElement register = driver.findElement(By.className("ico-register"));
        register.click();

        WebElement selectGender = driver.findElement(By.id("gender-female"));
        selectGender.click();

        WebElement firstName = driver.findElement(By.id("FirstName"));
        String firstNameValue = "Liliana";
        firstName.sendKeys(firstNameValue);

        WebElement lastName = driver.findElement(By.id("LastName"));
        String lastNameValue = "Dutescu";
        lastName.sendKeys(lastNameValue);

        WebElement dayOfBirth = driver.findElement(By.name("DateOfBirthDay"));
        Select dayDropdown = new Select(dayOfBirth);
        dayDropdown.selectByValue("24");

        WebElement monthOfBirth = driver.findElement(By.name("DateOfBirthMonth"));
        Select monthDropdown = new Select(monthOfBirth);
        monthDropdown.selectByValue("11");

        WebElement yearOfBirth = driver.findElement(By.name("DateOfBirthYear"));
        Select yearDropdown = new Select(yearOfBirth);
        yearDropdown.selectByValue("1988");

        WebElement email = driver.findElement(By.id("Email"));
        String emailValue = "dutescu_lilly@yahoo.com";
        email.sendKeys(emailValue);

        WebElement company = driver.findElement(By.id("Company"));
        String companyValue = "IT School";
        company.sendKeys(companyValue);

        WebElement selectNewsletter = driver.findElement(By.id("Newsletter"));
        selectNewsletter.click();

        WebElement password = driver.findElement(By.id("Password"));
        String passwordValue = "TestPassword24!";
        password.sendKeys(passwordValue);

        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        String confirmPasswordValue = "TestPassword24!";
        confirmPassword.sendKeys(confirmPasswordValue);

        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();

        WebElement error = driver.findElement(By.cssSelector(".message-error>ul>li"));
        String expectedError = "The specified email already exists";
        String actualError = error.getText();
        Assert.assertEquals(actualError, expectedError);

    }

}
