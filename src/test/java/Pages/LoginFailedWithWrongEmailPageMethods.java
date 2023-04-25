package Pages;

import Objects.LoginFailsWithWrongEmailObject;
import Objects.LoginFailsWithWrongPasswordObject;
import Objects.LoginSuccessObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFailedWithWrongEmailPageMethods extends BasePage {

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

    public LoginFailedWithWrongEmailPageMethods(WebDriver driver) {
        super(driver);
    }

    public void performLoginWithWrongEmail (LoginFailsWithWrongEmailObject loginFailsWithWrongEmailObject){
        elementMethods.clickElement(login);
        elementMethods.fillElement(emailLogin, loginFailsWithWrongEmailObject.getEmailLoginWrong());
        elementMethods.fillElement(passwordLogin, loginFailsWithWrongEmailObject.getPasswordLoginWrong());
        elementMethods.clickElement(loginButton);
    }

    public void performLogin (LoginSuccessObject loginSuccessObject){
        elementMethods.clickElement(login);
        elementMethods.fillElement(emailLogin, loginSuccessObject.getEmailLogin());
        elementMethods.fillElement(passwordLogin,loginSuccessObject.getPasswordLogin());
        elementMethods.clickElement(loginButton);
    }

    public void validateMessageForWrongEmail (LoginFailsWithWrongEmailObject loginFailsWithWrongEmailObject) {
        elementMethods.validateElementText(loginFailedMessage, loginFailsWithWrongEmailObject.getLoginErrorMessage2());
    }


}
