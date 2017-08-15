import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;

public class Requests {
    
    private static final String BASE_URL = "http://localhost:3000/";
    
    @Step("Retrieve the last updated time from the <endpoint> endpoint")
    public void getEndPointForLastUpdatedTime(String endpoint) {
        getDataStoreForJson(getHttpResponseAsJson(endpoint), endpoint);
    }

    @Step("Get to the <endpoint> endpoint")
    public void getEndPoint(String endpoint) {
        getDataStore(getHttpResponseAsString(endpoint));
     }

    @Step("Post to the <endpoint> endpoint")
    public void PostEndPoint(String endpoint) {
        getDataStore(postHttpResponseAsString(endpoint));
    }
    
    private DataStore getDataStoreForJson(HttpResponse<JsonNode> httpResponse, String endpoint) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        dataStore.put("httpResponse", httpResponse);
        dataStore.put("httpResponseCode", httpResponse.getStatus());
        dataStore.put("httpResponseStatusText", httpResponse.getStatusText());
        dataStore.put("lastUpdated", httpResponse.getBody().getObject().getJSONArray(endpoint.substring(0, endpoint.length() - 5)).getJSONObject(0).get("lastUpdated").toString());
        return dataStore;
    }
    
    private DataStore getDataStore(HttpResponse<String> httpResponse) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        dataStore.put("httpResponse", httpResponse);
        dataStore.put("httpResponseCode", httpResponse.getStatus());
        dataStore.put("httpResponseStatusText", httpResponse.getStatusText());
        dataStore.put("httpResponseBody", httpResponse.getBody());
        return dataStore;
    }
    
    private HttpResponse<JsonNode> getHttpResponseAsJson(String endpoint) {
        String url = BASE_URL+endpoint;
        Gauge.writeMessage(url);
        try{
            return Unirest.get(url)
            .header("content-type", "application/json")
            .header("Accept", "*/*")
            .asJson();
        }catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    
    private HttpResponse<String> getHttpResponseAsString(String endpoint) {
        String url = BASE_URL+endpoint;
        Gauge.writeMessage(url);
        try{
            return Unirest.get(url)
                        .header("Content-Type", "application/json")
                        .header("Accept", "*/*")
                        .asString();
        }catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private HttpResponse<String> postHttpResponseAsString(String endpoint) {
        String url = BASE_URL+endpoint;
        Gauge.writeMessage(url);
        try{
            return Unirest.post(url)
                        .header("Content-Type", "application/json")
                        .header("Accept", "*/*")
                        .body("{\"test\": 123}")
                        .asString();
        }
        catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

}
