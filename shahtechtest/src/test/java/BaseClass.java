import io.restassured.RestAssured;
import org.junit.BeforeClass;

public abstract class BaseClass {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;
    }


}
