package Tests;

import Pages.CartPageMethods;
import SharedData.Hooks;
import org.testng.annotations.Test;

public class ShoppingCartTests extends Hooks {

    @Test
    public void addItemsToTheShoppingCart(){

        //given you open the notebooks list
        CartPageMethods cartPageMethods = new CartPageMethods(getDriver());
        cartPageMethods.goToNotebooksAndApplySorting();
        TestReport.AttachReport("pass", "The Nootebooks list is opened and a sorting action is performed.");

        //and you add an item to the cart
        cartPageMethods.openNotebook();
        TestReport.AttachReport("pass", "The desired Notebook is opened in detailed view mode and added to the shopping cart.");

        //and you open the shopping cart page
        cartPageMethods.openShoppingCart();
        TestReport.AttachReport("pass", "The shopping cart is opened and the added notebook is visible in the list.");

        //and you click the continue shopping button
        cartPageMethods.continueShopping();
        TestReport.AttachReport("pass", "The shopping cart is closed so the user can continue shopping.");

        //and you open the phones list
        cartPageMethods.goToPhonesAndApplySorting();
        TestReport.AttachReport("pass", "The Phones list is opened and a sorting action is performed.");

        // and you add an item to the cart
        cartPageMethods.openPhone();
        TestReport.AttachReport("pass", "The desired Phone is opened in detailed view mode and added to the shopping cart.");

        //when you return to the shopping cart
        cartPageMethods.openShoppingCart();
        TestReport.AttachReport("pass", "The shopping cart is opened and the added notebook is visible in the list, along with the previously added Notebook.");

        //then you can proceed to checkout
        cartPageMethods.proceedWithCheckout();
        TestReport.AttachReport("pass", "The checkout page is accessed successfully.");


    }

}
