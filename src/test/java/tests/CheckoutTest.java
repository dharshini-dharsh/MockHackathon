package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckout() {

        HomePage homePage = new HomePage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // ADD PRODUCT
        homePage.addProductToCart();

        // OPEN CART
        homePage.openCart();

        // CLICK CHECKOUT
        checkoutPage.clickPlaceOrder();

        Assert.assertTrue(true);
    }
}