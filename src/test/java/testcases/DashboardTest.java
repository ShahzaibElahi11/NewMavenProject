package testcases;

import api.Dashboard;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class DashboardTest {


    @Test
    public void GetAllAdaptersCount() {

        Response response = Dashboard.getAllAdaptersCount();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    public void GetADAdapterCount(){
        Response response = Dashboard.getAdAdapterCount();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    public void GetAzureAdapterCount(){
        Response response = Dashboard.getAzureAdapterCount();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetWMICAdapterCount(){
        Response response = Dashboard.getWmicAdapterCount();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetOSDistribution(){
        Response response = Dashboard.getOSDistribution();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetTotalUserCount(){
        Response response = Dashboard.getTotalUserCount();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    public void GetAzureAssetTypeDistribution(){
        Response response = Dashboard.getAzureAssetTypeDistribution();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    public void GetADAssetTypeDistribution(){
        Response response = Dashboard.getAdAssetTypeDistribution();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetAWSAssetTypeDistribution(){
        Response response = Dashboard.getAwsAssetTypeDistribution();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    public void GetWMICAssetTypeDistribution(){
        Response response = Dashboard.getWmicAssetTypeDistribution();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetCloudVSNonCloud(){
        Response response = Dashboard.getCloudVSNonCloud();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }







}
