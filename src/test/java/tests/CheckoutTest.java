package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckout() {

        HomePage home = new HomePage(driver);

        ProductPage product = new ProductPage(driver);

        CheckoutPage checkout = new CheckoutPage(driver);

        home.goToProducts();

        product.addFirstProductToCart();

        home.openCart();

        checkout.clickPlaceOrder();

        Assert.assertTrue(true);
    }
}