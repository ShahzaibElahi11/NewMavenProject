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
import models.DeviceNotes;
import models.DeviceTag;
import utils.BaseClass;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.apache.commons.codec.binary.Base64.encodeBase64;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class TestDeviceDetail extends BaseClass {


    public static final String DEVICE_ENDPOINT = "/devices/";
    public static final String DEVICE_ALL_TAGS = "tags/";
    public static final String LOAD_BALANCER_RULE = "loadbalancer-rules?_id=";

    public static final String DELETE_SINGLE_TAG = "deleteSingleTag?deviceId=";
    public static final String DELETE_BULK_TAG = "deleteBulkTag";

    public static final String  DELETE_NOTE = "deleteNote?deviceId=";

    public static final String SINGLE_TAG_NAME = "Automation_Tag_Number_482";
    public static final String DELETE_DEVICE = "removeDiscoveredDevice?_id=";
    //re-think
    public static final String DELETE_DEVICE_ID = "5f0d7cd312e1364a117ce134";
    public static final String DEVICE_HARDWARE = "hardware/connected?_id=";
    public static final String USER_FOR_DEVICE = "users?_id=";


    @Test
    public void GetAllDevices() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/devices/getAllDevices?page=0&size=100");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test(enabled = false)
    public void GetAllDevices1() throws IOException {
        Response response = given()
                .contentType(io.restassured.http.ContentType.JSON)
                .header("Authorization","Bearer" + token )
                .when()
                .get(BASE_ENDPOINT + "/devices/getAllDevices?page=0&size=20");
        assertThat(response.getStatusCode(),equalTo(200));
    }

    @Test
    public void GetDevicesDetailsByID() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/devices/deviceDetail?_id=" + DEVICE_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetDeviceAdaptersList() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/devices/adapters/list?_id=" + DEVICE_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetDrivesDetailsById() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/devices/drives?_id=" + DEVICE_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetOSPatchesDetailsById() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/devices/os/patches/installed?_id=" + DEVICE_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetRunningProcessesDetailsById() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/devices/processes/running?_id=" + DEVICE_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetInstalledSoftwareDetailsById() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/devices/software/installed?_id=" + DEVICE_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetOSDetailsById() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/devices/os/info?_id=" + DEVICE_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetUserDetailsById() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/devices/users?_id=" + DEVICE_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetNetworkInterfacesDetailsById() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/devices/network/interfaces?_id=" + DEVICE_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetSharedFoldersDetailsById() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/devices/shared/folders?_id=" + DEVICE_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetDeviceNoteDetailsById() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/devices/getDeviceNote?deviceId=" + DEVICE_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetDeviceTagDetailsById() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/devices/getDeviceTag?deviceId=" + DEVICE_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test //extra
    public void GetGeneralDetailsById() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/devices/general?_id=" + DEVICE_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GeAdapterDetailsById() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/devices/adapter/data?_id=" + DEVICE_DETAIL_ID + "&adapter");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void PostInsertDeviceTag()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + "/devices/insertTag");

        String auth = new String();
        byte[] encodedAuth = encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{ \"tag\":\"Automation_Tag_Number_"+value+"\", \"deviceIds\":[\""+DEVICE_DETAIL_ID+"\"]}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void PostInsertDeviceTagNew(){

        DeviceTag deviceTag = new DeviceTag("Automation_Device_Tag_Number_"+value+"1", Collections.singletonList(DEVICE_DETAIL_ID));

        Response response = Apis.postInsertDeviceTag(deviceTag);
        assertThat(response.getStatusCode(), equalTo(200));


    }

    @Test
    public void PostInsertNote()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + "/devices/insertNote");

        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{ \"note\":\"Automation_Note_Number_" + value + "\", \"deviceId\":\""+DEVICE_DETAIL_ID+"\"}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);

    }

    @Test
    public void PostInsertDeviceNoteNew() {

        DeviceNotes deviceNotes = new DeviceNotes("Automation_Notes_#_"+value+"", ""+DEVICE_DETAIL_ID);

        Response response = Apis.postInsertDeviceNote(deviceNotes);
        assertThat(response.getStatusCode(), equalTo(200));
    }

    /**
     * insert new
     */
    @Test
    public void GetAllTags() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + DEVICE_ENDPOINT + DEVICE_ALL_TAGS);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetLoadBalancerRulesForDevice() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + DEVICE_ENDPOINT + LOAD_BALANCER_RULE + DEVICE_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }


    @Test // Not throw exception if tag name not exist.
    public void DeleteDeviceSingleTag() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT + DEVICE_ENDPOINT + DELETE_SINGLE_TAG + DEVICE_DETAIL_ID +"&tag="+ SINGLE_TAG_NAME)  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test(enabled = false) // issue - not complete. also postman issue
    public void DeleteDeviceBukTag() throws IOException {

        HttpDelete request = new HttpDelete(BASE_ENDPOINT + DEVICE_ENDPOINT + DELETE_BULK_TAG) ;
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{ \"userIds\": [\"5ef29cb2c454b418263ff7b5\"] }";

        //request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);


        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test // Not throw exception if note does not exist.
    public void DeleteDeviceNote() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT + DEVICE_ENDPOINT + DELETE_NOTE + DEVICE_DETAIL_ID )  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }


    @Test // Not throw exception if note does not exist.
    public void DeleteDiscoveredDevice() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT + DEVICE_ENDPOINT + DELETE_DEVICE + DELETE_DEVICE_ID ) ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetConnectedHardwareForDevice() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + DEVICE_ENDPOINT + DEVICE_HARDWARE + DEVICE_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetUsersForDevice() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + DEVICE_ENDPOINT + USER_FOR_DEVICE + DEVICE_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

}
