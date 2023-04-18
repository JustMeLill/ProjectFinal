package Tests;

import HelpMethods.ElementMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AddToCartTest extends SharedData {
    @Test
    public void MetodaTest(){

        ElementMethods elementMethods = new ElementMethods(getDriver());

        WebElement moveToComputers = getDriver().findElement(By.xpath("//a[text()='Computers ']"));
        elementMethods.moveToElement(moveToComputers);

        WebElement selectNotebooks = getDriver().findElement(By.xpath("//a[text()='Notebooks ']"));
        elementMethods.clickElement(selectNotebooks);

        WebElement sortByCPUType = getDriver().findElement(By.id("attribute-option-7"));
        elementMethods.clickElement(sortByCPUType);

        WebElement sortByMemory = getDriver().findElement(By.id("attribute-option-10"));
        elementMethods.clickElement(sortByMemory);

        elementMethods.waitElementVisibleWithStaleness(getDriver().findElement(By.cssSelector(".picture>a")));

        WebElement selectNotebookDetails = getDriver().findElement(By.cssSelector(".picture>a"));
        elementMethods.clickElement(selectNotebookDetails);

        WebElement addNotebookToCart = getDriver().findElement(By.id("add-to-cart-button-5"));
        elementMethods.clickElement(addNotebookToCart);

        WebElement visitCart = getDriver().findElement(By.xpath("//a[text()='shopping cart']"));
        elementMethods.clickElement(visitCart);

        WebElement continueShopping = getDriver().findElement(By.name("continueshopping"));
        elementMethods.clickElement(continueShopping);

        WebElement moveToElectronics = getDriver().findElement(By.xpath("//a[text()='Electronics ']"));
        elementMethods.moveToElement(moveToElectronics);

        WebElement selectPhones = getDriver().findElement(By.xpath("//a[text()='Cell phones ']"));
        elementMethods.clickElement(selectPhones);

        WebElement hoverSortBy = getDriver().findElement(By.id("products-orderby"));
        elementMethods.moveToElement(hoverSortBy);

        WebElement selectSortBy = getDriver().findElement(By.xpath("//option[text()='Name: Z to A']"));
        elementMethods.clickElement(selectSortBy);

        elementMethods.waitElementVisibleWithStaleness(getDriver().findElement(By.xpath("//a[@title='Show details for Nokia Lumia 1020']")));

        WebElement selectPhone = getDriver().findElement(By.xpath("//a[@title='Show details for Nokia Lumia 1020']"));
        elementMethods.clickElement(selectPhone);

        WebElement addPhoneToCart = getDriver().findElement(By.id("add-to-cart-button-20"));
        elementMethods.clickElement(addPhoneToCart);

        WebElement reVisitCart = getDriver().findElement(By.xpath("//a[text()='shopping cart']"));
        elementMethods.clickElement(reVisitCart);

        elementMethods.scrollByPixel(0, 500);

        WebElement agreeTerms = getDriver().findElement(By.id("termsofservice"));
        elementMethods.clickElement(agreeTerms);

        WebElement checkOut = getDriver().findElement(By.id("checkout"));
        elementMethods.clickElement(checkOut);

    }
}
