package testCases;

import base.testBase;
import email.sendEmailReport;
import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import pageObjects.dragDropDemoPage;

import static pageObjects.dragDropDemoPage.*;

public class basicTest extends testBase {

    dragDropDemoPage demoPageClass;

    public basicTest(){
        super();
    }

    @BeforeMethod
    public  void setup(){
        intialization();
    }
    @Test
    public void touchActions(){
        demoPageClass.dragdropFunctions();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @AfterSuite
    public void sendemail(){
        sendEmailReport.sendEmailReportTo();

    }
}
