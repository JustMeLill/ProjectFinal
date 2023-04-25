package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ExtentReport {

    private ExtentSparkReporter HTMLReporter;
    private ExtentReports Extent;
    private ExtentTest TestReport;
    private final  String PathToProject = System.getProperty("user.dir")+"/target/report";

    public ExtentReport (String ReportName){
        CreateDirectory();
        DeleteFiles();
        CreateReport(ReportName);

    }

    public ExtentReport (){
        CreateDirectory();
        DeleteFiles();
        CreateReport();

    }

    public void CreateDirectory (){
        File Directory = new File (PathToProject);
        if (!Directory.exists())
        {
            Directory.mkdirs();
        }
    }

    public void DeleteFiles (){
        File Directory = new File (PathToProject);
        File[] ListFiles = Directory.listFiles();
        for (Integer index = 0; index<ListFiles.length; index++) {
            ListFiles[index].delete();
        }
    }

    public void CreateReport (String ReportName){
        HTMLReporter = new ExtentSparkReporter("target/report/"+ReportName+".html");
        HTMLReporter.config().setTheme(Theme.DARK);
        Extent = new ExtentReports();
        Extent.attachReporter(HTMLReporter);
        TestReport = Extent.createTest(""+ReportName+"- report");
        AttachReport("info", " --- test "+ReportName+" started --- ");
    }

    public void CreateReport (){
        HTMLReporter = new ExtentSparkReporter("target/report/Report.html");
        HTMLReporter.config().setTheme(Theme.DARK);
        Extent = new ExtentReports();
        Extent.attachReporter(HTMLReporter);

    }

    public void AttachReport (String entryType, String message){
        if (entryType.equals("info")){
            TestReport.log(Status.INFO, message);
        }
        if (entryType.equals("pass")){
            TestReport.log(Status.PASS, message);
        }
    }

    public String GetScreenShot(WebDriver driver, String ReportName){
        String path = PathToProject+ReportName+".png";
        byte [] imageBytes;
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(path));
            imageBytes = IOUtils.toByteArray(Files.newInputStream(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    public void AttachReport (String entryType, String message, WebDriver driver, String ReportName){
        if (entryType.equals("fail")){
            TestReport.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(GetScreenShot(driver, ReportName)).build());
        }

    }

    public ExtentReports getExtent() {
        return Extent;
    }

    public ExtentTest getTestReport() {
        return TestReport;
    }
}
