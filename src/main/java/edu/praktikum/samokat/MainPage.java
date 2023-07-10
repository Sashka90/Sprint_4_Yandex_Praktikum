package edu.praktikum.samokat;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {

    private WebDriver driver;

    private WebDriverWait wait;

    private final static String URL = "https://qa-scooter.praktikum-services.ru/";

    private final static String[] FAQ_ANSWERS_TEXT = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой."
            , "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."
            ,"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."
            ,"Только начиная с завтрашнего дня. Но скоро станем расторопнее."
            ,"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."
            ,"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."
            ,"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."
            ,"Да, обязательно. Всем самокатов! И Москве, и Московской области."};

    public static String[] getFaqAnswersText() {
        return FAQ_ANSWERS_TEXT;
    }

    private By acceptCookieButton = By.xpath(".//button[contains(@class, 'App_CookieButton')]");
    private By faqHeadings = By.xpath("(.//div[contains(@id, 'accordion__heading')])");
    private By faqAnswers = By.xpath("(.//div[contains(@id, 'accordion__panel')])");
    private By logoSamokat = By.xpath(".//img[@alt = 'Scooter']");
    private By logoYandex = By.xpath(".//img[@alt = 'Yandex']");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public MainPage open() {
        driver.get(URL);
        return this;
    }

    public MainPage clickToAcceptCookieButton() {
        driver.findElement(acceptCookieButton).click();
        return this;
    }

    public OrderPage clickOrderButton(By locator) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
        driver.findElement(locator).click();
        return new OrderPage(driver);
    }

    public MainPage clickOnSamokatLogo() {
        driver.findElement(logoSamokat).click();
        return this;
    }

    public MainPage clickOnYandexLogo() {
        driver.findElement(logoYandex).click();
        return this;
    }

    public MainPage moveToBottomOfPage() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return this;
    }

    public void checkMainPageSamokat() {
        Assert.assertEquals(URL, driver.getCurrentUrl());
    }

    private void switchToWindow(int numberWindow) {
        String handle = driver.getWindowHandles().toArray()[numberWindow]
                .toString();
        driver.switchTo().window(handle);
    }

    public void checkPageYandex() {
        switchToWindow(1);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("html")));
        Assert.assertEquals("https://dzen.ru/?yredirect=true", driver.getCurrentUrl());
    }

    public MainPage clickToQuestion(int number) {
        List<WebElement> faqMenuList = driver.findElements(faqHeadings);
        faqMenuList.get(number).click();
        return this;
    }

    public Object getTextAnswer(int number) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElements(faqAnswers).get(number)));
        return driver.findElements(faqAnswers).get(number).getText();
    }
}
