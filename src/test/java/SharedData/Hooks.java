package SharedData;

import ExtentReport.ExtentReport;
import InputFile.PropertiesUtility;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Log;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.TestResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hooks extends SharedData {

    public HashMap<String, String>TestData;
    private String TestName;

    public static ExtentReport ExtentReportUtility = new ExtentReport();
    public static List<Log>LogContext = new ArrayList<>();
    public ExtentReport TestReport;

    @BeforeMethod
    public void prepareEnvironment (){
        Setup();
        TestName = this.getClass().getSimpleName();
        PropertiesUtility propertiesUtility = new PropertiesUtility(TestName);
        TestData = propertiesUtility.getAllData();
        TestReport = new ExtentReport(TestName);
    }

    @AfterMethod
    public void clearEnvironment (ITestResult Result){
        if (Result.getStatus()==ITestResult.FAILURE){
            TestReport.AttachReport("fail", Result.getThrowable().getMessage(), getDriver(), TestName);
        }
        TestReport.AttachReport("info", " --- finish " +TestName+" test --- ");
        synchronized (ExtentReportUtility){
            ExtentTest CurrentTest = ExtentReportUtility.getExtent().createTest(""+TestName+"- report");
            LogContext.addAll(TestReport.getTestReport().getModel().getLogs());
            for (Log log: LogContext){
                CurrentTest.getModel().getLogs().add(log);
            }
            ExtentReportUtility.getExtent().flush();
            LogContext.clear();
        }
        Clear();
    }

}
