package testcases;

import api.Apis;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import models.UserNote;
import models.UserTag;
import utils.BaseClass;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class TestUserDetails extends BaseClass {
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
    //public static final String USER_ID = "5f0e4c3e229fd5347635af9d";

    public static final String USER_ADAPTER_DATA = "adapter/data?_id=";
    public static final String USER_GENERAL_DETAILS = "general?_id=";



    @Test
    public void GetAllUsers() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + USER_ENDPOINT + ALL_USERS + PAGINATION);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetUserByID() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + USER_ENDPOINT + USER_DETAIL + USER_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetUserAdaptersList() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + USER_ENDPOINT + USER_ADAPTER_lIST + USER_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetAllUserTags() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + USER_ENDPOINT + ALL_USER_TAGS);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetUserTagById() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + USER_ENDPOINT + USER_TAG + USER_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetUserNoteById() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + USER_ENDPOINT + USER_NOTE + USER_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void PostInsertUserTag()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + USER_ENDPOINT + INSERT_TAG);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);
        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{ \"tag\":\"Automation_Tag_Number_"+value+"\", \"userIds\":[\""+USER_ID+"\"]}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void PostInsertUserTagNew(){
        UserTag userTag = new UserTag("Automation_User_Tag_Number_"+value+"1", Collections.singletonList(USER_ID));
        Response response = Apis.postInsertUserTag(userTag);
        assertThat(response.getStatusCode(), equalTo(200));

    }
    @Test
    public void PostInsertUserNote()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + USER_ENDPOINT + INSERT_NOTE);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);
        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{\"note\":\"Automation_Testing_Note_Number_"+value+"\" , \"userId\":\""+USER_ID+"\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void PostInsertUserNoteNew()throws IOException {
        UserNote userNote = new UserNote("Automation_Notes_#_"+value+"", ""+ USER_ID);

        Response response = Apis.postInsertUserNote(userNote);
        assertThat(response.getStatusCode(), equalTo(200));


    }

    @Test(enabled = false)  // Not throw exception if tag name not exist.
    public void DeleteUserSingleTag() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT + USER_ENDPOINT + DELETE_SINGLE_TAG + USER_ID +"&tag="+ SINGLE_TAG_NAME)  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test(enabled = false) // issue - not complete.
    public void DeleteUserBukTag() throws IOException {

        HttpDelete request = new HttpDelete(BASE_ENDPOINT + USER_ENDPOINT + DELETE_BULK_TAG) ;
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{ \"userIds\": [\"5ef29cb2c454b418263ff7b5\"] }";

        //request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);


        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test(enabled = false) // Not throw exception if note does not exist.
    public void DeleteUserNote() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT + USER_ENDPOINT + DELETE_NOTE + USER_ID )  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }
    @Test(enabled = false)
    public void DeleteUserNoteNew() throws IOException {
        Response deleteResponse = Apis.deleteUserNote();
        assertThat(deleteResponse.getStatusCode(), equalTo(200));

    }

    /**
     * new
     */

    @Test
    public void GetUsersAdapterData() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + USER_ENDPOINT + USER_ADAPTER_DATA + USER_ID+ "&adapter");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }
    @Test
    public void GetGeneralDetails() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + USER_ENDPOINT + USER_GENERAL_DETAILS + USER_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

}
