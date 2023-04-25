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

        //given you go to register page
        registerPageMethods.performRegister();
        TestReport.AttachReport("pass", "The Register page was accessed.");

        //when you fill in the register data and click the register button
        registerPageMethods.fillInRegisterData(registerObject);
        TestReport.AttachReport("pass", "The Register data was inserted and the register button was clicked.");

        //then the register process returns a message
        registerPageMethods.proceedWithRegister(registerObject);
        TestReport.AttachReport("pass", "The message - The specified email already exists - is displayed.");

    }

}
