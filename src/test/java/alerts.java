import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v137.filesystem.model.File;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class alerts {
    private static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "MyRedmi793");
        caps.setCapability("appium:udid", "502b604e");
        caps.setCapability("appium:platformVersion", "11");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("browserName", "Chrome");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, caps);

        System.out.println("Application Started");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
        driver.get("website url");

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"alert1\"]")).click();

        // Handle alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        System.out.println("All test executed");

        driver.activateApp("com.whatsapp");
        driver.activateApp("com.android.camera");


        new TouchAction(driver)
                .press(PointOption.point(500, 1000))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(500, 200))
                .release()
                .perform();
        driver.installApp("C:\\Apps\\demo.apk");
        driver.removeApp("com.example.demo");

// wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn")));

    }
}