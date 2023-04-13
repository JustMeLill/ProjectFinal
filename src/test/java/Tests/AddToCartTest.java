package Tests;

import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTest extends SharedData {
    @Test
    public void MetodaTest(){

        WebElement moveToComputers = getDriver().findElement(By.xpath("//a[text()='Computers ']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(moveToComputers).perform();

        WebElement selectNotebooks = getDriver().findElement(By.xpath("//a[text()='Notebooks ']"));
        selectNotebooks.click();

        WebElement sortByCPUType = getDriver().findElement(By.id("attribute-option-7"));
        sortByCPUType.click();

        WebElement sortByMemory = getDriver().findElement(By.id("attribute-option-10"));
        sortByMemory.click();


        WebDriverWait WaitExplicit = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WaitExplicit.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(getDriver().findElement(By.cssSelector(".product-title>a")))));

        WebElement selectNotebookDetails = getDriver().findElement(By.cssSelector(".picture>a"));
        selectNotebookDetails.click();

        WebElement addNotebookToCart = getDriver().findElement(By.id("add-to-cart-button-5"));
        addNotebookToCart.click();

        WebElement visitCart = getDriver().findElement(By.xpath("//a[text()='shopping cart']"));
        visitCart.click();

        WebElement continueShopping = getDriver().findElement(By.name("continueshopping"));
        continueShopping.click();

        WebElement moveToElectronics = getDriver().findElement(By.xpath("//a[text()='Electronics ']"));
        Actions secondActions = new Actions(getDriver());
        secondActions.moveToElement(moveToElectronics).perform();

        WebElement selectPhones = getDriver().findElement(By.xpath("//a[text()='Cell phones ']"));
        selectPhones.click();

        WebElement hoverSortBy = getDriver().findElement(By.id("products-orderby"));
        Actions thirdActions = new Actions(getDriver());
        thirdActions.moveToElement(hoverSortBy).perform();

        WebElement selectSortBy = getDriver().findElement(By.xpath("//option[text()='Name: Z to A']"));
        selectSortBy.click();

        WebDriverWait WaitExplicit2 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WaitExplicit2.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(getDriver().findElement(By.xpath("//a[@title='Show details for Nokia Lumia 1020']")))));

        WebElement selectPhone = getDriver().findElement(By.xpath("//a[@title='Show details for Nokia Lumia 1020']"));
        selectPhone.click();

        WebElement addPhoneToCart = getDriver().findElement(By.id("add-to-cart-button-20"));
        addPhoneToCart.click();

        WebElement reVisitCart = getDriver().findElement(By.xpath("//a[text()='shopping cart']"));
        reVisitCart.click();

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,2500)");

        WebElement agreeTerms = getDriver().findElement(By.id("termsofservice"));
        agreeTerms.click();

        WebElement checkOut = getDriver().findElement(By.id("checkout"));
        checkOut.click();

    }
}
