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


public class CreateMethodSteps{
    private RequestSpecification httpRequest;
    private Response response;
    private String title;
    private String firstName;
    private String lastName;
    private String picture;
    private String gender;
    private String email;
    private String dateOfBirth;
    private String phone;
    private String street;
    private String city;
    private String state;
    private String country;
    private String timezone;

    @Given("I have user data to create")
    public void iHaveUserDataToCreate() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        httpRequest = RestAssured.given().header("app-id", "662e51efbb70a7543a259560").contentType(ContentType.JSON);
    }

    
    @Given("I have user data with an email that is already in use")
    public void iHaveUserDataWithAnEmailThatIsAlreadyInUse() {
        iHaveUserDataToCreate();
        email = "paisall1@gmail.com";
    }

    @Given("I have user data with a last name exceeding 50 characters")
    public void iHaveUserDataWithALastNameExceeding50Characters() {
        iHaveUserDataToCreate();
        lastName = "jekijekijekijekijekijekijekijerrrrrrrrrrrrrrrrrrrr";
    }

    @Given("I have user data with a blank first name")
    public void iHaveUserDataWithABlankFirstName() {
        iHaveUserDataToCreate();
        lastName = "";
    }

    @Given("I have user data with a blank email")
    public void iHaveUserDataWithABlankEmail() {
        iHaveUserDataToCreate();
        email = "";
    }

    @When("I send a POST request to create the user")
    public void iSendAPOSTRequestToCreateTheUser() {
        String requestBody = "{\n" +
                "    \"title\": \"" + title + "\",\n" +
                "    \"firstName\": \"" + firstName + "\",\n" +
                "    \"lastName\": \"" + lastName + "\",\n" +
                "    \"picture\": \"" + picture + "\",\n" +
                "    \"gender\": \"" + gender + "\",\n" +
                "    \"email\": \"" + email + "\",\n" +
                "    \"dateOfBirth\": \"" + dateOfBirth + "\",\n" +
                "    \"phone\": \"" + phone + "\",\n" +
                "    \"location\": {\n" +
                "        \"street\": \"" + street + "\",\n" +
                "        \"city\": \"" + city + "\",\n" +
                "        \"state\": \"" + state + "\",\n" +
                "        \"country\": \"" + country + "\",\n" +
                "        \"timezone\": \"" + timezone + "\"\n" +
                "    }\n" +
                "}";
        httpRequest.body(requestBody);
        response = httpRequest.request(Method.POST, "/user/create");
    }

    @Then("I should receive a success response with status code {int}")
    public void iShouldReceiveASuccessResponseWithStatusCode(int expectedStatusCode) {
        assertEquals("Unexpected status code", expectedStatusCode, response.getStatusCode());
    }

    @Then("I should receive an error response with status code {int}")
    public void iShouldReceiveAnErrorResponseWithStatusCode(int expectedStatusCode) {
        assertEquals("Unexpected status code", expectedStatusCode, response.getStatusCode());
    }


    @Given("I have the following user data:")
    public void iHaveTheFollowingUserData(io.cucumber.datatable.DataTable dataTable) {
        title = dataTable.cell(1, 0);
        firstName = dataTable.cell(1, 1);
        lastName = dataTable.cell(1, 2);
        picture = dataTable.cell(1, 3);
        gender = dataTable.cell(1, 4);
        email = dataTable.cell(1, 5);
        dateOfBirth = dataTable.cell(1, 6);
        phone = dataTable.cell(1, 7);
        street = dataTable.cell(1, 8);
        city = dataTable.cell(1, 9);
        state = dataTable.cell(1, 10);
        country = dataTable.cell(1, 11);
        timezone = dataTable.cell(1, 12);
    }
}
