package testcases;

import api.PolicyRoutineApis;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import models.policyroutine.EnforcePolicyOnDevice;
import models.policyroutine.EnforcePolicyOnUser;
import models.policyroutine.PolicyRoutineMainAction;
import models.policyroutine.PolicyRoutine;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import utils.BaseClass;

import java.io.IOException;
import java.nio.charset.Charset;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestPolicyRoutine extends BaseClass {


    public static final String POLICY_ROUTINE = "/policy-routine/";
    //re-think
    public static final String PR_DELETE_ID = "5f22c5496d329947e1949ed0";


    @Test
    public void PostCreatePolicyRoutine() {
        //need Improvement
        PolicyRoutineMainAction policyRoutineMainAction = new PolicyRoutineMainAction(new String("RC02"));
        PolicyRoutine policyRoutine = new PolicyRoutine("Automation Policy Routine #" + value + "1", policyRoutineMainAction);
        Response response = PolicyRoutineApis.postPolicyRoutine(policyRoutine);
        assertThat(response.getStatusCode(), equalTo(200));

    }

    @Ignore
    @Test
    public void PutPolicyRoutine() throws IOException {

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
    public void GetPolicyRoutineAllData() {

        Response response = PolicyRoutineApis.getPolicyRoutineAllData();
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Ignore
    @Test
    public void DeletePolicyRoutineOld() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT + POLICY_ROUTINE + "?ids=" + PR_DELETE_ID);
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Ignore
    @Test
    public void DeletePolicyRoutine() {
        Response deleteResponse = PolicyRoutineApis.deletePolicyRoutine();
        assertThat(deleteResponse.getStatusCode(), equalTo(200));

    }

    @Test
    public void GetPolicyRoutineActions() {
        Response response = PolicyRoutineApis.getPolicyRoutineActions();
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetPolicyRoutineDeviceActions() {
        Response response = PolicyRoutineApis.getPolicyRoutineDeviceActions();
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));

    }


    @Test
    public void GetPolicyRoutineUserActions() {
        Response response = PolicyRoutineApis.getPolicyRoutineUserActions();
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));

    }

    @Test
    public void GetPolicyRoutineTable(){
        Response response = PolicyRoutineApis.getPolicyRoutineTable();
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));
    }


    @Test
    public void GetPolicyRoutineTableWithFilter(){
        Response response = PolicyRoutineApis.getPolicyRoutineTableWithFilter();
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetPolicyRoutineSummary(){
        Response response = PolicyRoutineApis.getPolicyRoutineSummary();
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));

    }


    @Test
    public void PostEnforcePolicyOnDevice() {
        EnforcePolicyOnDevice enforcePolicyOnDevice = new EnforcePolicyOnDevice("MSEDGEWIN10-5.inventa12.com");

        Response response = PolicyRoutineApis.postEnforcePolicyDevice(enforcePolicyOnDevice);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));

    }

    @Test
    public void PostEnforcePolicyOnUser() {

        EnforcePolicyOnUser enforcePolicyOnUser = new EnforcePolicyOnUser("filyas@netpace.com");
        Response response = PolicyRoutineApis.postEnforcePolicyUser(enforcePolicyOnUser);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetActionsPair(){
        Response response = PolicyRoutineApis.getActionsPair();
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));

    }

    @Test
    public void GetPolicyRoutineById(){
        Response response = PolicyRoutineApis.getPolicyRoutineById();
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));

    }

}
