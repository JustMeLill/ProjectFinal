package Tests;

import Objects.LoginFailsWithWrongPasswordObject;
import Objects.RegisterObject;
import Pages.LoginFailedWithWrongPWPageMethods;
import Pages.RegisterPageMethods;
import SharedData.Hooks;
import org.testng.annotations.Test;

public class LoginFailsWithWrongPasswordTest extends Hooks {

    @Test
    public void LoginFailsWithWrongPassword() {

        RegisterPageMethods registerPageMethods = new RegisterPageMethods(getDriver());
        LoginFailedWithWrongPWPageMethods loginFailedWithWrongPWPageMethods = new LoginFailedWithWrongPWPageMethods(getDriver());
        RegisterObject registerObject = new RegisterObject(TestData);
        LoginFailsWithWrongPasswordObject loginFailsWithWrongPasswordObject = new LoginFailsWithWrongPasswordObject(TestData);

        //given you have a registered account
        registerPageMethods.performRegister();
        TestReport.AttachReport("pass", "The Register page was accessed.");
        registerPageMethods.fillInRegisterData(registerObject);
        TestReport.AttachReport("pass", "The Register data was inserted and the register button was clicked.");
        registerPageMethods.proceedWithRegister(registerObject);
        TestReport.AttachReport("pass", "The message - The specified email already exists - is displayed.");

        //when you go to login page and fill in the correct username and a wrong password
        loginFailedWithWrongPWPageMethods.performLoginWithWrongPassword(loginFailsWithWrongPasswordObject);
        TestReport.AttachReport("pass", "The Login page was accessed, the wrong password was entered, and the login button was clicked");

        //then the login process returns a message
        loginFailedWithWrongPWPageMethods.validateMessageForWrongPw(loginFailsWithWrongPasswordObject);
        TestReport.AttachReport("pass", "After login fails with wrong credentials a specific message is displayed.");
    }

}

