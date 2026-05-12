package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][] {

                {"test@gmail.com", "12345", "valid"},
                {"wrong@gmail.com", "wrong123", "invalid"}

        };
    }

    @Test(dataProvider = "loginData")
    public void validateLogin(String email,
                              String password,
                              String type) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(email, password);

        boolean status = loginPage.isLoginSuccessful();

        if(type.equalsIgnoreCase("valid")) {

            Assert.assertTrue(status);

        } else {

            Assert.assertFalse(status);
        }
    }
}