package utils;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.*;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class BaseAPI {

    protected static final String BASE_ENDPOINT_INVENTA = ApplicationConfiguration.getBaseURL_InventaService();
    protected static final String BASE_ENDPOINT_CONNECTOR = ApplicationConfiguration.getBaseURL_ConnectorService();

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
        //System.out.println(((Map) ((List) ((Map) map.get("data")).get("content")).get(0)).get("_id"));

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

    public static String DEVICE_DETAIL_ID = "";
    public static String USER_ID = "";
    public static String ROLE_ID = "";
    public static String PERMISSION_ID = "";
    public static String ADMIN_USER_ID = "";
    public static String AUDIT_DETAIL_ID = "";
    public static String DELETE_ADMIN_USER_ID = "";
    public static String USER_AUDIT_ID = "";
    public static String DELETE_ROLE_ID = "";

    static {
        try {

            DEVICE_DETAIL_ID = getIdFromURL("http://inventaserver:9092/devices/getAllDevices?page=0&size=1&sortBy=_id");
            USER_ID = getIdFromURL("http://inventaserver:9092/users/getAllUsers/?page=0&size=1&sort=dateCreated,desc");
            ROLE_ID = getIdFromURL("http://inventaserver:9092/role/getAllRole?page=0&size=1&sort=dateCreated,desc");
            PERMISSION_ID = getIdFromPermissionURL("http://inventaserver:9092/permission/getAllPermission");
            ADMIN_USER_ID = getIdFromURL("http://inventaserver:9092/adminUsers/getAllAdminUsers?page=0&size=1&sort=dateCreated,desc"); // Update Parameter in Endpoint
            AUDIT_DETAIL_ID = getIdFromURL("http://inventaserver:9092/audit/getAllAudit?page=0&size=1&sort=dateCreated,desc");
            DELETE_ADMIN_USER_ID = getIdFromURL("http://inventaserver:9092/adminUsers/getAllAdminUsers?page=0&size=1&sort=dateModified,desc"); //add new endpoint
            USER_AUDIT_ID = getIdFromURL("http://inventaserver:9092/audit/getUserAudit?username=admininventa&page=0&size=1"); //add new endpoint
            DELETE_ROLE_ID = getIdFromURL("http://inventaserver:9092/role/getAllRole?page=0&size=1&sort=dateModified,desc");

            //http://inventaserver:9092/devices/getAllDevices?page=0&size=1&sort=firstFetchTime,desc

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
