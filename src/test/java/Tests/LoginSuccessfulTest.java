package Tests;

import Objects.LoginSuccessObject;
import Objects.RegisterObject;
import Pages.LoginSuccessPageMethods;
import Pages.RegisterPageMethods;
import SharedData.Hooks;
import org.testng.annotations.Test;

public class LoginSuccessfulTest extends Hooks {

    @Test
    public void LoginSucceedsWithGoodCredentials () {

        RegisterPageMethods registerPageMethods = new RegisterPageMethods(getDriver());
        RegisterObject registerObject = new RegisterObject(TestData);

        LoginSuccessPageMethods loginSuccessPageMethods = new LoginSuccessPageMethods(getDriver());
        LoginSuccessObject loginSuccessObject = new LoginSuccessObject(TestData);


        //given you have a registered account
        registerPageMethods.performRegister();
        TestReport.AttachReport("pass", "The Register page was accessed.");
        registerPageMethods.fillInRegisterData(registerObject);
        TestReport.AttachReport("pass", "The Register data was inserted and the register button was clicked.");
        registerPageMethods.proceedWithRegister(registerObject);
        TestReport.AttachReport("pass", "The message - The specified email already exists - is displayed.");

        // when you perform login with correct credentials
        loginSuccessPageMethods.performLogin(loginSuccessObject);
        TestReport.AttachReport("pass", "The Login page was accessed, the login credentials were entered, and the login button was clicked");

        // then the login is performed and the logout button is visible on page
        loginSuccessPageMethods.validateLogoutIsAvailable(loginSuccessObject);
        TestReport.AttachReport("pass", "After a successful login the logout button is visible on page.");
    }

}
