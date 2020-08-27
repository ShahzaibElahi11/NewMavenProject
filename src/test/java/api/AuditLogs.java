package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.BaseClass;

import static io.restassured.RestAssured.given;
public class AuditLogs extends BaseClass {

    public static final String AUDIT_ENDPOINT = "/audit/";

    public static Response getUserAudit() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + AUDIT_ENDPOINT + "getUserAudit?username=admininventa&page=0&size=1");
}

    public static Response getAuditDetail() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + AUDIT_ENDPOINT + "getAuditDetail?id=" + AUDIT_DETAIL_ID);
    }

    public static Response getAllUserAuditList() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + AUDIT_ENDPOINT + "getAllAudit?page=0&size=10");
    }

    public static Response getAllUsersName() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/adminUsers/getAllUsername");
    }

}
