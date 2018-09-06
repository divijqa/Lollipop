import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class desiredCaps {
    public static  AndroidDriver driver;
    public static AndroidDriver Capabilities() throws MalformedURLException {

       //public static  AndroidDriver driver;
        File f = new File("C:/Users/Divij/Desktop/APIS");
        //File fs = new File(f,"ApiDemos-debug.apk");
        File fs = new File(f,"Raaga Hindi Tamil Telugu songs and podcasts_v7.0.14_apkpure.com.apk");
       // File fs = new File(f,"com.delta.mobile.android_2018-04-04.apk");


        //capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Nexus_5X_API_26");
        capabilities.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");

        //android driver
         driver = new AndroidDriver(new
                URL("http://127.0.0.1:4723/wd/hub"),capabilities);
         return driver;

    }
}
