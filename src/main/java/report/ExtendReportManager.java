package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {

        if (extent == null) {

            // Create timestamped report name
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String reportPath = System.getProperty("user.dir")
                    + "/test-output/ExtentReport_" + timestamp + ".html";

            // Spark Reporter (HTML report engine)
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName("AutoQA Pro Test Report");
            sparkReporter.config().setDocumentTitle("Automation Test Results");

            // Main report object
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // System info (useful in interview/viva)
            extent.setSystemInfo("Project", "AutoQA Pro");
            extent.setSystemInfo("Tester", "Student");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "Chrome/Firefox");
        }

        return extent;
    }
}