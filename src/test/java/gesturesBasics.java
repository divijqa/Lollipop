import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class gesturesBasics extends desiredCaps {
    public static void main (String[] args) throws MalformedURLException {

        AndroidDriver driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        TouchAction t = new TouchAction(driver);
        t.tap(driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']")).perform();
        driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
        t.press(driver.findElementByXPath("//android.widget.TextView[@text='People Names']")).waitAction(Duration.ofSeconds(3000)).release().perform();
        String Text = String.valueOf(driver.findElementById("android:id/alertTitle").getText());
        System.out.println(Text);
    }
}
