package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By emailField = By.xpath("//input[@data-qa='login-email']");
    By passwordField = By.xpath("//input[@data-qa='login-password']");
    By loginButton = By.xpath("//button[@data-qa='login-button']");
    By logoutButton = By.xpath("//a[contains(text(),'Logout')]");

    // Fixed Error Locator
    By errorMessage = By.xpath("//p[contains(text(),'Your email or password is incorrect')]");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Login Method
    public void login(String email, String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    // Get Error Message
    public String getErrorMessage() {
        try {
            WebElement error = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector(".alert-danger")
                    )
            );
            return error.getText();

        } catch (Exception e) {
            return "No error message found";
        }
    }

    public boolean isLoginSuccessful() {

        try {

            return driver.findElement(logoutButton).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }
}