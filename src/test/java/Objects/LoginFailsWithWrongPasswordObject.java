package Objects;

import java.util.HashMap;

public class LoginFailsWithWrongPasswordObject {
    private String emailLogin;
    private String passwordLoginWrong;
    private String loginErrorMessage;

    public LoginFailsWithWrongPasswordObject(HashMap<String, String> TestData) {
        populateObject(TestData);
    }

    private void populateObject(HashMap<String, String> TestData) {
        for (String key: TestData.keySet()){
            switch (key){
                case "emailLogin":
                    setEmailLogin(TestData.get(key));
                    break;
                case "passwordLoginWrong":
                    setPasswordLoginWrong(TestData.get(key));
                    break;
                case "loginErrorMessage":
                    setLoginErrorMessage(TestData.get(key));
                    break;
            }
        }
    }

    public String getEmailLogin() {
        return emailLogin;
    }

    public void setEmailLogin(String emailLogin) {
        this.emailLogin = emailLogin;
    }

    public String getPasswordLoginWrong() {
        return passwordLoginWrong;
    }

    public void setPasswordLoginWrong(String passwordLoginWrong) {
        this.passwordLoginWrong = passwordLoginWrong;
    }

    public String getLoginErrorMessage() {
        return loginErrorMessage;
    }

    public void setLoginErrorMessage(String loginErrorMessage) {
        this.loginErrorMessage = loginErrorMessage;
    }
}
