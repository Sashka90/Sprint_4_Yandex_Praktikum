package edu.praktikum.samokat;

import edu.praktikum.samokat.helpers.BrowserRule;
import org.junit.Rule;
import org.junit.Test;

public class FaqCheckAnswersTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void faqCheckAnswersTest() {
        new MainPage(browserRule.getDriver(), browserRule.getWait())
                .open()
                .clickToAcceptCookieButton()
                .moveToBottomOfPage()
                .checkFaqAnswersIsVisible();
    }
}
