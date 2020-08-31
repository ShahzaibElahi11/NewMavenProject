package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.ApplicationConfiguration;
import utils.BaseTest;

import static io.restassured.RestAssured.given;

public class Dashboard extends BaseTest {

    protected static final String DASHBOARD_ENDPOINT = ApplicationConfiguration.getDashboardEndpoint();
    protected static final String CONNECTOR_PARAM = ApplicationConfiguration.getConnectorParam();
    protected static final String OS_DISTRIBUTION = ApplicationConfiguration.getOsDistribution();
    protected static final String USER_COUNT = ApplicationConfiguration.getUserCount();
    protected static final String ASSETS_TYPE_DISTRIBUTION = ApplicationConfiguration.getAssetsTypeDistribution();
    protected static final String CLOUD_VS_NON_CLOUD = ApplicationConfiguration.getCloudVsNonCloud();
    protected static final String WMIC = ApplicationConfiguration.getWMIC();

    //will continue


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
                .get(BASE_ENDPOINT_INVENTA + DASHBOARD_ENDPOINT + CONNECTOR_PARAM + "ad");
    }

    public static Response getAzureConnectorCount() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/query/adapters/count/devices/?adapter=adapter_azure");
    }

    public static Response getWmicConnectorCount() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/query/adapters/count/devices/?adapter=adapter_wmic");
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
                .get(BASE_ENDPOINT_INVENTA + "/query/dist/?field=type&match=adapters.adapter_azure");
    }

    public static Response getAdAssetTypeDistribution() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/query/dist/?field=type&match=adapters.adapter_ad");

    }

    public static Response getAwsAssetTypeDistribution() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/query/dist/?field=type&match=adapters.adapter_aws");
    }

    public static Response getWmicAssetTypeDistribution() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/query/dist/?field=type&match=adapters.adapter_wmic");

    }

    public static Response getCloudVSNonCloud() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + CLOUD_VS_NON_CLOUD);
    }
}
