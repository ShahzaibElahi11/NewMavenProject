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

import static org.hamcrest.Matchers.equalTo;

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
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data.content[0]._id", equalTo(DEVICE_DETAIL_ID), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Device Details By Device Id")
    public void getDevicesDetailsById(){
        Response response = Devices.getDevicesDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data._id", equalTo(DEVICE_DETAIL_ID), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Device with Adapters List By Device Id")
    public void getDeviceAdaptersList(){
        Response response = Devices.getDeviceAdaptersListById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Hard Drive Details By Device Id")
    public void getDrivesDetailsById(){
        Response response = Devices.getDrivesDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Operating System Patches Details By Device Id")
    public void getOSPatchesDetailsById(){
        Response response = Devices.getOSPatchesDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Running Processes Details By Device Id")
    public void getRunningProcessesDetailsById(){
        Response response = Devices.getRunningProcessesDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Installed Software Details By Device Id")
    public void getInstalledSoftwareDetailsById(){
        Response response = Devices.getInstalledSoftwareDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Installed Software Details By Device Id")
    public void getOSDetailsById(){
        Response response = Devices.getOSDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Device User Details By Device Id")
    public void getUserDetailsById(){
        Response response = Devices.getUserDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Network Interface Details By Device Id")
    public void getNetworkInterfacesDetailsById(){
        Response response = Devices.getNetworkInterfacesDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Shared Folders Details By Device Id")
    public void getSharedFoldersDetailsById(){
        Response response = Devices.getSharedFoldersDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Device Note By Device Id")
    public void getDeviceNoteDetailsById(){
        Response response = Devices.getDeviceNoteDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Device Tags By Device Id")
    public void getDeviceTagDetailsById(){
        Response response = Devices.getDeviceTagDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test //extra
    @Title("Get General Details By Device Id")
    public void getGeneralDetailsById(){
        Response response = Devices.getGeneralDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                 .body("data._id", equalTo(DEVICE_DETAIL_ID), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Adapter Details By Device Id")
    public void getAdapterDetailsById(){
        Response response = Devices.getAdapterDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
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
    @Title("Get All Device Tags")
    public void getAllTags(){
        Response response = Devices.getAllTags();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Load Balancer Rules Details By Device Id")
    public void getLoadBalancerRulesForDevice(){
        Response response = Devices.getLoadBalancerRulesForDevice();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Ignore
    @Test // Not throw exception if tag name not exist.
    @Title("Delete Device Single Tag")
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
    @Title("Delete Device Bulk Tag")
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
    @Title("Delete Device Note Tag")
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
    @Title("Delete Discovered Devices")
    public void deleteDiscoveredDevice() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DELETE_DEVICE + DELETE_DEVICE_ID ) ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        //assertEquals(actualStatus, 200);
        //Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Hardware Details By Device Id")
    public void getConnectedHardwareForDevice() {
        Response response = Devices.getConnectedHardwareForDevice();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get User for Device Details By Device Id")
    public void getUsersForDevice(){

        Response response = Devices.getUsersForDevice();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

}
