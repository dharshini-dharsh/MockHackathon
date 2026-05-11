package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import dataproviders.LoginDataProvider;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void validateLogin(String email, String password, String expectedResult) {

        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        login.login(email, password);

        if (expectedResult.equals("valid")) {
            Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com"));
        } else {
            Assert.assertTrue(login.getErrorMessage().toLowerCase().contains("incorrect"));
        }
    }
}