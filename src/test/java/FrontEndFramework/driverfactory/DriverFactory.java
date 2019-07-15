package FrontEndFramework.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static FrontEndFramework.driverfactory.Browsers.*;

public abstract class DriverFactory {
    public static WebDriver getDriver(){

         switch(valueOf(System.getProperty("browser", System.getProperty("default.browser").toUpperCase())))
        {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--start-maximized");
                //Use below argument for running tests on Jenkins
                //chromeOptions.addArguments("--headless");
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                return new FirefoxDriver();
            case EDGE:
                return new EdgeDriver();
            case MSIE:
                return new InternetExplorerDriver();
        }
        return null;
    }
}