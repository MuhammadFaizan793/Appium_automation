import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {
    private static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "MyRedmi793");
        caps.setCapability("appium:udid", "502b604e");
        caps.setCapability("appium:platformVersion", "11");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage", "com.myfitnesscoach");
        caps.setCapability("appium:appActivity", "com.myfitnesscoach.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AndroidDriver(url, caps);

        System.out.println("Application Started");
    }
}
