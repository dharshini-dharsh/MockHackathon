package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][]{

                // Valid login
                {"dharshinidharshu623@gmail.com", "Dharshu@2005", "valid"},

                // Invalid login
                {"wrong@gmail.com", "wrong123", "invalid"}
        };
    }

    @Test(dataProvider = "loginData")
    public void validateLogin(String email,
                              String password,
                              String type) {

        LoginPage login = new LoginPage(driver);

        login.login(email, password);

        if (type.equals("valid")) {

            Assert.assertTrue(
                    driver.getCurrentUrl().contains("automationexercise")
            );

        } else {

            Assert.assertTrue(
                    login.getErrorMessage()
                            .contains("incorrect")
            );
        }
    }
}