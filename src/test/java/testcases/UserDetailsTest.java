package testcases;

import api.UserApis;
import io.restassured.response.Response;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;

import models.users.UserNote;
import models.users.UserTag;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseClass;

import java.io.IOException;
import java.util.Collections;

import static junit.framework.TestCase.assertEquals;

@RunWith(SerenityRunner.class)
public class UserDetailsTest extends BaseClass {

    public static final String USER_ENDPOINT = "/users/";
    public static final String DELETE_SINGLE_TAG = "deleteSingleTag/?userId=";
    public static final String DELETE_BULK_TAG = "deleteBulkTag";
    public static final String DELETE_NOTE = "deleteNote?userId=";
    public static final String SINGLE_TAG_NAME = "Automation_Tag_Number_4536";



    @Test
    public void GetAllUsers(){
        Response response = UserApis.getAllUsers();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetUserByID(){
        Response response = UserApis.getUserByID();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetUserAdaptersList(){
        Response response = UserApis.getUserAdaptersList();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetAllUserTags(){
        Response response = UserApis.getAllUserTags();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetUserTagById(){
        Response response = UserApis.getUserTagById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetUserNoteById(){
        Response response = UserApis.getUserNoteById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void PostInsertUserTag(){
        UserTag userTag = new UserTag("Automation_User_Tag_Number_"+value+"1", Collections.singletonList(USER_ID));
        Response response = UserApis.postInsertUserTag(userTag);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void PostInsertUserNote()throws IOException {
        UserNote userNote = new UserNote("Automation_Notes_#_"+value+"", ""+ USER_ID);

        Response response = UserApis.postInsertUserNote(userNote);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);


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
        Response response = UserApis.deleteUserNote();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetUsersAdapterData(){

        Response response = UserApis.getUsersAdapterData();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }
    @Test
    public void GetGeneralDetails(){
        Response response = UserApis.getGeneralDetails();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

}
