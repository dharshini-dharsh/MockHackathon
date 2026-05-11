package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By email = By.xpath("//input[@data-qa='login-email']");
    private By password = By.xpath("//input[@data-qa='login-password']");
    private By loginBtn = By.xpath("//button[@data-qa='login-button']");
    private By errorMsg = By.xpath("//p[contains(text(),'incorrect')]");

    public void login(String userEmail, String userPassword) {
        type(driver.findElement(email), userEmail);
        type(driver.findElement(password), userPassword);
        click(driver.findElement(loginBtn));
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Incorrect')]"))
        );
        return error.getText();
    }

}