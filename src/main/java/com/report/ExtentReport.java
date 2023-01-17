package com.report;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReport  {
	
	private static ExtentReports extent;
	public static ExtentTest svcTest, parent;
	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	private static final ThreadLocal<String> testName = new ThreadLocal<String>();
    /**
     * Method to create Extent Report
     */
	private String fileName = "result.html";
	private String pattern = "dd-MMM-yyyy HH-mm-ss";

	public String testcaseName, testDescription, authors, category;
	public static String folderName = "";

	@BeforeSuite(alwaysRun = true)
	public synchronized void startReport() {
		String date = new SimpleDateFormat(pattern).format(new Date());
		folderName = "reports/" + date;

		File folder = new File("./" + folderName);
		if (!folder.exists()) {
			folder.mkdir();
		}
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./" + folderName + "/" + fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(!true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("TestVagrant Assessment");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Read RCB Json");
		htmlReporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	/**
     * Create node for each Test
     * @param testCaseName - Test case name which will be same as node name
     * @param testDescription- Test case description
     * @param category- Test case category - Positive or Negative
     * @author authors- who created test test case
     */
	@BeforeClass(alwaysRun = true)
	public synchronized void startTestCase() {
		parent = extent.createTest(testcaseName, testDescription);
		parent.assignCategory(category);
		parent.assignAuthor(authors);
		testName.set(testcaseName);
	}


    /**
     * Method to log the status
     * @param status - Status enum
     * @param log - log to be inserted
     */
    // To report steps 

    public static void reportLog(String desc, String status) {
    		
    		if(status.equalsIgnoreCase("PASS")) {
    			svcTest.pass(desc);		
    		}else if(status.equalsIgnoreCase("FAIL")) {
    			svcTest.fail(desc);
    			throw new RuntimeException();
    		}else if(status.equalsIgnoreCase("WARNING")) {
    			svcTest.warning(desc);		
    		}else {
    			svcTest.info(desc);
    		}	
    	}

    @AfterSuite(alwaysRun = true)
	public synchronized void endResult() {
		extent.flush();
	}

}
