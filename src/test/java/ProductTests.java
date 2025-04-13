import Base.BaseTest;
import Pages.MainPage;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest
{
    MainPage mainPage = new MainPage();

    @Test(description = "ürün arama çubuğuyla ürün arama ve filtreleme")
    public void filterProduct () {
        mainPage.home().fillSearch(Key).filterBrand("Samsung");
    }
}
