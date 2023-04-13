package Tests;

import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFailedTest extends SharedData {

    @Test
    public void MetodaTest() {

        WebElement login = getDriver().findElement(By.className("ico-login"));
        login.click();

        WebElement emailLogin = getDriver().findElement(By.id("Email"));
        String emailLoginValue = "dutescu_lilly@yahoo.com";
        emailLogin.sendKeys(emailLoginValue);

        WebElement passwordLogin = getDriver().findElement(By.id("Password"));
        String passwordLoginValue = "TestPassword24!WRONG";
        passwordLogin.sendKeys(passwordLoginValue);

        WebElement loginButton = getDriver().findElement(By.cssSelector(".fieldset>form>div>button"));
        loginButton.click();

        WebElement loginFailedMessage = getDriver().findElement(By.className("message-error"));
        String expectedLoginFailedMessage = "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect";
        String actualLoginFailedMessage = loginFailedMessage.getText();
        Assert.assertEquals(actualLoginFailedMessage, expectedLoginFailedMessage);

    }
}

