package SharedData;

import InputFile.PropertiesUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

public class Hooks extends SharedData {

    public HashMap<String, String>TestData;
    private String TestName;

    @BeforeMethod
    public void prepareEnvironment (){
        Setup();
        TestName = this.getClass().getSimpleName();
        PropertiesUtility propertiesUtility = new PropertiesUtility(TestName);
        TestData = propertiesUtility.getAllData();
    }

    @AfterMethod
    public void clearEnvironment (){
        Clear();
    }

}
