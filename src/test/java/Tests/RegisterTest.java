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


        WebElement register = getDriver().findElement(By.className("ico-register"));
        register.click();

        WebElement selectGender = getDriver().findElement(By.id("gender-female"));
        selectGender.click();

        WebElement firstName = getDriver().findElement(By.id("FirstName"));
        String firstNameValue = "Liliana";
        firstName.sendKeys(firstNameValue);

        WebElement lastName = getDriver().findElement(By.id("LastName"));
        String lastNameValue = "Dutescu";
        lastName.sendKeys(lastNameValue);

        WebElement dayOfBirth = getDriver().findElement(By.name("DateOfBirthDay"));
        Select dayDropdown = new Select(dayOfBirth);
        dayDropdown.selectByValue("24");

        WebElement monthOfBirth = getDriver().findElement(By.name("DateOfBirthMonth"));
        Select monthDropdown = new Select(monthOfBirth);
        monthDropdown.selectByValue("11");

        WebElement yearOfBirth = getDriver().findElement(By.name("DateOfBirthYear"));
        Select yearDropdown = new Select(yearOfBirth);
        yearDropdown.selectByValue("1988");

        WebElement email = getDriver().findElement(By.id("Email"));
        String emailValue = "dutescu_lilly@yahoo.com";
        email.sendKeys(emailValue);

        WebElement company = getDriver().findElement(By.id("Company"));
        String companyValue = "IT School";
        company.sendKeys(companyValue);

        WebElement selectNewsletter = getDriver().findElement(By.id("Newsletter"));
        selectNewsletter.click();

        WebElement password = getDriver().findElement(By.id("Password"));
        String passwordValue = "TestPassword24!";
        password.sendKeys(passwordValue);

        WebElement confirmPassword = getDriver().findElement(By.id("ConfirmPassword"));
        String confirmPasswordValue = "TestPassword24!";
        confirmPassword.sendKeys(confirmPasswordValue);

        WebElement registerButton = getDriver().findElement(By.id("register-button"));
        registerButton.click();

        WebElement error = getDriver().findElement(By.cssSelector(".message-error>ul>li"));
        String expectedError = "The specified email already exists";
        String actualError = error.getText();
        Assert.assertEquals(actualError, expectedError);

    }

}
