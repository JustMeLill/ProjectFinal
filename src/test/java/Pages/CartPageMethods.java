package Pages;

import HelpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPageMethods {

    private WebDriver driver;
    public ElementMethods elementMethods;

    public CartPageMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementMethods = new ElementMethods(driver);
    }

    @FindBy(xpath = "//a[text()='Computers ']")
    private WebElement moveToComputers;

    @FindBy(xpath = "//a[text()='Notebooks ']")
    private WebElement selectNotebooks;

    @FindBy(id = "attribute-option-7")
    private WebElement sortByCPUType;

    @FindBy(id = "attribute-option-10")
    private WebElement sortByMemory;

    @FindBy(css = ".picture>a")
    private WebElement selectNotebookDetails;

    @FindBy(id = "add-to-cart-button-5")
    private WebElement addNotebookToCart;

    @FindBy(xpath = "//a[text()='shopping cart']")
    private WebElement visitCart;

    @FindBy(name = "continueshopping")
    private WebElement continueShopping;

    @FindBy(xpath = "//a[text()='Electronics ']")
    private WebElement moveToElectronics;

    @FindBy(xpath = "//a[text()='Cell phones ']")
    private WebElement selectPhones;

    @FindBy(id = "products-orderby")
    private WebElement hoverSortBy;

    @FindBy(xpath = "//option[text()='Name: Z to A']")
    private WebElement selectSortBy;

    @FindBy(xpath = "//a[@title='Show details for Nokia Lumia 1020']")
    private WebElement selectPhone;

    @FindBy(id = "add-to-cart-button-20")
    private WebElement addPhoneToCart;

    @FindBy(id = "termsofservice")
    private WebElement agreeTerms;

    @FindBy(id = "checkout")
    private WebElement checkOut;


    public void goToNotebooksAndApplySorting (){
        elementMethods.moveToElement(moveToComputers);
        elementMethods.clickElement(selectNotebooks);
        elementMethods.clickElement(sortByCPUType);
        elementMethods.clickElement(sortByMemory);

    }

    public void openNotebook (){
        elementMethods.clickElement(selectNotebookDetails);
        elementMethods.clickElement(addNotebookToCart);
    }

    public void openShoppingCart (){
        elementMethods.clickElement(visitCart);
    }

    public void continueShopping (){
        elementMethods.clickElement(continueShopping);
    }


    public void goToPhonesAndApplySorting (){
        elementMethods.moveToElement(moveToElectronics);
        elementMethods.clickElement(selectPhones);
        elementMethods.moveToElement(hoverSortBy);
        elementMethods.clickElement(selectSortBy);

    }

    public void openPhone (){
        elementMethods.clickElement(selectPhone);
        elementMethods.clickElement(addPhoneToCart);
    }

    public void proceedWithCheckout (){
        elementMethods.scrollByPixel(0, 500);
        elementMethods.clickElement(agreeTerms);
        elementMethods.clickElement(checkOut);
    }



}
