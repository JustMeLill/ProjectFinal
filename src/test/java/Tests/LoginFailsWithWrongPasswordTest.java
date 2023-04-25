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
        registerPageMethods.fillInRegisterData(registerObject);
        registerPageMethods.proceedWithRegister(registerObject);

        //when you go to login page and fill in the correct username and a wrong password
        loginFailedWithWrongPWPageMethods.performLoginWithWrongPassword(loginFailsWithWrongPasswordObject);

        //then the login process returns a message
        loginFailedWithWrongPWPageMethods.validateMessageForWrongPw(loginFailsWithWrongPasswordObject);
    }

}

