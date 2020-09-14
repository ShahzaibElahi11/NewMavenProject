package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.usermanagement.AdminUser;
import models.usermanagement.Login;
import models.usermanagement.Role;
import utils.BaseAPI;

import java.io.IOException;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

public class UserManagement extends BaseAPI {

    public static Response postCreateRole(Role role) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(role)
                .when()
                .post(BASE_ENDPOINT_INVENTA + ROLE_ENDPOINT + CREATE_ROLE);

    }

    public static Response getAllRole() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + ROLE_ENDPOINT + GET_ALL_ROLE);
    }

    public static Response getRoleDetails() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + ROLE_ENDPOINT + ROLE_DETAILS + ROLE_ID);
    }

    public static Response getAllPermission() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + PERMISSION_ENDPOINT + GET_ALL_PERMISSION);
    }

    public static Response getPermissionDetails() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + PERMISSION_ENDPOINT + PERMISSION_DETAILS + PERMISSION_ID);
    }

    public static Response getAllModules() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + PERMISSION_ENDPOINT + GET_ALL_MODULES);
    }

    public static Response getRoleModules() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + PERMISSION_ENDPOINT + GET_ROLE_MODULES + "ADMIN");
    }

    public static Response getRolePermission() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + PERMISSION_ENDPOINT + GET_ROLE_PERMISSION + "dashboard&role=ADMIN");
    }

    public static Response getUserModules() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + PERMISSION_ENDPOINT + GET_USER_MODULES + ADMIN_USER_ID);
    }

    public static Response getAllAdminUser() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + ADMIN_USER_ENDPOINT + GET_ALL_ADMIN_USER + PAGINATION_PARAMETER);
    }

    public static Response getAdminUserDetail() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + ADMIN_USER_ENDPOINT + ADMIN_USER_DETAILS + ADMIN_USER_ID);
    }


    public static Response getAllAdminUserName() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + ADMIN_USER_ENDPOINT + ALL_ADMIN_USERNAME);
    }


    public static Response updateRole(Role role) throws IOException {
        String CURRENT_ROLE_ID = "";

        CURRENT_ROLE_ID = getIdFromURL("http://inventaserver:9092/role/getAllRole?page=0&size=1&sort=dateCreated,desc");
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(role)
                .when()
                .put(BASE_ENDPOINT_INVENTA + ROLE_ENDPOINT + UPDATE_ROLE + CURRENT_ROLE_ID);


    }

    public static Response postLogin(Login login) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(login)
                .when()
                .post(BASE_ENDPOINT_INVENTA + "/login");
    }

    public static Response postCreateUser(AdminUser adminUser) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(adminUser)
                .when()
                .post(BASE_ENDPOINT_INVENTA + ADMIN_USER_ENDPOINT + CREATE_ADMIN_USER);
    }

    public static Response updateAdminUser(AdminUser adminUser) throws IOException {
        String CURRENT_ADMIN_USER_ID = "";

        CURRENT_ADMIN_USER_ID = getIdFromURL("http://inventaserver:9092/adminUsers/getAllAdminUsers?page=0&size=1&sort=dateCreated,desc");
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(adminUser)
                .when()
                .put(BASE_ENDPOINT_INVENTA + ADMIN_USER_ENDPOINT + UPDATE_ADMIN_USER + CURRENT_ADMIN_USER_ID);
    }

    public static Response deleteAdminUser() throws IOException {
        String CURRENT_DELETE_ADMIN_USER_ID = "";

        CURRENT_DELETE_ADMIN_USER_ID = getIdFromURL("http://inventaserver:9092/adminUsers/getAllAdminUsers?page=0&size=1&sort=dateModified,desc");
        return given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(BASE_ENDPOINT_INVENTA + ADMIN_USER_ENDPOINT + DELETE_ADMIN_USER + CURRENT_DELETE_ADMIN_USER_ID);

    }

    public static Response deleteRole() throws IOException {
        String CURRENT_DELETE_ROLE_ID = "";

        CURRENT_DELETE_ROLE_ID = getIdFromURL("http://inventaserver:9092/role/getAllRole?page=0&size=1&sort=dateModified,desc");

        return given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(BASE_ENDPOINT_INVENTA + ROLE_ENDPOINT + DELETE_ROLE + CURRENT_DELETE_ROLE_ID);
    }
}
