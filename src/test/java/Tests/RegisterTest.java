package Tests;

import HelpMethods.ElementMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RegisterTest extends SharedData {

    @Test
    public void MetodaTest(){

        ElementMethods elementMethods = new ElementMethods(getDriver());

        WebElement register = getDriver().findElement(By.className("ico-register"));
        elementMethods.clickElement(register);

        WebElement selectGender = getDriver().findElement(By.id("gender-female"));
        elementMethods.clickElement(selectGender);

        WebElement firstName = getDriver().findElement(By.id("FirstName"));
        String firstNameValue = "Liliana";
        elementMethods.fillElement(firstName, firstNameValue);

        WebElement lastName = getDriver().findElement(By.id("LastName"));
        String lastNameValue = "Dutescu";
        elementMethods.fillElement(lastName, lastNameValue);

        WebElement dayOfBirth = getDriver().findElement(By.name("DateOfBirthDay"));
        elementMethods.selectElementByText(dayOfBirth, "24");

        WebElement monthOfBirth = getDriver().findElement(By.name("DateOfBirthMonth"));
        elementMethods.selectElementByText(monthOfBirth, "11");

        WebElement yearOfBirth = getDriver().findElement(By.name("DateOfBirthYear"));
        elementMethods.selectElementByText(yearOfBirth, "1988");

        WebElement email = getDriver().findElement(By.id("Email"));
        String emailValue = "dutescu_lilly@yahoo.com";
        elementMethods.fillElement(email, emailValue);

        WebElement company = getDriver().findElement(By.id("Company"));
        String companyValue = "IT School";
        elementMethods.fillElement(company, companyValue);

        WebElement selectNewsletter = getDriver().findElement(By.id("Newsletter"));
        elementMethods.clickElement(selectNewsletter);

        WebElement password = getDriver().findElement(By.id("Password"));
        String passwordValue = "TestPassword24!";
        elementMethods.fillElement(password, passwordValue);

        WebElement confirmPassword = getDriver().findElement(By.id("ConfirmPassword"));
        String confirmPasswordValue = "TestPassword24!";
        elementMethods.fillElement(confirmPassword, confirmPasswordValue);

        WebElement registerButton = getDriver().findElement(By.id("register-button"));
        elementMethods.clickElement(registerButton);

        WebElement error = getDriver().findElement(By.cssSelector(".message-error>ul>li"));
        String expectedError = "The specified email already exists";
        elementMethods.validateElementText(error, expectedError);

    }

}
