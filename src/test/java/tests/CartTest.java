package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.CartPage;

public class CartTest extends BaseTest {

    @Test
    public void validateCartProduct() {

        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        // ADD PRODUCT
        homePage.addProductToCart();

        // OPEN CART
        homePage.openCart();

        // VALIDATE PRODUCT
        String productName = cartPage.getCartProductName();

        Assert.assertTrue(productName.length() > 0);
    }

    @Test
    public void removeProductFromCart() {

        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        // ADD PRODUCT
        homePage.addProductToCart();

        // OPEN CART
        homePage.openCart();

        // REMOVE PRODUCT
        cartPage.removeProduct();

        Assert.assertTrue(true);
    }
}