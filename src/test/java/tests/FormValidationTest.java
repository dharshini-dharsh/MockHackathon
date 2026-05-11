package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;

public class FormValidationTest extends BaseTest {

    @Test
    public void emptyLoginValidation() {

        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        login.login("", "");

        Assert.assertTrue(login.getErrorMessage().length() > 0);
    }
}