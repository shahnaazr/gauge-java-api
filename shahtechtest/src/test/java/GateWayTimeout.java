import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.CoreMatchers.containsString;

public class GateWayTimeout extends BaseClass {
    @Test
    public void verifyStatusCodeForSuccessfulResponse(){
        getGatewayTimeoutEndpoint().then().statusCode(200);
    }

    @Test
    public void verifyStatusLineForSuccessfulResponse(){
        getGatewayTimeoutEndpoint().then().statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void verifyContentTypeForSuccessfulResponse(){
        getGatewayTimeoutEndpoint().then().contentType("text/html");
    }

    @Test
    public void verifyResponseBodyForSuccessfulResponse() throws IOException, JSONException {
        getGatewayTimeoutEndpoint().then().body(containsString("Automation Technical Test Web API"));
    }

    @Test
    public void verifyStatusCodeForIncorrectEndpoint(){
        getIncorrectGatewayTimeoutEndpoint().then().statusCode(404);
    }

    @Test
    public void verifyStatusLineForIncorrectEndpoint(){
        getIncorrectGatewayTimeoutEndpoint().then().statusLine("HTTP/1.1 404 Not Found");
    }

    @Test
    public void verifyContentTypeForIncorrectEndpoint(){
        getIncorrectGatewayTimeoutEndpoint().then().contentType("text/html");
    }

    @Test
    public void verifyResponseBodyForIncorrectEndpoint(){
        getIncorrectGatewayTimeoutEndpoint().then().body(containsString("Automation Technical Test Web API"));
    }

    @Test
    public void verifyStatusCodeForLastPostOfGatewayTimeoutEndpoint(){
        getLastPostOfGatewayTimeoutEndpoint().then().statusCode(200);
    }

    @Test
    public void verifyStatusLineForLastPostOfGatewayTimeoutEndpoint(){
        getLastPostOfGatewayTimeoutEndpoint().then().statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void verifyContentTypeForLastPostOfGatewayTimeoutEndpoint(){
        getLastPostOfGatewayTimeoutEndpoint().then().contentType("application/json");
    }

    @Test
    public void verifyResponseBodyForLastPostOfGatewayTimeoutEndpoint() throws IOException, JSONException {
        getLastPostOfGatewayTimeoutEndpoint().then().body(containsString("lastUpdated"));
    }

    @Test
    public void verifyStatusCodeForPostOfGatewayTimeoutEndpoint(){
        postToGatewayTimeoutEndpoint().then().statusCode(500);
    }

    @Test
    public void verifyStatusLineForPostOfGatewayTimeoutEndpoint(){
        postToGatewayTimeoutEndpoint().then().statusLine("HTTP/1.1 500 Internal Server Error");
    }

    @Test
    public void verifyContentTypeForPostOfGatewayTimeoutEndpoint(){
        postToGatewayTimeoutEndpoint().then().contentType("text/html; charset=utf-8");
    }

    @Test
    public void verifyResponseBodyForPostOfGatewayTimeoutEndpoint() throws IOException, JSONException {
        postToGatewayTimeoutEndpoint().then().body(containsString(""));
    }

    private Response getGatewayTimeoutEndpoint(){
        return given().when().get("/gateway_timeout");
    }

    private Response getIncorrectGatewayTimeoutEndpoint(){
        return given().when().get("/gateway");
    }

    private Response getLastPostOfGatewayTimeoutEndpoint(){
        postToGatewayTimeoutEndpoint();
        return given().when().get("/gateway_timeout/last");
    }

    private Response postToGatewayTimeoutEndpoint(){
        return given().config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("application/vnd.json", ContentType.JSON))).contentType("application/vnd.json").accept("application/json").body("{\"test\": 123}").when().get("/gateway_timeout");
    }

}

