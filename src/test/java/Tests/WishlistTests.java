package Tests;

import PagesMethods.WishlistPageMethods;
import SharedData.SharedData;
import org.testng.annotations.Test;

public class WishlistTests extends SharedData {

    @Test
    public void addAndRemoveItemsToAndFromTheWishlist(){

        WishlistPageMethods wishlistPageMethods = new WishlistPageMethods(getDriver());

        //given you open the wishlist page using the toolbar selector
        wishlistPageMethods.goToWishListFromToolbar();

        //and the wishlist is empty
        wishlistPageMethods.checkIfWishListIsEmpty("The wishlist is empty!");

        //when you open the books page
        wishlistPageMethods.openAnItemInTheBooksPage();

        //and you add a book to your wishlist
        wishlistPageMethods.addItemToWishlist();

        //and you open the wishlist page using the button
        wishlistPageMethods.openWishlistFromItemViewMode();

        //adn you remove the item from the wishlist
        wishlistPageMethods.removeItemFromWishlist();

        //then the wishlist is again empty
        wishlistPageMethods.checkIfWishListIsEmpty("The wishlist is empty!");

    }
}
