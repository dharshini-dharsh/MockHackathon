package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    // LOCATORS
    By productsButton = By.xpath("//a[@href='/products']");
    By cartButton = By.xpath("//a[@href='/view_cart']");
    By loginButton = By.xpath("//a[@href='/login']");
    By addToCartButton = By.xpath("(//a[contains(text(),'Add to cart')])[1]");

    // METHODS

    public void goToProducts() {

        driver.findElement(productsButton).click();
    }

    public void openCart() {

        driver.findElement(cartButton).click();
    }

    public void clickLogin() {

        driver.findElement(loginButton).click();
    }

    public void addProductToCart() {

        driver.findElement(addToCartButton).click();
    }
}