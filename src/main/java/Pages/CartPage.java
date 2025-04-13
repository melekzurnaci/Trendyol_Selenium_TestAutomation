package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage extends BaseTest {
    @Step("URL kontrolü")
    public CartPage checkUrl(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl);
        return this;
    }

    @Step("Text kontrolü")
    public CartPage checkTitleOrDesc(String expectedText, String cssSelecto) {

        String text = driver.findElement(By.cssSelector(cssSelecto)).getText();
        Assert.assertEquals(text, expectedText);
        return this;
    }

    @Step("sepete ürün ekleme")
    public CartPage addProduct(String Locator) {

        driver.get(PRODUCT);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".overlay")
        ));
        driver.findElement(By.cssSelector(".overlay")).click();
        driver.findElement(By.cssSelector(Locator)).click();
        return this;
    }

    @Step("ürün silme")
    public CartPage deleteProduct(String Locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".onboarding-overlay")
        ));

        driver.findElement(By.cssSelector(".onboarding-overlay")).click();
        driver.findElement(By.cssSelector(Locator)).click();
        return this;
    }
}
