package seminar_tasks.http_queries;

public class WebService {
    // использует HttpClient для получения данных с веб-сайта
    private HttpClient httpClient;

    public WebService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String webQuery(String url) {
        return httpClient.get(url);
    }

}
