package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import steps.GetContactsSteps;
import steps.LoginUserSteps;
import java.io.File;

public class updateContactStepDefinitons {
    Response response;
    File updateContact;
    @Steps(shared = true)
    LoginUserSteps loginUserSteps;
    @Steps(shared = true)
    GetContactsSteps getContactsSteps;
    @When("Sam try to update the contact")
    public void sam_try_to_update_the_contact() {
        String token = loginUserSteps.getToken();
        String idContact = getContactsSteps.idNewContact();
        updateContact = new File("src/test/resources/json/updateContact.json");
        response = RestAssured.given().body(updateContact)
                .auth().oauth2(token)
                .contentType("application/json")
                .when().put("/contacts/" + idContact)
                .then().statusCode(200)
                .extract().response();
    }

    @Then("he should see the contact updated")
    public void he_should_see_the_contact_updated() throws JSONException {

    }

}
