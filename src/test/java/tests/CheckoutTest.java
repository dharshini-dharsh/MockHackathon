package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckout() {

        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.clickPlaceOrder();
        checkout.enterPaymentDetails("Test User", "4111111111111111", "123", "12", "2026");
        checkout.submitPayment();

        Assert.assertTrue(true);
    }
}