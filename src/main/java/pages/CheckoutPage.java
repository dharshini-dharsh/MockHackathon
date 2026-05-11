package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private By placeOrderBtn = By.xpath("//a[contains(text(),'Place Order')]");
    private By nameOnCard = By.name("name_on_card");
    private By cardNumber = By.name("card_number");
    private By cvc = By.name("cvc");
    private By expiryMonth = By.name("expiry_month");
    private By expiryYear = By.name("expiry_year");
    private By payBtn = By.id("submit");

    public void clickPlaceOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement placeOrder = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Place Order')]"))
        );
        placeOrder.click();
    }

    public void enterPaymentDetails(String name, String number, String cvcVal, String month, String year) {
        type(driver.findElement(nameOnCard), name);
        type(driver.findElement(cardNumber), number);
        type(driver.findElement(cvc), cvcVal);
        type(driver.findElement(expiryMonth), month);
        type(driver.findElement(expiryYear), year);
    }

    public void submitPayment() {
        click(driver.findElement(payBtn));
    }
}