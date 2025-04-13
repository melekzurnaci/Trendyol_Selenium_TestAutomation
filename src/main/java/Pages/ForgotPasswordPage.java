package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ForgotPasswordPage extends BaseTest {

    @Step("'Sifremi unuttum' alanı url kontrolü")
    public ForgotPasswordPage urlControl() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.trendyol.com/sifremiunuttum");
        return this;
    }

    @Step("Sayfada title ve description kontrolü")
    public ForgotPasswordPage pageControl() {
        String title = driver.findElements(By.cssSelector(".change-password-info .title")).get(0).getText();
        Assert.assertEquals(title, "Şifre Yenileme");
        String desc = driver.findElements(By.cssSelector(".change-password-info .desc")).get(0).getText();
        Assert.assertEquals(desc, "Şifre yenileme bağlantısını gönderebilmemiz için e-posta adresinize ihtiyacımız var.");
        screenshot();
        return this;
    }
}
