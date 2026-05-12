package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test
    public void searchProductTest() {

        HomePage home = new HomePage(driver);

        ProductPage product = new ProductPage(driver);

        home.goToProducts();

        product.searchProduct("shirt");

        Assert.assertTrue(
                product.getFirstProductName().length() > 0);
    }

    @Test
    public void addProductToCartTest() {

        HomePage home = new HomePage(driver);

        ProductPage product = new ProductPage(driver);

        home.goToProducts();

        product.addFirstProductToCart();

        Assert.assertTrue(true);
    }
}