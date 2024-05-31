package apiusercontroller.StepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetMethodSteps {
    private RequestSpecification httpRequest;
    private Response response;

    @Given("I have no app-id")
    public void iHaveNoAppId() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        httpRequest = RestAssured.given().header("app-id", "").contentType(ContentType.JSON);
    }

    @Given("I have an invalid app-id")
    public void iHaveAnInvalidAppId() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        httpRequest = RestAssured.given().header("app-id", "662e51efbb70a7543a25956").contentType(ContentType.JSON);
    }

    @Given("I have a valid app-id")
    public void iHaveAValidAppId() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        httpRequest = RestAssured.given().header("app-id", "662e51efbb70a7543a259560").contentType(ContentType.JSON);
    }

    @When("I request user information by ID")
    public void iRequestUserInformationById() {
        response = httpRequest.request(Method.GET, "/user/60d0fe4f5311236168a109ac");
    }

    @When("I request user information by an invalid user ID")
    public void iRequestUserInformationByAnInvalidUserId() {
        response = httpRequest.request(Method.GET, "/user/60d0fe4f5311236168a109ba");
    }

    @When("I request user information by a valid user ID")
    public void iRequestUserInformationByAValidUserId() {
        response = httpRequest.request(Method.GET, "/user/60d0fe4f5311236168a109ca");
    }

    @When("I request user information by an invalid user ID format")
    public void iRequestUserInformationByAnInvalidUserIdFormat() {
        response = httpRequest.request(Method.GET, "/user/abc");
    }

    @Then("I should receive an error with status code {int}")
    public void iShouldReceiveAnErrorWithStatusCode(int expectedStatusCode) {
        assertEquals("Unexpected status code", expectedStatusCode, response.getStatusCode());
    }

    @Then("I should receive user information with status code {int}")
    public void iShouldReceiveUserInformationWithStatusCode(int expectedStatusCode) {
        assertEquals("Unexpected status code", expectedStatusCode, response.getStatusCode());
    }

    @Then("I should receive an error message containing {string}")
    public void iShouldReceiveAnErrorMessageContaining(String expectedErrorMessage) {
        String responseBody = response.getBody().asString();
        assertTrue("Response body does not contain expected error message", responseBody.contains(expectedErrorMessage));
    }
}