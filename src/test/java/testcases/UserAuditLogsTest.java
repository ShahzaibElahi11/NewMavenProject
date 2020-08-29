package testcases;

import api.AuditLogs;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseClass;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class UserAuditLogsTest extends BaseClass {

    @Test
    @Title("Get User Audit Details By UserName")
    public void getUserAudit() {
        Response response = AuditLogs.getUserAudit();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get User Audit Details By Id")
    public void getAuditDetail() {
        Response response = AuditLogs.getAuditDetail();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data._id", equalTo(AUDIT_DETAIL_ID), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get User Audit Details List")
    public void getAllUserAuditList() {
        Response response = AuditLogs.getAllUserAuditList();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }


    @Test
    @Title("Get Username List of User Audit")
    public void getAllUsersName() {
        Response response = AuditLogs.getAllUsersName();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data[0].username", equalTo("admininventa"));
    }


}
