package testcases;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseTest;

import java.io.IOException;

import static constants.AuditControllerConstants.*;
import static io.restassured.RestAssured.given;

@RunWith(SerenityRunner.class)
public class AuditControllerTest extends BaseTest {

    @Test
    @Title("Get User Audit Details By UserName")
    public void getUserAudit() {
        given().
                spec(requestSpec).
                when().
                get(AUDIT_ENDPOINT + USER_AUDIT).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get User Audit Details By Id")
    public void getAuditDetail() throws IOException {
        String auditId;
        auditId = getIdFromURL(GET_AUDIT_ID);
        given().
                spec(requestSpec).
                when().
                get(AUDIT_ENDPOINT + AUDIT_DETAIL + auditId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get User Audit Details List")
    public void getAllUserAuditList() {
        given().
                spec(requestSpec).
                when().
                get(AUDIT_ENDPOINT + ALL_USER_AUDIT_LIST).
                then().
                spec(responseSpec);
    }


}
