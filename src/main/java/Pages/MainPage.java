package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class MainPage extends BaseTest {

    @Step("Hesap bilgisi kontrol edilir")
    public MainPage accountControl() {
        String text = driver.findElements(By.cssSelector("[class='link-text']")).get(0).getText();
        Assert.assertEquals(text, "Hesabım");
        screenshot();
        return this;
    }

    @Step("Header menü linklerine tıklanır.")
    public MainPage clickHeaderNavigator(String cssSelector) {
        driver.findElement(By.cssSelector(cssSelector)).click();
        return this;
    }

    @Step("Search ile ürün arama")
    public MainPage fillSearch(String productKey) {
        driver.findElement(By.cssSelector(SEARCH_LOCATOR)).sendKeys(productKey + Keys.ENTER);
        sleep(1000);
        return this;
    }

    @Step("Marka Filtreleme")
    public MainPage filterBrand(String brandName) {
        driver.findElements(By.cssSelector(FILTER_BRAND)).get(1).sendKeys(brandName);
        driver.findElements(By.cssSelector("#sticky-aggregations > div > div:nth-child(3) > div.fltrs")).get(0).click();
        driver.findElements(By.cssSelector(PRODUCT_LIST_LOCATOR)).get(3).click();
        sleep(3000);
        return this;
    }

    @Step("Onboarding geç")
    public MainPage home() {
        driver.get("https://www.trendyol.com/");
        return this;
    }



}
