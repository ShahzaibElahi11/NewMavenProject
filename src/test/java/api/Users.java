package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.users.UserNote;
import models.users.UserTag;
import utils.BaseAPI;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

public class Users extends BaseAPI {

    public static final String SINGLE_TAG_NAME = "Automation_User_Tag_Number_" + value + "1";


    public static Response getAllUsers() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + ALL_USERS + PAGINATION);
    }

    public static Response getUserByID() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + USER_DETAIL + USER_ID);
    }

    public static Response getUserConnectorsList() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + CONNECTOR_LIST_BY_ID + USER_ID);
    }

    public static Response getAllUserTags() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + ALL_TAGS);
    }

    public static Response getUserTagById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + USER_TAG + USER_ID);
    }

    public static Response getUserNoteById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + USER_NOTE + USER_ID);
    }

    public static Response getUsersConnectorData() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + CONNECTOR_DATA + USER_ID + "&adapter");
    }

    public static Response getGeneralDetails() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + GENERAL_DETAILS + USER_ID);
    }

    public static Response postInsertUserNote(UserNote userNote) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(userNote)
                .when()
                .post(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + INSERT_NOTE);

    }

    public static Response postInsertUserTag(UserTag userTag) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(userTag)
                .when()
                .post(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + INSERT_TAG);

    }

    public static Response deleteUserNote() {
        return given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + DELETE_NOTE + USER_ID);

    }

    public static Response deleteUserSingleTag() {
        return given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + DELETE_SINGLE_TAG + USER_ID + "&tag=" + SINGLE_TAG_NAME);

    }


    public static Response deleteBulkUserTags(UserTag deleteUserTag) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(deleteUserTag)
                .when()
                .delete(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + DELETE_BULK_TAG);


    }
}
