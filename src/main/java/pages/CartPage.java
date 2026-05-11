package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By productName = By.cssSelector(".cart_description a");
    private By productPrice = By.xpath("//td[@class='cart_price']/p");
    private By removeBtn = By.cssSelector(".cart_quantity_delete");


    public String getCartProductName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='cart_description']//a"))
        );
        return productName.getText();
    }

    public String getCartProductPrice() {
        return getText(driver.findElement(productPrice));
    }

    public void removeProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement removeBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart_quantity_delete"))
        );
        removeBtn.click();
    }
}