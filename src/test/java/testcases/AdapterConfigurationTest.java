package testcases;

import api.AdapterConfiguration;
import io.restassured.response.Response;
import models.configuration.AwsConfiguration;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.ApplicationConfiguration;
import utils.BaseClass;

import java.io.IOException;
import java.nio.charset.Charset;


@RunWith(SerenityRunner.class)
public class AdapterConfigurationTest extends BaseClass {
    public final static String ADAPTER_ENDPOINT = "/adapters/";
    public final static String ADAPTER_CONFIGURATION = "active-directory/configure/?type=";
    public final static String ADAPTER_AD_AZURE_CONFIGURATION = "active-directory/configure";

    protected static final String AWS_KEY_ID = ApplicationConfiguration.getAwsKeyId();
    protected static final String AWS_SECRET_KEY = ApplicationConfiguration.getAwsSecretKey();

    @Test
    @Title("Get All Adapters")
    public void getAllAdapters(){
        Response response = AdapterConfiguration.getAllAdapters();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get AD Adapter Configuration")
    public void getADAdapterConfigurationTest(){
        Response response = AdapterConfiguration.getAdAdapterConfiguration();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }
    @Test
    @Title("Get AWS Adapter Configuration")
    public void getAWSAdapterConfigurationTest(){
        Response response = AdapterConfiguration.getAwsAdapterConfiguration();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Azure Adapter Configuration")
    public void getAZUREAdapterConfiguration(){
        Response response = AdapterConfiguration.getAzureAdapterConfiguration();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }
    @Ignore
    @Test
    public void PostAWSConfiguration(){
        AwsConfiguration awsConfiguration = new AwsConfiguration(true, AWS_KEY_ID, AWS_SECRET_KEY, "us-east-2", false, "Test", "", true, true, true,true, true, true,true, true, true, true, true, false,true, true,true, true, false);
        Response response = AdapterConfiguration.postAwsConfiguration(awsConfiguration);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Ignore
    @Test
    public void PostAzureConfiguration()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT_ADAPTER + ADAPTER_ENDPOINT + ADAPTER_AD_AZURE_CONFIGURATION);
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
        //Assert.assertEquals(actualStatusCode, HttpStatus.SC_OK);
        // Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Ignore
    @Test
    public void PostADConfiguration()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT_ADAPTER + ADAPTER_ENDPOINT + ADAPTER_AD_AZURE_CONFIGURATION);
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
        //Assert.assertEquals(actualStatusCode, HttpStatus.SC_OK);
        // Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get AWS Discover Now")
    public void getAwsDiscoverNow(){
        Response response = AdapterConfiguration.getAwsDiscoverNow();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Azure Discover Now")
    public void getAzureDiscoverNow(){
        Response response = AdapterConfiguration.getAzureDiscoverNow();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get AD Discover Now")
    public void getAdDiscoverNow(){
        Response response = AdapterConfiguration.getAdDiscoverNow();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get All Adapters Discover Now")
    public void GetAllAdapterDiscoverNow(){
        Response response = AdapterConfiguration.getAllAdapterDiscoverNow();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

}
