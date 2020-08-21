package testcases;

import api.Devices;
import io.restassured.response.Response;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
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
    @Title("Get All Device List")
    public void getAllDevices() {
        Response response = Devices.getAllDevices();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Device Details By Device ID")
    public void getDevicesDetailsById(){
        Response response = Devices.getDevicesDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }


    @Test
    @Title("Get Device with Adapters List By Device ID")
    public void getDeviceAdaptersList(){
        Response response = Devices.getDeviceAdaptersListById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Hard Drive Details By Device ID")
    public void getDrivesDetailsById(){
        Response response = Devices.getDrivesDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Operating System Patches Details By Device ID")
    public void getOSPatchesDetailsById(){
        Response response = Devices.getOSPatchesDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Running Processes Details By Device ID")
    public void getRunningProcessesDetailsById(){
        Response response = Devices.getRunningProcessesDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Installed Software Details By Device ID")
    public void getInstalledSoftwareDetailsById(){
        Response response = Devices.getInstalledSoftwareDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Installed Software Details By Device ID")
    public void getOSDetailsById(){
        Response response = Devices.getOSDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Device User Details By Device ID")
    public void getUserDetailsById(){
        Response response = Devices.getUserDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Network Interface Details By Device ID")
    public void getNetworkInterfacesDetailsById(){
        Response response = Devices.getNetworkInterfacesDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Shared Folders Details By Device ID")
    public void getSharedFoldersDetailsById(){
        Response response = Devices.getSharedFoldersDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Device Note By Device ID")
    public void getDeviceNoteDetailsById(){
        Response response = Devices.getDeviceNoteDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Device Tags By Device ID")
    public void getDeviceTagDetailsById(){
        Response response = Devices.getDeviceTagDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test //extra
    @Title("Get General Details By Device ID")
    public void getGeneralDetailsById(){
        Response response = Devices.getGeneralDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Adapter Details By Device ID")
    public void geAdapterDetailsById() throws IOException {
        Response response = Devices.getAdapterDetailsById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Post Insert Tags on Device")
    public void postInsertDeviceTag(){
        DeviceTag deviceTag = new DeviceTag("Automation_Device_Tag_Number_"+value+"1", Collections.singletonList(DEVICE_DETAIL_ID));
        Response response = Devices.postInsertDeviceTag(deviceTag);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Post Insert Note on Device")
    public void postInsertDeviceNote() {
        DeviceNotes deviceNotes = new DeviceNotes("Automation_Notes_#_"+value+"", ""+DEVICE_DETAIL_ID);
        Response response = Devices.postInsertDeviceNote(deviceNotes);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    /**
     * insert new
     */
    @Test
    @Title("Get All Devices Tags")
    public void getAllTags(){
        Response response = Devices.getAllTags();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Load Balancer Rules Details By Device ID")
    public void getLoadBalancerRulesForDevice(){
        Response response = Devices.getLoadBalancerRulesForDevice();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Ignore
    @Test // Not throw exception if tag name not exist.
    public void deleteDeviceSingleTag() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DELETE_SINGLE_TAG + DEVICE_DETAIL_ID +"&tag="+ SINGLE_TAG_NAME)  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        //assertEquals(actualStatus, 200);
        //Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Ignore
    @Test // issue - not complete. also postman issue
    public void deleteDeviceBukTag() throws IOException {

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
    public void deleteDeviceNote() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DELETE_NOTE + DEVICE_DETAIL_ID )  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        //assertEquals(actualStatus, 200);
        //Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Ignore
    @Test // Not throw exception if note does not exist.
    public void deleteDiscoveredDevice() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DELETE_DEVICE + DELETE_DEVICE_ID ) ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        //assertEquals(actualStatus, 200);
        //Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Hardware Details By Device ID")
    public void getConnectedHardwareForDevice() {
        Response response = Devices.getConnectedHardwareForDevice();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get User for Device Details By Device ID")
    public void getUsersForDevice(){

        Response response = Devices.getUsersForDevice();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

}
