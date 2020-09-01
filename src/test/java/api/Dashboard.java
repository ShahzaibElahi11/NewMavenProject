package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.BaseAPI;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

public class Dashboard extends BaseAPI {



    public static Response getAllConnectorCount() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DASHBOARD_ENDPOINT);

    }

    public static Response getAdConnectorCount() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DASHBOARD_ENDPOINT + CONNECTOR_PARAM + AD);
    }

    public static Response getAzureConnectorCount() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DASHBOARD_ENDPOINT + CONNECTOR_PARAM + AZURE);
    }

    public static Response getWmicConnectorCount() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DASHBOARD_ENDPOINT + CONNECTOR_PARAM + WMIC);
    }


    public static Response getOSDistribution() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + OS_DISTRIBUTION);
    }

    public static Response getTotalUserCount() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + USER_COUNT);

    }

    public static Response getAzureAssetTypeDistribution() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + ASSETS_TYPE_DISTRIBUTION + AZURE);
    }

    public static Response getAdAssetTypeDistribution() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + ASSETS_TYPE_DISTRIBUTION + AD);

    }

    public static Response getAwsAssetTypeDistribution() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + ASSETS_TYPE_DISTRIBUTION + AWS);
    }

    public static Response getWmicAssetTypeDistribution() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + ASSETS_TYPE_DISTRIBUTION + WMIC);

    }

    public static Response getCloudVSNonCloud() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + CLOUD_VS_NON_CLOUD);
    }
}
