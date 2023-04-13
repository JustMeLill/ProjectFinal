package SharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {
    public WebDriver driver;

    ChromeOptions chromeOptions = new ChromeOptions();
    @BeforeMethod
    public void Setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        chromeOptions.addArguments("window-size=1200,1080");
        chromeOptions.addArguments("--no-sandbox");
    }

    @AfterMethod
    public void Clear(){
        driver.quit();
    }


}
