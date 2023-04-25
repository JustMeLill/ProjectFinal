package Tests;

import Pages.LoginSuccessPageMethods;
import Pages.RegisterPageMethods;
import SharedData.SharedData;
import org.testng.annotations.Test;

public class LoginSuccessfulTests extends SharedData {
    @Test
    public void LoginSucceedsWithGoodCredentials () {

        RegisterPageMethods registerPageMethods = new RegisterPageMethods(getDriver());
        LoginSuccessPageMethods loginSuccessPageMethods = new LoginSuccessPageMethods(getDriver());

        //given
        registerPageMethods.performRegister();
        registerPageMethods.fillInRegisterData("Liliana","Dutescu","24",
                "November","1988","dutescu_lilly@yahoo.com",
                "IT School","TestPassword24!","TestPassword24!");

        // when
        loginSuccessPageMethods.performLogin("dutescu_lilly@yahoo.com","TestPassword24!");

        // then
        loginSuccessPageMethods.validateLogoutIsAvailable("Log out");
    }

}
