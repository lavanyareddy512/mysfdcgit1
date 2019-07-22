import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class Driver extends ReusableMethods{
	
	static int resultflag = 0;

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		
		ReusableMethods re = new ReusableMethods();	
		String data = "C:\\myProject\\eclipse-workspace\\SalesForce\\SFDC_Testing_Excel_Data\\SFDCData.xls";
		String[][] recdata = ReusableMethods.readXlData(data , "Sheet1");		
		for(int i = 1; i <recdata.length; i++) {
			resultflag = 0;
			if(recdata[i][1].equalsIgnoreCase("Y")) {
				
				String testScript = recdata[i][2];
							
				//Method testCase = AutomationScripts.class.getMethod(testScript);
				
				Method testCase = AutomationScripts.class.getMethod(testScript);
				testCase.invoke(testCase);
			}else {
				System.out.println("Row number "+i+" script execution is skipped");
				resultflag = 1;
				writeXlData(i,"skip","Blue");
			}		
			System.out.println(resultflag);
			ReusableMethods.report.endTest(logger);
			ReusableMethods.report.flush();
			
			if(resultflag == 0) {
				writeXlData(i,"Pass","Green");
				
			}else if(resultflag == 1) {
				writeXlData(i,"skip","Blue");
			}
			 
	}
	}
	
	public static void writeXlData(int i,String result,String color) throws IOException{
		File file=new File("C:\\myProject\\eclipse-workspace\\SalesForce\\SFDC_Testing_Excel_Data\\SFDCData.xls");
		FileInputStream fs=new FileInputStream(file);
		HSSFWorkbook wb=new HSSFWorkbook(fs);
		HSSFSheet sheet=wb.getSheet("Sheet1");
		HSSFCellStyle style = ((HSSFWorkbook)wb).createCellStyle();	
		if (color.equals("Green")){
			style.setFillForegroundColor(HSSFColor.GREEN.index);
		}
			else if (color.equals("Red")) {
				style.setFillForegroundColor(HSSFColor.RED.index);
			}
			else {
				style.setFillForegroundColor(HSSFColor.BLUE.index);
			}
		
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 
		
		sheet.getRow(i).getCell(3).setCellValue(result);
		sheet.getRow(i).getCell(3).setCellStyle(style);
		
		FileOutputStream fo=new FileOutputStream(file);
		wb.write(fo);
		fo.flush();
		fo.close();
		System.out.println("completed");
	}

}
