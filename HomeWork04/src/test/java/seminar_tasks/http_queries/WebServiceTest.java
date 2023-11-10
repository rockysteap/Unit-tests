package seminar_tasks.http_queries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WebServiceTest {
    // нужно написать тест с использованием моков для класса, который выполняет HTTP-запросы

    @Test
    void HTTPQueriesWebService() {
        HttpClient httpClient = mock(HttpClient.class);
        WebService webService = new WebService(httpClient);

        String reference = """
                Access-Control-Allow-Credentials: true
                Access-Control-Allow-Headers: DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Authorization
                Access-Control-Allow-Methods: PUT, GET, POST, OPTIONS
                Access-Control-Allow-Origin: *
                Access-Control-Max-Age: 1728000
                Content-Encoding: gzip
                Content-Type: text/html
                Date: Fri, 10 Nov 2023 08:39:07 GMT
                Etag: W/"6449337d-16c"
                Last-Modified: Wed, 26 Apr 2023 14:21:49 GMT
                Strict-Transport-Security: max-age=15724800; includeSubDomains
                Vary: Accept-Encoding
                """;

        when(httpClient.get("gb.ru")).thenReturn(reference);

        assertEquals(reference, webService.webQuery("gb.ru"));
    }
}
