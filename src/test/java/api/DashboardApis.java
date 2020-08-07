package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.BaseClass;

import static io.restassured.RestAssured.given;

public class DashboardApis extends BaseClass {

    public static Response getAllAdaptersCount() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/query/adapters/count/devices/");

    }

    public static Response getAdAdapterCount() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/query/adapters/count/devices/?adapter=adapter_ad");
    }

    public static Response getAzureAdapterCount() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/query/adapters/count/devices/?adapter=adapter_azure");
    }

    public static Response getWmicAdapterCount() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/query/adapters/count/devices/?adapter=adapter_wmic");
    }


    public static Response getOSDistribution() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/query/dist/?field=common.operatingSystem.type");
    }

    public static Response getTotalUserCount() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/query/count/users/");

    }

    public static Response getAzureAssetTypeDistribution() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/query/dist/?field=type&match=adapters.adapter_azure");
    }

    public static Response getAdAssetTypeDistribution() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/query/dist/?field=type&match=adapters.adapter_ad");

    }

    public static Response getAwsAssetTypeDistribution() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/query/dist/?field=type&match=adapters.adapter_aws");
    }

    public static Response getWmicAssetTypeDistribution() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/query/dist/?field=type&match=adapters.adapter_wmic");

    }

    public static Response getCloudVSNonCloud() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + "/query/pie/?field=adapterProperties&match=CLOUD%20PROVIDER");
    }
}
