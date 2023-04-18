package Tests;

import HelpMethods.ElementMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WishlistTest extends SharedData {

    @Test
    public void MetodaTest(){

        ElementMethods elementMethods = new ElementMethods(getDriver());

        WebElement wishlist = getDriver().findElement(By.className("wishlist-label"));
        elementMethods.clickElement(wishlist);

        WebElement wishlistEmpty = getDriver().findElement(By.className("no-data"));
        String expectedMessage = "The wishlist is empty!";
        elementMethods.validateElementText(wishlistEmpty, expectedMessage);

        WebElement openBooks = getDriver().findElement(By.xpath("//a[text()='Books ']"));
        elementMethods.clickElement(openBooks);

        WebElement listOfBooks = getDriver().findElement(By.className("products-wrapper"));
        elementMethods.moveToElement(listOfBooks);

        WebElement openBook = getDriver().findElement(By.xpath("//a[@title='Show details for First Prize Pies']"));
        elementMethods.clickElement(openBook);

        WebElement addToWishlist = getDriver().findElement(By.id("add-to-wishlist-button-38"));
        elementMethods.clickElement(addToWishlist);

        WebElement clickWishlist = getDriver().findElement(By.xpath("//a[text()='wishlist']"));
        elementMethods.clickElement(clickWishlist);

        WebElement removeWishlistItem = getDriver().findElement(By.className("remove-btn"));
        elementMethods.clickElement(removeWishlistItem);

        WebElement wishlistCleared = getDriver().findElement(By.className("no-data"));
        String expectedMessage2 = "The wishlist is empty!";
        elementMethods.validateElementText(wishlistCleared, expectedMessage2);

    }
}
