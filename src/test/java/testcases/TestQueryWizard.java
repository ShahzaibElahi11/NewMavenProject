package testcases;

import api.QueryWizardApis;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import utils.BaseClass;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestQueryWizard extends BaseClass {

    public static final String SAVED_QUERY = "/saved-query/";

    @Test
    public void GetEqualOperator(){
        Response response = QueryWizardApis.getEqualOperator();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetNotEqualOperator(){
        Response response = QueryWizardApis.getNotEqualOperator();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }

    @Test
    public void GetExistsOperatorTrue(){
        Response response = QueryWizardApis.getExistsOperatorTrue();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }

    @Test
    public void GetExistsOperatorFalse() {
        Response response = QueryWizardApis.getExistsOperatorFalse();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }
    @Test
    public void GetStartWithOperator(){
        Response response = QueryWizardApis.getStartWithOperator();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetEndWithOperator(){
        Response response = QueryWizardApis.getEndWithOperator();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }
    @Test
    public void GetInOperator(){
        Response response = QueryWizardApis.getInOperator();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetContainOperator(){
        Response response = QueryWizardApis.getContainOperator();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }
    @Test
    public void GetANDOperator(){
        Response response = QueryWizardApis.getANDOperator();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetOROperator(){
        Response response = QueryWizardApis.getOROperator();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetAdapterDetailsQuery(){
        Response response = QueryWizardApis.getAdapterDetailsQuery();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetStatementQuery(){
        Response response = QueryWizardApis.getStatementQuery();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }

    /**
     * Saved Query Controller
     *
     */
    @Ignore
    @Test
    public void PostDeviceSaveQuery()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + SAVED_QUERY);
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

        HttpPost request = new HttpPost(BASE_ENDPOINT + SAVED_QUERY);
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

        HttpPost request = new HttpPost(BASE_ENDPOINT + SAVED_QUERY);
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
        Response response = QueryWizardApis.getDeviceSavedQueries();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetUserSavedQueries(){
        Response response = QueryWizardApis.getUserSavedQueries();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetExecuteDeviceSavedQuery(){
        Response response = QueryWizardApis.getExecuteDeviceSavedQuery();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetExecuteUserSavedQuery(){
        Response response = QueryWizardApis.getExecuteUserSavedQuery();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }


    @Test
    public void GetAllSavedQueries(){
        Response response = QueryWizardApis.getAllSavedQueries();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }

    @Test
    public void GetAllSavedQueriesNoPaginationDevice(){
        Response response = QueryWizardApis.getAllSavedQueriesNoPaginationDevice();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }

    @Test
    public void GetAllSavedQueriesNoPaginationUser(){
        Response response = QueryWizardApis.getAllSavedQueriesNoPaginationUser();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }


    /**
     * Remaining
     * Patch- Rename User Saved Query	http://inventaserver:9092/saved-query/rename/?oldName=testuser&newName=test_user&type=USER
     * Patch- Rename Device Saved Query	http://inventaserver:9092/saved-query/rename/?oldName=SaveQuery14&newName=SaveQuery143&type=DEVICE
     */
    /**
     * new
     */

}
