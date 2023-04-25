package Tests;

import Pages.LoginFailedPageMethods;
import Pages.RegisterPageMethods;
import SharedData.SharedData;
import org.testng.annotations.Test;

public class LoginFailesWithWrongEmailTest extends SharedData {

    RegisterPageMethods registerPageMethods = new RegisterPageMethods(getDriver());
    LoginFailedPageMethods loginFailedPageMethods = new LoginFailedPageMethods(getDriver());

    @Test
    public void LoginFailsWithWrongEmail() {

        //given you have a registered account
        registerPageMethods.performRegister();
        registerPageMethods.fillInRegisterData("Liliana", "Dutescu", "24",
                "November", "1988","dutescu_lilly@yahoo.com",
                "IT School","TestPassword24!","TestPassword24!");

        //when you go to the login page and fill in a wrong username and the correct password
        loginFailedPageMethods.performLogin("dutescu_lilly_wrong@yahoo.com","TestPassword24!");

        //then the login process returns a message
        loginFailedPageMethods.validateLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }
}
