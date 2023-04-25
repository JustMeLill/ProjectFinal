package Objects;

import java.util.HashMap;

public class RegisterObject {

    private String firstNameValue;
    private String lastNameValue;
    private String dayOfBirthValue;
    private String monthOfBirthValue;
    private String yearOfBirthValue;
    private String emailValue;
    private String companyValue;
    private String passwordValue;
    private String confirmPasswordValue;
    private String expectedMessageRegister;

    public RegisterObject(HashMap<String, String> TestData) {
        populateObject(TestData);
    }

    private void populateObject(HashMap<String, String> TestData) {
        for (String key: TestData.keySet()){
            switch (key){
                case "firstNameValue":
                    setFirstNameValue(TestData.get(key));
                    break;
                case "lastNameValue":
                    setLastNameValue(TestData.get(key));
                    break;
                case "dayOfBirthValue":
                    setDayOfBirthValue(TestData.get(key));
                    break;
                case "monthOfBirthValue":
                    setMonthOfBirthValue(TestData.get(key));
                    break;
                case "yearOfBirthValue":
                    setYearOfBirthValue(TestData.get(key));
                    break;
                case "emailValue":
                    setEmailValue(TestData.get(key));
                    break;
                case "companyValue":
                    setCompanyValue(TestData.get(key));
                    break;
                case "passwordValue":
                    setPasswordValue(TestData.get(key));
                    break;
                case "confirmPasswordValue":
                    setConfirmPasswordValue(TestData.get(key));
                    break;
                case "expectedMessageRegister":
                    setExpectedMessageRegister(TestData.get(key));
                    break;
            }
        }
    }

    public String getFirstNameValue() {
        return firstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    public String getDayOfBirthValue() {
        return dayOfBirthValue;
    }

    public void setDayOfBirthValue(String dayOfBirthValue) {
        this.dayOfBirthValue = dayOfBirthValue;
    }

    public String getMonthOfBirthValue() {
        return monthOfBirthValue;
    }

    public void setMonthOfBirthValue(String monthOfBirthValue) {
        this.monthOfBirthValue = monthOfBirthValue;
    }

    public String getYearOfBirthValue() {
        return yearOfBirthValue;
    }

    public void setYearOfBirthValue(String yearOfBirthValue) {
        this.yearOfBirthValue = yearOfBirthValue;
    }

    public String getEmailValue() {
        return emailValue;
    }

    public void setEmailValue(String emailValue) {
        this.emailValue = emailValue;
    }

    public String getCompanyValue() {
        return companyValue;
    }

    public void setCompanyValue(String companyValue) {
        this.companyValue = companyValue;
    }

    public String getPasswordValue() {
        return passwordValue;
    }

    public void setPasswordValue(String passwordValue) {
        this.passwordValue = passwordValue;
    }

    public String getConfirmPasswordValue() {
        return confirmPasswordValue;
    }

    public void setConfirmPasswordValue(String confirmPasswordValue) {
        this.confirmPasswordValue = confirmPasswordValue;
    }

    public String getExpectedMessageRegister() {
        return expectedMessageRegister;
    }

    public void setExpectedMessageRegister(String expectedMessageRegister) {
        this.expectedMessageRegister = expectedMessageRegister;
    }
}
