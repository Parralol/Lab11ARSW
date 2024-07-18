package co.edu.escuelaing.arws.interactiveblackboard.configurator;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class BBConfigurator {

    /**
     * @Autowired
     *            RestTemplateBuilder restTemplateBuilder;
     */
    /*
     * @Value(value = "${server.ssl.key-store}")
     * Resource keyStore = null;
     * 
     * @Value(value = "${server.ssl.trust-store}")
     * Resource trustStore = null;
     */

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    /**
     * @Bean("restTemplate")
     * public RestTemplate restTemplate(){
     * 
     * return restTemplateBuilder.requestFactory(() -> {
     * SSLContext sslContext = null;
     * try {
     * sslContext = SSLContextBuilder
     * .create()
     * .loadKeyMaterial(keyStore.getFile(), "admins".toCharArray(),
     * "admins".toCharArray())
     * .loadTrustMaterial(trustStore.getFile(), "admins".toCharArray())
     * .build();
     * } catch (KeyManagementException | UnrecoverableKeyException |
     * NoSuchAlgorithmException | KeyStoreException
     * | CertificateException | IOException e) {
     * e.printStackTrace();
     * }
     * 
     * SSLConnectionSocketFactory socketFactory = new
     * SSLConnectionSocketFactory(sslContext);
     * 
     * HttpClientConnectionManager connectionManager =
     * PoolingHttpClientConnectionManagerBuilder.create()
     * .setSSLSocketFactory(socketFactory)
     * .build();
     * 
     * org.apache.hc.client5.http.impl.classic.CloseableHttpClient c5 =
     * HttpClients.custom()
     * .setConnectionManager(connectionManager)
     * .evictExpiredConnections()
     * .build();
     * 
     * return new HttpComponentsClientHttpRequestFactory(c5);
     * }).build();}
     */
}
