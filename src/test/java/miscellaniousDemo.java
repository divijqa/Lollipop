import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class miscellaniousDemo extends desiredCaps {

    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver.currentActivity());
        System.out.println(driver.getContext());
        System.out.println(driver.getOrientation());
        System.out.println(driver.isLocked());
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.pressKeyCode(AndroidKeyCode.HOME);
        //driver = Capabilities();


    }

    /*public static void miscellaniousDemo(){
        PageFactory.initElements(driver, this);

    }*/
}