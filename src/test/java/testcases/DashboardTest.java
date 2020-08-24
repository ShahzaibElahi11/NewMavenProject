package testcases;

import api.Dashboard;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class DashboardTest {


    @Test
    @Title("Get All Adapters Count")
    public void getAllAdaptersCount() {
        Response response = Dashboard.getAllAdaptersCount();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    @Title("Get AD Adapter Count")
    public void getADAdapterCount(){
        Response response = Dashboard.getAdAdapterCount();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    @Title("Get Azure Adapter Count")
    public void getAzureAdapterCount(){
        Response response = Dashboard.getAzureAdapterCount();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get WMIC Adapter Count")
    public void getWMICAdapterCount(){
        Response response = Dashboard.getWmicAdapterCount();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Operating System Type Count")
    public void getOSDistribution(){
        Response response = Dashboard.getOSDistribution();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Total User Count")
    public void getTotalUserCount(){
        Response response = Dashboard.getTotalUserCount();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    @Title("Get Count of Azure Type Assets")
    public void getAzureAssetTypeDistribution(){
        Response response = Dashboard.getAzureAssetTypeDistribution();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    @Title("Get Count of AD Type Assets")
    public void getADAssetTypeDistribution(){
        Response response = Dashboard.getAdAssetTypeDistribution();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Count of AWS Type Assets")
    public void getAWSAssetTypeDistribution(){
        Response response = Dashboard.getAwsAssetTypeDistribution();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    @Title("Get Count of WMIC Type Assets")
    public void getWMICAssetTypeDistribution(){
        Response response = Dashboard.getWmicAssetTypeDistribution();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Count of Cloud VS NonCloud Assets")
    public void getCloudVSNonCloud(){
        Response response = Dashboard.getCloudVSNonCloud();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }







}
