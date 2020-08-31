package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.ApplicationConfiguration;
import utils.BaseTest;

import static io.restassured.RestAssured.given;

public class AuditLogs extends BaseTest {

   protected static final String AUDIT_ENDPOINT = ApplicationConfiguration.getAuditEndpoint();
    protected static final String USER_AUDIT = ApplicationConfiguration.getUserAudit();
    protected static final String AUDIT_DETAIL = ApplicationConfiguration.getAuditDetail();
    protected static final String ALL_USER_AUDIT_LIST = ApplicationConfiguration.getAllUserAuditList();
    protected static final String ALL_USER_NAME = ApplicationConfiguration.getAllUserName();


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
