package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import steps.LoginUserSteps;

public class LogOutStepDefinitions {
    int statusCode;
    Response response;
    @Steps(shared = true)
    LoginUserSteps loginUserSteps;
    @When("Sam requested the logout service")
    public void sam_requested_the_logout_service() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("he should exit the app")
    public void he_should_exit_the_app() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
