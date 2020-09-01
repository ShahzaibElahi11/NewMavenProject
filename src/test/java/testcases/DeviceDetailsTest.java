package testcases;

import api.Devices;
import io.restassured.response.Response;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import models.devices.DeviceNotes;
import models.devices.DeviceTag;
import org.junit.runner.RunWith;
import utils.BaseAPI;
import utils.BaseTest;

import java.io.IOException;
import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static utils.BaseAPI.getIdFromURL;

@RunWith(SerenityRunner.class)
public class DeviceDetailsTest extends BaseTest {

    public static String DEVICE_DETAIL_ID;

    static {
        try {
            DEVICE_DETAIL_ID = getIdFromURL("http://inventaserver:9092/devices/getAllDevices?page=0&size=1&sortBy=_id");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int value = BaseAPI.value;

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
    public void getDevicesDetailsById() {
        Response response = Devices.getDevicesDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data._id", equalTo(DEVICE_DETAIL_ID), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Device with Connectors List By Device Id")
    public void getDeviceConnectorsList() {
        Response response = Devices.getDeviceConnectorsListById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Hard Drive Details By Device Id")
    public void getDrivesDetailsById() {
        Response response = Devices.getDrivesDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Operating System Patches Details By Device Id")
    public void getOSPatchesDetailsById() {
        Response response = Devices.getOSPatchesDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Running Processes Details By Device Id")
    public void getRunningProcessesDetailsById() {
        Response response = Devices.getRunningProcessesDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Installed Software Details By Device Id")
    public void getInstalledSoftwareDetailsById() {
        Response response = Devices.getInstalledSoftwareDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Installed Software Details By Device Id")
    public void getOSDetailsById() {
        Response response = Devices.getOSDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Device User Details By Device Id")
    public void getUserDetailsById() {
        Response response = Devices.getUserDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Network Interface Details By Device Id")
    public void getNetworkInterfacesDetailsById() {
        Response response = Devices.getNetworkInterfacesDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Shared Folders Details By Device Id")
    public void getSharedFoldersDetailsById() {
        Response response = Devices.getSharedFoldersDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Device Note By Device Id")
    public void getDeviceNoteDetailsById() {
        Response response = Devices.getDeviceNoteDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Device Tags By Device Id")
    public void getDeviceTagDetailsById() {
        Response response = Devices.getDeviceTagDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test //extra
    @Title("Get General Details By Device Id")
    public void getGeneralDetailsById() {
        Response response = Devices.getGeneralDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data._id", equalTo(DEVICE_DETAIL_ID), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Connector Details By Device Id")
    public void getConnectorDetailsById() {
        Response response = Devices.getConnectorDetailsById();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Post Insert Tags on Device")
    public void postInsertDeviceTag() {
        DeviceTag deviceTag = new DeviceTag("Automation_Device_Tag_Number_" + value + "1", Collections.singletonList(DEVICE_DETAIL_ID));
        Response response = Devices.postInsertDeviceTag(deviceTag);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Post Insert Note on Device")
    public void postInsertDeviceNote() {
        DeviceNotes deviceNotes = new DeviceNotes("Automation_Notes_#_" + value + "", "" + DEVICE_DETAIL_ID);
        Response response = Devices.postInsertDeviceNote(deviceNotes);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    /**
     * insert new
     */
    @Test
    @Title("Get All Device Tags")
    public void getAllTags() {
        Response response = Devices.getAllTags();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Load Balancer Rules Details By Device Id")
    public void getLoadBalancerRulesForDevice() {
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
    public void deleteDeviceSingleTag() {
        //BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DELETE_SINGLE_TAG + DEVICE_DETAIL_ID +"&tag="+ SINGLE_TAG_NAME;


    }

    @Ignore
    @Test // issue - not complete. also postman issue
    @Title("Delete Device Bulk Tag")
    public void deleteDeviceBukTag() {
        //BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DELETE_BULK_TAG


    }

    @Ignore
    @Test // Not throw exception if note does not exist.
    @Title("Delete Device Note Tag")
    public void deleteDeviceNote() {
        //BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DELETE_NOTE + DEVICE_DETAIL_ID

    }

    @Ignore
    @Test // Not throw exception if note does not exist.
    @Title("Delete Discovered Devices")
    public void deleteDiscoveredDevice() throws IOException {
        //BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DELETE_DEVICE + DELETE_DEVICE_ID
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
    public void getUsersForDevice() {

        Response response = Devices.getUsersForDevice();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

}
