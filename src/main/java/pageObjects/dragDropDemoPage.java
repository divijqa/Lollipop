package pageObjects;

import base.testBase;
import comonFunctions.conditionsFunction;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.excelUtility;

import java.util.concurrent.TimeUnit;

public class dragDropDemoPage extends testBase {

   // public static TouchAction c ;

    public dragDropDemoPage(){
           PageFactory.initElements(driver, this);
    }

   /* @FindBy(AndroidUIAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))" )
    WebElement scrollView;*/

    @FindBy(xpath = "//android.widget.TextView[@text='Views']")
    WebElement textView;

    @FindBy(xpath = "//android.widget.TextView[@text='Drag and Drop']" )
    WebElement textViewTwo;

    @FindBy(xpath = "(//android.view.View)[1]")
    WebElement view1;

    @FindBy(xpath = "(//android.view.View)[2]")
    WebElement view2;

    public void dragdropFunctions(){
           //c = new TouchAction(driver);
           //driver.manage().timeouts().implicitlyWait(excelUtility.IMPLICIT_WAIT, TimeUnit.SECONDS);
           driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))");
           //driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
           textView.click();
           //driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
           textViewTwo.click();
           // c.longPress(driver.findElementById("com.example.android.apis:id/drag_dot_1")).moveTo(driver.findElementById("com.example.android.apis:id/drag_dot_2")).release().perform();
          // c.longPress(driver.findElementByXPath("(//android.view.View)[1]")).moveTo(driver.findElementByXPath("(//android.view.View)[2]")).release().perform();
           conditionsFunction.touchActionsFunction(view1, view2);
    }
}
