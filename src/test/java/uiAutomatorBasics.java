import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class uiAutomatorBasics extends desiredCaps{

    public static void main (String[] args) throws MalformedURLException {

        AndroidDriver driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElementsByAndroidUIAutomator("attribute(\"value\")");
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        //validate clickable feature for all options
        //driver.findElementsByAndroidUIAutomator("new UISelector().property(value)");
        //System.out.println(driver.findElementsByAndroidUIAutomator("new UISelector().clickable(true)").size());
        driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();


    }
}
