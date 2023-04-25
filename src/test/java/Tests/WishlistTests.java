package Tests;

import Pages.WishlistPageMethods;
import SharedData.Hooks;
import org.testng.annotations.Test;

public class WishlistTests extends Hooks {

    @Test
    public void addAndRemoveItemsToAndFromTheWishlist(){

        //given you open the wishlist page using the toolbar selector
        WishlistPageMethods wishlistPageMethods = new WishlistPageMethods(getDriver());
        wishlistPageMethods.goToWishListFromToolbar();
        TestReport.AttachReport("pass", "The Wishlist page is opened.");

        //and the wishlist is empty
        wishlistPageMethods.checkIfWishListIsEmpty("The wishlist is empty!");
        TestReport.AttachReport("pass", "The Wishlist is empty.");

        //when you open the books page
        wishlistPageMethods.openAnItemInTheBooksPage();
        TestReport.AttachReport("pass", "The Books pages is opened and a Book is opened in detailed view mode.");

        //and you add a book to your wishlist
        wishlistPageMethods.addItemToWishlist();
        TestReport.AttachReport("pass", "The desired Book is added to the wishlist.");

        //and you open the wishlist page using the button
        wishlistPageMethods.openWishlistFromItemViewMode();
        TestReport.AttachReport("pass", "The Wishlist page is opened again from item view mode.");

        //adn you remove the item from the wishlist
        wishlistPageMethods.removeItemFromWishlist();
        TestReport.AttachReport("pass", "The Book in the wishlist is removed.");

        //then the wishlist is again empty
        wishlistPageMethods.checkIfWishListIsEmpty("The wishlist is empty!");
        TestReport.AttachReport("pass", "The Wishlist is empty.");

    }
}
