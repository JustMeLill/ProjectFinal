package Tests;

import HelpMethods.ElementMethods;
import Pages.CartPageMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ShoppingCartTests extends SharedData {

    @Test
    public void addItemsToTheShoppingCart(){

        CartPageMethods cartPageMethods = new CartPageMethods(getDriver());
        ElementMethods elementMethods = new ElementMethods(getDriver());

        //given you open the notebooks list
        cartPageMethods.goToNotebooksAndApplySorting();

        //and you add an item to the cart
        elementMethods.waitElementVisibleWithStaleness(getDriver().findElement(By.cssSelector(".picture>a")));
        cartPageMethods.openNotebook();

        //and you open the shopping cart page
        cartPageMethods.openShoppingCart();

        //and you click the continue shopping button
        cartPageMethods.continueShopping();

        //and you open the phones list
        cartPageMethods.goToPhonesAndApplySorting();

        // and you add an item to the cart
        elementMethods.waitElementVisibleWithStaleness(getDriver().findElement(By.xpath("//a[@title='Show details for Nokia Lumia 1020']")));
        cartPageMethods.openPhone();

        //when you return to the shopping cart
        cartPageMethods.openShoppingCart();

        //then you can proceed to checkout
        cartPageMethods.proceedWithCheckout();


    }

}
