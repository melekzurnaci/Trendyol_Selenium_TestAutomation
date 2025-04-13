package Base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLibrary {

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.trendyol.com/giris");
    }

    @AfterMethod
    public void closeBrowser(ITestResult result) {
        // Test başarısız olduysa ekran görüntüsü alıyoruz.
        if (result.getStatus() == ITestResult.FAILURE) {
            bugScreenshot(result.getName());
        }
        driver.quit();
    }

}
