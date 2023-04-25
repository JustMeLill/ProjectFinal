package Pages;

import HelpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPageMethods {

    private WebDriver driver;
    public ElementMethods elementMethods;

    public WishlistPageMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementMethods = new ElementMethods(driver);
    }

    @FindBy(className = "wishlist-label")
    private WebElement wishlist;

    @FindBy(className = "no-data")
    private WebElement wishlistEmpty;

    @FindBy(xpath = "//a[text()='Books ']")
    private WebElement openBooks;

    @FindBy(className = "products-wrapper")
    private WebElement listOfBooks;

    @FindBy(xpath = "//a[@title='Show details for First Prize Pies']")
    private WebElement openBook;

    @FindBy(id = "add-to-wishlist-button-38")
    private WebElement addToWishlist;

    @FindBy(xpath = "//a[text()='wishlist']")
    private WebElement clickWishlist;

    @FindBy(className = "remove-btn")
    private WebElement removeWishlistItem;

    public void goToWishListFromToolbar (){
        elementMethods.clickElement(wishlist);
    }

    public void checkIfWishListIsEmpty (String expectedMessage){
        elementMethods.validateElementText(wishlistEmpty, expectedMessage);

    }

    public void openAnItemInTheBooksPage (){
        elementMethods.clickElement(openBooks);
        elementMethods.moveToElement(listOfBooks);
        elementMethods.clickElement(openBook);
    }

    public void addItemToWishlist (){
        elementMethods.clickElement(addToWishlist);
    }
    public void openWishlistFromItemViewMode (){
        elementMethods.clickElement(clickWishlist);

    }

    public void removeItemFromWishlist (){
        elementMethods.clickElement(removeWishlistItem);
    }

}
