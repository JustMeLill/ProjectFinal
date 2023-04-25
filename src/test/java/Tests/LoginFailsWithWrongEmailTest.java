package Tests;

import Objects.LoginFailsWithWrongEmailObject;
import Objects.RegisterObject;
import Pages.LoginFailedWithWrongEmailPageMethods;
import Pages.RegisterPageMethods;
import SharedData.Hooks;
import org.testng.annotations.Test;

public class LoginFailsWithWrongEmailTest extends Hooks {

    @Test
    public void LoginFailsWithWrongEmail() {

        RegisterPageMethods registerPageMethods = new RegisterPageMethods(getDriver());
        LoginFailedWithWrongEmailPageMethods loginFailedWithWrongEmailPageMethods = new LoginFailedWithWrongEmailPageMethods(getDriver());
        RegisterObject registerObject = new RegisterObject(TestData);
        LoginFailsWithWrongEmailObject loginFailsWithWrongEmailObject = new LoginFailsWithWrongEmailObject(TestData);

        //given you have a registered account
        registerPageMethods.performRegister();
        TestReport.AttachReport("pass", "The Register page was accessed.");
        registerPageMethods.fillInRegisterData(registerObject);
        TestReport.AttachReport("pass", "The Register data was inserted and the register button was clicked.");
        registerPageMethods.proceedWithRegister(registerObject);
        TestReport.AttachReport("pass", "The message - The specified email already exists - is displayed.");

        //when you go to the login page and fill in a wrong username and the correct password
        loginFailedWithWrongEmailPageMethods.performLoginWithWrongEmail(loginFailsWithWrongEmailObject);
        TestReport.AttachReport("pass", "The Login page was accessed, the wrong email entered, and the login button was clicked");

        //then the login process returns a message
        loginFailedWithWrongEmailPageMethods.validateMessageForWrongEmail(loginFailsWithWrongEmailObject);
        TestReport.AttachReport("pass", "After login fails due to no account found, a specific message is displayed.");
    }
}
