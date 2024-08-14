package contactList;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;


public class CreateContactStepDefinitions {
    String token;
    int statusCode;
    @Before
    public void setupBaseUrl(){
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
    }


    @Given("^(.*) is logged into the application")
    public void user_is_logged_in_the_application(String user) {
        File loginUserRequest = new File("src/test/resources/json/loginUser.json");
        Response response = RestAssured.given().body(loginUserRequest)
                .contentType("application/json")
                .when().post("/users/login")
                .then().statusCode(200)
                .extract().response();
        token = response.jsonPath().getString("token");
        //return token;
    }

    @When("^(.*) requested the add contact service")
    public void user_requested_the_add_contact_service(String user) {
        File addContact = new File("src/test/resources/json/addContact.json");
        Response responseContact = RestAssured.given().body(addContact)
                .auth().oauth2(token)
                .contentType("application/json")
                .when().post("/contacts")
                .then().statusCode(201)
                .extract().response();
        statusCode = responseContact.statusCode();
    }

    @Then("he should see the newly created contact")
    public void user_should_see_the_new_created_user() {
        assertEquals(statusCode, 201);
    }

}
