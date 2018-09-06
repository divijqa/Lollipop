import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class swipeDemo extends desiredCaps {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        AndroidDriver driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TouchAction a =new TouchAction(driver);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        driver.findElementByXPath("//*[@content-desc='9']").click();
       // Thread.sleep(2000);
        a.press(driver.findElementByXPath("//*[@content-desc='15']")).waitAction(Duration.ofSeconds(3000)).moveTo(driver.findElementByXPath("//*[@content-desc='45']")).release().perform();
    }
}