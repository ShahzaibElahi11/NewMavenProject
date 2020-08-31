package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.usermanagement.AdminUser;
import models.usermanagement.Login;
import models.usermanagement.Role;
import utils.BaseTest;

import static io.restassured.RestAssured.given;

public class UserManagement extends BaseTest {
    public static final String ROLE_ENDPOINT = "/role/";
    public static final String CREATE_ROLE = "createRole";
    public static final String GET_ALL_ROLE = "getAllRole";
    public static final String ROLE_DETAILS = "getRoleDetail?id=";
    public static final String UPDATE_ROLE = "updateRole?id=";
    public static final String DELETE_ROLE = "deleteRole?id=";

    public static final String PERMISSION_ENDPOINT = "/permission/";
    public static final String GET_ALL_PERMISSION = "getAllPermission";
    public static final String PERMISSION_DETAILS = "getPermissionDetail?id=";

    public static final String GET_ALL_MODULES = "getAllModules";
    public static final String GET_ROLE_MODULES = "getRoleModules?role=";
    public static final String GET_ROLE_PERMISSION = "getRolePermission?module=";
    public static final String GET_USER_MODULES = "getUserModules?userId=";

    public final static String ADMIN_USER_ENDPOINT = "/adminUsers/";
    public static final String CREATE_ADMIN_USER = "createUser";
    public static final String GET_ALL_ADMIN_USER = "getAllAdminUsers";
    public static final String ADMIN_USER_DETAILS = "getAdminUserDetail?_id=";
    public static final String UPDATE_ADMIN_USER = "updateUser?id=";
    public static final String DELETE_ADMIN_USER = "deleteAdminUser?_id=";
    public static final String ALL_ADMIN_USERNAME = "getAllUsername";


    public final static String LOGIN = "/login";
    public static final String PAGINATION_PARAMETER = "?page=0&size=100";


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


    public static Response updateRole(Role role) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(role)
                .when()
                .put(BASE_ENDPOINT_INVENTA + ROLE_ENDPOINT + UPDATE_ROLE + ROLE_ID);


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

    public static Response updateAdminUser(AdminUser adminUser) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(adminUser)
                .when()
                .put(BASE_ENDPOINT_INVENTA + ADMIN_USER_ENDPOINT + UPDATE_ADMIN_USER + ADMIN_USER_ID);
    }

    public static Response deleteAdminUser() {
        return given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(BASE_ENDPOINT_INVENTA + ADMIN_USER_ENDPOINT + DELETE_ADMIN_USER + DELETE_ADMIN_USER_ID);

    }

    public static Response deleteRole() {
        return given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(BASE_ENDPOINT_INVENTA + ROLE_ENDPOINT + DELETE_ROLE + DELETE_ROLE_ID);
    }
}
