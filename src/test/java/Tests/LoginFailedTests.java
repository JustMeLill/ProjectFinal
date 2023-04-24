package Tests;

import PagesMethods.LoginPageMethods;
import PagesMethods.RegisterPageMethods;
import SharedData.SharedData;
import org.testng.annotations.Test;

public class LoginFailedTests extends SharedData {

    RegisterPageMethods registerPageMethods = new RegisterPageMethods(getDriver());
    LoginPageMethods loginPageMethods = new LoginPageMethods(getDriver());
    @Test
    public void LoginFailsWithWrongPassword() {


        //given you have a registered account
        registerPageMethods.performRegister();
        registerPageMethods.fillInRegisterData("Liliana","Dutescu","24",
                "November","1988","dutescu_lilly@yahoo.com",
                "IT School","TestPassword24!","TestPassword24!");

        //when you go to login page and fill in the correct username and a wrong password
        loginPageMethods.performLogin("dutescu_lilly@yahoo.com","TestPassword24!WRONG");

        //then the login process returns a message
        loginPageMethods.validateLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void LoginFailsWithWrongEmail() {

        //given you have a registered account
        registerPageMethods.performRegister();
        registerPageMethods.fillInRegisterData("Liliana", "Dutescu", "24",
                "November", "1988","dutescu_lilly@yahoo.com",
                "IT School","TestPassword24!","TestPassword24!");

        //when you go to the login page and fill in a wrong username and the correct password
        loginPageMethods.performLogin("dutescu_lilly_wrong@yahoo.com","TestPassword24!");

        //then the login process returns a message
        loginPageMethods.validateLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }
}

