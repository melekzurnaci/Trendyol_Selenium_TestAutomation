import Base.BaseTest;
import Pages.CartPage;
import Pages.LoginPage;
import Pages.MainPage;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();


    @Test(description = "Boş sepet kontrolü")
    public void emptyCartCheck() {
        loginPage.fillEmail(email).fillPassword(password).clickLogin();
        sleep(1000);
        mainPage.clickHeaderNavigator(MY_CART);
        cartPage.checkUrl(CART_URL)
                .checkTitleOrDesc(Empty_Cart_Text, Bos_Sepet_text)
                .checkTitleOrDesc(Empty_Cart_Button_Text, Alisverise_Basla_Text);

    }

    @Test(description = "Sepete ürün ekleme")
    public void addProduct() {
        loginPage.fillEmail(email).fillPassword(password).clickLogin();
        sleep(1000);
        cartPage.addProduct(ADD_TO_CART);
        mainPage.clickHeaderNavigator(MY_CART);
        cartPage.checkUrl(CART_URL);
        sleep(3000);

    }

    @Test(description = "Sepeten ürün silme")
    public void deleteProduct() {
        loginPage.fillEmail(email).fillPassword(password).clickLogin();
        sleep(1000);
        cartPage.addProduct(ADD_TO_CART);
        mainPage.clickHeaderNavigator(MY_CART);
        cartPage.deleteProduct(DELETE_TO_CART);
        sleep(3000);

    }


}
