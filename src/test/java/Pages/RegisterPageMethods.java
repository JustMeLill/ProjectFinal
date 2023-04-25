package Pages;

import Objects.RegisterObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPageMethods extends BasePage {

    @FindBy(className = "ico-register")
    private WebElement register;

    @FindBy(id = "gender-female")
    private WebElement selectGender;

    @FindBy(id = "FirstName")
    private WebElement firstName;

    @FindBy(id = "LastName")
    private WebElement lastName;

    @FindBy(name = "DateOfBirthDay")
    private WebElement dayOfBirth;

    @FindBy(name = "DateOfBirthMonth")
    private WebElement monthOfBirth;

    @FindBy(name = "DateOfBirthYear")
    private WebElement yearOfBirth;

    @FindBy(id = "Email")
    private WebElement email;

    @FindBy(id = "Company")
    private WebElement company;

    @FindBy(id = "Newsletter")
    private WebElement selectNewsletter;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPassword;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(css = ".message-error>ul>li")
    private WebElement error;


    public RegisterPageMethods(WebDriver driver) {
        super(driver);
    }

    public void performRegister (){
        elementMethods.clickElement(register);
    }

    public void fillInRegisterData (RegisterObject registerObject){
        elementMethods.clickElement(selectGender);
        elementMethods.fillElement(firstName, registerObject.getFirstNameValue());
        elementMethods.fillElement(lastName, registerObject.getLastNameValue());
        elementMethods.selectElementByText(dayOfBirth, registerObject.getDayOfBirthValue());
        elementMethods.selectElementByText(monthOfBirth, registerObject.getMonthOfBirthValue());
        elementMethods.selectElementByText(yearOfBirth, registerObject.getYearOfBirthValue());
        elementMethods.fillElement(email, registerObject.getEmailValue());
        elementMethods.fillElement(company, registerObject.getCompanyValue());
        elementMethods.clickElement(selectNewsletter);
        elementMethods.fillElement(password, registerObject.getPasswordValue());
        elementMethods.fillElement(confirmPassword, registerObject.getConfirmPasswordValue());
        elementMethods.waitElementVisible(registerButton);
        elementMethods.clickElement(registerButton);
    }

    public void proceedWithRegister (RegisterObject registerObject){
       elementMethods.validateElementText(error, registerObject.getExpectedMessageRegister());
    }

}
