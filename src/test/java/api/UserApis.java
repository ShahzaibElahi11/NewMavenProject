package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.users.UserNote;
import models.users.UserTag;
import utils.BaseClass;

import static io.restassured.RestAssured.given;

public class UserApis extends BaseClass {
    public static final String USER_ENDPOINT = "/users/";
    public static final String PAGINATION = "?page=0&size=100";
    public static final String ALL_USERS = "getAllUsers";
    public static final String USER_DETAIL = "userDetail?_id=";
    public static final String USER_ADAPTER_lIST = "adapters/list?_id=";
    public static final String ALL_USER_TAGS = "tags/";
    public static final String USER_TAG = "getUserTag?userId=";
    public static final String USER_NOTE = "getUserNote?userId=";

    public static final String INSERT_NOTE = "insertNote";
    public static final String INSERT_TAG = "insertTag";
    public static final String DELETE_SINGLE_TAG = "deleteSingleTag/?userId=";
    public static final String DELETE_BULK_TAG = "deleteBulkTag";

    public static final String DELETE_NOTE = "deleteNote?userId=";

    public static final String SINGLE_TAG_NAME = "Automation_Tag_Number_4536";

    public static final String USER_ADAPTER_DATA = "adapter/data?_id=";
    public static final String USER_GENERAL_DETAILS = "general?_id=";


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

    public static Response getUserAdaptersList() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + USER_ADAPTER_lIST + USER_ID);
    }

    public static Response getAllUserTags() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + ALL_USERS + PAGINATION);
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

    public static Response getUsersAdapterData() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + USER_ADAPTER_DATA + USER_ID+ "&adapter");
    }

    public static Response getGeneralDetails() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + USER_GENERAL_DETAILS + USER_ID);
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





}
