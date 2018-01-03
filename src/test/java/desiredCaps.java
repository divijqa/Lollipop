import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class desiredCaps {

    public static AndroidDriver Capabilities() throws MalformedURLException {

        AndroidDriver driver;
        File f = new File("C:/Users/Divij/Desktop");
        File fs = new File(f,"ApiDemos-debug.apk");

        //capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel API 25");
        capabilities.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
        capabilities.setCapability("platformVersion", "7.1.1");
        capabilities.setCapability("platformName", "Android");

        //android driver
         driver = new AndroidDriver(new
                URL("http://127.0.0.1:4723/wd/hub"),capabilities);
         return driver;
    }
}
