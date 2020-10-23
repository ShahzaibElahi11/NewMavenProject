package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.devices.DeviceNotes;
import models.devices.DeviceTag;
import utils.BaseAPI;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

public class Devices extends BaseAPI {


    public static Response getAllDevices() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT+ GET_ALL_DEVICES);
    }

    public static Response getDevicesDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DEVICES_DETAILS + DEVICE_DETAIL_ID);
    }

    public static Response getDeviceConnectorsListById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + CONNECTOR_LIST_BY_ID + DEVICE_DETAIL_ID);
    }

    public static Response getDrivesDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DRIVE_DETAILS + DEVICE_DETAIL_ID);
    }

    public static Response getOSPatchesDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT+ OS_PATCHES + DEVICE_DETAIL_ID);
    }

    public static Response getRunningProcessesDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + RUNNING_PROCESSES + DEVICE_DETAIL_ID);
    }

    public static Response getInstalledSoftwareDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + INSTALLED_SOFTWARE + DEVICE_DETAIL_ID);
    }

    public static Response getOSDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + OS_INFO + DEVICE_DETAIL_ID);

    }

    public static Response getUserDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + USER_DETAILS_BY_ID + DEVICE_DETAIL_ID);
    }

    public static Response getNetworkInterfacesDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + NETWORK_INTERFACE + DEVICE_DETAIL_ID);

    }

    public static Response getSharedFoldersDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + SHARED_FOLDER + DEVICE_DETAIL_ID);

    }

    public static Response getDeviceNoteDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT+ DEVICE_NOTE + DEVICE_DETAIL_ID);

    }

    public static Response getDeviceTagDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DEVICE_TAG + DEVICE_DETAIL_ID);

    }

    public static Response getGeneralDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + GENERAL_DETAILS + DEVICE_DETAIL_ID);

    }

    public static Response getConnectorDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + CONNECTOR_DATA + DEVICE_DETAIL_ID + "&adapter");

    }

    public static Response getAllTags() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + ALL_TAGS);

    }

    public static Response getLoadBalancerRulesForDevice() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + LOAD_BALANCER_RULE + DEVICE_DETAIL_ID);

    }

    public static Response getConnectedHardwareForDevice() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DEVICE_HARDWARE + DEVICE_DETAIL_ID);

    }

    public static Response getUsersForDevice() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + USER_DETAILS_BY_ID + DEVICE_DETAIL_ID);

    }

    public static Response postInsertDeviceNote(DeviceNotes deviceNotes) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(deviceNotes)
                .when()
                .post(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT+ INSERT_NOTE + "?deviceId=" + DEVICE_DETAIL_ID);

    }

    public static Response postInsertDeviceTag(DeviceTag deviceTag) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(deviceTag)
                .when()
                .post(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + INSERT_TAG);

    }


}
