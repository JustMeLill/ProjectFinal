package Tests;

import PagesMethods.RegisterPageMethods;
import SharedData.SharedData;
import org.testng.annotations.Test;

public class RegisterTest extends SharedData {

    @Test
    public void registerUser (){

        RegisterPageMethods registerPageMethods = new RegisterPageMethods(getDriver());

        //given you have a registered account
        registerPageMethods.performRegister();

        //when you fill in the register data again and click the register button
        registerPageMethods.fillInRegisterData("Liliana", "Dutescu", "24",
                "November", "1988","dutescu_lilly@yahoo.com",
                "IT School","TestPassword24!","TestPassword24!");

        //then the register process returns a message
        registerPageMethods.proceedWithRegister("The specified email already exists");

    }

}
