package Tests;

import HelpMethods.ElementMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginSuccessfulTest extends SharedData {
    @Test
    public void MetodaTest() {

        ElementMethods elementMethods = new ElementMethods(getDriver());

        WebElement login = getDriver().findElement(By.className("ico-login"));
        elementMethods.clickElement(login);

        WebElement emailLogin = getDriver().findElement(By.id("Email"));
        String emailLoginValue = "dutescu_lilly@yahoo.com";
        elementMethods.fillElement(emailLogin, emailLoginValue);

        WebElement passwordLogin = getDriver().findElement(By.id("Password"));
        String passwordLoginValue = "TestPassword24!";
        elementMethods.fillElement(passwordLogin, passwordLoginValue);

        WebElement loginButton = getDriver().findElement(By.cssSelector(".fieldset>form>div>button"));
        elementMethods.clickElement(loginButton);

    }
}
