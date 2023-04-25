package Tests;

import InputFile.PropertiesUtility;
import Objects.LoginFailsWithWrongEmailObject;
import Objects.RegisterObject;
import Pages.LoginFailedWithWrongEmailPageMethods;
import Pages.RegisterPageMethods;
import SharedData.Hooks;
import org.testng.annotations.Test;

public class LoginFailsWithWrongEmailTest extends Hooks {

    @Test
    public void LoginFailsWithWrongEmail() {

        RegisterObject registerObject = new RegisterObject(new PropertiesUtility("RegisterTest").getAllData());
        LoginFailsWithWrongEmailObject loginFailsWithWrongEmailObject = new LoginFailsWithWrongEmailObject(new PropertiesUtility("LoginFailsWithWrongEmailTest").getAllData());

        //given you have a registered account
        RegisterPageMethods registerPageMethods = new RegisterPageMethods(getDriver());
        registerPageMethods.performRegister();
        TestReport.AttachReport("pass", "The Register page was accessed.");
        registerPageMethods.fillInRegisterData(registerObject);
        TestReport.AttachReport("pass", "The Register data was inserted and the register button was clicked.");


        //when you go to the login page and fill in a wrong username and the correct password
        LoginFailedWithWrongEmailPageMethods loginFailedWithWrongEmailPageMethods = new LoginFailedWithWrongEmailPageMethods(getDriver());
        loginFailedWithWrongEmailPageMethods.performLoginWithWrongEmail(loginFailsWithWrongEmailObject);
        TestReport.AttachReport("pass", "The Login page was accessed, the wrong email entered, and the login button was clicked");

        //then the login process returns a message
        loginFailedWithWrongEmailPageMethods.validateMessageForWrongEmail(loginFailsWithWrongEmailObject);
        TestReport.AttachReport("pass", "After login fails due to no account found, a specific message is displayed.");
    }
}
