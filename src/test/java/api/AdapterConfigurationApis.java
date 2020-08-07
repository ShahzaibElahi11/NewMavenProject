package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.BaseClass;

import static io.restassured.RestAssured.given;

public class AdapterConfigurationApis extends BaseClass {

    public final static String ADAPTER_ENDPOINT = "/adapters/";
    public final static String ADAPTER_CONFIGURATION = "active-directory/configure/?type=";
    public final static String ADAPTER_AD_AZURE_CONFIGURATION = "active-directory/configure";

    public static Response getAllAdapters(){
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(ADAPTER_CONFIG_ENDPOINT + ADAPTER_ENDPOINT );
    }
    public static Response getAdAdapterConfiguration() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(ADAPTER_CONFIG_ENDPOINT + ADAPTER_ENDPOINT + ADAPTER_CONFIGURATION + "ad");
    }

    public static Response getAwsAdapterConfiguration() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(ADAPTER_CONFIG_ENDPOINT + ADAPTER_ENDPOINT + ADAPTER_CONFIGURATION + "aws");
    }

    public static Response getAzureAdapterConfiguration() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(ADAPTER_CONFIG_ENDPOINT + ADAPTER_ENDPOINT + ADAPTER_CONFIGURATION + "azure");
    }
}
