package apiusercontroller.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.assertEquals;

public class DeleteMethodSteps {
    private RequestSpecification httpRequest;
    private Response response;

    @Given("I don't have app-id")
    public void iDontHaveAppId(){
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        httpRequest = RestAssured.given().header("app-id", "").contentType(ContentType.JSON);
    }

    @Given("I have a (in)valid app-id {string}")
    public void iHaveInvalidAppId(String appId){
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        httpRequest = RestAssured.given().header("app-id", appId).contentType(ContentType.JSON);
    }

    @When("I send a DELETE request with ID {string}")
    public void iSendADELETERequestWithID(String id) {
        response = httpRequest.request(Method.DELETE, "/user/" + id);
    }

    @When("I send a DELETE request without ID")
    public void iSendADELETERequestWithoutID() {
        response = httpRequest.request(Method.DELETE, "/user/");
    }

    @Then("I should receive error with status code {int}")
    public void iShouldReceiveAnErrorWithStatusCode(int expectedStatusCode){
        assertEquals("Unexpected status code", expectedStatusCode, response.getStatusCode());
    }

    @Then("I should receive success with status code {int}")
    public void iShouldReceiveASuccessWithStatusCode(int expectedStatusCode) {
        assertEquals("Unexpected status code", expectedStatusCode, response.getStatusCode());
    }
}
