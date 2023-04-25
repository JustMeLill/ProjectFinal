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
        registerPageMethods.fillInRegisterData(registerObject);
        registerPageMethods.proceedWithRegister(registerObject);

        //when you go to the login page and fill in a wrong username and the correct password
        loginFailedWithWrongEmailPageMethods.performLoginWithWrongEmail(loginFailsWithWrongEmailObject);

        //then the login process returns a message
        loginFailedWithWrongEmailPageMethods.validateMessageForWrongEmail(loginFailsWithWrongEmailObject);
    }
}
