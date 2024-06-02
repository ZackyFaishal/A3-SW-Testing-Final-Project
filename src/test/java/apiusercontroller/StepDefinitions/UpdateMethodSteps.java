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
import static org.junit.Assert.assertTrue;

import java.util.Map;

public class UpdateMethodSteps {
    private RequestSpecification httpRequest;
    private Response response;


    @Given("I have an existing user")
    public void iHaveAnExistingUser() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        httpRequest = RestAssured.given().header("app-id", " ").contentType(ContentType.JSON);
        response = httpRequest.request(Method.GET, "user/60d0fe4f5311236168a10a27");
    }

    @When("I update the user without including the app-id in the header")
    public void i_update_the_user_without_including_the_app_id_in_the_header() {
        // Data yang akan diperbarui
        String requestBody = "{\"name\": \"Updated Name\"}";

        // Mengirim permintaan PUT tanpa menyertakan app-id dalam header
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .request(Method.PUT, "user/60d0fe4f5311236168a10a27");
    }

    @Then("the response body should contain {string}")
    public void the_response_body_should_contain(String expectedErrorMessage) {
        String actualResponseBody = response.getBody().asString();
        assertTrue(actualResponseBody.contains(expectedErrorMessage));
    }

    @Then("the message status should be {int} Forbidden")
    public void the_message_status_should_be(int expectedStatus) {
        assertEquals("Unexpected status code", expectedStatus, response.getStatusCode());
    }

    @Then("the message status should be {int} Bad request")
    public void the_message_status_should_be_bad_request(int expectedStatus) {
        assertEquals("Unexpected status code", expectedStatus, response.getStatusCode());
    }

    @Then("the database condition should not change")
    public void the_database_condition_should_not_change() {
        // Code to check if the database condition remains unchanged
    }

    @Given("I have an user")
    public void iHaveAnUser() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        httpRequest = RestAssured.given().header("app-id", "662e5c").contentType(ContentType.JSON);
        response = httpRequest.request(Method.GET, "user/60d0fe4f5311236168a10a27");
    }

    @When("I update the user without including the incorrect app-id in the header")
    public void iUpdateTheUserWithoutIncludingTheIncorrectAppIdInTheHeader() {
        // Data yang akan diperbarui
        String requestBody = "{\"name\": \"Updated Name\"}";

        // Mengirim permintaan PUT tanpa menyertakan app-id yang salah dalam header
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .request(Method.PUT, "user/60d0fe4f5311236168a10a27");
    }

    @Given("I have a user registered on the system")
    public void iHaveAUserRegisteredOnTheSystem() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        httpRequest = RestAssured.given().header("app-id", "662e5c0abb70a7055e2595ba").contentType(ContentType.JSON);
        response = httpRequest.request(Method.GET, "user/60d0fe4f5311236168a10a27");
    }

    @When("I update the user firstName with only 2 characters")
    public void iUpdateTheUserFirstNameWithOnly2Characters() {
        // Data yang akan diperbarui
        String requestBody = "{\"firstName\": \"Ak\"}";

        // Mengirim permintaan PUT dengan data firstName hanya 2 karakter
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("app-id", "662e5c0abb70a7055e2595ba") 
                .body(requestBody)
                .request(Method.PUT, "user/60d0fe4f5311236168a10a27");
    }

    @When("I update the user firstName with only 50 characters")
    public void iUpdateTheUserFirstNameWithOnly50Characters() {
        // Data yang akan diperbarui
        String requestBody = "{\"firstName\": \"aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyy\"}";

        // Mengirim permintaan PUT dengan data firstName hanya 50 karakter
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("app-id", "662e5c0abb70a7055e2595ba") 
                .body(requestBody)
                .request(Method.PUT, "user/60d0fe4f5311236168a10a27");
    }

    @When("I update the user with title and gender fields using the following data")
    public void iUpdateTheUserWithTitleAndGenderFieldsUsingTheFollowingData(Map<String, String> userData) {
        // Mengirim permintaan PUT dengan data yang diberikan
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("app-id", "662e5c0abb70a7055e2595ba") 
                .body(userData)
                .request(Method.PUT, "user/60d0fe4f5311236168a10a27");
    }

    @Then("I should receive  success response with status code {int}")
    public void iShouldReceiveAnSuccessResponseWithStatusCode(int expectedStatusCode) {
        assertEquals("Unexpected status code", expectedStatusCode, response.getStatusCode());
    }
    
}
