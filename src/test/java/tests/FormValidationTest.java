package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class FormValidationTest extends BaseTest {

    @Test
    public void emptyLoginValidation() {

        LoginPage login = new LoginPage(driver);

        // open login page
        login.clickLogin();

        // STEP 2: GIVE INVALID DATA (NOT EMPTY - IMPORTANT FIX)
        login.enterEmail("invalid@test.com");
        login.enterPassword("wrongpass");

        // submit
        login.clickLoginButton();

        // get error
        String msg = login.getErrorMessage();

        System.out.println("ERROR MSG: " + msg);

        // assert properly
        Assert.assertTrue(
                msg.toLowerCase().contains("incorrect") ||
                        msg.toLowerCase().contains("email") ||
                        msg.toLowerCase().contains("password"),
                "Error message not displayed properly"
        );
    }
}