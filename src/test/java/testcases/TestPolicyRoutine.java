package testcases;

import api.Apis;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import models.EnforcePolicyOnDevice;
import models.EnforcePolicyOnUser;
import models.PolicyRoutineMainAction;
import models.PolicyRoutine;
import utils.BaseClass;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class TestPolicyRoutine extends BaseClass {


    public static final String POLICY_ROUTINE = "/policy-routine/";
    //  public static final String PR_UPDATE_ID = "5f0f3612229fd5347635b24c";
    //re-think
    public static final String PR_DELETE_ID = "5f22c5496d329947e1949ed0";
    public static final String PR_ACTION = "actions";
    public static final String PR_TABLE = "table/?page=0&size=10";

    //re-think
    public static final String PR_FILTER_NAME = "TEST_FILTER";


    @Test
    public void PostCreatePolicyRoutine()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + POLICY_ROUTINE);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{\"name\": \"Automation Policy Routine # " + value + "\",\"mainAction\": {\"action\": \"RC02\", \"properties\": {\"user\": \"user1\", \"password\":\"ppp\"}},\"successCount\": 1}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }
    @Test
    public void PostCreatePolicyRoutineNew() {
        //need Improvement
        PolicyRoutineMainAction policyRoutineMainAction = new PolicyRoutineMainAction(new String("RC02") );
        PolicyRoutine policyRoutine = new PolicyRoutine("Automation Policy Routine #"+value+"1", policyRoutineMainAction);
        Response response = Apis.postPolicyRoutine(policyRoutine);
        assertThat(response.getStatusCode(), equalTo(200));

    }



    @Test
    public void PutPolicyRoutine()throws IOException {

        HttpPut request = new HttpPut(BASE_ENDPOINT + POLICY_ROUTINE + PR_ID);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{\"name\": \"Automation Updated Policy Routine # " + value + "\",\"mainAction\": {\"action\": \"RC02\", \"properties\": {\"user\": \"user1\", \"password\":\"ppp\"}},\"successCount\": 1}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void GetPolicyRoutineAllData() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + POLICY_ROUTINE)  ;
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    //@Test
    @Test(enabled = false)
    public void DeletePolicyRoutine() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT + POLICY_ROUTINE + "?ids=" + PR_DELETE_ID )  ;

        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

//    @Test
//    public void DeletePolicyRoutineNew() {
//        Response deleteResponse = Apis.deletePolicyRoutine();
//        assertThat(deleteResponse.getStatusCode(), equalTo(200));
//
//    }

    @Test
    public void GetPolicyRoutineActions() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + POLICY_ROUTINE + PR_ACTION)  ;
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetPolicyRoutineDeviceActions() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + POLICY_ROUTINE + PR_ACTION + "/devices")  ;
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }


    @Test
    public void GetPolicyRoutineUserActions() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + POLICY_ROUTINE + PR_ACTION + "/users")  ;
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetPolicyRoutineTable() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + POLICY_ROUTINE + PR_TABLE)  ;
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }


    @Test
    public void GetPolicyRoutineTableWithFilter() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + POLICY_ROUTINE + PR_TABLE + "&filter=" + PR_FILTER_NAME)  ;
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetPolicyRoutineSummary() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + POLICY_ROUTINE + "summary/" +  PR_ID) ;
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }


    @Test
    public void PostEnforcePolicyonDevice()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + POLICY_ROUTINE + "enforce/"+ DEVICE_DETAIL_ID + "/devices/");
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "[{\"hostName\": \"MSEDGEWIN10-5\"}]";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void PostEnforcePolicyOnDeviceNew(){
        EnforcePolicyOnDevice enforcePolicyOnDevice = new EnforcePolicyOnDevice("MSEDGEWIN10-5.inventa12.com");

        Response response = Apis.postEnforcePolicyDevice(enforcePolicyOnDevice);
        assertThat(response.getStatusCode(), equalTo(200));

    }


    @Test
    public void PostEnforcePolicyonUser()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + POLICY_ROUTINE + "enforce/"+ USER_ID + "/users/");
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "[{\"name\": \"abcuser\"}]";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }
    @Test
    public void PostEnforcePolicyOnUserNew(){

        EnforcePolicyOnUser enforcePolicyOnUser = new EnforcePolicyOnUser("filyas@netpace.com");
        Response response = Apis.postEnforcePolicyUser(enforcePolicyOnUser);
        assertThat(response.getStatusCode(), equalTo(200));

    }

    /**
     * new added
     *
     */

    @Test
    public void GetActionsPair() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + POLICY_ROUTINE + PR_ACTION + "/pair") ;
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }
    @Test
    public void GetPolicyRoutineById() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + POLICY_ROUTINE + PR_ID) ;
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

}
