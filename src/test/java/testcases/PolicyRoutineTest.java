package testcases;

import api.PolicyRoutines;
import io.restassured.response.Response;
import models.policyroutine.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import utils.BaseTest;


import static constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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
    public void testB_PutPolicyRoutineNew() {
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
    public void testC_DeletePolicyRoutine() {
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


    @Test
    @Title("Get Policy Routine Table With Filter")
    public void getPolicyRoutineTableWithFilter() {
        given().
                spec(requestSpec).
                when().
                get(POLICY_ROUTINE + PR_TABLE + "&filter=" + PR_FILTER_NAME).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Policy Routine Summary")
    public void getPolicyRoutineSummary() {
        given().
                spec(requestSpec).
                when().
                get(POLICY_ROUTINE + "summary/" + PR_ID).
                then().
                spec(responseSpec).
                and().
                body("data.mainAction.action", equalTo("RC02"));

    }


    @Test
    @Title("Post Policy Routine Enforce on Devices")
    public void postEnforcePolicyOnDevice() {
        EnforcePolicyOnDevice enforcePolicyOnDevice = new EnforcePolicyOnDevice("MSEDGEWIN10-5.inventa12.com");
        given().
                spec(requestSpec).
                and().
                body(enforcePolicyOnDevice).
                when().
                post(POLICY_ROUTINE + "enforce/" + DEVICE_DETAIL_ID + "/devices/").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK);

    }

    @Test
    @Title("Post Policy Routine Enforce on Users")
    public void postEnforcePolicyOnUser() {

        EnforcePolicyOnUser enforcePolicyOnUser = new EnforcePolicyOnUser("filyas@netpace.com");
        Response response = PolicyRoutines.postEnforcePolicyUser(enforcePolicyOnUser);
        given().
                spec(requestSpec).
                and().
                body(enforcePolicyOnUser).
                when().
                post(POLICY_ROUTINE + "enforce/" + USER_ID + "/users/").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK);
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
    public void getPolicyRoutineById() {
        given().
                spec(requestSpec).
                when().
                get(POLICY_ROUTINE + PR_ID).
                then().
                spec(responseSpec).
                and().
                body("data._id", equalTo(PR_ID));
    }


}
