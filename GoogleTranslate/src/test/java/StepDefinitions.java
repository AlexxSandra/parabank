import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepDefinitions {

    private RequestSpecification requestSpecification;
    private Response response; // sozdali pole

    @Given("The following API endpoind {string}")
    public void theFollowingAPIEndpoind(String endpoint) { ///argument
        requestSpecification = RestAssured.given().baseUri(endpoint); //enpoint= ssylkaurl, prisvaevaem endpoint requestSpecification. zadaeom cto requestspec eavleaetsea etim enpointom
    }

    @When("GET request is sent")
    public void getRequestIsSent() {
        response = requestSpecification.get(); //response budet vzeat iz requestspacification
    }

    @Then("the response Status {int} displayed")
    public void theResponseStatusDisplayed(int status) {
        int actualStatus = response.getStatusCode();
        assertThat(status,is(actualStatus));
    }

    @And("response body contains the following text {string}")
    public void responseBodyContainsTheFollowingTextEnUSLtr(String expectedResponseBody) {
    }
}
