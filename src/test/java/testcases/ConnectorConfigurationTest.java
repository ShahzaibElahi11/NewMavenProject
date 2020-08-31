package testcases;

import api.ConnectorConfiguration;
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
import utils.BaseTest;

import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class ConnectorConfigurationTest extends BaseTest {

    protected static final String AWS_KEY_ID = ApplicationConfiguration.getAwsKeyId();
    protected static final String AWS_SECRET_KEY = ApplicationConfiguration.getAwsSecretKey();

    @Test
    @Title("Get All Connectors")
    public void getAllConnectors() {
        Response response = ConnectorConfiguration.getAllConnector();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("meta.status", equalTo("success"));

    }

    @Test
    @Title("Get AD Connector Configuration")
    public void getADConnectorConfiguration() {
        Response response = ConnectorConfiguration.getAdConnectorConfiguration();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get AWS Connector Configuration")
    public void getAWSConnectorConfiguration() {
        Response response = ConnectorConfiguration.getAwsConnectorConfiguration();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Azure Connector Configuration")
    public void getAzureConnectorConfiguration() {
        Response response = ConnectorConfiguration.getAzureConnectorConfiguration();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("meta.status", equalTo("success"));
    }

    @Ignore
    @Test
    @Title("Post AWS Connector Configuration")
    public void postAWSConfiguration() {
        AwsConfiguration awsConfiguration = new AwsConfiguration(true, AWS_KEY_ID, AWS_SECRET_KEY, "us-east-2", false, "Test", "", true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, false);
        Response response = ConnectorConfiguration.postAwsConfiguration(awsConfiguration);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Ignore
    @Test
    @Title("Post Azure Connector Configuration")
    public void postAzureConfiguration() {
        //BASE_ENDPOINT_ADAPTER + ADAPTER_ENDPOINT + ADAPTER_AD_AZURE_CONFIGURATION

    }

    @Ignore
    @Test
    @Title("Post AD Connector Configuration")
    public void postADConfiguration() {
        //BASE_ENDPOINT_ADAPTER + ADAPTER_ENDPOINT + ADAPTER_AD_AZURE_CONFIGURATION

    }

    @Test
    @Title("Get AWS Discover Now")
    public void getAwsDiscoverNow() {
        Response response = ConnectorConfiguration.getAwsDiscoverNow();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("data", equalTo("Triggered Discovery"), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Azure Discover Now")
    public void getAzureDiscoverNow() {
        Response response = ConnectorConfiguration.getAzureDiscoverNow();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("data", equalTo("Triggered Discovery"), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get AD Discover Now")
    public void getAdDiscoverNow() {
        Response response = ConnectorConfiguration.getAdDiscoverNow();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("data", equalTo("Triggered Discovery"), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get All Connector Discover Now")
    public void getAllConnectorDiscoverNow() {
        Response response = ConnectorConfiguration.getAllConnectorDiscoverNow();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("data", equalTo("Triggered Discovery"), "meta.status", equalTo("success"));
    }

}
