package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.configuration.AwsConfiguration;
import utils.ApplicationConfiguration;
import utils.BaseTest;

import static io.restassured.RestAssured.given;

public class ConnectorConfiguration extends BaseTest {

    protected static final String CONNECTOR_ENDPOINT = ApplicationConfiguration.getConnectorEndpoint();
    protected static final String CONNECTOR_CONFIGURATION = ApplicationConfiguration.getConnectorConfiguration();
    protected static final String DISCOVER = ApplicationConfiguration.getDISCOVER();
    protected static final String AWS = ApplicationConfiguration.getAWS();
    protected static final String AD = ApplicationConfiguration.getAD();
    protected static final String AZURE = ApplicationConfiguration.getAZURE();


    public static Response getAllConnector() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_CONNECTOR + CONNECTOR_ENDPOINT);
    }

    public static Response getAdConnectorConfiguration() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_CONNECTOR + CONNECTOR_ENDPOINT + CONNECTOR_CONFIGURATION + AD);
    }

    public static Response getAwsConnectorConfiguration() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_CONNECTOR + CONNECTOR_ENDPOINT + CONNECTOR_CONFIGURATION + AWS);
    }

    public static Response getAzureConnectorConfiguration() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_CONNECTOR + CONNECTOR_ENDPOINT + CONNECTOR_CONFIGURATION + AZURE);
    }

    public static Response postAwsConfiguration(AwsConfiguration awsConfiguration) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(awsConfiguration)
                .when()
                .post(BASE_ENDPOINT_CONNECTOR + "/aws/configure");

    }

    public static Response getAwsDiscoverNow() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_CONNECTOR + CONNECTOR_ENDPOINT + DISCOVER + AWS);
    }

    public static Response getAzureDiscoverNow() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_CONNECTOR + CONNECTOR_ENDPOINT + DISCOVER + AZURE);
    }


    public static Response getAdDiscoverNow() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_CONNECTOR + CONNECTOR_ENDPOINT + DISCOVER + AD);
    }

    public static Response getAllConnectorDiscoverNow() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_CONNECTOR + CONNECTOR_ENDPOINT + DISCOVER);
    }
}
