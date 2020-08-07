package api;


import models.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.BaseClass;


import static io.restassured.RestAssured.given;


public class Apis extends BaseClass {

    private static final String apiUrl = "https://restful-booker.herokuapp.com/booking/";
    protected static final String BASE_ENDPOINT = "http://inventaserver:9092";
    public final static String ADMIN_USER_ENDPOINT = "/adminUsers/";
    public static final String CREATE_ADMIN_USER = "createUser";
    public static final String POLICY_ROUTINE = "/policy-routine/";
    public static final String AD_LOGIN = "/ad/login/";

    public static final String USER_ENDPOINT = "/users/";
    public static final String INSERT_TAG = "insertTag";
    public static final String DELETE_NOTE = "deleteNote?userId=";

    public static final String ROLE_ENDPOINT = "/role/";
    public static final String CREATE_ROLE = "createRole";
    public static final String UPDATE_ROLE = "updateRole?id=";





    public static Response getBookings() {
        return given().get(apiUrl);

    }

    public static Response getBookingById(String bookingId) {
        return given().get(apiUrl + bookingId);

    }

    public static Response postBooking(BookingPayload bookingPayload) {
        return given()
                .contentType(ContentType.JSON)
                .body(bookingPayload)
                .when()
                .post(apiUrl);

    }

    public static Response postInsertDeviceNote(DeviceNotes deviceNotes) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(deviceNotes)
                .when()
                .post(BASE_ENDPOINT + "/devices/insertNote");

    }

    public static Response postInsertDeviceTag(DeviceTag deviceTag) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(deviceTag)
                .when()
                .post(BASE_ENDPOINT + "/devices/insertTag");

    }

    public static Response postInsertUserNote(UserNote userNote) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(userNote)
                .when()
                .post(BASE_ENDPOINT + "/users/insertNote");

    }

    public static Response postInsertUserTag(UserTag userTag) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(userTag)
                .when()
                .post(BASE_ENDPOINT + USER_ENDPOINT + INSERT_TAG);

    }

    public static Response postLogin(Login login) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(login)
                .when()
                .post(BASE_ENDPOINT + "/login");
    }

    public static Response postCreateUser(AdminUser adminUser) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(adminUser)
                .when()
                .post(BASE_ENDPOINT + ADMIN_USER_ENDPOINT + CREATE_ADMIN_USER);
    }

    public static Response postEnforcePolicyDevice(EnforcePolicyOnDevice enforcePolicyOnDevice) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(enforcePolicyOnDevice)
                .when()
                .post(BASE_ENDPOINT + POLICY_ROUTINE + "enforce/" + DEVICE_DETAIL_ID + "/devices/");
    }

    public static Response postEnforcePolicyUser(EnforcePolicyOnUser enforcePolicyOnUser) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(enforcePolicyOnUser)
                .when()
                .post(BASE_ENDPOINT + POLICY_ROUTINE + "enforce/" + USER_ID + "/users/");
    }

    public static Response postAdLogin(AdLogin adLogin) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(adLogin)
                .when()
                .post(BASE_ENDPOINT + AD_LOGIN);
    }

    public static Response deleteUserNote() {
        return given()
                .header("Authorization", "Bearer" + token)
                .when()
                .delete(BASE_ENDPOINT + USER_ENDPOINT + DELETE_NOTE + USER_ID);

    }

    public static Response postPolicyRoutine(PolicyRoutine policyRoutine) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(policyRoutine)
                .when()
                .post(BASE_ENDPOINT + POLICY_ROUTINE);
    }


    public static Response deletePolicyRoutine() {
        return given()
                .header("Authorization", "Bearer" + token)
                .when()
                .delete(BASE_ENDPOINT + POLICY_ROUTINE + "?ids=" + PR_ID);

    }

    public static Response postCreateRole(Role role) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(role)
                .when()
                .post(BASE_ENDPOINT + ROLE_ENDPOINT + CREATE_ROLE);

    }


    public static Response updateRole(Role role) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(role)
                .when()
                .put(BASE_ENDPOINT + ROLE_ENDPOINT + UPDATE_ROLE + ROLE_ID);

    }


}
