package testcases;

import api.AdapterConfigurationApis;
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
import utils.BaseClass;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class TestAdapterConfiguration extends BaseClass {
    public final static String ADAPTER_ENDPOINT = "/adapters/";
    public final static String ADAPTER_CONFIGURATION = "active-directory/configure/?type=";
    public final static String ADAPTER_AD_AZURE_CONFIGURATION = "active-directory/configure";


    @Test
    public void GetAllAdaptersNew(){
        Response response = AdapterConfigurationApis.getAllAdapters();
        assertThat(response.getStatusCode(),equalTo(200));
    }


    @Test
    public void GetADAdapterConfigurationNew(){
        Response response = AdapterConfigurationApis.getAdAdapterConfiguration();
        assertThat(response.getStatusCode(),equalTo(200));

    }
    @Test
    public void GetAWSAdapterConfigurationNew(){
        Response response = AdapterConfigurationApis.getAwsAdapterConfiguration();
        assertThat(response.getStatusCode(),equalTo(200));
    }
    @Test
    public void GetAZUREAdapterConfigurationNew(){
        Response response = AdapterConfigurationApis.getAzureAdapterConfiguration();
        assertThat(response.getStatusCode(),equalTo(200));
    }

    @Test
    public void GetAllAdapters() throws IOException {
        HttpGet get = new HttpGet(ADAPTER_CONFIG_ENDPOINT + ADAPTER_ENDPOINT );
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }


    @Test
    public void GetADAdapterConfiguration() throws IOException {
        HttpGet get = new HttpGet(ADAPTER_CONFIG_ENDPOINT + ADAPTER_ENDPOINT + ADAPTER_CONFIGURATION + "ad");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }


    @Test
    public void GetAWSAdapterConfiguration() throws IOException {
        HttpGet get = new HttpGet(ADAPTER_CONFIG_ENDPOINT + ADAPTER_ENDPOINT + ADAPTER_CONFIGURATION + "aws");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetAZUREAdapterConfiguration() throws IOException {
        HttpGet get = new HttpGet(ADAPTER_CONFIG_ENDPOINT + ADAPTER_ENDPOINT + ADAPTER_CONFIGURATION + "azure");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }


    @Test(enabled = false)  //Validation issue - https://netpace.atlassian.net/browse/VIN-1621
    public void PostAWSConfiguration()throws IOException {

        HttpPost request = new HttpPost(ADAPTER_CONFIG_ENDPOINT + "/aws/configure");
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{\"aws.accessKeyId\": \"AKIAYNDI4PCCT4BQ3HOE\", \"aws.accessKeySecret\": \"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\", \"aws.allRegionEnabled\": false, \"aws.configured\": true, \"aws.region\": \"us-east-1\" }";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test(enabled = false)
    public void PostAzureConfiguration()throws IOException {

        HttpPost request = new HttpPost(ADAPTER_CONFIG_ENDPOINT + ADAPTER_ENDPOINT + ADAPTER_AD_AZURE_CONFIGURATION);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{\"azure.clientId\": \"a40ab72d-e920-421d-ab66-515a59e11cb7\", \"azure.clientSecret\": \"L@lVOB4G6hoR[E/.K7l9mIn1O34.D_1f\", \"azure.subscriptionId\": \"b433aca0-7a45-446f-a16a-598111f218fb\", \"azure.tenantId\": \"ba164d97-20d4-4ca8-a610-28902882de11\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test(enabled = false)
    public void PostADConfiguration()throws IOException {

        HttpPost request = new HttpPost(ADAPTER_CONFIG_ENDPOINT + ADAPTER_ENDPOINT + ADAPTER_AD_AZURE_CONFIGURATION);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{\"ad.base\": \"dc=inventa12,dc=com\",\"ad.connectToGC\": false,\"ad.connectionTimeout\": 2000,\"ad.customDns\": \"192.168.1.121\",\"ad.enableIpResolving\": false,\"ad.enabled\": true,\"ad.fetchDisabledDevicesAndUsers\": true,\"ad.fetchUserImages\": false,\"ad.fetchUsers\": true,\"ad.pageSize\": 100,\"ad.password\": \"Netp@ce456\",\"ad.url\": \"192.168.1.121\",\"ad.useSSL\": false,\"ad.userDn\": \"administrator@inventa12.com\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }


}
