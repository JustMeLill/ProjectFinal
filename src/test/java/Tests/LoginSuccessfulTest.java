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
        registerPageMethods.fillInRegisterData(registerObject);
        registerPageMethods.proceedWithRegister(registerObject);

        // when you perform login with correct credentials
        loginSuccessPageMethods.performLogin(loginSuccessObject);

        // then the login is performed and the logout button is visible on page
        loginSuccessPageMethods.validateLogoutIsAvailable(loginSuccessObject);
    }

}
