package testcases;

import api.AdapterConfiguration;
import io.restassured.response.Response;
import models.configuration.AwsConfiguration;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.ApplicationConfiguration;
import utils.BaseClass;

import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class AdapterConfigurationTest extends BaseClass {

    protected static final String AWS_KEY_ID = ApplicationConfiguration.getAwsKeyId();
    protected static final String AWS_SECRET_KEY = ApplicationConfiguration.getAwsSecretKey();

    @Test
    @Title("Get All Adapters")
    public void getAllAdapters() {
        Response response = AdapterConfiguration.getAllAdapters();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("meta.status", equalTo("success"));

    }

    @Test
    @Title("Get AD Adapter Configuration")
    public void getADAdapterConfiguration() {
        Response response = AdapterConfiguration.getAdAdapterConfiguration();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get AWS Adapter Configuration")
    public void getAWSAdapterConfiguration() {
        Response response = AdapterConfiguration.getAwsAdapterConfiguration();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Azure Adapter Configuration")
    public void getAZUREAdapterConfiguration() {
        Response response = AdapterConfiguration.getAzureAdapterConfiguration();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("meta.status", equalTo("success"));
    }

    @Ignore
    @Test
    @Title("Post AWS Adapter Configuration")
    public void postAWSConfiguration() {
        AwsConfiguration awsConfiguration = new AwsConfiguration(true, AWS_KEY_ID, AWS_SECRET_KEY, "us-east-2", false, "Test", "", true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, false);
        Response response = AdapterConfiguration.postAwsConfiguration(awsConfiguration);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Ignore
    @Test
    @Title("Post Azure Adapter Configuration")
    public void postAzureConfiguration() {
        //BASE_ENDPOINT_ADAPTER + ADAPTER_ENDPOINT + ADAPTER_AD_AZURE_CONFIGURATION

    }

    @Ignore
    @Test
    @Title("Post AD Adapter Configuration")
    public void postADConfiguration() {
        //BASE_ENDPOINT_ADAPTER + ADAPTER_ENDPOINT + ADAPTER_AD_AZURE_CONFIGURATION

    }

    @Test
    @Title("Get AWS Discover Now")
    public void getAwsDiscoverNow() {
        Response response = AdapterConfiguration.getAwsDiscoverNow();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("data", equalTo("Triggered Discovery"), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Azure Discover Now")
    public void getAzureDiscoverNow() {
        Response response = AdapterConfiguration.getAzureDiscoverNow();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("data", equalTo("Triggered Discovery"), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get AD Discover Now")
    public void getAdDiscoverNow() {
        Response response = AdapterConfiguration.getAdDiscoverNow();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("data", equalTo("Triggered Discovery"), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get All Adapters Discover Now")
    public void getAllAdapterDiscoverNow() {
        Response response = AdapterConfiguration.getAllAdapterDiscoverNow();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("data", equalTo("Triggered Discovery"), "meta.status", equalTo("success"));
    }

}
