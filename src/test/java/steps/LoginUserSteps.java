package steps;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;

import java.io.File;

public class LoginUserSteps {
    String token;
    @Before
    public void setupBaseUrl(){
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
    }
    @Step("#actor is logged into the application")
    public String user_is_logged(){
        File loginUserRequest = new File("src/test/resources/json/loginUser.json");
        Response response = RestAssured.given().body(loginUserRequest)
                .contentType("application/json")
                .when().post("/users/login")
                .then().statusCode(200)
                .extract().response();
        token = response.jsonPath().getString("token");
        return token;
    }
}
