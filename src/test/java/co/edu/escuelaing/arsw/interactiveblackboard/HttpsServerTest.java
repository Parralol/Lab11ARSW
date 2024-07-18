package co.edu.escuelaing.arsw.interactiveblackboard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpsServerTest {

    @LocalServerPort
    private int port;

    @Value("${server.ssl.key-store}")
    private String keyStorePath;

    @Value("${server.ssl.key-store-password}")
    private String keyStorePassword;

    @Test
    public void testHttpsEndpoint() {
        String url = "https://localhost:" + port + "/secure-endpoint";
        ResponseEntity<String> response = new RestTemplate().getForEntity(url, String.class);
        assertEquals("Secure Response", response.getBody());
    }
}