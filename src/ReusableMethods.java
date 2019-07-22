import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReusableMethods {
	
	static WebDriver driver;
	static ExtentTest logger;
	static ExtentReports report;
	
	/*
	 * Name of the Method: createTestScriptReport
	 * Brief Description: Creates Reports and Logs the status
	 * Arguments: TestScriptName-->Testcase name to be executed.
	 * Created by: Automation Team
	 * Creation Date: July 15 2019
	 * Last Modified: July 15 2019
	 * 
	 */
	
	public static ExtentTest createTestScriptReport(String TestScriptName) {
		
		String fileName = new SimpleDateFormat("'SampleDemo_'yyyyMMddHHmmss'.html'").format(new Date());
		String path = "C:\\myProject\\ExtentReport\\"+fileName;
		report = new ExtentReports(path);
		
		logger = report.startTest(TestScriptName);
		return logger;
	}
	
	/*
	 * Name of the Method: initializeDriver
	 * Brief Description: Initialize web browser driver to perform automation
	 * Created by: Automation Team
	 * Creation Date: July 15 2019
	 * Last Modified: July 15 2019
	 * 
	 */
	
	public static void initializeDriver() {
		
		//For Chrome driver
		String chromeDriverPath = "C:\\myProject\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		
//		//For Firefox driver
//		String fireFoxDriverPath = "C:\\myProject\\drivers\\geckodriver.exe";
//		System.setProperty("webdriver.gecko.driver", fireFoxDriverPath);
//		WebDriver driver;
//		driver = new FirefoxDriver();
		
		System.out.println("PASS: Driver Initialized");
		logger.log(LogStatus.INFO, "Driver Initialized");
	}

	/*
	 * Name of the Method: launchURL
	 * Brief Description: Launch Application to perform Automation
	 * Created by: Automation Team
	 * Creation Date: July 15 2019
	 * Last Modified: July 15 2019
	 * 
	 */
	
	public static void launchURL() {
		//initializeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		System.out.println("PASS: URL Launched");
		logger.log(LogStatus.INFO, "URL Launched");
	}
	
	
	/*
	 * Name of the Method: enterText
	 * Brief Description: Enter text into the TextBox
	 * Arguments: obj---> Web Object, text--> Text to be entered, objName-->Name of the Object
	 * Created by: Automation Team
	 * Creation Date: July 15 2019
	 * Last Modified: July 15 2019
	 * 
	 */
	
	public static void enterText(WebElement obj, String text, String objName) throws InterruptedException {
		if(obj.isEnabled()) {
			Thread.sleep(3000);
			obj.sendKeys(text);
			System.out.println("PASS: " + text + " is entered in " +objName+ " field.");
			logger.log(LogStatus.PASS, text + " is entered in " +objName+ " field.");
		}else {
			System.out.println("FAIL: " + objName + " is not Enabled. Please check the Application.");
			logger.log(LogStatus.FAIL, objName + " is not Enabled. Please check the Application.");
		}
	}
	
	/*
	 * Name of the Method: clickButton
	 * Brief Description: Click on the Button
	 * Arguments: obj---> Web Object, objName-->Name of the Object
	 * Created by: Automation Team
	 * Creation Date: July 15 2019
	 * Last Modified: July 15 2019
	 * 
	 */
	
	public static void clickButton(WebElement obj, String objName) {
		if(obj.isEnabled()) {
			obj.click();
			System.out.println("PASS: " + objName + " is Clicked");
			logger.log(LogStatus.PASS, objName + " is Clicked");
			
		}else {
			System.out.println("FAIL: " + objName + " is not getting Clicked. Please check the Application.");
			logger.log(LogStatus.FAIL, objName + " is not getting Clicked. Please check the Application.");
		}
	}
	
	/*
	 * Name of the Method: validateTextMessage
	 * Brief Description: compares actual message and expected message
	 * Arguments: obj---> Web Object, expectedMessage-->Expected message of testcase, objName-->Name of the Object
	 * Created by: Automation Team
	 * Creation Date: July 15 2019
	 * Last Modified: July 15 2019
	 * 
	 */
	public static void validateTextMessage(WebElement obj, String expectedMessage, String objName) {
		String actualMessage = null;
		if(obj.isEnabled()) {
			actualMessage = obj.getText();
			if(actualMessage.equals(expectedMessage)) {
				System.out.println("PASS: Actual Message " +actualMessage+ " is equal to Expected Message "+expectedMessage);
				logger.log(LogStatus.PASS, "Actual Message " + actualMessage + " is equal to Expected Message "+expectedMessage);
			}else {
				System.out.println("FAIL: Actual Message " +actualMessage+ " is not equal to Expected Message "+expectedMessage);
				logger.log(LogStatus.FAIL, "Actual Message "+ actualMessage + " is not equal to Expected Message " +expectedMessage);
			}
			//System.out.println("PASS: "+ obj +" is enabled.");
			//logger.log(LogStatus.PASS, obj + " is enabled");
		}else {
			System.out.println("FAIL: "+ obj +" is not enabled. Couldn't get the message");
			logger.log(LogStatus.FAIL, obj + " is not enabled. Couldn't get the message");
		}
	}
	
	/*
	 * Name of the Method: selectCheckBox
	 * Brief Description: To select a checkbox
	 * Arguments: obj---> Web Object, objName-->Name of the Object
	 * Created by: Automation Team
	 * Creation Date: July 15 2019
	 * Last Modified: July 15 2019
	 * 
	 */
	
	public static void selectCheckBox(WebElement obj, String objName) {
		if(obj.isEnabled()) {
			obj.click();
			System.out.println("PASS: Checkbox " +objName+ " is Selected");
			logger.log(LogStatus.PASS, "Checkbox " +objName+ " is Selected");
		}else {
			System.out.println("FAIL: Checkbox " +objName+ " is not getting Selected. Please check the Application.");
			logger.log(LogStatus.FAIL, "Checkbox " +objName+ " is not getting Selected. Please check the Application.");
		}
		
	}
	
	
	/*
	 * Name of the Method: deSelectCheckBox
	 * Brief Description: Uncheck a checkbox
	 * Arguments: obj---> Web Object, objName-->Name of the Object
	 * Created by: Automation Team
	 * Creation Date: July 15 2019
	 * Last Modified: July 15 2019
	 * 
	 */
	public static void deSelectCheckBox(WebElement obj, String objName) {
		if(obj.isEnabled() && obj.isSelected()) {
			obj.click();
			System.out.println("PASS: Checkbox " +objName+ " is Unchecked");
			logger.log(LogStatus.PASS, "Checkbox " +objName+ " is Unchecked");
		}else {
			System.out.println("FAIL: Checkbox " +objName+ " is not getting Unchecked. Please check the Application.");
			logger.log(LogStatus.FAIL, "Checkbox " +objName+ " is not getting Unchecked. Please check the Application.");
		}
		
	}
	
	/*
	 * Name of the Method: clickLink
	 * Brief Description: Click on the Link Text
	 * Arguments: obj---> Web Object, objName-->Name of the Object
	 * Created by: Automation Team
	 * Creation Date: July 15 2019
	 * Last Modified: July 15 2019
	 * 
	 */
	
	public static void clickLink(WebElement obj, String objName) {
		if(obj.isEnabled()) {
			obj.click();
			System.out.println("PASS: " +objName+ " is Clicked");
			logger.log(LogStatus.PASS, objName + " is Clicked");
		}else {
			System.out.println("FAIL: " +objName+ " is not getting Clicked. Please check the Application.");
			logger.log(LogStatus.FAIL, objName + " is getting Clicked. Please check the Application.");
		}
	}
	
	/* name of the method:   clickobject--->Button
	 * BriefDescription  :   clicking a button
	 * Arguments         :  obj-->object,objName--->object name
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */
	
	public static void clickObj(WebElement obj,String objName)
	{
		if(obj.isDisplayed())
		{
			obj.click();
			System.out.println("pass :" +objName + "button is clicked");
			logger.log(LogStatus.PASS, objName + "button is clicked");
		}
		else
		{
			System.out.println("Fail:" +objName+"button is not displayed ,please check the application");
			logger.log(LogStatus.FAIL, objName+ "button is not displayed ,please check the application");
		}
	}
	
	public static void selectDropdown(WebElement obj, String objName) {
		
		if(obj.isDisplayed())
		{
			if(obj.isSelected())
			{
				System.out.println("Pass: "+objName+" is already selected");
			}else
			{
				obj.click();
				System.out.println("Pass: "+objName+" is selected");
				logger.log(LogStatus.PASS, objName + " is selected");
			}
		}else
		{
			System.out.println("Fail:"+objName+" is not present.Please chk application.");	
			logger.log(LogStatus.FAIL, objName+ " is not present, please check the application.");
		}	
			
	}
	
	
	/* name of the method:   iFrame
	 * BriefDescription  :   iframe using webelement 
	 * Arguments         :  driver--->driver 
	 *                      obj--->webelement
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */
	
	public static void switchFrame( WebDriver driver,WebElement obj) {
		 
	    if(obj.isDisplayed()) {
	     driver.switchTo().frame(obj);
	     System.out.println("Pass: we can switch to the "+obj+ " frame");
	     logger.log(LogStatus.PASS,  "Switch to frame" );
	     
	    }else {
	     System.out.println("fail: we can't switch to the "+obj+ " frame");
	     logger.log(LogStatus.FAIL,  "Cannot Switch to frame" );
	    }
	}
	
	/* name of the method:   switchFrameid
	 * BriefDescription  :   iframe using webelement 
	 * Arguments         :  driver--->driver 
	 *                      obj--->iframe id
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */

	public static void switchFrameid( WebDriver driver,String obj) {
		 
	     driver.switchTo().frame(obj);
	     System.out.println("Pass: we can switch to the "+obj+ " frame");
	     logger.log(LogStatus.PASS,  "we can switch to the frame" );
	     
	    }

	/* name of the method:   switchdefaultFrame
	 * BriefDescription  :   iframe for switching back to default frame 
	 * Arguments         :  driver--->driver 
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 
	public static void switchdefaultFrame( WebDriver driver)
	{
	driver.switchTo().defaultContent();
	System.out.println("Pass: we can switch to the "+ driver + " back to frame");
	logger.log(LogStatus.PASS,  "we can switch back to the frame" );
	}

	/* name of the method:   mouseOver
	 * BriefDescription  :   mouseOver  
	 * Arguments         :  obj,index 
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 

	public static void mouseOver(WebDriver driver,WebElement obj) {
		if(obj.isDisplayed()) {
	   Actions action=new Actions(driver);
	   action.moveToElement(obj).build().perform();
		System.out.println("Pass: "+obj+" is present");
		logger.log(LogStatus.PASS,  "obj is present" );
		}
	 else {
			System.out.println("Fail:"+obj+" is not present.Please chk application");
			logger.log(LogStatus.FAIL,  "obj is not present.Please chk application" );
		}
	}

	/* name of the method:   selectbyText
	 * BriefDescription  :   selected by clicking the dropdown 
	 * Arguments         :  obj,objName 
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 
	public static void SelectbyText(WebElement we, String VisibleText){
		   if(we.isDisplayed())
		   {
			   Select selObj=new Select(we);
	           selObj.selectByVisibleText(VisibleText);
		           System.out.println("Pass: "+VisibleText+ " is Selected by VisibleText" );
		           logger.log(LogStatus.PASS, " is Selected by VisibleText" );
		           
		   } 
		   else
		   {
		    System.out.println("Fail: "+VisibleText+ " is not available");
		    logger.log(LogStatus.FAIL, " is not Selected by VisibleText" );
		    
		   }
		   
		   
	}

	/* name of the method:   SelectByValue
	 * BriefDescription  :   selectedByValue by clicking the dropdown 
	 * Arguments         :  obj,index 
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 
	public static void SelectByValue(WebElement obj, String val) {
		  //if(obj.isSelected()) {
		if(obj.isDisplayed()) {
		   Select selObj=new Select(obj);
		    
		   selObj.selectByValue(val);
		  System.out.println("pass:"+val + " is selected from drop down ");
		  logger.log(LogStatus.PASS, " is selected from drop down " );
		 
		  }else {
		   System.out.println("Fail:"+val+"is not selected");
		   logger.log(LogStatus.FAIL, " is not selected from drop down " );
		  }
		 }	  


	/* name of the method:   SelectByindex
	 * BriefDescription  :   selected by clicking the dropdown 
	 * Arguments         :  obj,index 
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 
	public static void selectByIndex(WebElement obj, int index) {
		  if(obj.isDisplayed()) {
		   Select selObj=new Select(obj);
		  selObj.selectByIndex(index);
		  
		  System.out.println("pass:"+index + " is selected from drop down ");
		  logger.log(LogStatus.PASS, " is selected from drop down " );
		  }else {
		   System.out.println("Fail:"+index+"is not selected");
		   logger.log(LogStatus.FAIL, " is not selected from drop down " );
		  }
		 }

	public static void selectByVisibleText(WebElement obj, String Name) {
		if(obj.isDisplayed()) {
			 Select drop = new Select(obj);
			 drop.selectByVisibleText(Name);
		 System.out.println("Pass: dropdown is selected");
		 }else {
		 System.out.println("Fail: dropdown is not available check your application");
		 }
		 }



	/*
	 * Name of the method: Radiobutton
	 * Brief Description: To click on the radio button 
	 * Arguments: obj --> web object, objName--> name of the object
	 * Created by: Automation team
	 * Creation Date: Feb 12 2019
	 * Last Modified: Feb 12 2019
	 * */
	public static void Radiobutton(WebElement obj, String objName) {
		
		if(obj.isDisplayed() ){
			obj.click();
			System.out.println("Pass: "+objName+" is clicked");
		}else {
			System.out.println("Fail:"+objName+" is not displayed .Please check your application");			
		}
	}

	/* name of the method:   switchtoAlert
	 * BriefDescription  :   Switch to alert
	 * Arguments         :  driver
	 *  createdby        :  Automation team 
	 *  created date     :02/13/19 
	 *  LastModified Date:02/13/19          
	 */ 
	public static void switchtoAlert(WebDriver driver) {
		 driver.switchTo().alert().accept();
		 System.out.println("Pass: alert is present and accept");
	}


	
	public static String[][] readXlData(String path, String string) throws IOException{
		FileInputStream fs=new FileInputStream(new File(path));
		HSSFWorkbook wb=new HSSFWorkbook(fs);
		HSSFSheet sheet=wb.getSheet("Sheet1");
		int rowCount=sheet.getLastRowNum()+1;
		int colCount=sheet.getRow(0).getLastCellNum();
		String[][] data=new String[rowCount][colCount];
		for(int i=0;i<rowCount;i++){
			for(int j=0;j<colCount;j++){
				int cellType=sheet.getRow(i).getCell(j).getCellType();
				if(cellType==HSSFCell.CELL_TYPE_NUMERIC){
					int val=(int)sheet.getRow(i).getCell(j).getNumericCellValue();
					data[i][j]=String.valueOf(val);
				}
				else
					data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
					
			}
		}
		return (data);
	}

}
