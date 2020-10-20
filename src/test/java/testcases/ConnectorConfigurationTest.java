package testcases;

import models.configuration.AwsConfiguration;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
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
                get(CONNECTOR_ENDPOINT + CONNECTOR_CONFIGURATION_INSTANCE + AZURE_ENDPOINT).
                then().
                spec(responseSpec);
    }

//    @Test
//    @Title("Post AWS Connector Configuration")
//    public void postAWSConfiguration() {
//        AwsConfiguration awsConfiguration = new AwsConfiguration(true, AWS_KEY_ID, AWS_SECRET_KEY, "us-east-3", false, "Test", "", true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, false);
//        given().
//                spec(requestSpecForConnector).
//                and().
//                body(awsConfiguration).
//                when().
//                post("/aws/configure").
//                then().
//                assertThat().
//                statusCode(SC_OK);
//
//    }


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

    @Test
    @Title("Get CrowdStrike Connector Configuration")
    public void getCrowdStrikeConnectorConfiguration() {
        given().
                spec(requestSpecForConnector).
                when().
                get(CONNECTOR_ENDPOINT + CONNECTOR_CONFIGURATION_INSTANCE + CROWDSTRIKE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get CrowdStrike Discover Now")
    public void getCrowdStrikeDiscoverNow() {
        given().
                spec(requestSpecForConnector).
                when().
                get(CONNECTOR_ENDPOINT + DISCOVER + CROWDSTRIKE).
                then().
                spec(responseSpec).
                and().
                body("data", equalTo("Triggered Discovery"));
    }

    @Test
    @Title("Get Shodan Connector Configuration")
    public void getShodanConnectorConfiguration() {
        given().
                spec(requestSpecForConnector).
                when().
                get(CONNECTOR_ENDPOINT + CONNECTOR_CONFIGURATION + SHODAN).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Shodan Discover Now")
    public void getShodanDiscoverNow() {
        given().
                spec(requestSpecForConnector).
                when().
                get(CONNECTOR_ENDPOINT + DISCOVER + SHODAN).
                then().
                spec(responseSpec).
                and().
                body("data", equalTo("Triggered Discovery"));
    }

    @Test
    @Title("Get VMware ESXi Connector Configuration")
    public void getVmwareEsxiConnectorConfiguration() {
        given().
                spec(requestSpecForConnector).
                when().
                get(CONNECTOR_ENDPOINT + CONNECTOR_CONFIGURATION_INSTANCE + VMWARE_ESXI).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get VMware ESXi Discover Now")
    public void getVmwareEsxiDiscoverNow() {
        given().
                spec(requestSpecForConnector).
                when().
                get(CONNECTOR_ENDPOINT + DISCOVER + "vmware").
                then().
                spec(responseSpec).
                and().
                body("data", equalTo("Triggered Discovery"));
    }


}
