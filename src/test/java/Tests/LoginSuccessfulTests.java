package Tests;

import PagesMethods.LoginPageMethods;
import PagesMethods.RegisterPageMethods;
import SharedData.SharedData;
import org.testng.annotations.Test;

public class LoginSuccessfulTests extends SharedData {
    @Test
    public void LoginSucceedsWithGoodCredentials () {

        RegisterPageMethods registerPageMethods = new RegisterPageMethods(getDriver());
        LoginPageMethods loginPageMethods = new LoginPageMethods(getDriver());

        //given
        registerPageMethods.performRegister();
        registerPageMethods.fillInRegisterData("Liliana","Dutescu","24",
                "November","1988","dutescu_lilly@yahoo.com",
                "IT School","TestPassword24!","TestPassword24!");

        // when
        loginPageMethods.performLogin("dutescu_lilly@yahoo.com","TestPassword24!");

        // then
        loginPageMethods.validateLogoutIsAvailable("Log out");
    }

}
