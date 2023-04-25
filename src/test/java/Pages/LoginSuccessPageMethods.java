package Pages;

import HelpMethods.ElementMethods;
import Objects.LoginSuccessObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSuccessPageMethods extends BasePage {

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

    public LoginSuccessPageMethods(WebDriver driver) {
        super(driver);
    }


    public void performLogin (LoginSuccessObject loginSuccessObject){
        elementMethods.clickElement(login);
        elementMethods.fillElement(emailLogin, loginSuccessObject.getEmailLogin());
        elementMethods.fillElement(passwordLogin,loginSuccessObject.getPasswordLogin());
        elementMethods.clickElement(loginButton);
    }

    public void validateLogoutIsAvailable(LoginSuccessObject loginSuccessObject) {
        elementMethods.validateElementText(logout, loginSuccessObject.getLogout());
    }
}
