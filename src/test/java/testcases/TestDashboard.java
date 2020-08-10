package testcases;

import api.DashboardApis;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestDashboard {

    @Test
    public void GetAllAdaptersCount() {

        Response response = DashboardApis.getAllAdaptersCount();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }
    @Test
    public void GetADAdapterCount(){
        Response response = DashboardApis.getAdAdapterCount();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }
    @Test
    public void GetAzureAdapterCount(){
        Response response = DashboardApis.getAzureAdapterCount();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetWMICAdapterCount(){
        Response response = DashboardApis.getWmicAdapterCount();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetOSDistribution(){
        Response response = DashboardApis.getOSDistribution();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetTotalUserCount(){
        Response response = DashboardApis.getTotalUserCount();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }
    @Test
    public void GetAzureAssetTypeDistribution(){
        Response response = DashboardApis.getAzureAssetTypeDistribution();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }
    @Test
    public void GetADAssetTypeDistribution(){
        Response response = DashboardApis.getAdAssetTypeDistribution();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetAWSAssetTypeDistribution(){
        Response response = DashboardApis.getAwsAssetTypeDistribution();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }
    @Test
    public void GetWMICAssetTypeDistribution(){
        Response response = DashboardApis.getWmicAssetTypeDistribution();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetCloudVSNonCloud(){
        Response response = DashboardApis.getCloudVSNonCloud();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }







}
