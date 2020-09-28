package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.policyroutine.EnforcePolicyOnDevice;
import models.policyroutine.EnforcePolicyOnUser;
import models.policyroutine.PolicyRoutine;
import utils.BaseAPI;

import java.io.IOException;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

public class PolicyRoutines extends BaseAPI {

    public static Response getPolicyRoutineAllData() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE);
    }

    public static Response getPolicyRoutineActions() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE + PR_ACTION);
    }

    public static Response getPolicyRoutineDeviceActions() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE + PR_ACTION + "/devices");
    }

    public static Response getPolicyRoutineUserActions() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE + PR_ACTION + "/users");
    }


    public static Response getPolicyRoutineTable() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE + PR_TABLE);
    }


    public static Response getPolicyRoutineTableWithFilter() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE + PR_TABLE + "&filter=" + PR_FILTER_NAME);
    }

    public static Response getPolicyRoutineSummary() throws IOException {
        String PR_ID = "";
        PR_ID = getIdFromURL("http://inventaserver:9092/policy-routine/?page=0&size=1&sort=dateCreated,desc");

        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE + "summary/" + PR_ID);
    }

    public static Response postEnforcePolicyDevice(EnforcePolicyOnDevice enforcePolicyOnDevice) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(enforcePolicyOnDevice)
                .when()
                .post(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE + "enforce/" + DEVICE_DETAIL_ID + "/devices/");
    }

    public static Response postEnforcePolicyUser(EnforcePolicyOnUser enforcePolicyOnUser) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(enforcePolicyOnUser)
                .when()
                .post(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE + "enforce/" + USER_ID + "/users/");
    }


    public static Response getActionsPair() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE + PR_ACTION + "/pair");
    }


    public static Response getPolicyRoutineById() throws IOException {
        String PR_ID = "";
        PR_ID = getIdFromURL("http://inventaserver:9092/policy-routine/?page=0&size=1&sort=dateCreated,desc");

        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE + PR_ID);
    }

    public static Response deletePolicyRoutine() throws IOException {
       String DELETE_PR_ID = "";
        DELETE_PR_ID = getIdFromURL("http://inventaserver:9092/policy-routine/?page=0&size=1&sort=dateModified,desc");

        return given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE + "?ids=" + DELETE_PR_ID);

    }

    public static Response postPolicyRoutine(PolicyRoutine policyRoutine) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(policyRoutine)
                .when()
                .post(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE);
    }


    public static Response updatePolicyRoutine(PolicyRoutine policyRoutine) throws IOException {
        String PR_ID = "";
        PR_ID = getIdFromURL("http://inventaserver:9092/policy-routine/?page=0&size=1&sort=dateCreated,desc");
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(policyRoutine)
                .when()
                .put(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE + PR_ID);
    }
}

