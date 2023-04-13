package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        WaitExplicit.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".product-title>a")))));

        WebElement selectNotebookDetails = driver.findElement(By.cssSelector(".picture>a"));
        selectNotebookDetails.click();

        WebElement addNotebookToCart = driver.findElement(By.id("add-to-cart-button-5"));
        addNotebookToCart.click();

        WebElement visitCart = driver.findElement(By.xpath("//a[text()='shopping cart']"));
        visitCart.click();

        WebElement continueShopping = driver.findElement(By.name("continueshopping"));
        continueShopping.click();

        WebElement moveToElectronics = driver.findElement(By.xpath("//a[text()='Electronics ']"));
        Actions secondActions = new Actions(driver);
        secondActions.moveToElement(moveToElectronics).perform();

        WebElement selectPhones = driver.findElement(By.xpath("//a[text()='Cell phones ']"));
        selectPhones.click();

        WebElement hoverSortBy = driver.findElement(By.id("products-orderby"));
        Actions thirdActions = new Actions(driver);
        thirdActions.moveToElement(hoverSortBy).perform();

        WebElement selectSortBy = driver.findElement(By.xpath("//option[text()='Name: Z to A']"));
        selectSortBy.click();

        WebDriverWait WaitExplicit2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WaitExplicit2.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//a[@title='Show details for Nokia Lumia 1020']")))));

        WebElement selectPhone = driver.findElement(By.xpath("//a[@title='Show details for Nokia Lumia 1020']"));
        selectPhone.click();

        WebElement addPhoneToCart = driver.findElement(By.id("add-to-cart-button-20"));
        addPhoneToCart.click();

        WebElement reVisitCart = driver.findElement(By.xpath("//a[text()='shopping cart']"));
        reVisitCart.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2500)");

        WebElement agreeTerms = driver.findElement(By.id("termsofservice"));
        agreeTerms.click();

        WebElement checkOut = driver.findElement(By.id("checkout"));
        checkOut.click();


    }

}
