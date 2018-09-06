import base.testBase;
import email.sendEmailReport;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import pageObjects.dragDropDemoPage;
import utility.excelUtility;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class dragdropDemo extends testBase {
   /* public static void main(String[] args) throws MalformedURLException {

        //AndroidDriver driver = Capabilities();
        TouchAction c = new TouchAction(driver);
        // driver.get("http://google.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))");
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
       // c.longPress(driver.findElementById("com.example.android.apis:id/drag_dot_1")).moveTo(driver.findElementById("com.example.android.apis:id/drag_dot_2")).release().perform();
        c.longPress(driver.findElementByXPath("(//android.view.View)[1]")).moveTo(driver.findElementByXPath("(//android.view.View)[2]")).release().perform();
    }*/

    public dragdropDemo(){
        super();
    }

    @BeforeMethod
    public static void setup(){
        intialization();
    }
    @Test
    public static void touchActions(){
        dragDropDemoPage.dragdropFunctions();
    }

    @AfterMethod
    public static void teardown(){
        driver.quit();
    }

    @AfterSuite
    public void sendemail(){
        sendEmailReport.sendEmailReportTo();

    }
}
