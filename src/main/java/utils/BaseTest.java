package utils;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.Assume;
import org.junit.BeforeClass;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static org.hamcrest.Matchers.equalTo;

public class BaseTest {

    protected static final String BASE_ENDPOINT = ApplicationConfiguration.getInventaBaseUrl();
    protected static final int INVENTA_PORT = Integer.parseInt(ApplicationConfiguration.getInventaServicePort());
    protected static final int CONNECTOR_PORT = Integer.parseInt(ApplicationConfiguration.getConnectorServicePort());

    //For Token
    public static final String SUBJECT = ApplicationConfiguration.getSubject();
    public static final int EXPIRATION_TIME = Integer.parseInt(ApplicationConfiguration.getExpirationTime());
    public static final String SECRET = ApplicationConfiguration.getSecretKey();
    public static final String BEARER = "Bearer ";
    public static final String AUTHORIZATION = "Authorization";

    protected static final String TOKEN = JWT.create()
            .withSubject(SUBJECT)
            .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .sign(HMAC512(SECRET.getBytes()));

    public static final String CONTENT = "content";
    public static final String DATA = "data";
    public static final String ID = "_id";



    /**
     * Random Number Generation
     */
    static Random rand = new Random();
    public static final int VALUE = rand.nextInt(5000);

    /**
     * ID Extraction Implementation
     */

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    //Changes - Add Token implementation in this function
    public static JSONObject readJsonFromUrl(String url) throws IOException {
        URL url1 = new URL(url);
        URLConnection uc = url1.openConnection();
        String basicAuth = BEARER + TOKEN;

        uc.setRequestProperty(AUTHORIZATION, basicAuth);

        try (InputStream is = uc.getInputStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            JSONObject json;
            json = new JSONObject(jsonText);
            return json;
        }
    }

    public static String getIdFromURL(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper(); // just need one
        String json = readJsonFromUrl(url).toString();
        Map<String, Object> map = mapper.readValue(json, Map.class);
        Assume.assumeNotNull(map.get(DATA));
        Assume.assumeNotNull(((Map)map.get(DATA)).get(CONTENT));
        Assume.assumeFalse(((List)((Map)map.get(DATA)).get(CONTENT)).isEmpty());
        Assume.assumeNotNull(((Map)((List)((Map)map.get(DATA)).get(CONTENT)).get(0)).get(ID));
        return ((Map) ((List) ((Map) map.get(DATA)).get(CONTENT)).get(0)).get(ID) + "";

    }

    //will check later once siraj has fixed.
    public static String getIdFromPermissionURL(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper(); // just need one
        String json = readJsonFromUrl(url).toString();
        Map<String, Object> map = mapper.readValue(json, Map.class);
        return ((Map) ((List) map.get(DATA)).get(0)).get(ID) + "";

    }

    /*******************************************************
     * Create a static RequestSpecification for Inevnta Fronted Application :
     * - Set the Request Base URL
     * - Set the Request URL Port
     * - Set the Request contentType is JSON
     * - Set the Request AUTHORIZATION in the header
     ******************************************************/

    public static RequestSpecification requestSpec;

    @BeforeClass
    public static void createRequestSpecification() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_ENDPOINT)
                .setPort(INVENTA_PORT)
                .setContentType(ContentType.JSON)
                .addHeader(AUTHORIZATION, BEARER + TOKEN)
                .build();
    }

    /*******************************************************
     * Create a static RequestSpecification for Inevnta Connector:
     * - Set the Request Base URL
     * - Set the Request URL Port
     * - Set the Request contentType is JSON
     * - Set the Request AUTHORIZATION in the header
     ******************************************************/

    public static RequestSpecification requestSpecForConnector;

    @BeforeClass
    public static void createRequestSpecificationForConnector() {

        requestSpecForConnector = new RequestSpecBuilder()
                .setBaseUri(BASE_ENDPOINT)
                .setPort(CONNECTOR_PORT)
                .setContentType(ContentType.JSON)
                .addHeader(AUTHORIZATION, BEARER + TOKEN)
                .build();
    }


    /*******************************************************
     * Create a static ResponseSpecification that checks whether:
     * - the response has statusCode 200
     * - the response contentType is JSON
     * - the value of 'meta.status ' in the response body
     *   is equal to 'success'
     ******************************************************/

    public static ResponseSpecification responseSpec;

    @BeforeClass
    public static void createResponseSpecification() {

        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(HttpStatus.SC_OK).
                expectContentType(ContentType.JSON).
                expectBody("meta.status", equalTo("success")).
                build();

    }

}
