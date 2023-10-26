package com.project.stepdefinitions;

import com.project.pageobjects.pages.LoginPage;
import com.project.util.WaitersConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@RequiredArgsConstructor
public class StepDefinitions {
    private WebDriver webDriver;
    private final int elementIsDisplayed = WaitersConfig.getElementIsDisplayed();
    LoginPage loginPage;
    private static final Logger LOG = LoggerFactory.getLogger(WaitersConfig.class);

    public StepDefinitions(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public StepDefinitions() {
    }

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
}


//    @Given("user is accessing the Contact Us page")
//    public void accessTheContactUsPage() {
//        final String url = "https://parabank.parasoft.com/parabank/contact.htm";
//        checkPage(url);
//        LOG.info(String.format("User has accessed the contact us page - {%s}", url));
//    }
//
//    @When("user enters correct credentials in Contact Us page")
//    public void enterCorrectCredentialsInContactUsPage() {
//        loginPage.enterUsername("Alex Sandra");
//        loginPage.enterEmail("br.murkina@mail.ru");
//        loginPage.enterPhone("+37379377625");
//        loginPage.enterMessage("Hello, I want to learn Java");
//        LOG.info("User entered the credentials");
//    }
//
//
//    @And("user clicks on Send to Customer Care button")
//    public void clickSendToCustomerCareButton() {
//        final String url = "https://parabank.parasoft.com/parabank/contact.htm";
//
//        webDriver.findElement(By.xpath("//input[@value='Send to Customer Care']")).click();
//
//        final WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.urlContains(url));
//    }
//
//    @Then("the message should be successful send")
//    public void messageSuccessfulSend() {
//        final String title = webDriver.findElement(By.xpath("//h1[@class='title']")).getText();
//
//        await().pollInterval(250, MILLISECONDS)
//                .atMost(20, SECONDS)
//                .until(() -> title.equals("Customer Care"));
//        assertThat(title, is("Customer Care"));
//
//    }
//}


