import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.CoreMatchers.containsString;

public class Forbidden extends BaseClass {
    @Test
    public void verifyStatusCodeForSuccessfulResponse(){
        getForbiddenEndpoint().then().statusCode(200);
    }

    @Test
    public void verifyStatusLineForSuccessfulResponse(){
        getForbiddenEndpoint().then().statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void verifyContentTypeForSuccessfulResponse(){
        getForbiddenEndpoint().then().contentType("text/html");
    }

    @Test
    public void verifyResponseBodyForSuccessfulResponse() throws IOException, JSONException {
        getForbiddenEndpoint().then().body(containsString("Automation Technical Test Web API"));
    }

    @Test
    public void verifyStatusCodeForIncorrectEndpoint(){
        getIncorrectForbiddenEndpoint().then().statusCode(404);
    }

    @Test
    public void verifyStatusLineForIncorrectEndpoint(){
        getIncorrectForbiddenEndpoint().then().statusLine("HTTP/1.1 404 Not Found");
    }

    @Test
    public void verifyContentTypeForIncorrectEndpoint(){
        getIncorrectForbiddenEndpoint().then().contentType("text/html");
    }

    @Test
    public void verifyResponseBodyForIncorrectEndpoint(){
        getIncorrectForbiddenEndpoint().then().body(containsString("Automation Technical Test Web API"));
    }

    @Test
    public void verifyStatusCodeForLastPostOfForbiddenEndpoint(){
        getLastPostOfForbiddenEndpoint().then().statusCode(200);
    }

    @Test
    public void verifyStatusLineForLastPostOfForbiddenEndpoint(){
        getLastPostOfForbiddenEndpoint().then().statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void verifyContentTypeForLastPostOfForbiddenEndpoint(){
        getLastPostOfForbiddenEndpoint().then().contentType("application/json");
    }

    @Test
    public void verifyResponseBodyForLastPostOfForbiddenEndpoint() throws IOException, JSONException {
        getLastPostOfForbiddenEndpoint().then().body(containsString("lastUpdated"));
    }

    @Test
    public void verifyStatusCodeForPostOfForbiddenEndpoint(){
        postToForbiddenEndpoint().then().statusCode(500);
    }

    @Test
    public void verifyStatusLineForPostOfForbiddenEndpoint(){
        postToForbiddenEndpoint().then().statusLine("HTTP/1.1 500 Internal Server Error");
    }

    @Test
    public void verifyContentTypeForPostOfForbiddenEndpoint(){
        postToForbiddenEndpoint().then().contentType("text/html; charset=utf-8");
    }

    @Test
    public void verifyResponseBodyForPostOfForbiddenEndpoint() throws IOException, JSONException {
        postToForbiddenEndpoint().then().body(containsString(""));
    }

    private Response getForbiddenEndpoint(){
        return given().when().get("/forbidden");
    }

    private Response getIncorrectForbiddenEndpoint(){
        return given().when().get("/forbid");
    }

    private Response getLastPostOfForbiddenEndpoint(){
        postToForbiddenEndpoint();
        return given().when().get("/forbidden/last");
    }

    private Response postToForbiddenEndpoint(){
        return given().config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("application/vnd.json", ContentType.JSON))).contentType("application/vnd.json").accept("application/json").body("{\"test\": 123}").when().get("/forbidden");
    }

}

