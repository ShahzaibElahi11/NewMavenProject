package testcases;

import api.PolicyRoutines;
import io.restassured.response.Response;
import models.policyroutine.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.http.HttpStatus;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import utils.BaseAPI;
import utils.BaseTest;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static utils.BaseAPI.getIdFromURL;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PolicyRoutineTest extends BaseTest {

    public static boolean isPreviousTestPass;

    //Update Post Method Using Builder Class
    @Test
    @Title("Create New Policy Routine")
    public void testA_PostCreatePolicyRoutine() {
        isPreviousTestPass = false;
        PolicyRoutineProperties policyRoutineProperties = new PolicyRoutineProperties.Builder()
                .setUsername("test")
                .setPassword("password123")
                .build();
        PolicyRoutineMainAction policyRoutineMainAction = new PolicyRoutineMainAction.Builder()
                .setAction("RC02")
                .setProperties(policyRoutineProperties)
                .build();
        PolicyRoutine policyRoutine = new PolicyRoutine.Builder()
                .setName("Automation Policy Routine # " + value)
                .setMainAction(policyRoutineMainAction)
                .build();
        Response response = PolicyRoutines.postPolicyRoutine(policyRoutine);
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }


    @Test
    @Title("Update Policy Routine")
    public void testB_PutPolicyRoutineNew() throws IOException {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        PolicyRoutineProperties policyRoutineProperties = new PolicyRoutineProperties.Builder()
                .setUsername("test")
                .setPassword("password123")
                .build();
        PolicyRoutineMainAction policyRoutineMainAction = new PolicyRoutineMainAction.Builder()
                .setAction("RC02")
                .setProperties(policyRoutineProperties)
                .build();
        PolicyRoutine policyRoutine = new PolicyRoutine.Builder()
                .setName("Update1_Automation Policy Routine # " + value)
                .setMainAction(policyRoutineMainAction)
                .build();
        Response response = PolicyRoutines.updatePolicyRoutine(policyRoutine);
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }


    @Test
    @Title("Delete Policy Routine")
    public void testC_DeletePolicyRoutine() throws IOException {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = PolicyRoutines.deletePolicyRoutine();
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Display All Policy Routine Data")
    public void getPolicyRoutineAllData() {
        Response response = PolicyRoutines.getPolicyRoutineAllData();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }


    @Test
    @Title("Get Policy Routine Action")
    public void getPolicyRoutineActions() {
        Response response = PolicyRoutines.getPolicyRoutineActions();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Policy Routine Action on Devices")
    public void getPolicyRoutineDeviceActions() {
        Response response = PolicyRoutines.getPolicyRoutineDeviceActions();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }


    @Test
    @Title("Get Policy Routine Action on Users")
    public void getPolicyRoutineUserActions() {
        Response response = PolicyRoutines.getPolicyRoutineUserActions();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Policy Routine Table")
    public void getPolicyRoutineTable() {
        Response response = PolicyRoutines.getPolicyRoutineTable();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Ignore
    @Test
    @Title("Get Policy Routine Table With Filter")
    public void getPolicyRoutineTableWithFilter() {
        Response response = PolicyRoutines.getPolicyRoutineTableWithFilter();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Policy Routine Summary")
    public void getPolicyRoutineSummary() throws IOException {
        Response response = PolicyRoutines.getPolicyRoutineSummary();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));

    }


    @Test
    @Title("Post Policy Routine Enforce on Devices")
    public void postEnforcePolicyOnDevice() {
        EnforcePolicyOnDevice enforcePolicyOnDevice = new EnforcePolicyOnDevice("MSEDGEWIN10-5.inventa12.com");
        Response response = PolicyRoutines.postEnforcePolicyDevice(enforcePolicyOnDevice);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Post Policy Routine Enforce on Users")
    public void postEnforcePolicyOnUser() {

        EnforcePolicyOnUser enforcePolicyOnUser = new EnforcePolicyOnUser("filyas@netpace.com");
        Response response = PolicyRoutines.postEnforcePolicyUser(enforcePolicyOnUser);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Policy Routine Action Pair")
    public void getActionsPair() {
        Response response = PolicyRoutines.getActionsPair();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Policy Routine Details By Id")
    public void getPolicyRoutineById() throws IOException {
        Response response = PolicyRoutines.getPolicyRoutineById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"));
    }


}
