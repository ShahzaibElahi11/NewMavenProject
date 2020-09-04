package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.policyroutine.EnforcePolicyOnUser;
import models.policyroutine.PolicyRoutine;
import utils.BaseTest;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

public class PolicyRoutines extends BaseTest {


    public static Response postEnforcePolicyUser(EnforcePolicyOnUser enforcePolicyOnUser) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(enforcePolicyOnUser)
                .when()
                .post(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE + "enforce/" + USER_ID + "/users/");
    }


    public static Response deletePolicyRoutine() {
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


    public static Response updatePolicyRoutine(PolicyRoutine policyRoutine) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(policyRoutine)
                .when()
                .put(BASE_ENDPOINT_INVENTA + POLICY_ROUTINE + PR_ID);
    }
}

