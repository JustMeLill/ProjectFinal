package Objects;

import java.util.HashMap;

public class LoginSuccessObject {

    private String emailLogin;
    private String passwordLogin;
    private String logout;

    public LoginSuccessObject(HashMap<String, String> TestData) {
        populateObject(TestData);
    }

    private void populateObject(HashMap<String, String> TestData) {
        for (String key: TestData.keySet()){
            switch (key){
                case "emailLogin":
                    setEmailLogin(TestData.get(key));
                    break;
                case "passwordLogin":
                    setPasswordLogin(TestData.get(key));
                    break;
                case "logout":
                    setLogout(TestData.get(key));
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

    public String getPasswordLogin() {
        return passwordLogin;
    }

    public void setPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
    }

    public String getLogout() {
        return logout;
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }

}
