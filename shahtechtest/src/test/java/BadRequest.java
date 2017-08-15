import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.CoreMatchers.containsString;

public class BadRequest extends BaseClass {
    @Test
    public void verifyStatusCodeForSuccessfulResponse(){
        getBadRequestEndpoint().then().statusCode(200);
    }

    @Test
    public void verifyStatusLineForSuccessfulResponse(){
        getBadRequestEndpoint().then().statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void verifyContentTypeForSuccessfulResponse(){
        getBadRequestEndpoint().then().contentType("text/html");
    }

    @Test
    public void verifyResponseBodyForSuccessfulResponse() throws IOException, JSONException {
        getBadRequestEndpoint().then().body(containsString("Automation Technical Test Web API"));
    }

    @Test
    public void verifyStatusCodeForIncorrectEndpoint(){
        getIncorrectBadRequestEndpoint().then().statusCode(404);
    }

    @Test
    public void verifyStatusLineForIncorrectEndpoint(){
        getIncorrectBadRequestEndpoint().then().statusLine("HTTP/1.1 404 Not Found");
    }

    @Test
    public void verifyContentTypeForIncorrectEndpoint(){
        getIncorrectBadRequestEndpoint().then().contentType("text/html");
    }

    @Test
    public void verifyResponseBodyForIncorrectEndpoint(){
        getIncorrectBadRequestEndpoint().then().body(containsString("Automation Technical Test Web API"));
    }

    @Test
    public void verifyStatusCodeForLastPostOfBadRequestEndpoint(){
        getLastPostOfBadRequestEndpoint().then().statusCode(200);
    }

    @Test
    public void verifyStatusLineForLastPostOfBadRequestEndpoint(){
        getLastPostOfBadRequestEndpoint().then().statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void verifyContentTypeForLastPostOfBadRequestEndpoint(){
        getLastPostOfBadRequestEndpoint().then().contentType("application/json");
    }

    @Test
    public void verifyResponseBodyForLastPostOfBadRequestEndpoint() throws IOException, JSONException {
        getLastPostOfBadRequestEndpoint().then().body(containsString("lastUpdated"));
    }

    @Test
    public void verifyStatusCodeForPostOfBadRequestEndpoint(){
        postToBadRequestEndpoint().then().statusCode(500);
    }

    @Test
    public void verifyStatusLineForPostOfBadRequestEndpoint(){
        postToBadRequestEndpoint().then().statusLine("HTTP/1.1 500 Internal Server Error");
    }

    @Test
    public void verifyContentTypeForPostOfBadRequestEndpoint(){
        postToBadRequestEndpoint().then().contentType("text/html; charset=utf-8");
    }

    @Test
    public void verifyResponseBodyForPostOfBadRequestEndpoint() throws IOException, JSONException {
        postToBadRequestEndpoint().then().body(containsString(""));
    }

    private Response getBadRequestEndpoint(){
        return given().when().get("/bad_request");
    }

    private Response getIncorrectBadRequestEndpoint(){
        return given().when().get("/bad_res");
    }

    private Response getLastPostOfBadRequestEndpoint(){
        postToBadRequestEndpoint();
        return given().when().get("/bad_request/last");
    }

    private Response postToBadRequestEndpoint(){
        return given().config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("application/vnd.json", ContentType.JSON))).contentType("application/vnd.json").accept("application/json").body("{\"test\": 123}").when().get("/bad_request");
    }

}
