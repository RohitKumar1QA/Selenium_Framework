package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports getReportsObject()
	{
		String path = System.getProperty("user.dir")+"\\ExtentReports\\LoginTest1.html";
		ExtentSparkReporter spark1=new ExtentSparkReporter(path);
		spark1.config().setReportName("Automation Test Script");
		spark1.config().setDocumentTitle("TestScript Result");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(spark1);
		extent.setSystemInfo("Tester","Rohit Kumar");
		return extent;
	}
	
	
}
