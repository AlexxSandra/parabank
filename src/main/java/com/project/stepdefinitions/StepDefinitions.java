package com.project.stepdefinitions;

import com.project.pageobjects.pages.LoginPage;
import com.project.util.WaitersConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RequiredArgsConstructor
public class StepDefinitions {
    private WebDriver webDriver;
    private final int elementIsDisplayed = WaitersConfig.getElementIsDisplayed();
    LoginPage loginPage;
    private static final Logger LOG = LoggerFactory.getLogger(WaitersConfig.class);

    public void checkPage(String page) {
        webDriver.get(page);
        final WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(elementIsDisplayed));
        wait.until(ExpectedConditions.urlToBe(page));
        assertThat(webDriver.getCurrentUrl(), is(page));
    }

    @Given("user is accessing the login page")
    public void accessTheWebPage() {
        final String url = "https://parabank.parasoft.com/parabank/index.htm";
        checkPage(url);
        LOG.info(String.format("User has accessed the login page - {%s}", url));
    }

    @When("user enters correct credentials")
    public void enterCorrectCredentials() {
        loginPage.enterUsername("johndoe223");
        loginPage.enterPassword("johndoe223");
        loginPage.clickLoginButton();
        LOG.info("User entered the credentials");
    }

    @Then("user is successful logged in")
    public void checkSuccessfulLogin() {
        final String url = "https://parabank.parasoft.com/parabank/overview.htm";
        checkPage(url);
        LOG.info(String.format("User has accessed the login page - {%s}", url));
    }


//  @Then("the error message is displayed")
//    public void clickOnTheLoginButton() {
//        final String title = webDriver.findElement(By.xpath("//h1[@class='title']")).getText();
//        final String error = webDriver.findElement(By.xpath("//p[@class='error']")).getText();
//
//        await().pollInterval(250, MILLISECONDS)
//                .atMost(20, SECONDS)
//                .until(() -> title.equals("Error!") && error.equals("An internal error has occurred and has been logged."));
//        webDriver.close();
//    }


    @Given("user is accessing the Contact Us page")
    public void accessTheContactUsPage() {
        final String url = "https://parabank.parasoft.com/parabank/contact.htm";
        webDriver.get(url);

        final WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(url));
        assertThat(webDriver.getCurrentUrl(), is(url));

    }

    @When("user enters correct credentials for Contact Us page")
    public void enterCorrectCredentialsForContactUsPage() {
        webDriver.findElement(By.xpath("//input[@id='name']")).sendKeys("Alex Sandra");//vyzyvaet webdriver i nahodit element po xpath i posle dobavleeaet sled text. Nahodit blagodarea etim elementam
        webDriver.findElement(By.xpath("//input[@id='email']")).sendKeys("br.murkina@mail.ru");
        webDriver.findElement(By.xpath("//input[@id='phone']")).sendKeys("+37379377625");
        webDriver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Hello, I want to learn Java");
    }

    @And("user clicks on Contact Us button")
    public void clickOnContactUsButton() {
        final String url = "https://parabank.parasoft.com/parabank/contact.htm";

        webDriver.findElement(By.xpath("//input[@value='Send to Customer Care']")).click();

        final WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains(url));
    }

    @Then("the message should be successful send")
    public void messageSuccessfulSend() {
        final String title = webDriver.findElement(By.xpath("//h1[@class='title']")).getText();

        await().pollInterval(250, MILLISECONDS)
                .atMost(20, SECONDS)
                .until(() -> title.equals("Customer Care"));
        assertThat(title, is("Customer Care"));

    }
}


