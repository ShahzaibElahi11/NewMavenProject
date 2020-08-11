package utils;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;


import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class BaseClass {

    protected CloseableHttpClient client;
    protected CloseableHttpResponse response;
//
//    @Before
//    public void setup() {
//        client = HttpClientBuilder.create().build();
//
//    }
//
//    @After
//    public void closeResources() throws IOException {
//        client.close();
//        response.close();
//    }



    protected static final String BASE_ENDPOINT_INVENTA = ApplicationConfiguration.getBaseURL_InventaService();
    protected static final String BASE_ENDPOINT_ADAPTER = ApplicationConfiguration.getBaseURL_AdapterService();

    //For Token
    public static final String SUBJECT = ApplicationConfiguration.getSubject();
    public static final int EXPIRATION_TIME = Integer.parseInt(ApplicationConfiguration.getExpirationTime());
    public static final String SECRET = ApplicationConfiguration.getSecretKey();

    protected static final String token = JWT.create()
            .withSubject(SUBJECT)
            .withExpiresAt(new Date(System.currentTimeMillis()+ EXPIRATION_TIME))
            .sign(HMAC512(SECRET.getBytes()));




    /**
     * Random Number Generation
     */
    static Random rand = new Random();
    protected static final int value = rand.nextInt(5000);

    //protected static final String randomString = RandomStringUtils.randomAlphabetic(8);



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
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
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
        Map<String,Object> map = mapper.readValue(json, Map.class);
        System.out.println(((Map)((List)((Map)map.get("data")).get("content")).get(0)).get("_id"));


        return ((Map)((List)((Map)map.get("data")).get("content")).get(0)).get("_id")+"";
    }
    public static String getIdFromRolePermissionURL(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper(); // just need one
        String json = readJsonFromUrl(url).toString();
        Map<String,Object> map = mapper.readValue(json, Map.class);
        System.out.println (((Map)((List)map.get("data")).get(4)).get("_id"));

        return ((Map)((List)map.get("data")).get(4)).get("_id")+"";

    }
    public static String getNameFromSaveQueryWizardURL(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper(); // just need one
        String json = readJsonFromUrl(url).toString();
        Map<String,Object> map = mapper.readValue(json, Map.class);
        //System.out.println(((Map)((List)((Map)map.get("data")).get("content")).get(0)).get("name"));


        return ((Map)((List)((Map)map.get("data")).get("content")).get(0)).get("name")+"";
    }

    public static String DEVICE_DETAIL_ID = "";
    public static String USER_ID = "";
    public static String PR_ID = "";
    public static String PERMISSION_ID = "";
    public static String ROLE_ID = "";
    public static String ADMIN_USER_ID = "";
    public static String SAVED_DEVICE_QUERY_NAME = "";
    public static String SAVED_USER_QUERY_NAME = "";
    public static String AUDIT_DETAIL_ID = "";
   // public static String Delete_ROLE_ID = "";

    static {
        try {
            DEVICE_DETAIL_ID = getIdFromURL("http://inventaserver:9092/devices/getAllDevices?page=0&size=1&sortBy=_id");
            USER_ID = getIdFromURL("http://inventaserver:9092/users/getAllUsers/?page=0&size=1");
            PR_ID = getIdFromURL("http://inventaserver:9092/policy-routine/?page=0&size=1");
            PERMISSION_ID = getIdFromRolePermissionURL("http://inventaserver:9092/permission/getAllPermission?page=0&size=1");
            ROLE_ID = getIdFromRolePermissionURL("http://inventaserver:9092/role/getAllRole?page=0&size=1");
            ADMIN_USER_ID = getIdFromURL("http://inventaserver:9092/adminUsers/getAllAdminUsers?page=0&size=1");
            SAVED_DEVICE_QUERY_NAME = getNameFromSaveQueryWizardURL("http://inventaserver:9092/saved-query/?type=DEVICE&page=0&size=1");
            SAVED_USER_QUERY_NAME = getNameFromSaveQueryWizardURL("http://inventaserver:9092/saved-query/?type=USER&page=0&size=1");
            AUDIT_DETAIL_ID = getIdFromURL("http://inventaserver:9092/audit/getAllAudit?page=0&size=1");
            //Delete_ROLE_ID = getIdFromRolePermissionURL("http://inventaserver:9092/role/getAllRole?page=0&size=1");



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
