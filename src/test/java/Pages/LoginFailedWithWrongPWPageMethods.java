package Pages;

import Objects.LoginFailsWithWrongPasswordObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFailedWithWrongPWPageMethods extends BasePage {

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

    public LoginFailedWithWrongPWPageMethods(WebDriver driver) {
        super(driver);
    }

    public void performLoginWithWrongPassword (LoginFailsWithWrongPasswordObject loginFailsWithWrongPasswordObject){
        elementMethods.clickElement(login);
        elementMethods.fillElement(emailLogin, loginFailsWithWrongPasswordObject.getEmailLogin());
        elementMethods.fillElement(passwordLogin, loginFailsWithWrongPasswordObject.getPasswordLoginWrong());
        elementMethods.clickElement(loginButton);
    }

    public void validateMessageForWrongPw (LoginFailsWithWrongPasswordObject loginFailsWithWrongPasswordObject) {
        elementMethods.validateElementText(loginFailedMessage, loginFailsWithWrongPasswordObject.getLoginErrorMessage());
    }

    public void performLoginWithWrongEmailPassword (String expectedLoginFailedMessage) {

    }

}
