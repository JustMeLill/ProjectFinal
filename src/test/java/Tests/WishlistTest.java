package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WishlistTest {
    public WebDriver driver;
    ChromeOptions chromeOptions = new ChromeOptions();


    @Test
    public void MetodaTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        chromeOptions.addArguments("window-size=1200,1080");
        chromeOptions.addArguments("--no-sandbox");

        WebElement wishlist = driver.findElement(By.className("wishlist-label"));
        wishlist.click();

        WebElement wishlistEmpty = driver.findElement(By.className("no-data"));
        String expectedMessage = "The wishlist is empty!";
        String actualMessage = wishlistEmpty.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        WebElement openBooks = driver.findElement(By.xpath("//a[text()='Books ']"));
        openBooks.click();

        WebElement listOfBooks = driver.findElement(By.className("products-wrapper"));
        Actions actions = new Actions(driver);
        actions.moveToElement(listOfBooks).perform();


        WebElement openBook = driver.findElement(By.xpath("//a[@title='Show details for First Prize Pies']"));
        openBook.click();

        WebElement addToWishlist = driver.findElement(By.id("add-to-wishlist-button-38"));
        addToWishlist.click();

        WebElement clickWishlist = driver.findElement(By.xpath("//a[text()='wishlist']"));
        clickWishlist.click();

        WebElement removeWishlistItem = driver.findElement(By.className("remove-btn"));
        removeWishlistItem.click();

        WebElement wishlistCleared = driver.findElement(By.className("no-data"));
        String expectedMessage2 = "The wishlist is empty!";
        String actualMessage2 = wishlistCleared.getText();
        Assert.assertEquals(actualMessage2, expectedMessage2);



    }


}
