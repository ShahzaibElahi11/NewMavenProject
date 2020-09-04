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
public class DashboardTest extends BaseTest {

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


}
