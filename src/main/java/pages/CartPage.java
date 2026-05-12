package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By productName = By.xpath("//td[@class='cart_description']//a");

    By deleteBtn = By.xpath("//a[contains(@class,'cart_quantity_delete')]");

    public String getCartProductName() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productName)
        ).getText();
    }

    public void removeProduct() {

        wait.until(
                ExpectedConditions.elementToBeClickable(deleteBtn)
        ).click();
    }
}