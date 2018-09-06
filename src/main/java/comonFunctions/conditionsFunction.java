package comonFunctions;

import base.testBase;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;

public class conditionsFunction extends testBase {

    public static  TouchAction c;

    public static void touchActionsFunction(WebElement element, WebElement element2){

        c = new TouchAction(driver);
        c.longPress(element).moveTo(element2).release().perform();

    }
}
