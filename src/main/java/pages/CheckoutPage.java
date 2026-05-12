package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By checkoutBtn =
            By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    public void clickPlaceOrder() {

        wait.until(
                ExpectedConditions.elementToBeClickable(checkoutBtn));

        driver.findElement(checkoutBtn).click();
    }
}