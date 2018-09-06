package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringObjectFactory;
import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import utility.excelUtility;
import utility.webListener;

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class testBase {

    public static AndroidDriver driver;
    public static Properties prop;
    public static File f;
    public static File fs;
    public  static EventFiringObjectFactory e_driver;
    public static webListener eventListener;

    public static void fileload() throws FileNotFoundException {

        f = new File("C:/Users/Divij/Desktop/APIS");
        fs = new File(f,"Raaga Hindi Tamil Telugu songs and podcasts_v7.0.14_apkpure.com.apk");
    }

    public static AndroidDriver capabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Nexus_5X_API_26");
        capabilities.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");

        //android driver
        try {
            driver = new AndroidDriver(new
                    URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static void intialization(){
        capabilities();
        e_driver = new EventFiringObjectFactory(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new webListener();
        e_driver.register(eventListener);
        driver = e_driver;

        /*driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(excelUtility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(excelUtility.IMPLICIT_WAIT, TimeUnit.SECONDS);*/
        driver.manage().timeouts().implicitlyWait(excelUtility.IMPLICIT_WAIT, TimeUnit.SECONDS);

    }


    }
