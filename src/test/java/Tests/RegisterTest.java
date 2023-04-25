package Tests;

import Objects.RegisterObject;
import Pages.RegisterPageMethods;
import SharedData.Hooks;
import org.testng.annotations.Test;

public class RegisterTest extends Hooks {

    @Test
    public void registerUser (){

        RegisterPageMethods registerPageMethods = new RegisterPageMethods(getDriver());
        RegisterObject registerObject = new RegisterObject(TestData);

        //given you have a registered account
        registerPageMethods.performRegister();

        //when you fill in the register data again and click the register button
        registerPageMethods.fillInRegisterData(registerObject);

        //then the register process returns a message
        registerPageMethods.proceedWithRegister(registerObject);

    }

}
