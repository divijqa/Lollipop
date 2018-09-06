import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class basics extends desiredCaps {

    /*
       xpath syntax
       //tagName[@attribute='value']
       //example

     */
    public static void main (String[] args) throws MalformedURLException {

        AndroidDriver driver = Capabilities();
       // driver.get("http://google.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.findElement(By.name("q")).sendKeys("Delta Airlines");
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("JUBERT91_2GEXT");
        //driver.findElementsByClassName("android.widget.Button").get(1).click();
        driver.findElementByXPath("(//android.widget.Button)[1]").click();

    }

}
