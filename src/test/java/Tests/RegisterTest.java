package Tests;

import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends SharedData {

    @Test
    public void MetodaTest(){


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
