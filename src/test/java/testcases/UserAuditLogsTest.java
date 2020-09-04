package testcases;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseTest;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class UserAuditLogsTest extends BaseTest {

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
    public void getAuditDetail() {
        given().
                spec(requestSpec).
                when().
                get(AUDIT_ENDPOINT + AUDIT_DETAIL + AUDIT_DETAIL_ID).
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


    @Test
    @Title("Get Username List of User Audit")
    public void getAllUsersName() {
        given().
                spec(requestSpec).
                when().
                get(ALL_USER_NAME).
                then().
                spec(responseSpec).
                and().
                body("data[0].username", equalTo("admininventa"));
    }


}
