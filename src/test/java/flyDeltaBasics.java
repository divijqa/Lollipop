import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class flyDeltaBasics {
    public static void main (String[] args) throws MalformedURLException {

        AndroidDriver driver = desiredCaps.Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
}
