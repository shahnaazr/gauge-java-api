import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.CoreMatchers.containsString;

public class NoResponse extends BaseClass {

    @Test
    public void verifyStatusCodeForSuccessfulResponse(){
        getNoResponseEndpoint().then().statusCode(200);
    }

    @Test
    public void verifyStatusLineForSuccessfulResponse(){
        getNoResponseEndpoint().then().statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void verifyContentTypeForSuccessfulResponse(){
        getNoResponseEndpoint().then().contentType("text/html");
    }

    @Test
    public void verifyResponseBodyForSuccessfulResponse() throws IOException, JSONException {
        getNoResponseEndpoint().then().body(containsString("What is 204 No Response"));
    }

    @Test
    public void verifyStatusCodeForIncorrectEndpoint(){
        getIncorrectNoResponseEndpoint().then().statusCode(404);
    }

    @Test
    public void verifyStatusLineForIncorrectEndpoint(){
        getIncorrectNoResponseEndpoint().then().statusLine("HTTP/1.1 404 Not Found");
    }

    @Test
    public void verifyContentTypeForIncorrectEndpoint(){
        getIncorrectNoResponseEndpoint().then().contentType("text/html");
    }

    @Test
    public void verifyResponseBodyForIncorrectEndpoint(){
        getIncorrectNoResponseEndpoint().then().body(containsString("Automation Technical Test Web API"));
    }

    @Test
    public void verifyStatusCodeForLastPostOfNoResponseEndpoint(){
        getLastPostOfNoResponseEndpoint().then().statusCode(200);
    }

    @Test
    public void verifyStatusLineForLastPostOfNoResponseEndpoint(){
        getLastPostOfNoResponseEndpoint().then().statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void verifyContentTypeForLastPostOfNoResponseEndpoint(){
        getLastPostOfNoResponseEndpoint().then().contentType("application/json");
    }

    @Test
    public void verifyResponseBodyForLastPostOfNoResponseEndpoint() throws IOException, JSONException {
        getLastPostOfNoResponseEndpoint().then().body(containsString("lastUpdated"));
    }

    @Test
    public void verifyStatusCodeForPostOfNoResponseEndpoint(){
        postToNoResponseEndpoint().then().statusCode(500);
    }

    @Test
    public void verifyStatusLineForPostOfNoResponseEndpoint(){
        postToNoResponseEndpoint().then().statusLine("HTTP/1.1 500 Internal Server Error");
    }

    @Test
    public void verifyContentTypeForPostOfNoResponseEndpoint(){
        postToNoResponseEndpoint().then().contentType("text/html; charset=utf-8");
    }

    @Test
    public void verifyResponseBodyForPostOfNoResponseEndpoint() throws IOException, JSONException {
        postToNoResponseEndpoint().then().body(containsString(""));
    }

    private Response getNoResponseEndpoint(){
        return given().when().get("/no_response");
    }

    private Response getIncorrectNoResponseEndpoint(){
        return given().when().get("/no_res");
    }

    private Response getLastPostOfNoResponseEndpoint(){
        postToNoResponseEndpoint();
        return given().when().get("/no_response/last");
    }

    private Response postToNoResponseEndpoint(){
        return given().config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("application/vnd.json", ContentType.JSON))).contentType("application/vnd.json").accept("application/json").body("{\"test\": 123}").when().get("/no_response");
    }

}
