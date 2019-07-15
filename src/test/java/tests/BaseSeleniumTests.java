package tests;

import FrontEndFramework.driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class BaseSeleniumTests {

    final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    @BeforeClass
    public void setupWebDriver() {
        driver.set(DriverFactory.getDriver());
        driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDownTest() {
        driver.get().quit();
        System.out.println("### Driver quit");
    }
}
