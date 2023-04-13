package Tests;

import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistTest extends SharedData {

    @Test
    public void MetodaTest(){

        WebElement wishlist = getDriver().findElement(By.className("wishlist-label"));
        wishlist.click();

        WebElement wishlistEmpty = getDriver().findElement(By.className("no-data"));
        String expectedMessage = "The wishlist is empty!";
        String actualMessage = wishlistEmpty.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        WebElement openBooks = getDriver().findElement(By.xpath("//a[text()='Books ']"));
        openBooks.click();

        WebElement listOfBooks = getDriver().findElement(By.className("products-wrapper"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(listOfBooks).perform();


        WebElement openBook = getDriver().findElement(By.xpath("//a[@title='Show details for First Prize Pies']"));
        openBook.click();

        WebElement addToWishlist = getDriver().findElement(By.id("add-to-wishlist-button-38"));
        addToWishlist.click();

        WebElement clickWishlist = getDriver().findElement(By.xpath("//a[text()='wishlist']"));
        clickWishlist.click();

        WebElement removeWishlistItem = getDriver().findElement(By.className("remove-btn"));
        removeWishlistItem.click();

        WebElement wishlistCleared = getDriver().findElement(By.className("no-data"));
        String expectedMessage2 = "The wishlist is empty!";
        String actualMessage2 = wishlistCleared.getText();
        Assert.assertEquals(actualMessage2, expectedMessage2);



    }


}
