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

import static constants.Constants.*;
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
        PolicyRoutine policyRoutine = PolicyRoutine.builder().name("Automation Policy Routine # " + value).mainAction(policyRoutineMainAction).build();

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
    public void testB_PutPolicyRoutineNew() throws IOException {
        String CURRENT_PR_ID = "";
        CURRENT_PR_ID = getIdFromURL("http://inventaserver:9092/policy-routine/?page=0&size=1&sort=dateCreated,desc");

        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;

        PolicyRoutineProperties policyRoutineProperties = PolicyRoutineProperties.builder().username("test1").password("password123").build();
        PolicyRoutineMainAction policyRoutineMainAction = PolicyRoutineMainAction.builder().action("RC02").properties(policyRoutineProperties).build();
        PolicyRoutine policyRoutine = PolicyRoutine.builder().name("Update1_Automation Policy Routine # " + value).mainAction(policyRoutineMainAction).build();

        Response response = given().
                spec(requestSpec).
                and().
                body(policyRoutine).
                when().
                put(POLICY_ROUTINE + CURRENT_PR_ID);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.then().
                spec(responseSpec).
                and().
                body("meta.status", equalTo("success"));
    }


    @Test
    @Title("Delete Policy Routine")
    public void testC_DeletePolicyRoutine() throws IOException {
        String CURRENT_PR_DELETE_ID = "";
        CURRENT_PR_DELETE_ID = getIdFromURL("http://inventaserver:9092/policy-routine/?page=0&size=1&sort=dateModified,desc");

        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = given().
                spec(requestSpec).
                when().
                delete(POLICY_ROUTINE + "?ids=" + CURRENT_PR_DELETE_ID);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;

        response.
                then().
                assertThat().
                statusCode(SC_OK);
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
                spec(responseSpec);
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
                statusCode(SC_OK);
    }

    @Test
    @Title("Post Policy Routine Enforce on Users")
    public void postEnforcePolicyOnUser() {
        EnforcePolicyOnUser enforcePolicyOnUser = new EnforcePolicyOnUser("filyas@netpace.com");
        given().
                spec(requestSpec).
                and().
                body(enforcePolicyOnUser).
                when().
                post(POLICY_ROUTINE + "enforce/" + USER_ID + "/users/").
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
