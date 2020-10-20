package testcases;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class DashboardControllerTest extends BaseTest {

    List adapterName = new ArrayList();

    @Test
    @Title("Get All Connectors Count")
    public void getAllConnectorsCount() {
        given().
                spec(requestSpec).
                when().
                get(DASHBOARD_ENDPOINT).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AD Connector Count")
    public void getADConnectorCount() {
        adapterName.add("adapter_ad");
        given().
                spec(requestSpec).
                when().
                get(DASHBOARD_ENDPOINT + CONNECTOR_PARAM + AD).
                then().
                spec(responseSpec).
                and().
                body("data.name", equalTo(adapterName));

    }

    @Test
    @Title("Get Azure Connector Count")
    public void getAzureConnectorCount() {
        adapterName.add("adapter_azure");
        given().
                spec(requestSpec).
                when().
                get(DASHBOARD_ENDPOINT + CONNECTOR_PARAM + AZURE).
                then().
                spec(responseSpec).
                and().
                body("data.name", equalTo(adapterName));
    }

    @Test
    @Title("Get WMIC Connector Count")
    public void getWMICConnectorCount() {
        adapterName.add("adapter_wmic");
        given().
                spec(requestSpec).
                when().
                get(DASHBOARD_ENDPOINT + CONNECTOR_PARAM + WMIC).
                then().
                spec(responseSpec).
                and().
                body("data.name", equalTo(adapterName));
    }

    @Test
    @Title("Get Operating System Type Count")
    public void getOSDistribution() {
        given().
                spec(requestSpec).
                when().
                get(OS_DISTRIBUTION).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Total User Count")
    public void getTotalUserCount() {
        given().
                spec(requestSpec).
                when().
                get(USER_COUNT).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get Count of Azure Type Assets")
    public void getAzureAssetTypeDistribution() {
        given().
                spec(requestSpec).
                when().
                get(ASSETS_TYPE_DISTRIBUTION + AZURE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Count of AD Type Assets")
    public void getADAssetTypeDistribution() {
        given().
                spec(requestSpec).
                when().
                get(ASSETS_TYPE_DISTRIBUTION + AD).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Count of AWS Type Assets")
    public void getAWSAssetTypeDistribution() {
        given().
                spec(requestSpec).
                when().
                get(ASSETS_TYPE_DISTRIBUTION + AWS).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Count of WMIC Type Assets")
    public void getWMICAssetTypeDistribution() {
        given().
                spec(requestSpec).
                when().
                get(ASSETS_TYPE_DISTRIBUTION + WMIC).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Count of Cloud VS NonCloud Assets")
    public void getCloudVSNonCloud() {
        given().
                spec(requestSpec).
                when().
                get(CLOUD_VS_NON_CLOUD).
                then().
                spec(responseSpec);
    }
//new dashboard test cases

    @Test
    @Title("Get Assets By Month and Date")
    public void getAssetsByMonthDate() {
        given().
                spec(requestSpec).
                when().
                get(ASSETS_BY_MONTH_DATE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get User By Month and Date")
    public void getUserByMonthDate() {
        given().
                spec(requestSpec).
                when().
                get(USER_BY_MONTH_DATE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Total WINDOWS Assets")
    public void getTotalWindowsAssets() {
        given().
                spec(requestSpec).
                when().
                get(TOTAL_WINDOWS_ASSETS).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Total LINUX Assets")
    public void getTotalLinuxAssets() {
        given().
                spec(requestSpec).
                when().
                get(TOTAL_LINUX_ASSETS).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Total Cloud Assets")
    public void getTotalCloudAssets() {
        given().
                spec(requestSpec).
                when().
                get(TOTAL_CLOUD_ASSETS).
                then().spec(responseSpec);
    }

    @Test
    @Title("Get Total Missing EDR")
    public void getTotalMissingEdr() {
        given().
                spec(requestSpec).
                when().
                get(TOTAL_MISSING_EDR_ASSETS).
                then().spec(responseSpec);
    }

    @Test
    @Title("Get Total Assets Distribution")
    public void getTotalAssetsDistribution() {
        given().
                spec(requestSpec).
                when().
                get(TOTAL_ASSETS_DISTRIBUTION).
                then().spec(responseSpec);
    }


    @Test
    @Title("Get Total Cloud Device Type Assets")
    public void getTotalCloudDeviceTypeAssets() {
        given().
                spec(requestSpec).
                when().
                get(TOTAL_CLOUD_DEVICE_TYPE_ASSETS).
                then().spec(responseSpec);
    }

    @Test
    @Title("Get User Distribution")
    public void getUserDistribution() {
        given().
                spec(requestSpec).
                when().
                get(USER_DISTRIBUTION).
                then().spec(responseSpec);
    }

    @Test
    @Title("Get Check CPU Health")
    public void getCpuHealth() {
        given().
                spec(requestSpec).
                when().
                get(CPU_HEALTH).
                then().spec(responseSpec);
    }

    @Test
    @Title("Get Check Memory Health")
    public void getMemoryHealth() {
        given().
                spec(requestSpec).
                when().
                get(MEMORY_HEALTH).
                then().spec(responseSpec);
    }

    @Test
    @Title("Get Check Discovery Health")
    public void getDiscoveryHealth() {
        given().
                spec(requestSpec).
                when().
                get(DISCOVERY_HEALTH).
                then().spec(responseSpec);
    }

}
