package testcases;

import api.Users;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.http.HttpStatus;
import models.users.UserNote;
import models.users.UserTag;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import utils.BaseTest;

import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDetailsTest extends BaseTest {

    public static boolean isPreviousTestPass;

    @Test
    @Title("Get Discovered User List")
    public void getAllUsers() {
        Response response = Users.getAllUsers();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data.content[0]._id", equalTo(USER_ID), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Discovered User Detail By  Id")
    public void getUserByID() {
        Response response = Users.getUserByID();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data._id", equalTo(USER_ID), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Discovered User Connector List")
    public void getUserConnectorsList() {
        Response response = Users.getUserConnectorsList();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Discovered User Tags")
    public void getAllUserTags() {
        Response response = Users.getAllUserTags();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Post Insert Tag on  Discovered User")
    public void testA_postInsertUserTag() {
        isPreviousTestPass = false;
        UserTag userTag = new UserTag("Automation_User_Tag_Number_" + value + "1", Collections.singletonList(USER_ID));
        Response response = Users.postInsertUserTag(userTag);
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Discovered User Tags By Id")
    public void testB_getUserTagById() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = Users.getUserTagById();
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data.tags[0]", equalTo("Automation_User_Tag_Number_" + value + "1"), "meta.status", equalTo("success"));
    }

    @Test // Not throw exception if tag name not exist.
    @Title("Delete Single Tag of Discovered User")
    public void testC_deleteUserSingleTag() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = Users.deleteUserSingleTag();
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Delete Bulk Tags of Discovered User")
    public void testD_deleteUserBukTag() {
        UserTag deleteUserTag = new UserTag(Collections.singletonList(USER_ID));
        Response response = Users.deleteBulkUserTags(deleteUserTag);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Post Insert Note on  Discovered User")
    public void testE_postInsertUserNote() {
        isPreviousTestPass = false;
        UserNote userNote = new UserNote("Automation_Notes_#_" + value + "2", "" + USER_ID);
        Response response = Users.postInsertUserNote(userNote);
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Discovered User Note By Id")
    public void testF_getUserNoteById() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = Users.getUserNoteById();
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data.note", equalTo("Automation_Notes_#_" + value + "2"), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Delete Note of Discovered User")
    public void testG_deleteUserNote() {
        Response response = Users.deleteUserNote();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Users Connector Data of Discovered User")
    public void getUsersConnectorData() {
        Response response = Users.getUsersConnectorData();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get General Details By Id of Discovered User")
    public void getGeneralDetails() {
        Response response = Users.getGeneralDetails();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data._id", equalTo(USER_ID), "meta.status", equalTo("success"));
    }

}
