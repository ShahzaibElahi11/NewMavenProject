package testcases;

import models.configuration.AwsConfiguration;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.http.HttpStatus;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.ApplicationConfiguration;
import utils.BaseTest;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class ConnectorConfigurationTest extends BaseTest {

    protected static final String AWS_KEY_ID = ApplicationConfiguration.getAwsKeyId();
    protected static final String AWS_SECRET_KEY = ApplicationConfiguration.getAwsSecretKey();

    @Test
    @Title("Get All Connectors")
    public void getAllConnectors() {
        given().
                spec(requestSpecForConnector).
                when().
                get(CONNECTOR_ENDPOINT).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AD Connector Configuration")
    public void getADConnectorConfiguration() {
        given().
                spec(requestSpecForConnector).
                when().
                get(CONNECTOR_ENDPOINT + CONNECTOR_CONFIGURATION_INSTANCE + ACTIVE_DIRECTORY).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Connector Configuration")
    public void getAWSConnectorConfiguration() {
        given().
                spec(requestSpecForConnector).
                when().
                get(CONNECTOR_ENDPOINT + CONNECTOR_CONFIGURATION_INSTANCE + AWS_ENDPOINT).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Connector Configuration")
    public void getAzureConnectorConfiguration() {
        given().
                spec(requestSpecForConnector).
                when().
                get(CONNECTOR_ENDPOINT + CONNECTOR_CONFIGURATION + AZURE).
                then().
                spec(responseSpec);
    }

    @Ignore
    @Test
    @Title("Post AWS Connector Configuration")
    public void postAWSConfiguration() {
        AwsConfiguration awsConfiguration = new AwsConfiguration(true, AWS_KEY_ID, AWS_SECRET_KEY, "us-east-3", false, "Test", "", true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, false);
        given().
                spec(requestSpecForConnector).
                and().
                body(awsConfiguration).
                when().
                post("/aws/configure").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK);

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
        given().
                spec(requestSpecForConnector).
                when().
                get(CONNECTOR_ENDPOINT + DISCOVER + AWS).
                then().
                spec(responseSpec).
                and().
                body("data", equalTo("Triggered Discovery"));
    }

    @Test
    @Title("Get Azure Discover Now")
    public void getAzureDiscoverNow() {
        given().
                spec(requestSpecForConnector).
                when().
                get(CONNECTOR_ENDPOINT + DISCOVER + AZURE).
                then().
                spec(responseSpec).
                and().
                body("data", equalTo("Triggered Discovery"));
    }

    @Test
    @Title("Get AD Discover Now")
    public void getAdDiscoverNow() {
        given().
                spec(requestSpecForConnector).
                when().
                get(CONNECTOR_ENDPOINT + DISCOVER + AD).
                then().
                spec(responseSpec).
                and().
                body("data", equalTo("Triggered Discovery"));
    }

    @Test
    @Title("Get All Connector Discover Now")
    public void getAllConnectorDiscoverNow() {
        given().
                spec(requestSpecForConnector).
                when().
                get(CONNECTOR_ENDPOINT + DISCOVER).
                then().
                spec(responseSpec).
                and().
                body("data", equalTo("Triggered Discovery"));
    }

    //I will CrowedStrike and VM Ware endpoints.


}
