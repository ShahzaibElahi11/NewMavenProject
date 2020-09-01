package testcases;

import api.QueryWizard;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseTest;

@RunWith(SerenityRunner.class)
public class QueryWizardTest extends BaseTest {

    @Test
    @Title("Get Query Wizard Equal Operator")
    public void getEqualOperator(){
        Response response = QueryWizard.getEqualOperator();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Query Wizard Not Equal Operator")
    public void getNotEqualOperator(){
        Response response = QueryWizard.getNotEqualOperator();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Query Wizard Exists Operator with True Condition")
    public void getExistsOperatorTrue(){
        Response response = QueryWizard.getExistsOperatorTrue();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Query Wizard Exists Operator with False Condition")
    public void getExistsOperatorFalse() {
        Response response = QueryWizard.getExistsOperatorFalse();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }
    @Test
    @Title("Get Query Wizard Starts With Operator")
    public void getStartWithOperator(){
        Response response = QueryWizard.getStartWithOperator();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Query Wizard End With Operator")
    public void getEndWithOperator(){
        Response response = QueryWizard.getEndWithOperator();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    @Title("Get Query Wizard IN Operator")
    public void getInOperator(){
        Response response = QueryWizard.getInOperator();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Query Wizard Contain Operator")
    public void getContainOperator(){
        Response response = QueryWizard.getContainOperator();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    @Title("Get Query Wizard AND Operator")
    public void getANDOperator(){
        Response response = QueryWizard.getANDOperator();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Query Wizard OR Operator")
    public void getOROperator(){
        Response response = QueryWizard.getOROperator();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Query Wizard Connector Details Query")
    public void getConnectorDetailsQuery(){
        Response response = QueryWizard.getConnectorDetailsQuery();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Query Wizard Statement Query")
    public void getStatementQuery(){
        Response response = QueryWizard.getStatementQuery();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    /**
     * Saved Query Controller
     *
     */
    @Ignore
    @Test
    @Title("Post Enforce Save Query on Device")
    public void postDeviceSaveQuery(){
        //BASE_ENDPOINT_INVENTA + SAVED_QUERY
        //String json = "{\"name\":\"Automation_Device_SaveQuery_#"+value+"\",\"query\": \"(hostName==\\\"inventa-windows\\\")\",\"type\": \"DEVICE\", \"description\": \"Automation_Device_SaveQuery_#"+value+"\"}";

    }

    @Ignore
    @Test
    @Title("Post Enforce Save Query on User")
    public void postUserSaveQuery(){
        //BASE_ENDPOINT_INVENTA + SAVED_QUERY
        // String json = "{\"name\":\"Automation_User_SaveQuery_#"+value+"\",\"query\": \"(common.displayName ==\\\"msiraj\\\")\",\"type\": \"USER\", \"description\": \"Automation_DeviceSaveQuery_#"+value+"\"}";
    }

    @Ignore
    @Test
    @Title("Post Enforce Save Query Overwrite")
    public void postSaveQueryOverWrite(){
        //BASE_ENDPOINT_INVENTA + SAVED_QUERY
        // String json = "{\"name\":\"Automation_SaveQuery_OverWrite_#" + value + "\",\"query\": \"(hostName==\\\"inventa-windows\\\")\",\"type\": \"DEVICE\", \"description\": \"Over Write Done Automation_SaveQuery_#" + value + "\"}";

    }

    @Test
    @Title("Get Device Saved Queries")
    public void getDeviceSavedQueries(){
        Response response = QueryWizard.getDeviceSavedQueries();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get User Saved Queries")
    public void getUserSavedQueries(){
        Response response = QueryWizard.getUserSavedQueries();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Execute Saved Queries on Devices")
    public void getExecuteDeviceSavedQuery(){
        Response response = QueryWizard.getExecuteDeviceSavedQuery();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Ignore
    @Test
    @Title("Get Execute Saved Queries on Users")
    public void getExecuteUserSavedQuery(){
        Response response = QueryWizard.getExecuteUserSavedQuery();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }


    @Test
    @Title("Get All Saved Queries")
    public void getAllSavedQueries(){
        Response response = QueryWizard.getAllSavedQueries();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get All Device Saved Queries Without Pagination")
    public void getAllSavedQueriesNoPaginationDevice(){
        Response response = QueryWizard.getAllSavedQueriesNoPaginationDevice();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get All User Saved Queries Without Pagination")
    public void getAllSavedQueriesNoPaginationUser(){
        Response response = QueryWizard.getAllSavedQueriesNoPaginationUser();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }


    /**
     * Remaining
     * Patch- Rename User Saved Query	http://inventaserver:9092/saved-query/rename/?oldName=testuser&newName=test_user&type=USER
     * Patch- Rename Device Saved Query	http://inventaserver:9092/saved-query/rename/?oldName=SaveQuery14&newName=SaveQuery143&type=DEVICE
     */
    /**
     * new
     */

    @Test
    @Title("Get Query Wizard All AD Device Fields")
    public void getAllAdDeviceFields(){
        Response response = QueryWizard.getAllAdDeviceFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Query Wizard All AWS Device Fields")
    public void getAllAwsDeviceFields(){
        Response response = QueryWizard.getAllAwsDeviceFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }
    @Test
    @Title("Get Query Wizard All Azure Device Fields")
    public void getAllAzureDeviceFields(){
        Response response = QueryWizard.getAllAzureDeviceFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Query Wizard All Wmic Device Fields")
    public void getAllWmicDeviceFields(){
        Response response = QueryWizard.getAllWmicDeviceFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Query Wizard All AD User Fields")
    public void getAllAdUserFields(){
        Response response = QueryWizard.getAllAdUserFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Query Wizard All AWS User Fields")
    public void getAllAwsUserFields(){
        Response response = QueryWizard.getAllAwsUserFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Query Wizard All Azure User Fields")
    public void getAllAzureUserFields(){
        Response response = QueryWizard.getAllAzureUserFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Query Wizard Azure Type Fields For Devices")
    public void getAzureTypeDeviceFields(){
        Response response = QueryWizard.getAzureTypeDeviceFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Query Wizard Aws Type Fields For Devices")
    public void getAwsTypeDeviceFields(){
        Response response = QueryWizard.getAwsTypeDeviceFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Query Wizard Aws Type Fields For Devices")
    public void getAdTypeDeviceFields(){
        Response response = QueryWizard.getAdTypeDeviceFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }




}
