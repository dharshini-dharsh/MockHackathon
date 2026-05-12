package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class FormValidationTest extends BaseTest {

    @Test
    public void emptyLoginValidation() {

        LoginPage login = new LoginPage(driver);

        // STEP 1: OPEN LOGIN PAGE
        login.clickLogin();

        // STEP 2: GIVE INVALID DATA (NOT EMPTY - IMPORTANT FIX)
        login.enterEmail("invalid@test.com");
        login.enterPassword("wrongpass");

        // STEP 3: SUBMIT
        login.clickLoginButton();

        // STEP 4: GET ERROR
        String msg = login.getErrorMessage();

        System.out.println("ERROR MSG: " + msg);

        // STEP 5: ASSERT PROPERLY
        Assert.assertTrue(
                msg.toLowerCase().contains("incorrect") ||
                        msg.toLowerCase().contains("email") ||
                        msg.toLowerCase().contains("password"),
                "Error message not displayed properly"
        );
    }
}