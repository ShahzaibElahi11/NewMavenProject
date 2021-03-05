package testcases;

import io.restassured.response.Response;
import models.policyroutine.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import utils.BaseTest;


import java.io.IOException;

import static constants.PolicyRoutineControllerConstants.*;
import static constants.UserControllerConstants.GET_USER_ID;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.apache.http.HttpStatus.*;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PolicyRoutineTest extends BaseTest {

    public static boolean isPreviousTestPass;

    @Test
    @Title("Create New Policy Routine")
    public void testA_PostCreatePolicyRoutine() {
        isPreviousTestPass = false;

        PolicyRoutineProperties policyRoutineProperties = PolicyRoutineProperties.builder().username("test1").password("password123").build();
        PolicyRoutineMainAction policyRoutineMainAction = PolicyRoutineMainAction.builder().action("RC02").properties(policyRoutineProperties).build();
        PolicyRoutine policyRoutine = PolicyRoutine.builder().name("Automation Policy Routine # " + VALUE).mainAction(policyRoutineMainAction).build();

        Response response = given().
                spec(requestSpec).
                and().
                body(policyRoutine).
                when().
                post(POLICY_ROUTINE);

        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.then().
                spec(responseSpec).
                and()
                .body("meta.status", equalTo("success"));
    }


    @Test
    @Title("Update Policy Routine")
    public void testB_PutPolicyRoutine() throws IOException {
        String currentPolicyRoutineId = "";
        currentPolicyRoutineId = getIdFromURL(PUT_POLICY_ROUTINE_ID);

        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;

        PolicyRoutineProperties policyRoutineProperties = PolicyRoutineProperties.builder().username("test1").password("password123").build();
        PolicyRoutineMainAction policyRoutineMainAction = PolicyRoutineMainAction.builder().action("RC02").properties(policyRoutineProperties).build();
        PolicyRoutine policyRoutine = PolicyRoutine.builder().name("Update1_Automation Policy Routine # " + VALUE).mainAction(policyRoutineMainAction).build();

        Response response = given().
                spec(requestSpec).
                and().
                body(policyRoutine).
                when().
                put(POLICY_ROUTINE + currentPolicyRoutineId);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Delete Policy Routine")
    public void testC_DeletePolicyRoutine() throws IOException {
        String policyRoutineDeleteId = "";
        policyRoutineDeleteId = getIdFromURL(DELETE_POLICY_ROUTINE_ID);

        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = given().
                spec(requestSpec).
                when().
                delete(POLICY_ROUTINE + "?ids=" + policyRoutineDeleteId);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;

        response.
                then().
                assertThat().
                statusCode(SC_OK);
    }

    @Test
    @Title("Get All Policy Routine Data")
    public void getPolicyRoutineAllData() {
        given().
                spec(requestSpec).
                when().
                get(POLICY_ROUTINE).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Policy Routine Action")
    public void getPolicyRoutineActions() {
        given().
                spec(requestSpec).
                when().
                get(POLICY_ROUTINE + PR_ACTION).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Policy Routine Action on Devices")
    public void getPolicyRoutineDeviceActions() {
        given().
                spec(requestSpec).
                when().
                get(POLICY_ROUTINE + PR_ACTION + "/devices").
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get Policy Routine Action on Users")
    public void getPolicyRoutineUserActions() {
        given().
                spec(requestSpec).
                when().
                get(POLICY_ROUTINE + PR_ACTION + "/users").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Policy Routine Table")
    public void getPolicyRoutineTable() {
        given().
                spec(requestSpec).
                when().
                get(POLICY_ROUTINE + PR_TABLE).
                then().
                spec(responseSpec);
    }

    @Ignore
    @Test
    @Title("Get Policy Routine Summary")
    public void getPolicyRoutineSummary() throws IOException {
         String policyRoutineId;
        policyRoutineId = getIdFromURL(GET_POLICY_ROUTINE_ID);
        given().
                spec(requestSpec).
                when().
                get(POLICY_ROUTINE + "summary/" + policyRoutineId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Post Policy Routine Enforce on Devices")
    public void postEnforcePolicyOnDevice() throws IOException {
        String deviceId;
        deviceId = getIdFromURL(GET_DEVICE_ID);
        EnforcePolicyOnDevice enforcePolicyOnDevice = new EnforcePolicyOnDevice("MSEDGEWIN10-5.inventa12.com");
        given().
                spec(requestSpec).
                and().
                body(enforcePolicyOnDevice).
                when().
                post(POLICY_ROUTINE + "enforce/" + deviceId + "/"+ DEVICES).
                then().
                assertThat().
                statusCode(SC_OK);
    }

    @Test
    @Title("Post Policy Routine Enforce on Users")
    public void postEnforcePolicyOnUser() throws IOException {
        String userId;
        userId = getIdFromURL(GET_USER_ID);
        EnforcePolicyOnUser enforcePolicyOnUser = new EnforcePolicyOnUser("filyas@netpace.com");
        given().
                spec(requestSpec).
                and().
                body(enforcePolicyOnUser).
                when().
                post(POLICY_ROUTINE + "enforce/" + userId + "/" + USERS).
                then().
                assertThat().
                statusCode(SC_OK);
    }

    @Test
    @Title("Get Policy Routine Action Pair")
    public void getActionsPair() {
        given().
                spec(requestSpec).
                when().
                get(POLICY_ROUTINE + PR_ACTION + "/pair").
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get Policy Routine Details By Id")
    public void getPolicyRoutineById() throws IOException {
        String policyRoutineId;
        policyRoutineId = getIdFromURL(GET_POLICY_ROUTINE_ID);
        given().
                spec(requestSpec).
                when().
                get(POLICY_ROUTINE + policyRoutineId).
                then().
                spec(responseSpec).
                and().
                body("data._id", equalTo(policyRoutineId));
    }

    @Test
    @Title("Get All Device Policy Routines")
    public void getAllDevicePolicyRoutines() {
        given().
                spec(requestSpec).
                when().
                get(POLICY_ROUTINE + DEVICES).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get All User Policy Routines")
    public void getAllUserPolicyRoutines() {
        given().
                spec(requestSpec).
                when().
                get(POLICY_ROUTINE + USERS).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Policy Routine Set For Device")
    public void getPolicyRoutineSetForDevice() throws IOException {
        String deviceId;
        deviceId = getIdFromURL(GET_DEVICE_ID);
        given().
                spec(requestSpec).
                when().
                get(POLICY_ROUTINE + "set/device/" + deviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Policy Routine Set For User")
    public void getPolicyRoutineSetForUser() throws IOException {
        String userId;
        userId = getIdFromURL(GET_USER_ID);
        given().
                spec(requestSpec).
                when().
                get(POLICY_ROUTINE + "set/user/" + userId).
                then().
                spec(responseSpec);
    }



}
