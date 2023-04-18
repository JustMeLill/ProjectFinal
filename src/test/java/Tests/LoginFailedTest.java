package Tests;

import HelpMethods.ElementMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginFailedTest extends SharedData {

    @Test
    public void MetodaTest() {

        ElementMethods elementMethods = new ElementMethods(getDriver());

        WebElement login = getDriver().findElement(By.className("ico-login"));
        elementMethods.clickElement(login);

        WebElement emailLogin = getDriver().findElement(By.id("Email"));
        String emailLoginValue = "dutescu_lilly@yahoo.com";
        elementMethods.fillElement(emailLogin, emailLoginValue);

        WebElement passwordLogin = getDriver().findElement(By.id("Password"));
        String passwordLoginValue = "TestPassword24!WRONG";
        elementMethods.fillElement(passwordLogin,passwordLoginValue);

        WebElement loginButton = getDriver().findElement(By.cssSelector(".fieldset>form>div>button"));
        elementMethods.clickElement(loginButton);

        WebElement loginFailedMessage = getDriver().findElement(By.className("message-error"));
        String expectedLoginFailedMessage = "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect";
        elementMethods.validateElementText(loginFailedMessage, expectedLoginFailedMessage);

    }
}

