package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTest {
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


        WebElement moveToComputers = driver.findElement(By.xpath("//a[text()='Computers ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(moveToComputers).perform();

        WebElement selectNotebooks = driver.findElement(By.xpath("//a[text()='Notebooks ']"));
        selectNotebooks.click();

        WebElement sortByCPUType = driver.findElement(By.id("attribute-option-7"));
        sortByCPUType.click();

        WebElement sortByMemory = driver.findElement(By.id("attribute-option-10"));
        sortByMemory.click();

        WebDriverWait WaitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10));
        WaitExplicit.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".product-title>a")));
        WaitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-title>a")));
        WebElement selectNotebookDetails = driver.findElement(By.cssSelector(".product-title>a"));
        WaitExplicit.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(selectNotebookDetails)));
        selectNotebookDetails.click();

        //.picture>a
        //.product-title>a

        WebElement addToCart = driver.findElement(By.className("button-2 product-box-add-to-cart-button"));
        addToCart.click();


        //.details>div>div>button[1]



    }

}
