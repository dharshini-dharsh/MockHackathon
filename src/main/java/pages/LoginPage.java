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
    By signupLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    By emailField = By.xpath("//input[@data-qa='login-email']");
    By passwordField = By.xpath("//input[@data-qa='login-password']");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");
    By errorMessage = By.xpath("//p[contains(text(),'incorrect')]");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Login method
    public void login(String email, String password) {

        wait.until(ExpectedConditions.elementToBeClickable(signupLoginBtn)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField))
                .sendKeys(email);

        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(loginBtn).click();
    }

    // Error message method
    public String getErrorMessage() {

        WebElement error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMessage));

        return error.getText();
    }
}