package testcases;

import api.QueryWizard;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseClass;
import java.io.IOException;
import java.nio.charset.Charset;



@RunWith(SerenityRunner.class)
public class QueryWizardTest extends BaseClass {

    public static final String SAVED_QUERY = "/saved-query/";

    @Test
    public void GetEqualOperator(){
        Response response = QueryWizard.getEqualOperator();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetNotEqualOperator(){
        Response response = QueryWizard.getNotEqualOperator();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetExistsOperatorTrue(){
        Response response = QueryWizard.getExistsOperatorTrue();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetExistsOperatorFalse() {
        Response response = QueryWizard.getExistsOperatorFalse();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }
    @Test
    public void GetStartWithOperator(){
        Response response = QueryWizard.getStartWithOperator();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetEndWithOperator(){
        Response response = QueryWizard.getEndWithOperator();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    public void GetInOperator(){
        Response response = QueryWizard.getInOperator();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetContainOperator(){
        Response response = QueryWizard.getContainOperator();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Test
    public void GetANDOperator(){
        Response response = QueryWizard.getANDOperator();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetOROperator(){
        Response response = QueryWizard.getOROperator();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetAdapterDetailsQuery(){
        Response response = QueryWizard.getAdapterDetailsQuery();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetStatementQuery(){
        Response response = QueryWizard.getStatementQuery();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    /**
     * Saved Query Controller
     *
     */
    @Ignore
    @Test
    public void PostDeviceSaveQuery()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT_INVENTA + SAVED_QUERY);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{\"name\":\"Automation_Device_SaveQuery_#"+value+"\",\"query\": \"(hostName==\\\"inventa-windows\\\")\",\"type\": \"DEVICE\", \"description\": \"Automation_Device_SaveQuery_#"+value+"\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);

    }

    @Ignore
    @Test
    public void PostUserSaveQuery()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT_INVENTA + SAVED_QUERY);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{\"name\":\"Automation_User_SaveQuery_#"+value+"\",\"query\": \"(common.displayName ==\\\"msiraj\\\")\",\"type\": \"USER\", \"description\": \"Automation_DeviceSaveQuery_#"+value+"\"}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);

    }

    @Ignore
    @Test
    public void PostSaveQueryOverWrite()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT_INVENTA + SAVED_QUERY);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{\"name\":\"Automation_SaveQuery_OverWrite_#" + value + "\",\"query\": \"(hostName==\\\"inventa-windows\\\")\",\"type\": \"DEVICE\", \"description\": \"Over Write Done Automation_SaveQuery_#" + value + "\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);

    }

    @Test
    public void GetDeviceSavedQueries(){
        Response response = QueryWizard.getDeviceSavedQueries();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetUserSavedQueries(){
        Response response = QueryWizard.getUserSavedQueries();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetExecuteDeviceSavedQuery(){
        Response response = QueryWizard.getExecuteDeviceSavedQuery();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetExecuteUserSavedQuery(){
        Response response = QueryWizard.getExecuteUserSavedQuery();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }


    @Test
    public void GetAllSavedQueries(){
        Response response = QueryWizard.getAllSavedQueries();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetAllSavedQueriesNoPaginationDevice(){
        Response response = QueryWizard.getAllSavedQueriesNoPaginationDevice();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetAllSavedQueriesNoPaginationUser(){
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
    public void GetAllAdDeviceFields(){
        Response response = QueryWizard.getAllAdDeviceFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetAllAwsDeviceFields(){
        Response response = QueryWizard.getAllAwsDeviceFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }
    @Test
    public void GetAllAzureDeviceFields(){
        Response response = QueryWizard.getAllAzureDeviceFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetAllWmicDeviceFields(){
        Response response = QueryWizard.getAllWmicDeviceFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetAllAdUserFields(){
        Response response = QueryWizard.getAllAdUserFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetAllAwsUserFields(){
        Response response = QueryWizard.getAllAwsUserFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetAllAzureUserFields(){
        Response response = QueryWizard.getAllAzureUserFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetAzureTypeDeviceFields(){
        Response response = QueryWizard.getAzureTypeDeviceFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetAwsTypeDeviceFields(){
        Response response = QueryWizard.getAwsTypeDeviceFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetAdTypeDeviceFields(){
        Response response = QueryWizard.getAdTypeDeviceFields();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }




}
