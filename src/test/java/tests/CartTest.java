package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {
    @Test
    public void openCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");

        productsPage.addToCart();
        productsPage.cartLinkBtn();

        Assert.assertTrue(cartPage.isPageOpened());
    }
}
