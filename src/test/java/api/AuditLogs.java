package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.BaseAPI;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

public class AuditLogs extends BaseAPI {

    public static Response getUserAudit() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + AUDIT_ENDPOINT + USER_AUDIT);
    }

    public static Response getAuditDetail() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + AUDIT_ENDPOINT + AUDIT_DETAIL + AUDIT_DETAIL_ID);
    }

    public static Response getAllUserAuditList() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + AUDIT_ENDPOINT + ALL_USER_AUDIT_LIST);
    }

    public static Response getAllUsersName() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + ALL_USER_NAME);
    }

}
