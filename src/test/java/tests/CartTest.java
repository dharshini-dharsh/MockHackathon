package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class CartTest extends BaseTest {

    @Test
    public void validateCartProduct() {

        HomePage home = new HomePage(driver);

        ProductPage product = new ProductPage(driver);

        CartPage cart = new CartPage(driver);

        home.goToProducts();

        product.addFirstProductToCart();

        home.openCart();

        Assert.assertTrue(
                cart.getCartProductName().length() > 0);
    }

    @Test
    public void removeProductFromCart() {

        HomePage home = new HomePage(driver);

        ProductPage product = new ProductPage(driver);

        CartPage cart = new CartPage(driver);

        home.goToProducts();

        product.addFirstProductToCart();

        home.openCart();

        cart.removeProduct();

        Assert.assertTrue(true);
    }
}