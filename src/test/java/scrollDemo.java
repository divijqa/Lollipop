import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class scrollDemo extends desiredCaps {

    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))");
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
//        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
//        driver.findElementByXPath("//android.widget.TextView[@text='WebView']").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"))");
        driver.findElementByXPath("//android.widget.TextView[@text='Radio Group']").click();

    }
}
