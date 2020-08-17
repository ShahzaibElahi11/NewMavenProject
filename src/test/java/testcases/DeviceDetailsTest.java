package testcases;

import api.DeviceApis;
import io.restassured.response.Response;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import models.devices.DeviceNotes;
import models.devices.DeviceTag;
import org.junit.runner.RunWith;
import utils.BaseClass;

import java.io.IOException;
import java.util.Collections;

@RunWith(SerenityRunner.class)
public class DeviceDetailsTest extends BaseClass {


    public static final String DEVICE_ENDPOINT = "/devices/";
    public static final String DELETE_SINGLE_TAG = "deleteSingleTag?deviceId=";
    public static final String DELETE_BULK_TAG = "deleteBulkTag";
    public static final String  DELETE_NOTE = "deleteNote?deviceId=";
    public static final String SINGLE_TAG_NAME = "Automation_Tag_Number_482";
    public static final String DELETE_DEVICE = "removeDiscoveredDevice?_id=";
    //re-think
    public static final String DELETE_DEVICE_ID = "5f0d7cd312e1364a117ce134";


    @Test
    public void GetAllDevices() {
        Response response = DeviceApis.getAllDevices();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetDevicesDetailsById(){
        Response response = DeviceApis.getDevicesDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }


    @Test
    public void GetDeviceAdaptersList(){

        Response response = DeviceApis.getDeviceAdaptersListById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetDrivesDetailsById(){

        Response response = DeviceApis.getDrivesDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetOSPatchesDetailsById(){
        Response response = DeviceApis.getOSPatchesDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetRunningProcessesDetailsById(){
        Response response = DeviceApis.getRunningProcessesDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetInstalledSoftwareDetailsById(){
        Response response = DeviceApis.getInstalledSoftwareDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetOSDetailsById(){
        Response response = DeviceApis.getOSDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetUserDetailsById(){
        Response response = DeviceApis.getUserDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetNetworkInterfacesDetailsById(){
        Response response = DeviceApis.getNetworkInterfacesDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetSharedFoldersDetailsById(){
        Response response = DeviceApis.getSharedFoldersDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetDeviceNoteDetailsById(){
        Response response = DeviceApis.getDeviceNoteDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetDeviceTagDetailsById(){
        Response response = DeviceApis.getDeviceTagDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test //extra
    public void GetGeneralDetailsById(){
        Response response = DeviceApis.getGeneralDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GeAdapterDetailsById() throws IOException {
        Response response = DeviceApis.getAdapterDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void PostInsertDeviceTag(){
        DeviceTag deviceTag = new DeviceTag("Automation_Device_Tag_Number_"+value+"1", Collections.singletonList(DEVICE_DETAIL_ID));
        Response response = DeviceApis.postInsertDeviceTag(deviceTag);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void PostInsertDeviceNote() {
        DeviceNotes deviceNotes = new DeviceNotes("Automation_Notes_#_"+value+"", ""+DEVICE_DETAIL_ID);
        Response response = DeviceApis.postInsertDeviceNote(deviceNotes);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    /**
     * insert new
     */
    @Test
    public void GetAllTags(){

        Response response = DeviceApis.getAllTags();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetLoadBalancerRulesForDevice(){
        Response response = DeviceApis.getLoadBalancerRulesForDevice();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Ignore
    @Test // Not throw exception if tag name not exist.
    public void DeleteDeviceSingleTag() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DELETE_SINGLE_TAG + DEVICE_DETAIL_ID +"&tag="+ SINGLE_TAG_NAME)  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        //assertEquals(actualStatus, 200);
        //Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Ignore
    @Test // issue - not complete. also postman issue
    public void DeleteDeviceBukTag() throws IOException {

        HttpDelete request = new HttpDelete(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DELETE_BULK_TAG) ;
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{ \"userIds\": [\"5ef29cb2c454b418263ff7b5\"] }";

        //request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);


        int actualStatus = response.getStatusLine().getStatusCode();
        //assertEquals(actualStatus, 200);
        //Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }
    @Ignore
    @Test // Not throw exception if note does not exist.
    public void DeleteDeviceNote() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DELETE_NOTE + DEVICE_DETAIL_ID )  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        //assertEquals(actualStatus, 200);
        //Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Ignore
    @Test // Not throw exception if note does not exist.
    public void DeleteDiscoveredDevice() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DELETE_DEVICE + DELETE_DEVICE_ID ) ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        //assertEquals(actualStatus, 200);
        //Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetConnectedHardwareForDevice() {
        Response response = DeviceApis.getConnectedHardwareForDevice();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetUsersForDevice(){

        Response response = DeviceApis.getUsersForDevice();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

}
