package edu.praktikum.samokat;

import edu.praktikum.samokat.helpers.BrowserRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

@RunWith(Parameterized.class)
public class OrderSamokatTest {

    private final String name;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String telephone;
    private final String date;
    private final String rentalDate;
    private final String color;
    private final String comment;
    private final By orderButton;

    public OrderSamokatTest(By orderButton, String name, String lastName, String address, String metroStation, String telephone, String date, String rentalDate, String color, String comment) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.telephone = telephone;
        this.date = date;
        this.rentalDate = rentalDate;
        this.color = color;
        this.comment = comment;
        this.orderButton = orderButton;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                {xpath(".//div[contains(@class, 'Header')]/button[text()='Заказать']"),"Александр", "Якушев", "Улица Пушкина, дом Колотушкина", "Черкизовская", "79046667788", "01.08.2023", "Сутки", "чёрный жемчуг", ":)"},
                {xpath(".//div[contains(@class, 'Header')]/button[text()='Заказать']"),"Иван", "Иванов", "Кремль, дом 1", "Строгино", "79046667788", "21.07.2023", "Трое суток", "серая безысходность", ":)"},
                {xpath(".//div[contains(@class, 'Home_FinishButton')]/button[text()='Заказать']"),"Василий", "Задов", "Москва, улица красивых молдавских партизан д.33", "Бабушкинская", "79046667788", "21.09.2023", "Семеро суток", "серая безысходность", ":)"}
        };
    }

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void orderSamokatTest() {
        new MainPage(browserRule.getDriver(), browserRule.getWait())
                .open()
                .clickToAcceptCookieButton()
                .clickOrderButton(orderButton)
                .fillOrderFieldsPersonalData(name, lastName, address, metroStation, telephone)
                .clickNextButton()
                .fillOrderFieldsAboutRent(date, rentalDate, color, comment)
                .clickOrderButton()
                .clickYesButton()
                .checkSubmitOrder();
    }
}
