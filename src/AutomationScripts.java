import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;


public class AutomationScripts extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException, IOException {
		TC1_loginErrorMessage();
		TC2_loginToSalesforce();
		TC3_checkRememberMe();
		TC4A_forgotPasswordLink();
		TC4B_forgotPasswordWrongPassword();
		TC5_userDropdown();

	}
	public static void logger() {
		ReusableMethods.report.endTest(logger);
		ReusableMethods.report.flush();
	}
	
	public static void login() throws InterruptedException {
		
		//Enter Username
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName, "mike.arnhold123-xnjq@force.com", "User Name");
				
		//Enter Password
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password, "arnhold@123", "Password");
				
		//Click on login button
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		clickButton(loginButton, "Login Button");
		
	}
	
	public static void TC1_loginErrorMessage() throws InterruptedException, IOException {
		
		createTestScriptReport("TC1_loginErrorMessage");
		initializeDriver();
		String[][] data = readXlData("C:\\myProject\\GIT\\SFDC_Testing_Excel_Data\\TC1_loginErrorMessage.xls","Sheet1");
		String url = data[1][1];
		String userNameData = data[1][2];
		//String passwordData = data[1][3];
		String passwordData = null;
		launchURL();
		Thread.sleep(3000);
		
		//Enter Username
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName, userNameData, "User Name");
		
		//Enter Password
		//WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		//enterText(password, passwordData, "Password");
		
		//Click on login button
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		clickButton(loginButton, "Login Button");
		Thread.sleep(5000);
		
		//Validating Error Message
		WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error']"));
		validateTextMessage(errorMessage, "Please enter your password.", "Error Message forEmpty password.");
		//Thread.sleep(5000);
		
		//Qutting/Closing the Web browser Window
		//driver.quit();
		driver.close();
				
		//Logging Reports
		System.out.println("Test case Executed. Unable to login to Salesforce Application.");
		logger.log(LogStatus.PASS, "Test case Executed. Unable to login to Salesforce Application.");
		System.out.println("TC1_loginErrorMessage is completed");
		//logger.log(LogStatus.INFO, "TC1_loginErrorMessage is completed");
		
		logger();
				
	}
	
	public static void TC2_loginToSalesforce() throws InterruptedException, IOException {
		
		createTestScriptReport("TC2_loginToSalesforce");
		initializeDriver();
		String[][] data = readXlData("C:\\myProject\\GIT\\SFDC_Testing_Excel_Data\\TC2_loginToSalesforce.xls","Sheet1");
		String url = data[1][1];
		String userNameData = data[1][2];
		String passwordData = data[1][3];
		launchURL();
		Thread.sleep(3000);
		
		//Enter Username
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName, userNameData, "User Name");
		
		//Enter Password
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password, passwordData, "Password");
		
		//Click on login button
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		clickButton(loginButton, "Login Button");
		Thread.sleep(5000);
		
		//Qutting/Closing the Web browser Window
		//driver.quit();
		driver.close();
				
		//Logging Reports
		System.out.println("Test case Executed. Logged into Salesforce Application Successfully.");
		logger.log(LogStatus.PASS, "Test case Executed. Logged into Salesforce Application Successfully.");
		System.out.println("TC2_loginToSalesforce is completed");
		//logger.log(LogStatus.INFO, "TC2_loginToSalesforce is completed");
				
		logger();
				
	}
	
	public static void TC3_checkRememberMe() throws InterruptedException, IOException {
		
		createTestScriptReport("TC3_checkRememberMe");
		initializeDriver();
		String[][] data = readXlData("C:\\myProject\\GIT\\SFDC_Testing_Excel_Data\\TC2_loginToSalesforce.xls","Sheet1");
		String url = data[1][1];
		String userNameData = data[1][2];
		String passwordData = data[1][3];
		launchURL();
		Thread.sleep(3000);
		
		//Enter Username
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName, userNameData, "User Name");
		
		//Enter Password
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password, passwordData, "Password");
		
		//selecting the RememberMe CheckBox	
		WebElement rememberMeCheckBox = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		selectCheckBox(rememberMeCheckBox, "Remember Me Checkbox");
		Thread.sleep(5000);
				
		//Click on login button
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		clickButton(loginButton, "Login Button");
		Thread.sleep(5000);
		
		//Select User Dropdown
		WebElement userDropdown = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		selectDropdown(userDropdown, "userDropdown Menu");
		
		//Click on logout button 
		WebElement userLogout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		clickButton(userLogout, "Logout from User Dropdown");
		Thread.sleep(5000);
		
		/* WebElement promptAlertButton = driver.findElement(By.id("tryLexDialogX"));
		promptAlertButton.click(); */
		
		//Qutting/Closing the Web browser Window
		//driver.quit();
		driver.close();
						
		//Logging Reports
		System.out.println("Test case Executed. Username is saved in Browser");
		logger.log(LogStatus.PASS, "Test case Executed. Username is saved in Browser");
		System.out.println("TC3_checkRememberMe is completed");
		//logger.log(LogStatus.INFO, "TC3_checkRememberMe is completed");
						
		logger();
		
	}
	
	public static void TC4A_forgotPasswordLink() throws InterruptedException, IOException {
		
		createTestScriptReport("TC4A_forgotPasswordLink");
		initializeDriver();
		String[][] data = readXlData("C:\\myProject\\GIT\\SFDC_Testing_Excel_Data\\TC4A_forgotPasswordLink.xls","Sheet1");
		String userNameData = data[1][0];
		launchURL();
		Thread.sleep(3000);
		
		//Enter Username
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName, userNameData, "User Name");
		
		//Click on ForgotPassword Link
		WebElement forgotPassword = driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
		clickLink(forgotPassword, "Forgot Password Link");
						
		//Enter Username/Email Id  to send the Password Link
		WebElement uName = driver.findElement(By.xpath("//input[@id='un']"));
		enterText(uName, userNameData, "User Name/Emaild to send the Password Reset Link");
		
		//Click on Continue Button
		WebElement Continue = driver.findElement(By.xpath("//input[@id='continue']"));
		clickButton(Continue, "Continue Button to send the Password Reset Link");
				
		//Click on Cancel Button
		//WebElement Cancel = driver.findElement(By.xpath("//a[@class='secondary button fiftyfifty mb16']"));
		//clickButton(Cancel, "Cancel Button to Reset Password");
		
		//Qutting/Closing the Web browser Window
		//driver.quit();
		driver.close();
						
		//Logging Reports
		System.out.println("Test case Executed. Password Rest Link has been sent to Email ID");
		logger.log(LogStatus.PASS, "Test case Executed. Password Rest Link has been sent to Email ID");
		System.out.println("TC4A_forgotPasswordLink is completed");
		//logger.log(LogStatus.INFO, "TC4A_forgotPasswordLink is completed");
						
		logger();
				
	}
	
	public static void TC4B_forgotPasswordWrongPassword() throws InterruptedException, IOException {
		
		createTestScriptReport("TC4B_forgotPasswordWrongPassword");
		initializeDriver();
		String[][] data = readXlData("C:\\myProject\\GIT\\SFDC_Testing_Excel_Data\\TC4B_forgotPasswordWrongPassword.xls","Sheet1");
		String url = data[1][1];
		String userNameData = data[1][1];
		String passwordData = data[1][2];
		launchURL();
		Thread.sleep(3000);
		
		//Enter Username
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName, userNameData, "User Name");
		
		//Enter Password
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password, passwordData, "Password");
		
		//Click on login button
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));
		clickButton(loginButton, "Login Button");
		Thread.sleep(5000);
		
		//Validating Error Message
		WebElement errorMessage = driver.findElement(By.xpath("//div[@id='error']"));
		String expectedMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		Thread.sleep(5000);
		validateTextMessage(errorMessage, expectedMessage, "Error Message for wrong user name and  password");
				
		//Qutting/Closing the Web browser Window
		//driver.quit();
		driver.close();
						
		//Logging Reports
		System.out.println("Test case Executed. Error Message for wrong user name and  password is validated");
		logger.log(LogStatus.PASS, "Test case Executed. Error Message for wrong user name and  password is validated");
		System.out.println("TC4B_forgotPasswordWrongPassword is completed");
		//logger.log(LogStatus.INFO, "TC4B_forgotPasswordWrongPassword is completed");
						
		logger();
		
	}
	
	public static void TC5_userDropdown() throws InterruptedException {
		
		createTestScriptReport("TC5_userDropdown");
		initializeDriver();
		launchURL();
		Thread.sleep(3000);
		login();
		Thread.sleep(5000);
		
		//Select User Dropdown
		WebElement userDropdown = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		selectDropdown(userDropdown, "userDropdown Menu");
		
		//Qutting/Closing the Web browser Window
		//driver.quit();
		driver.close();
				
		//Logging Reports
		System.out.println("Test case Executed. Selected Userdropdown Menu.");
		logger.log(LogStatus.PASS, "Test case Executed. Selected Userdropdown Menu.");
		System.out.println("TC05_UserMenuDropDown is completed");
		//logger.log(LogStatus.INFO, "TC05_UserMenuDropDown is completed");
		
		logger();
		
	}

}
