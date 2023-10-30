package com.google.translate.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@AllArgsConstructor
@NoArgsConstructor
public class StepDefinitions {

    private RequestSpecification requestSpecification;
    private Response response; // sozdali pole

    ///GET
    @Given("The following GET API endpoint {string}")
    public void theFollowingGETAPIEndpointOne(String url) {
        requestSpecification = given().baseUri(url);
    }

    @When("GET request is sent")
    public void getRequestIsSent() {
        response = requestSpecification.get(); //response budet vzeat iz requestspacification
    }

    @Then("the response Status {int} displayed")
    public void theResponseStatusDisplayed(int status) {
        int actualStatus = response.getStatusCode();
        assertThat(status, is(actualStatus));
    }

    @And("response body contains the following text$")
    public void responseBodyContainsTheFollowingTextEnUSLtr(String expectedResponseBody) {
        String actualResponseBody = response.getBody().asString();
        assertThat(actualResponseBody, containsString(expectedResponseBody));
    }

    ///POST
    @Given("The following POST API endpoint {string}")
    public void theFollowingPOSTAPIEndpointOne(String url) {
        requestSpecification = given()
                .baseUri(url)
                .contentType(ContentType.MULTIPART)
                .multiPart("code", "public class Main {\n" +
                        "  public static void main(String[] args) {\n" +
                        "    System.out.println(\"Hello World\");\n" +
                        "  }\n" +
                        "}\n");
    }

    @When("POST request is sent with the following body")
    public void postRequestIsSentWithTheFollowingBody() {
        response = requestSpecification.post();
    }
}
