
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Assertions {

    @Step("And the status code should be <response_code>")
    public void statusCodeShouldEqual(Integer response_code) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        assertEquals(response_code, (Integer) dataStore.get("httpResponseCode"));
    }

    @Step("Then the response status line should contain <response_status_line>")
    public void responseStatusLineShouldContain(String response_status_line) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        assertEquals(response_status_line, (String) dataStore.get("httpResponseStatusText"));
    }

    @Step("And the response body should be <response_body>")
    public void responseBodyShouldEqual(String response_body) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        assertEquals(response_body, (String) dataStore.get("httpResponseBody"));
    }

    @Step("And the response body should contain the last updated value")
    public void responseBodyShouldContain() {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        assertNotNull((String) dataStore.get("lastUpdated"));
    }

}
