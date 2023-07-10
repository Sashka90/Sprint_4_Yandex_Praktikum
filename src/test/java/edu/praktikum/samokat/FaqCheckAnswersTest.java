package edu.praktikum.samokat;

import edu.praktikum.samokat.helpers.BrowserRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static edu.praktikum.samokat.MainPage.getFaqAnswersText;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FaqCheckAnswersTest {

    private final int questionNumber;
    private final int answerNumber;
    private final String expectedAnswer;

    public FaqCheckAnswersTest(int questionNumber, int answerNumber, String expectedAnswer) {
        this.questionNumber = questionNumber;
        this.answerNumber = answerNumber;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {0, 0, getFaqAnswersText()[0]},
                {1, 1, getFaqAnswersText()[1]},
                {2, 2, getFaqAnswersText()[2]},
                {3, 3, getFaqAnswersText()[3]},
                {4, 4, getFaqAnswersText()[4]},
                {5, 5, getFaqAnswersText()[5]},
                {6, 6, getFaqAnswersText()[6]},
                {7, 7, getFaqAnswersText()[7]},
        };
    }

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void faqCheckAnswersTest() {
        MainPage mainPage = new MainPage(browserRule.getDriver(), browserRule.getWait())
                .open()
                .clickToAcceptCookieButton().moveToBottomOfPage()
                .clickToQuestion(questionNumber);
        assertEquals(expectedAnswer, mainPage.getTextAnswer(answerNumber));
    }
}
