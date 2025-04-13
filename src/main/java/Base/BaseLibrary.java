package Base;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.ByteArrayInputStream;

public class BaseLibrary extends Data {
    public static WebDriver driver;

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public byte[] bugScreenshot(String testName) {
        byte[] screenShot = screenshot();
        String attachmentName = (testName != null && !testName.isEmpty()) ?
                testName : "Ekran Görüntüsü";

        Allure.addAttachment(attachmentName,
                "image/png",
                new ByteArrayInputStream(screenShot),
                "png");
        return screenShot;
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
