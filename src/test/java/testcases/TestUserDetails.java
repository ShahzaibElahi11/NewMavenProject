package testcases;

import api.UserApis;
import io.restassured.response.Response;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;

import models.users.UserNote;
import models.users.UserTag;
import org.junit.Ignore;
import org.junit.Test;
import utils.BaseClass;

import java.io.IOException;
import java.util.Collections;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestUserDetails extends BaseClass {

    public static final String USER_ENDPOINT = "/users/";
    public static final String DELETE_SINGLE_TAG = "deleteSingleTag/?userId=";
    public static final String DELETE_BULK_TAG = "deleteBulkTag";
    public static final String DELETE_NOTE = "deleteNote?userId=";
    public static final String SINGLE_TAG_NAME = "Automation_Tag_Number_4536";



    @Test
    public void GetAllUsers(){
        Response response = UserApis.getAllUsers();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }

    @Test
    public void GetUserByID(){
        Response response = UserApis.getUserByID();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetUserAdaptersList(){
        Response response = UserApis.getUserAdaptersList();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetAllUserTags(){
        Response response = UserApis.getAllUserTags();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetUserTagById(){
        Response response = UserApis.getUserTagById();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetUserNoteById(){
        Response response = UserApis.getUserNoteById();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void PostInsertUserTagNew(){
        UserTag userTag = new UserTag("Automation_User_Tag_Number_"+value+"1", Collections.singletonList(USER_ID));
        Response response = UserApis.postInsertUserTag(userTag);
        assertThat(response.getStatusCode(), equalTo(200));

    }

    @Test
    public void PostInsertUserNoteNew()throws IOException {
        UserNote userNote = new UserNote("Automation_Notes_#_"+value+"", ""+ USER_ID);

        Response response = UserApis.postInsertUserNote(userNote);
        assertThat(response.getStatusCode(), equalTo(200));


    }
    @Ignore
    @Test // Not throw exception if tag name not exist.
    public void DeleteUserSingleTag() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + DELETE_SINGLE_TAG + USER_ID +"&tag="+ SINGLE_TAG_NAME)  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }
    @Ignore
    @Test// issue - not complete.
    public void DeleteUserBukTag() throws IOException {

        HttpDelete request = new HttpDelete(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + DELETE_BULK_TAG) ;
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{ \"userIds\": [\"5ef29cb2c454b418263ff7b5\"] }";

        //request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);


        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Ignore
    @Test // Not throw exception if note does not exist.
    public void DeleteUserNote() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT_INVENTA + USER_ENDPOINT + DELETE_NOTE + USER_ID )  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }
    @Ignore
    @Test
    public void DeleteUserNoteNew(){
        Response deleteResponse = UserApis.deleteUserNote();
        assertThat(deleteResponse.getStatusCode(), equalTo(200));

    }

    @Test
    public void GetUsersAdapterData(){

        Response response = UserApis.getUsersAdapterData();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }
    @Test
    public void GetGeneralDetails(){
        Response response = UserApis.getGeneralDetails();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }

}
