package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import steps.GetContactsSteps;
import steps.LoginUserSteps;

import static org.junit.Assert.assertEquals;

public class GetContactStepDefinition {
    String idContacts;
    String token;
    int statusCode;
    @Steps(shared = true)
    LoginUserSteps loginUserSteps;
    @Steps(shared = true)
    GetContactsSteps getContactsSteps;
    @When("^(.*) requested the contact service")
    public void sam_requested_the_contact_service(String actor) {
        token = loginUserSteps.getToken();
        idContacts = getContactsSteps.idNewContact();
    }
    @Then("he should see the contact requested")
    public void he_should_see_the_contact_requested() {
        Response response = RestAssured.given()
                .auth().oauth2(token)
                .contentType("application/json")
                .when().get("/contacts/" + idContacts)
                .then().statusCode(200)
                .extract().response();
        String idContact = response.jsonPath().getString("_id");
        assertEquals(idContacts, idContact);
    }

}
