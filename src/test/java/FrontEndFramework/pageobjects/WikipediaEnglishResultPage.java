package FrontEndFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WikipediaEnglishResultPage extends GenericPage {

    private static final By PAGE_FIRST_HEADING = By.id("firstHeading");


    public WikipediaEnglishResultPage(WebDriver webDriver){
        super(webDriver);
        waitForElementPresent(PAGE_FIRST_HEADING);
    }

    public void assertGivenPageHeading(String expectedPageHeading) {
        assertGivenTextInElement(PAGE_FIRST_HEADING, expectedPageHeading);
    }

    public void assertGivenPageInEnglish() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.contains("en.wikipedia"));
    }
}