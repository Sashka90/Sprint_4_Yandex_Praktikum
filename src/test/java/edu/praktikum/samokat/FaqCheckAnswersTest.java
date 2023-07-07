package edu.praktikum.samokat;

import edu.praktikum.samokat.helpers.BrowserRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class FaqCheckAnswersTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void faqCheckAnswersTest() {
        MainPage mainPage = new MainPage(browserRule.getDriver(), browserRule.getWait());

        mainPage.open();
        mainPage.clickToAcceptCookieButton();
        mainPage.moveToBottomOfPage();
        mainPage.clickToQuestion(0);
        Assert.assertEquals(mainPage.getFaqAnswer1().getText(), MainPage.getFaqAnswersText()[0]);
        Assert.assertTrue(mainPage.getFaqAnswer1().isDisplayed());
        mainPage.clickToQuestion(1);
        Assert.assertEquals(mainPage.getFaqAnswer2().getText(), MainPage.getFaqAnswersText()[1]);
        Assert.assertTrue(mainPage.getFaqAnswer2().isDisplayed());
        mainPage.clickToQuestion(2);
        Assert.assertEquals(mainPage.getFaqAnswer3().getText(), MainPage.getFaqAnswersText()[2]);
        Assert.assertTrue(mainPage.getFaqAnswer3().isDisplayed());
        mainPage.clickToQuestion(3);
        Assert.assertEquals(mainPage.getFaqAnswer4().getText(), MainPage.getFaqAnswersText()[3]);
        Assert.assertTrue(mainPage.getFaqAnswer4().isDisplayed());
        mainPage.clickToQuestion(4);
        Assert.assertEquals(mainPage.getFaqAnswer5().getText(), MainPage.getFaqAnswersText()[4]);
        Assert.assertTrue(mainPage.getFaqAnswer5().isDisplayed());
        mainPage.clickToQuestion(5);
        Assert.assertEquals(mainPage.getFaqAnswer6().getText(), MainPage.getFaqAnswersText()[5]);
        Assert.assertTrue(mainPage.getFaqAnswer6().isDisplayed());
        mainPage.clickToQuestion(6);
        Assert.assertEquals(mainPage.getFaqAnswer7().getText(), MainPage.getFaqAnswersText()[6]);
        Assert.assertTrue(mainPage.getFaqAnswer7().isDisplayed());
        mainPage.clickToQuestion(7);
        Assert.assertEquals(mainPage.getFaqAnswer8().getText(), MainPage.getFaqAnswersText()[7]);
        Assert.assertTrue(mainPage.getFaqAnswer8().isDisplayed());
    }
}
