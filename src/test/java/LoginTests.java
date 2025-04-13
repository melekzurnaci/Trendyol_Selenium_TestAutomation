import Base.BaseTest;
import Pages.ForgotPasswordPage;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Test(description = "Başarılı kullanıcı girişi")
    public void successLogin() {
        loginPage.fillEmail(email)
                .fillPassword(password)
                .clickLogin();

        sleep(3000);
        mainPage.accountControl();

    }

    @Test(description = "Başarısız kullanıcı girişi (Hatalı şifreyle)")
    public void unsuccessLogin() {
        loginPage.fillEmail(email).fillPassword(wrongPass).clickLogin();
        sleep(3000);
        loginPage.errorMessageControl("E-posta adresiniz ve/veya şifreniz hatalı.");
    }

    @Test(description = "Başarısız kullanıcı girişi (Hatalı emaille)")
    public void unsuccessLogin02() {
        loginPage.fillEmail(wrongEmail).fillPassword(wrongPass).clickLogin();
        sleep(3000);
        loginPage.errorMessageControl("E-posta adresiniz ve/veya şifreniz hatalı.");
    }

    @Test(description = "Başarısız kullanıcı girişi(email ve şifre input alanları boş karakter)")
    public void successLogin03() {
        loginPage.fillEmail("    ").fillPassword("   ").clickLogin();
        sleep(3000);
        loginPage.errorMessageControl("Lütfen geçerli bir e-posta adresi giriniz.");
    }

    @Test(description = "Başarısız kullanıcı girişi(email ve şifre input alanları es geçilip")
    public void successLogin04() {
        loginPage.clickLogin();
        sleep(2000);
        loginPage.errorMessageControl("Lütfen geçerli bir e-posta adresi giriniz.");
    }

    @Test(description = "'sifremi unuttum' kontrolü")
    public void forgotMyPasswordCheck() {
        loginPage.clickForgotPassword();
        sleep(2000);
        forgotPasswordPage.urlControl().pageControl();

    }

}
