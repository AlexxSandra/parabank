package com.project.pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.StringReader;

public class ContactUsPage {
    private WebDriver driver;
    private By usernameInput = By.xpath("//input[@id='name']");
    private By emailInput = By.xpath("//input[@id='email']");
    private By phoneInput = By.xpath("//input[@id='phone']");
    private By messageInput = By.xpath("//textarea[@id='message']");
    private By SendtoCustomerCareButton = By.xpath("//textarea[@id='message']");


    public ContactUsPage (WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername (String username) {driver.findElement(usernameInput).sendKeys(username);}

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void enterMessage(String message) {driver.findElement(messageInput).sendKeys(message);}

    public void clickSendToCustomerCareButton() {driver.findElement(SendtoCustomerCareButton).click();}


}
