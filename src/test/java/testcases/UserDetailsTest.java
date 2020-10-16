package testcases;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import models.users.UserNote;
import models.users.UserTag;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import utils.BaseTest;

import java.io.IOException;
import java.util.Collections;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.apache.http.HttpStatus.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDetailsTest extends BaseTest {
    public static final String SINGLE_TAG_NAME = "Automation_User_Tag_Number_" + value + "1";
    public static boolean isPreviousTestPass;

    public static String USER_ID = "";
    static {
        try {
            USER_ID = getIdFromURL(GET_USER_ID);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        @Test
    @Title("Get Discovered User List")
    public void getAllUsers() {
        given().
                spec(requestSpec).
                when().
                get(USER_ENDPOINT + ALL_USERS + PAGINATION).
                then().
                spec(responseSpec).
                and().
                body("data.content[0]._id", equalTo(USER_ID));
    }

    @Test
    @Title("Get Discovered User Detail By  Id")
    public void getUserByID() {
        given().
                spec(requestSpec).
                when().
                get(USER_ENDPOINT + USER_DETAIL + USER_ID).
                then().
                spec(responseSpec).
                and().
                body("data._id", equalTo(USER_ID));
    }

    @Test
    @Title("Get Discovered User Connector List")
    public void getUserConnectorsList() {
        given().
                spec(requestSpec).
                when().
                get(USER_ENDPOINT + CONNECTOR_LIST_BY_ID + USER_ID).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Discovered User Tags")
    public void getAllUserTags() {
        given().
                spec(requestSpec).
                when().
                get(USER_ENDPOINT + ALL_TAGS).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Post Insert Tag on  Discovered User")
    public void testA_postInsertUserTag() {
        isPreviousTestPass = false;
        UserTag userTag = new UserTag("Automation_User_Tag_Number_" + value + "1", Collections.singletonList(USER_ID));
        Response response = given().
                spec(requestSpec).
                and().
                body(userTag).
                when().
                post(USER_ENDPOINT + INSERT_TAG);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                assertThat().
                statusCode(SC_OK);
    }

    @Test
    @Title("Get Discovered User Tags By Id")
    public void testB_getUserTagById() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = given().
                spec(requestSpec).
                when().
                get(USER_ENDPOINT + USER_TAG + USER_ID);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec).
                and()
                .body("data.tags[0]", equalTo("Automation_User_Tag_Number_" + value + "1"));
    }

    @Test // Not throw exception if tag name not exist.
    @Title("Delete Single Tag of Discovered User")
    public void testC_deleteUserSingleTag() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = given().
                spec(requestSpec).
                when().
                delete(USER_ENDPOINT + DELETE_USER_SINGLE_TAG + USER_ID + "&tag=" + SINGLE_TAG_NAME);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                assertThat().
                statusCode(SC_OK);

    }

    @Test
    @Title("Delete Bulk Tags of Discovered User")
    public void testD_deleteUserBukTag() {
        UserTag deleteUserTag = new UserTag(Collections.singletonList(USER_ID));
        given().
                spec(requestSpec).
                and().
                body(deleteUserTag).
                when().
                delete(USER_ENDPOINT + DELETE_BULK_TAG).
                then().
                spec(responseSpec).
                and().
                body("data.message", equalTo("Delete tag success"));

    }

    @Test
    @Title("Post Insert Note on  Discovered User")
    public void testE_postInsertUserNote() {
        isPreviousTestPass = false;
        UserNote userNote = new UserNote("Automation_Notes_#_" + value + "2", "" + USER_ID);
        Response response = given().
                spec(requestSpec).
                and().
                body(userNote).
                when().
                post(USER_ENDPOINT + INSERT_NOTE);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                assertThat().
                statusCode(SC_OK);

    }

    @Test
    @Title("Get Discovered User Note By Id")
    public void testF_getUserNoteById() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = given().
                spec(requestSpec).
                when().
                get(USER_ENDPOINT + USER_NOTE + USER_ID);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec).
                and()
                .body("data.note", equalTo("Automation_Notes_#_" + value + "2"));
    }

    @Test
    @Title("Delete Note of Discovered User")
    public void testG_deleteUserNote() {
        given().
                spec(requestSpec).
                when().
                delete(USER_ENDPOINT + DELETE_USER_NOTE + USER_ID).
                then().
                assertThat().
                statusCode(SC_OK);
    }

    @Test
    @Title("Get Users Connector Data of Discovered User")
    public void getUsersConnectorData() {
        given().
                spec(requestSpec).
                when().
                get(USER_ENDPOINT + CONNECTOR_DATA + USER_ID + "&adapter").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get General Details By Id of Discovered User")
    public void getGeneralDetails() {
        given().
                spec(requestSpec).
                when().
                get(USER_ENDPOINT + GENERAL_DETAILS + USER_ID).
                then().
                spec(responseSpec).
                and().
                body("data._id", equalTo(USER_ID));
    }

}
