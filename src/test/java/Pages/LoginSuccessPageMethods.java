package Pages;

import HelpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSuccessPageMethods extends BasePage {

    public LoginSuccessPageMethods(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "ico-login")
    private WebElement login;

    @FindBy(id = "Email")
    private WebElement emailLogin;

    @FindBy(id = "Password")
    private WebElement passwordLogin;
    @FindBy(css = ".fieldset>form>div>button")
    private WebElement loginButton;

    @FindBy(className = "ico-logout")
    private WebElement logout;



    public void performLogin (String emailLoginValue, String passwordLoginValue){
        elementMethods.clickElement(login);
        elementMethods.fillElement(emailLogin, emailLoginValue);
        elementMethods.fillElement(passwordLogin,passwordLoginValue);
        elementMethods.clickElement(loginButton);
    }

    public void validateLogoutIsAvailable(String expectedText) {
        elementMethods.validateElementText(logout, expectedText);
    }
}
