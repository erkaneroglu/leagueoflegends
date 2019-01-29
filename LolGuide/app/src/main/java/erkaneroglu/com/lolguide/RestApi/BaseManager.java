package erkaneroglu.com.lolguide.RestApi;

public class BaseManager {
    protected RestApi getRestApiClient() {
        RestApiClient restApiClient = new RestApiClient(BaseUrl.url_champ);
        return restApiClient.getmRestApi();
    }
}