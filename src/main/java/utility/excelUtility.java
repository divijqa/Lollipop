package utility;

import base.testBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class excelUtility extends testBase {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;

    public static String TESTDATA_SHEET_PATH = "/Users/Divij/workspace"
            + "/sers/src/main/java/gov/pa/cw/sers/testdata/GeicoTestData.xlsx";

    static Workbook book;
    static Sheet sheet;


    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");
    }

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
//				prop = new Properties();
//				FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/gov/pa/cw"
//						+ "/sers/config/config.properties");
//				prop.load(ip);
//			if(prop.getProperty("env").toString().equals("dev")){
//				file = new FileInputStream("/sers/src/main/java/gov/pa/cw/sers/testdata/FreeCrmTestDatadev.xlsx");
//			}if(prop.getProperty("env").toString().equals("uat")){
//				file = new FileInputStream("/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx");
//			}
            //file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        // System.out.println(sheet.getLastRowNum() + "--------" +
        // sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                // System.out.println(data[i][k]);
            }
        }
        return data;
    }

    public static void takeScreenshotAtEndOfTest() {
        //File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String currentDir = System.getProperty("user.dir");

        //FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
        try {
            FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + "screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
