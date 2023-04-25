package InputFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesUtility {

    public FileInputStream fileInputStream;
    public Properties properties;

    public PropertiesUtility(String name) {
        loadFile(name);
    }

    private void loadFile (String name){
        properties = new Properties();
        try {
            fileInputStream = new FileInputStream("src/test/resources/TestData/"+name+"Data.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public HashMap<String, String> getAllData (){
        HashMap<String,String > TestData = new HashMap<>();
        for (String key: properties.stringPropertyNames()){
            TestData.put(key, properties.getProperty(key));
        }
        return TestData;
    }
}
