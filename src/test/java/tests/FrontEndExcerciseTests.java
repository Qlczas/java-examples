package tests;

import org.testng.annotations.Test;
import FrontEndFramework.pageobjects.WikipediaMainPage;
import FrontEndFramework.pageobjects.WikipediaEnglishResultPage;

import java.util.UUID;

public class FrontEndExcerciseTests extends BaseSeleniumTests {

    private final String SEARCH_TEST_PHRASE = "Taxi Brooklyn";

    private final String TEST_COMMENT = "Very interesting! ";
    private String currentTestString = generateRandomTestString(TEST_COMMENT);

    @Test
    public void testSearchingForPhraseInEnglish() {
        WikipediaMainPage wikipediaMainPage = new WikipediaMainPage(driver.get());
        wikipediaMainPage.searchForGivenPhraseInEnglish(SEARCH_TEST_PHRASE);

        WikipediaEnglishResultPage wikipediaEnglishResultPage = new WikipediaEnglishResultPage(driver.get());
        wikipediaEnglishResultPage.assertGivenPageHeading(SEARCH_TEST_PHRASE);
        wikipediaEnglishResultPage.assertGivenPageInEnglish();
    }

    private String generateRandomTestString(String constantTestComment) {
        String currentTestString = constantTestComment + UUID.randomUUID().toString();
        return currentTestString;
    }
}