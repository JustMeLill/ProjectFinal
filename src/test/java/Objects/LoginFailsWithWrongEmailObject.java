package Objects;

import java.util.HashMap;

public class LoginFailsWithWrongEmailObject {
    private String emailLoginWrong;
    private String passwordLoginWrong;
    private String loginErrorMessage2;

    public LoginFailsWithWrongEmailObject(HashMap<String, String> TestData) {
        populateObject(TestData);
    }

    private void populateObject(HashMap<String, String> TestData) {
        for (String key: TestData.keySet()){
            switch (key){
                case "emailLoginWrong":
                    setEmailLoginWrong(TestData.get(key));
                    break;
                case "passwordLoginWrong":
                    setPasswordLoginWrong(TestData.get(key));
                    break;
                case "loginErrorMessage2":
                    setLoginErrorMessage2(TestData.get(key));
                    break;
            }
        }
    }

    public String getEmailLoginWrong() {
        return emailLoginWrong;
    }

    public void setEmailLoginWrong(String emailLoginWrong) {
        this.emailLoginWrong = emailLoginWrong;
    }

    public String getPasswordLoginWrong() {
        return passwordLoginWrong;
    }

    public void setPasswordLoginWrong(String passwordLoginWrong) {
        this.passwordLoginWrong = passwordLoginWrong;
    }

    public String getLoginErrorMessage2() {
        return loginErrorMessage2;
    }

    public void setLoginErrorMessage2(String loginErrorMessage2) {
        this.loginErrorMessage2 = loginErrorMessage2;
    }
}
