package Tests;

import InputFile.PropertiesUtility;
import Objects.LoginFailsWithWrongPasswordObject;
import Objects.RegisterObject;
import Pages.LoginFailedWithWrongPWPageMethods;
import Pages.RegisterPageMethods;
import SharedData.Hooks;
import org.testng.annotations.Test;

public class LoginFailsWithWrongPasswordTest extends Hooks {

    @Test
    public void LoginFailsWithWrongPassword() {

        RegisterObject registerObject = new RegisterObject(new PropertiesUtility("RegisterTest").getAllData());
        LoginFailsWithWrongPasswordObject loginFailsWithWrongPasswordObject = new LoginFailsWithWrongPasswordObject(new PropertiesUtility("LoginFailsWithWrongPasswordTest").getAllData());

        //given you have a registered account
        RegisterPageMethods registerPageMethods = new RegisterPageMethods(getDriver());
        registerPageMethods.performRegister();
        TestReport.AttachReport("pass", "The Register page was accessed.");
        registerPageMethods.fillInRegisterData(registerObject);
        TestReport.AttachReport("pass", "The Register data was inserted and the register button was clicked.");


        //when you go to login page and fill in the correct username and a wrong password
        LoginFailedWithWrongPWPageMethods loginFailedWithWrongPWPageMethods = new LoginFailedWithWrongPWPageMethods(getDriver());
        loginFailedWithWrongPWPageMethods.performLoginWithWrongPassword(loginFailsWithWrongPasswordObject);
        TestReport.AttachReport("pass", "The Login page was accessed, the wrong password was entered, and the login button was clicked");

        //then the login process returns a message
        loginFailedWithWrongPWPageMethods.validateMessageForWrongPw(loginFailsWithWrongPasswordObject);
        TestReport.AttachReport("pass", "After login fails with wrong credentials a specific message is displayed.");
    }

}

