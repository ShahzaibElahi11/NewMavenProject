package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.configuration.AwsConfiguration;
import utils.BaseClass;

import static io.restassured.RestAssured.given;

public class AdapterConfiguration extends BaseClass {

    public final static String ADAPTER_ENDPOINT = "/adapters/";
    public final static String ADAPTER_CONFIGURATION = "active-directory/configure/?type=";
    public final static String ADAPTER_AD_AZURE_CONFIGURATION = "active-directory/configure";
    public final static String DISCOVER = "discover/";
    public final static String AWS = "aws";
    public final static String AD = "ad";
    public final static String AZURE = "azure";


    public static Response getAllAdapters() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_ADAPTER + ADAPTER_ENDPOINT);
    }

    public static Response getAdAdapterConfiguration() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_ADAPTER + ADAPTER_ENDPOINT + ADAPTER_CONFIGURATION + AD);
    }

    public static Response getAwsAdapterConfiguration() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_ADAPTER + ADAPTER_ENDPOINT + ADAPTER_CONFIGURATION + AWS);
    }

    public static Response getAzureAdapterConfiguration() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_ADAPTER + ADAPTER_ENDPOINT + ADAPTER_CONFIGURATION + AZURE);
    }

    public static Response postAwsConfiguration(AwsConfiguration awsConfiguration) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(awsConfiguration)
                .when()
                .post(BASE_ENDPOINT_ADAPTER + "/aws/configure");

    }

    public static Response getAwsDiscoverNow() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_ADAPTER + ADAPTER_ENDPOINT + DISCOVER + AWS);
    }

    public static Response getAzureDiscoverNow() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_ADAPTER + ADAPTER_ENDPOINT + DISCOVER + AZURE);
    }


    public static Response getAdDiscoverNow() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_ADAPTER + ADAPTER_ENDPOINT + DISCOVER + AD);
    }

    public static Response getAllAdapterDiscoverNow() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_ADAPTER + ADAPTER_ENDPOINT + DISCOVER);
    }
}
