package utils;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assume;
import org.junit.BeforeClass;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.*;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static org.hamcrest.Matchers.equalTo;

public class BaseTest {

    protected static final String BASE_ENDPOINT = ApplicationConfiguration.getInventaBaseURL();
    protected static final int INVENTA_PORT = Integer.parseInt(ApplicationConfiguration.getInventaServicePort());
    protected static final int CONNECTOR_PORT = Integer.parseInt(ApplicationConfiguration.getConnectorServicePort());

    //For Token
    public static final String SUBJECT = ApplicationConfiguration.getSubject();
    public static final int EXPIRATION_TIME = Integer.parseInt(ApplicationConfiguration.getExpirationTime());
    public static final String SECRET = ApplicationConfiguration.getSecretKey();

    protected static final String token = JWT.create()
            .withSubject(SUBJECT)
            .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .sign(HMAC512(SECRET.getBytes()));


    /**
     * Random Number Generation
     */
    static Random rand = new Random();
    public static final int value = rand.nextInt(5000);

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
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        URL url1 = new URL(url);
        URLConnection uc = url1.openConnection();
        String basicAuth = "Bearer " + token;

        uc.setRequestProperty("Authorization", basicAuth);
        InputStream is = uc.getInputStream();

        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static String getIdFromURL(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper(); // just need one
        String json = readJsonFromUrl(url).toString();
        Map<String, Object> map = mapper.readValue(json, Map.class);
        Assume.assumeNotNull(map.get("data"));
        Assume.assumeNotNull(((Map)map.get("data")).get("content"));
        Assume.assumeFalse(((List)((Map)map.get("data")).get("content")).isEmpty());
        Assume.assumeNotNull(((Map)((List)((Map)map.get("data")).get("content")).get(0)).get("_id"));
        return ((Map) ((List) ((Map) map.get("data")).get("content")).get(0)).get("_id") + "";

    }

    //will check later once siraj has fixed.
    public static String getIdFromPermissionURL(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper(); // just need one
        String json = readJsonFromUrl(url).toString();
        Map<String, Object> map = mapper.readValue(json, Map.class);
        //System.out.println(((Map) ((List) map.get("data")).get(3)).get("_id"));
        return ((Map) ((List) map.get("data")).get(3)).get("_id") + "";

    }

    public static RequestSpecification requestSpec;

    @BeforeClass
    public static void createRequestSpecification() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_ENDPOINT)
                .setPort(INVENTA_PORT)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }

    public static RequestSpecification requestSpecForConnector;

    @BeforeClass
    public static void createRequestSpecificationForConnector() {

        requestSpecForConnector = new RequestSpecBuilder()
                .setBaseUri(BASE_ENDPOINT)
                .setPort(CONNECTOR_PORT)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }

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
