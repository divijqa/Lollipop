import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ragaBasics extends desiredCaps {
    public static void main (String[] args) throws MalformedURLException, InterruptedException {

        AndroidDriver driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.pressKeyCode(AndroidKeyCode.BACK);
        Thread.sleep(3000);
       // driver.findElementByXPath("//android.widget.TextView[@text='Skip']").click();
        //driver.findElementById("com.raaga.android:id/Skip").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"World Music\"))");
        driver.findElementByXPath("//android.widget.TextView[@text='World Music']").click();
       // driver.findElementByXPath("//android.widget.TextView[@text='Maybe Later']").click();
        Thread.sleep(3000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"com.raaga.android:id/music_home_raaga_live\"))");
        driver.findElementById("com.raaga.android:id/music_home_raaga_live").click();

    }
}
