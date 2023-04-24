package PagesMethods;

import HelpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageMethods {

    private WebDriver driver;
    public ElementMethods elementMethods;

    public LoginPageMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementMethods = new ElementMethods(driver);
    }

    @FindBy(className = "ico-login")
    private WebElement login;

    @FindBy(id = "Email")
    private WebElement emailLogin;

    @FindBy(id = "Password")
    private WebElement passwordLogin;
    @FindBy(css = ".fieldset>form>div>button")
    private WebElement loginButton;

    @FindBy(className = "message-error")
    private WebElement loginFailedMessage;

    @FindBy(className = "ico-logout")
    private WebElement logout;

    public void performLogin (String emailLoginValue, String passwordLoginValue){
        elementMethods.clickElement(login);
        elementMethods.fillElement(emailLogin, emailLoginValue);
        elementMethods.fillElement(passwordLogin,passwordLoginValue);
        elementMethods.clickElement(loginButton);
    }

    public void validateLoginErrorMessage(String expectedLoginFailedMessage) {
        elementMethods.validateElementText(loginFailedMessage, expectedLoginFailedMessage);
    }

    public void validateLogoutIsAvailable(String expectedText) {
        elementMethods.validateElementText(logout, expectedText);
    }
}
