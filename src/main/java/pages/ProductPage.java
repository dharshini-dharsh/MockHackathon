package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;

    By searchBox = By.id("search_product");

    By searchButton = By.id("submit_search");

    By firstProduct =
            By.xpath("(//div[@class='productinfo text-center']/p)[1]");

    By addToCartButton =
            By.xpath("(//a[contains(text(),'Add to cart')])[1]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String productName) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));

        driver.findElement(searchBox).sendKeys(productName);

        driver.findElement(searchButton).click();
    }

    public String getFirstProductName() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));

        return driver.findElement(firstProduct).getText();
    }

    public void addFirstProductToCart() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", element);
    }
}