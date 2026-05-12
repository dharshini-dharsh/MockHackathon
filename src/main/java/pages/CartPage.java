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

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By cartProduct =
            By.xpath("//td[@class='cart_description']//a");

    By deleteBtn =
            By.xpath("//a[@class='cart_quantity_delete']");

    public String getCartProductName() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartProduct));

        return driver.findElement(cartProduct).getText();
    }

    public void removeProduct() {

        wait.until(
                ExpectedConditions.elementToBeClickable(deleteBtn));

        driver.findElement(deleteBtn).click();
    }
}