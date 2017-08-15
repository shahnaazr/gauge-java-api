import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.CoreMatchers.containsString;

public class Unauthorized extends BaseClass {

    @Test
    public void verifyStatusCodeForSuccessfulResponse(){
        getUnauthorizedEndpoint().then().statusCode(200);
    }

    @Test
    public void verifyStatusLineForSuccessfulResponse(){
        getUnauthorizedEndpoint().then().statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void verifyContentTypeForSuccessfulResponse(){
        getUnauthorizedEndpoint().then().contentType("text/html");
    }

    @Test
    public void verifyResponseBodyForSuccessfulResponse() throws IOException, JSONException {
        getUnauthorizedEndpoint().then().body(containsString("What is a 401 Unauthorized"));
    }

    @Test
    public void verifyStatusCodeForIncorrectEndpoint(){
        getIncorrectUnauthorizedEndpoint().then().statusCode(404);
    }

    @Test
    public void verifyStatusLineForIncorrectEndpoint(){
        getIncorrectUnauthorizedEndpoint().then().statusLine("HTTP/1.1 404 Not Found");
    }

    @Test
    public void verifyContentTypeForIncorrectEndpoint(){
        getIncorrectUnauthorizedEndpoint().then().contentType("text/html");
    }

    @Test
    public void verifyResponseBodyForIncorrectEndpoint(){
        getIncorrectUnauthorizedEndpoint().then().body(containsString("What is a 404 Not Found"));
    }

    @Test
    public void verifyStatusCodeForLastPostOfUnauthorizedEndpoint(){
        getLastPostOfUnauthorizedEndpoint().then().statusCode(200);
    }

    @Test
    public void verifyStatusLineForLastPostOfUnauthorizedEndpoint(){
        getLastPostOfUnauthorizedEndpoint().then().statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void verifyContentTypeForLastPostOfUnauthorizedEndpoint(){
        getLastPostOfUnauthorizedEndpoint().then().contentType("application/json");
    }

    @Test
    public void verifyResponseBodyForLastPostOfUnauthorizedEndpoint() throws IOException, JSONException {
        getLastPostOfUnauthorizedEndpoint().then().body(containsString("lastUpdated"));
    }

    @Test
    public void verifyStatusCodeForPostOfUnauthorizedEndpoint(){
        postToUnauthorizedEndpoint().then().statusCode(500);
    }

    @Test
    public void verifyStatusLineForPostOfUnauthorizedEndpoint(){
        postToUnauthorizedEndpoint().then().statusLine("HTTP/1.1 500 Internal Server Error");
    }

    @Test
    public void verifyContentTypeForPostOfUnauthorizedEndpoint(){
        postToUnauthorizedEndpoint().then().contentType("text/html; charset=utf-8");
    }

    @Test
    public void verifyResponseBodyForPostOfUnauthorizedEndpoint() throws IOException, JSONException {
        postToUnauthorizedEndpoint().then().body(containsString(""));
    }

    private Response getUnauthorizedEndpoint(){
        return given().when().get("/unauthorized");
    }

    private Response getIncorrectUnauthorizedEndpoint(){
        return given().when().get("/unauth");
    }

    private Response getLastPostOfUnauthorizedEndpoint(){
                postToUnauthorizedEndpoint();
        return given().when().get("/unauthorized/last");
    }

    private Response postToUnauthorizedEndpoint(){
        return given().config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("application/vnd.json", ContentType.JSON))).contentType("application/vnd.json").accept("application/json").body("{\"test\": 123}").when().get("/unauthorized");
    }

}
