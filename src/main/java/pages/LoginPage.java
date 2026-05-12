package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locators

    By loginLink =
            By.xpath("//a[contains(text(),'Signup / Login')]");

    By emailField =
            By.xpath("//input[@data-qa='login-email']");

    By passwordField =
            By.xpath("//input[@data-qa='login-password']");

    By loginButton =
            By.xpath("//button[contains(text(),'Login')]");

    // fixed locators (more stable than full sentence match)
    By errorMessage =
            By.xpath("//p[contains(text(),'Your email') or contains(text(),'incorrect')]");

    By logoutBtn =
            By.xpath("//a[contains(text(),'Logout')]");

    // action methods

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    // login flow

    public void login(String email, String password) {
        clickLogin();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    // Error validation

    public String getErrorMessage() {

        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(errorMessage)
            ).getText();
        } catch (Exception e) {
            return "ERROR MESSAGE NOT FOUND";
        }
    }

    // Logout

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
    }
}