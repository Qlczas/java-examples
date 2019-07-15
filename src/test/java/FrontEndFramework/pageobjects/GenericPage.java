package FrontEndFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

class GenericPage {

    final WebDriver driver;

    GenericPage(WebDriver webDriver) {
        driver = webDriver;
    }

    void OpenPage(String pageUrl) {
        driver.get(pageUrl);
    }

    void waitForElementPresent(By elementLocator) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
    }

    void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    void switchToGivenFrame(String frameName) {
        driver.switchTo().frame(frameName);
    }

    void clickElement(By elementLocator) {
        WebElement elementToBeClicked = driver.findElement(elementLocator);
        elementToBeClicked.click();
    }

    void typeGivenTextIntoElement(By elementLocator, String textToSend){
        WebElement element = driver.findElement(elementLocator);
        element.isDisplayed();
        element.clear();
        element.sendKeys(textToSend);
    }

    void assertGivenTextInElement(By elementLocator, String expectedText){
        WebElement element = driver.findElement(elementLocator);
        String actualText = element.getText();
        System.out.println("### Expected element text:" + expectedText);
        System.out.println("### Actual element text:" + actualText);
        Assert.assertEquals(actualText, expectedText);
    }

    void selectGivenOptionFromDropdown(By elementLocator, String elementValue) {
        Select dropdown = new Select (driver.findElement(elementLocator));
        dropdown.selectByValue(elementValue);
    }
}