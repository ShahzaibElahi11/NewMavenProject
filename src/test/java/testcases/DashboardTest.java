package testcases;

import api.Dashboard;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class DashboardTest {

    List adapterName = new ArrayList();

    @Test
    @Title("Get All Adapters Count")
    public void getAllAdaptersCount() {
        Response response = Dashboard.getAllAdaptersCount();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
        //Rethink
    }
    @Test
    @Title("Get AD Adapter Count")
    public void getADAdapterCount(){
        Response response = Dashboard.getAdAdapterCount();
        adapterName.add("adapter_ad");
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data.name", equalTo(adapterName));
 /*
        ArrayList count = response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body("meta.status", equalTo("success"))
                .extract()
                .path("data.value");
        Assert.assertEquals(2, Integer.parseInt((String) count.get(0))); //Assert By Expected Number
   */

    }
    @Test
    @Title("Get Azure Adapter Count")
    public void getAzureAdapterCount(){
        Response response = Dashboard.getAzureAdapterCount();
        adapterName.add("adapter_azure");
                response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data.name", equalTo(adapterName), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get WMIC Adapter Count")
    public void getWMICAdapterCount(){
        Response response = Dashboard.getWmicAdapterCount();
       //List adapterName = Collections.singletonList("adapter_wmic");
       adapterName.add("adapter_wmic");
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data.name", equalTo(adapterName), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Operating System Type Count")
    public void getOSDistribution(){
        Response response = Dashboard.getOSDistribution();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"))
                .body("data.common.operatingSystem.type", contains("WINDOWS", "LINUX"));

        //ReThink
    }

    @Test
    @Title("Get Total User Count")
    public void getTotalUserCount(){
        Response response = Dashboard.getTotalUserCount();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }
    @Test
    @Title("Get Count of Azure Type Assets")
    public void getAzureAssetTypeDistribution(){
        Response response = Dashboard.getAzureAssetTypeDistribution();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }
    @Test
    @Title("Get Count of AD Type Assets")
    public void getADAssetTypeDistribution(){
        Response response = Dashboard.getAdAssetTypeDistribution();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));    }

    @Test
    @Title("Get Count of AWS Type Assets")
    public void getAWSAssetTypeDistribution(){
        Response response = Dashboard.getAwsAssetTypeDistribution();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));

}
    @Test
    @Title("Get Count of WMIC Type Assets")
    public void getWMICAssetTypeDistribution(){
        Response response = Dashboard.getWmicAssetTypeDistribution();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));


}

    @Test
    @Title("Get Count of Cloud VS NonCloud Assets")
    public void getCloudVSNonCloud(){
        Response response = Dashboard.getCloudVSNonCloud();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));

    }


}
