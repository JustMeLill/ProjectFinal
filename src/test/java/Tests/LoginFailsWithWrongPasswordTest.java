package Tests;

import Pages.LoginFailedPageMethods;
import Pages.RegisterPageMethods;
import SharedData.SharedData;
import org.testng.annotations.Test;

public class LoginFailsWithWrongPasswordTest extends SharedData {

    @Test
    public void LoginFailsWithWrongPassword() {

        RegisterPageMethods registerPageMethods = new RegisterPageMethods(getDriver());
        LoginFailedPageMethods loginFailedPageMethods = new LoginFailedPageMethods(getDriver());

        //given you have a registered account
        registerPageMethods.performRegister();
        registerPageMethods.fillInRegisterData("Liliana","Dutescu","24",
                "November","1988","dutescu_lilly@yahoo.com",
                "IT School","TestPassword24!","TestPassword24!");

        //when you go to login page and fill in the correct username and a wrong password
        loginFailedPageMethods.performLogin("dutescu_lilly@yahoo.com","TestPassword24!WRONG");

        //then the login process returns a message
        loginFailedPageMethods.validateLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

}

