package testcases;

import api.PolicyRoutineApis;
import io.restassured.response.Response;
import models.policyroutine.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
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

    //Update Post Method Using Builder Class
    @Test
    public void PostCreatePolicyRoutine() {
        PolicyRoutineProperties policyRoutineProperties = new PolicyRoutineProperties.Builder()
            .setUsername("test")
            .setPassword("password123")
            .build();
        PolicyRoutineMainAction policyRoutineMainAction = new PolicyRoutineMainAction.Builder()
                .setAction("RC02")
                .setProperties(policyRoutineProperties)
                .build();
        PolicyRoutine policyRoutine = new PolicyRoutine.Builder()
                .setName("Automation Policy Routine # "+value)
                .setMainAction(policyRoutineMainAction)
                .build();
        Response response = PolicyRoutineApis.postPolicyRoutine(policyRoutine);
        assertThat(response.getStatusCode(), equalTo(200));
    }


    @Test
    public void PutPolicyRoutineNew(){
        PolicyRoutineProperties policyRoutineProperties = new PolicyRoutineProperties.Builder()
                .setUsername("test")
                .setPassword("password123")
                .build();
        PolicyRoutineMainAction policyRoutineMainAction = new PolicyRoutineMainAction.Builder()
                .setAction("RC02")
                .setProperties(policyRoutineProperties)
                .build();
        PolicyRoutine policyRoutine = new PolicyRoutine.Builder()
                .setName("Update_Automation Policy Routine # "+value)
                .setMainAction(policyRoutineMainAction)
                .build();
        Response response = PolicyRoutineApis.updatePolicyRoutine(policyRoutine);
        assertThat(response.getStatusCode(), equalTo(200));

    }

    @Test
    public void GetPolicyRoutineAllData() {

        Response response = PolicyRoutineApis.getPolicyRoutineAllData();
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Ignore
    @Test
    public void DeletePolicyRoutineOld() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE + "?ids=" + PR_DELETE_ID);
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
