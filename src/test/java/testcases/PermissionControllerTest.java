package testcases;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseTest;

import java.io.IOException;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

@RunWith(SerenityRunner.class)
public class PermissionControllerTest extends BaseTest {

    @Test
    @Title("Get All Permission")
    public void getAllPermission() {
        given().
                spec(requestSpec).
                when().
                get(PERMISSION_ENDPOINT + GET_ALL_PERMISSION).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Permission Details By Id")
    public void getPermissionDetails() throws IOException {
        String permissionId;
        permissionId = getIdFromPermissionURL(GET_PERMISSION_ID);
        given().
                spec(requestSpec).
                when().
                get(PERMISSION_ENDPOINT + PERMISSION_DETAILS + permissionId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get All Modules List")
    public void getAllModules() {
        given().
                spec(requestSpec).
                when().
                get(PERMISSION_ENDPOINT + GET_ALL_MODULES).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Role Modules By ADMIN Detail")
    public void getRoleModules() {
        given().
                spec(requestSpec).
                when().
                get(PERMISSION_ENDPOINT + GET_ROLE_MODULES + "ADMIN").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Role Permission By Role")
    public void getRolePermission() {
        given().
                spec(requestSpec).
                when().
                get(PERMISSION_ENDPOINT + GET_ROLE_PERMISSION + "dashboard&role=ADMIN").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get User Modules Details By User Id")
    public void getUserModules() throws IOException {
        String adminUserId;
        adminUserId = getIdFromURL(GET_ADMIN_USER_ID);
        given().
                spec(requestSpec).
                when().
                get(PERMISSION_ENDPOINT + GET_USER_MODULES + adminUserId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get All User Permission By Admin User Id")
    public void getUserPermissionById() throws IOException {
        String adminUserId;
        adminUserId = getIdFromURL(GET_ADMIN_USER_ID);
        given().
                spec(requestSpec).
                when().
                get(PERMISSION_ENDPOINT + USER_PERMISSION + "?userId=" + adminUserId + "&module=asset").
                then().
                spec(responseSpec);

    }
}
