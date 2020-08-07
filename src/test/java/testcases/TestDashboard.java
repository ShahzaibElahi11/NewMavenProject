package testcases;

import api.DashboardApis;
import io.restassured.response.Response;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;
import utils.BaseClass;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class TestDashboard extends BaseClass {

    @Test
    public void GetAllAdaptersCountNew() {

        Response response = DashboardApis.getAllAdaptersCount();
        assertThat(response.getStatusCode(),equalTo(200));
    }
    @Test
    public void GetADAdapterCountNew(){
        Response response = DashboardApis.getAdAdapterCount();
        assertThat(response.getStatusCode(),equalTo(200));
    }
    @Test
    public void GetAzureAdapterCountNew(){
        Response response = DashboardApis.getAzureAdapterCount();
        assertThat(response.getStatusCode(),equalTo(200));
    }

    @Test
    public void GetWMICAdapterCountNew(){
        Response response = DashboardApis.getWmicAdapterCount();
        assertThat(response.getStatusCode(),equalTo(200));
    }

    @Test
    public void GetOSDistributionNew(){
        Response response = DashboardApis.getOSDistribution();
        assertThat(response.getStatusCode(),equalTo(200));
    }

    @Test
    public void GetTotalUserCountNew(){
        Response response = DashboardApis.getTotalUserCount();
        assertThat(response.getStatusCode(),equalTo(200));
    }
    @Test
    public void GetAzureAssetTypeDistributionNew(){
        Response response = DashboardApis.getAzureAssetTypeDistribution();
        assertThat(response.getStatusCode(),equalTo(200));
    }
    @Test
    public void GetADAssetTypeDistributionNew(){
        Response response = DashboardApis.getAdAssetTypeDistribution();
        assertThat(response.getStatusCode(),equalTo(200));
    }

    @Test
    public void GetAWSAssetTypeDistributionNew(){
        Response response = DashboardApis.getAwsAssetTypeDistribution();
        assertThat(response.getStatusCode(),equalTo(200));
    }
    @Test
    public void GetWMICAssetTypeDistributionNew(){
        Response response = DashboardApis.getWmicAssetTypeDistribution();
        assertThat(response.getStatusCode(),equalTo(200));
    }

    @Test
    public void GetCloudVSNonCloudNew(){
        Response response = DashboardApis.getCloudVSNonCloud();
        assertThat(response.getStatusCode(),equalTo(200));

    }



    @Test
    public void GetAllAdaptersCount() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/query/adapters/count/devices/");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetADAdapterCount() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/query/adapters/count/devices/?adapter=adapter_ad");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetAzureAdapterCount() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/query/adapters/count/devices/?adapter=adapter_azure");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetWMICAdapterCount() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/query/adapters/count/devices/?adapter=adapter_wmic");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetOSDistribution() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/query/dist/?field=common.operatingSystem.type");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetTotalUserCount() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/query/count/users/");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetAzureAssetTypeDistribution() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/query/dist/?field=type&match=adapters.adapter_azure");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetADAssetTypeDistribution() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/query/dist/?field=type&match=adapters.adapter_ad");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetAWSAssetTypeDistribution() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/query/dist/?field=type&match=adapters.adapter_aws");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetWMICAssetTypeDistribution() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/query/dist/?field=type&match=adapters.adapter_wmic");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetCloudVSNonCloud() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/query/pie/?field=adapterProperties&match=CLOUD%20PROVIDER");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }



}
