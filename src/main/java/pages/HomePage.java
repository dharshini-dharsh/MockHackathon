package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By productsBtn = By.xpath("//a[contains(text(),'Products')]");
    By cartBtn = By.xpath("//a[contains(text(),'Cart')]");
    By loginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");

    public void goToProducts() {
        driver.findElement(productsBtn).click();
    }

    public void openCart() {
        driver.findElement(cartBtn).click();
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
}