package edu.praktikum.samokat;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private WebDriver driver;

    private By inputName = By.cssSelector("[placeholder = '* Имя']");
    private By inputLastName = By.cssSelector("[placeholder = '* Фамилия']");
    private By inputAddress = By.cssSelector("[placeholder = '* Адрес: куда привезти заказ']");
    private By dropdownMetroStation = By.cssSelector("[placeholder = '* Станция метро']");
    private By inputTelephone = By.cssSelector("[placeholder = '* Телефон: на него позвонит курьер']");
    private By inputDate = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private By dropdownRentalPeriod = By.xpath(".//div[@class= 'Dropdown-control']");
    private By checkBoxBlack = By.xpath(".//label[@for='black']");
    private By checkBoxGrey = By.xpath(".//label[@for='grey']");
    private By inputComment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    private By buttonNext = By.xpath(".//button[text()='Далее']");
    private By buttonOrder = By.xpath(".//div[contains(@class, 'Order_Buttons')]/button[text()='Заказать']");
    private By buttonYes = By.xpath(".//button[text()='Да']");
    private By submitOrder = By.xpath(".//div[contains(@class, 'ModalHeader')]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    private void fillTheField(By field, String text) {
        driver.findElement(field).sendKeys(text);
    }

    private void selectValueFromDropdownListMetroStation(By dropdown, String value) {
        driver.findElement(dropdown).click();
        driver.findElement(By.xpath(".//li[@class='select-search__row']/following::div[contains(text(), '"+value+"')]")).click();
    }

    private void selectValueFromDropdownListRentalDate(By dropdown, String value) {
        driver.findElement(dropdown).click();
        value = value.toLowerCase();
        driver.findElement(By.xpath(".//div[@class='Dropdown-option' and text() = '"+value+"']")).click();
    }

    public OrderPage fillOrderFieldsPersonalData(String name, String lastName, String address, String metroStation, String telephone) {
        fillTheField(inputName, name);
        fillTheField(inputLastName, lastName);
        fillTheField(inputAddress, address);
        selectValueFromDropdownListMetroStation(dropdownMetroStation, metroStation);
        fillTheField(inputTelephone, telephone);
        return this;
    }

    private void selectCheckbox(String color) {
        if (color == "чёрный жемчуг") {
            driver.findElement(checkBoxBlack).click();
        } else {
            driver.findElement(checkBoxGrey).click();
        }
    }

    public OrderPage clickNextButton() {
        driver.findElement(buttonNext).click();
        return this;
    }

    public OrderPage fillOrderFieldsAboutRent(String date, String rentalPeriod, String color, String comment) {
        fillTheField(inputDate, date);
        driver.findElement(inputDate).sendKeys(Keys.ENTER);
        selectValueFromDropdownListRentalDate(dropdownRentalPeriod, rentalPeriod);
        selectCheckbox(color);
        fillTheField(inputComment, comment);
        return this;
    }

    public OrderPage clickOrderButton() {
        driver.findElement(buttonOrder).click();
        return this;
    }

    public OrderPage clickYesButton() {
        driver.findElement(buttonYes).click();
        return this;
    }

    public OrderPage checkSubmitOrder() {
        String str = driver.findElement(submitOrder).getText();
        Assert.assertEquals("Заказ оформлен", str);
        return this;
    }
}
