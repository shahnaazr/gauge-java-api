
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Test;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.CoreMatchers.containsString;

public class InternalServerError extends BaseClass {

    @Test
    public void verifyStatusCodeForSuccessfulResponse(){
        getInternalServerErrorEndpoint().then().statusCode(200);
    }

    @Test
    public void verifyStatusLineForSuccessfulResponse(){
        getInternalServerErrorEndpoint().then().statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void verifyContentTypeForSuccessfulResponse(){
        getInternalServerErrorEndpoint().then().contentType("text/html");
    }

    @Test
    public void verifyResponseBodyForSuccessfulResponse() throws IOException, JSONException {
        getInternalServerErrorEndpoint().then().body(containsString("What is a 500 Internal Server Error"));
    }

    @Test
    public void verifyStatusCodeForIncorrectEndpoint(){
        getIncorrectInternalServerErrorEndpoint().then().statusCode(404);
    }

    @Test
    public void verifyStatusLineForIncorrectEndpoint(){
        getIncorrectInternalServerErrorEndpoint().then().statusLine("HTTP/1.1 404 Not Found");
    }

    @Test
    public void verifyContentTypeForIncorrectEndpoint(){
        getIncorrectInternalServerErrorEndpoint().then().contentType("text/html");
    }

    @Test
    public void verifyResponseBodyForIncorrectEndpoint(){
        getIncorrectInternalServerErrorEndpoint().then().body(containsString("What is a 404 Not Found"));
    }

    @Test
    public void verifyStatusCodeForLastPostOfInternalServerErrorEndpoint(){
        getLastPostOfInternalServerErrorEndpoint().then().statusCode(200);
    }

    @Test
    public void verifyStatusLineForLastPostOfInternalServerErrorEndpoint(){
        getLastPostOfInternalServerErrorEndpoint().then().statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void verifyContentTypeForLastPostOfInternalServerErrorEndpoint(){
        getLastPostOfInternalServerErrorEndpoint().then().contentType("application/json");
    }

    @Test
    public void verifyResponseBodyForLastPostOfInternalServerErrorEndpoint() throws IOException, JSONException {
        getLastPostOfInternalServerErrorEndpoint().then().body(containsString("lastUpdated"));
    }

    @Test
    public void verifyStatusCodeForPostOfInternalServerErrorEndpoint(){
        postToInternalServerErrorEndpoint().then().statusCode(500);
    }

    @Test
    public void verifyStatusLineForPostOfInternalServerErrorEndpoint(){
        postToInternalServerErrorEndpoint().then().statusLine("HTTP/1.1 500 Internal Server Error");
    }

    @Test
    public void verifyContentTypeForPostOfInternalServerErrorEndpoint(){
        postToInternalServerErrorEndpoint().then().contentType("text/html; charset=utf-8");
    }

    @Test
    public void verifyResponseBodyForPostOfInternalServerErrorEndpoint() throws IOException, JSONException {
        postToInternalServerErrorEndpoint().then().body(containsString(""));
    }

    private Response getInternalServerErrorEndpoint(){
        return given().when().get("/internal_server_error");
    }

    private Response getIncorrectInternalServerErrorEndpoint(){
        return given().when().get("/internal_server");
    }

    private Response getLastPostOfInternalServerErrorEndpoint(){
                postToInternalServerErrorEndpoint();
        return given().when().get("/internal_server_error/last");
    }

    private Response postToInternalServerErrorEndpoint(){
        return given().config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("application/vnd.json", ContentType.JSON))).contentType("application/vnd.json").accept("application/json").body("{\"test\": 123}").when().get("/internal_server_error");
    }

}
