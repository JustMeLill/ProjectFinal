package PagesMethods;

import HelpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageMethods {

    private WebDriver driver;
    public ElementMethods elementMethods;

    public RegisterPageMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementMethods = new ElementMethods(driver);
    }

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

    public void performRegister (){
        elementMethods.clickElement(register);
    }

    public void fillInRegisterData (String firstNameValue, String lastNameValue, String dayOfBirthValue,
                                 String monthOfBirthValue, String yearOfBirthValue,
                                 String emailValue, String companyValue,
                                 String passwordValue, String confirmPasswordValue){
        elementMethods.clickElement(selectGender);
        elementMethods.fillElement(firstName, firstNameValue);
        elementMethods.fillElement(lastName, lastNameValue);
        elementMethods.selectElementByText(dayOfBirth, dayOfBirthValue);
        elementMethods.selectElementByText(monthOfBirth, monthOfBirthValue);
        elementMethods.selectElementByText(yearOfBirth, yearOfBirthValue);
        elementMethods.fillElement(email, emailValue);
        elementMethods.fillElement(company, companyValue);
        elementMethods.clickElement(selectNewsletter);
        elementMethods.fillElement(password, passwordValue);
        elementMethods.fillElement(confirmPassword, confirmPasswordValue);
        elementMethods.waitElementVisible(registerButton);
        elementMethods.clickElement(registerButton);
    }

    public void proceedWithRegister (String expectedMessageRegister){
       elementMethods.validateElementText(error, expectedMessageRegister);
    }

}
