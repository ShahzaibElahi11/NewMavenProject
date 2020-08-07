package testcases;

import api.Apis;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import models.AdLogin;
import utils.BaseClass;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class TestLDAP extends BaseClass {

    public static final String CONFIG_ENDPOINT = "/config/";
    public static final String CONFIG_TYPE = "?type=ldap";
    public static final String AD_LOGIN = "/ad/login/";

    public static final String LDAP_MACHINE_IP = "ldap://192.168.1.20:389";
    public static final String LDAP_DOMAIN = "inventa.local";
    public static final String AD_USERNAME = "arsalansiddiq";
    public static final String AD_PASSWORD = "Netpace123";



    @Test
    public void PostConfigureLDAP()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + CONFIG_ENDPOINT);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);
        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{\"ldap.url\": \""+LDAP_MACHINE_IP+"\", \"ldap.domain\": \""+LDAP_DOMAIN+"\", \"ldap.role\": \""+ROLE_ID+"\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void GetLDAPConfiguration() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + CONFIG_ENDPOINT + CONFIG_TYPE);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void PostADLogin()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + AD_LOGIN);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);
        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{\"username\": \""+AD_USERNAME+"\", \"password\":\""+AD_PASSWORD+"\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }
    @Test
    public void PostADLoginNew(){

        AdLogin adLogin = new AdLogin("arsalansiddiq", "Netpace123");
        Response response = Apis.postAdLogin(adLogin);
        assertThat(response.getStatusCode(), equalTo(200));

    }
}
