package com.cts.genericUtils.ExtentReports;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;
	
	static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
 
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir+"/ExtentReports/ExtentReportResults_" + timeStamp + ".html", true);
        }
        return extent;
    }
}
