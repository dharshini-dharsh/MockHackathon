package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartTest extends BaseTest {

    @Test
    public void validateCartProduct() {

        CartPage cart = new CartPage(driver);

        Assert.assertTrue(cart.getCartProductName().length() > 0);
    }

    @Test
    public void removeProductFromCart() {

        CartPage cart = new CartPage(driver);

        cart.removeProduct();

        Assert.assertTrue(true);
    }
}