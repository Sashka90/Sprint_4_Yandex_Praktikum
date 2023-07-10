package edu.praktikum.samokat;

import edu.praktikum.samokat.helpers.BrowserRule;
import org.junit.Rule;
import org.junit.Test;

public class ClickOnLogoTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void clickOnSamokatLogoTest() {
        new MainPage(browserRule.getDriver(), browserRule.getWait())
                .open()
                .clickOnSamokatLogo()
                .checkMainPageSamokat();
    }

    @Test
    public void clickOnYandexLogoTest() {
        new MainPage(browserRule.getDriver(), browserRule.getWait())
                .open()
                .clickOnYandexLogo()
                .checkPageYandex();
    }
}
