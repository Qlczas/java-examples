package FrontEndFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaMainPage extends GenericPage {

    private static String TEST_URL = "https://www.wikipedia.org/";
    private static final By WIKIPEDIA_LOGO = By.xpath("//div[@class='central-textlogo-wrapper']/div[contains(text(), 'Wikipedia')]");
    private static final By SEARCH_TEXTBOX = By.id("searchInput");
    private static final By SEARCH_LANGUAGE_DROPDOWN = By.id("searchLanguage");
    private static final By SEARCH_BUTTON = By.xpath("//button[@type='submit']");
    private static final String ENGLISH_LANGUAGE_CODE = "en";

    public WikipediaMainPage(WebDriver webDriver){
        super(webDriver);
        OpenPage(TEST_URL);
        waitForElementPresent(WIKIPEDIA_LOGO);
        waitForElementPresent(SEARCH_TEXTBOX);
        waitForElementPresent(SEARCH_LANGUAGE_DROPDOWN);
        waitForElementPresent(SEARCH_BUTTON);
        System.out.println("### Page was opened successfully! " + TEST_URL);
    }

    public void searchForGivenPhraseInEnglish(String searchPhrase){
        typeGivenTextIntoElement(SEARCH_TEXTBOX, searchPhrase);
        selectGivenOptionFromDropdown(SEARCH_LANGUAGE_DROPDOWN, ENGLISH_LANGUAGE_CODE);
        clickElement(SEARCH_BUTTON);
    }

}