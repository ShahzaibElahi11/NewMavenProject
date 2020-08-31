package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.devices.DeviceNotes;
import models.devices.DeviceTag;
import utils.BaseTest;

import static io.restassured.RestAssured.given;

public class Devices extends BaseTest {

    public static final String DEVICE_ENDPOINT = "/devices/";
    public static final String DEVICE_ALL_TAGS = "tags/";
    public static final String LOAD_BALANCER_RULE = "loadbalancer-rules?_id=";

    public static final String DEVICE_HARDWARE = "hardware/connected?_id=";
    public static final String USER_FOR_DEVICE = "users?_id=";


    public static Response getAllDevices() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/devices/getAllDevices?page=0&size=10");
    }

    public static Response getDevicesDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/devices/deviceDetail?_id=" + DEVICE_DETAIL_ID);
    }

    public static Response getDeviceConnectorsListById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/devices/adapters/list?_id=" + DEVICE_DETAIL_ID);
    }

    public static Response getDrivesDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/devices/drives?_id=" + DEVICE_DETAIL_ID);
    }

    public static Response getOSPatchesDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/devices/os/patches/installed?_id=" + DEVICE_DETAIL_ID);
    }

    public static Response getRunningProcessesDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/devices/processes/running?_id=" + DEVICE_DETAIL_ID);
    }

    public static Response getInstalledSoftwareDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/devices/software/installed?_id=" + DEVICE_DETAIL_ID);
    }

    public static Response getOSDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/devices/os/info?_id=" + DEVICE_DETAIL_ID);

    }

    public static Response getUserDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/devices/users?_id=" + DEVICE_DETAIL_ID);
    }

    public static Response getNetworkInterfacesDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/devices/network/interfaces?_id=" + DEVICE_DETAIL_ID);

    }

    public static Response getSharedFoldersDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/devices/shared/folders?_id=" + DEVICE_DETAIL_ID);

    }

    public static Response getDeviceNoteDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/devices/getDeviceNote?deviceId=" + DEVICE_DETAIL_ID);

    }

    public static Response getDeviceTagDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/devices/getDeviceTag?deviceId=" + DEVICE_DETAIL_ID);

    }

    public static Response getGeneralDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/devices/general?_id=" + DEVICE_DETAIL_ID);

    }

    public static Response getConnectorDetailsById() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + "/devices/adapter/data?_id=" + DEVICE_DETAIL_ID + "&adapter");

    }

    public static Response getAllTags() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + DEVICE_ALL_TAGS);

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
                .get(BASE_ENDPOINT_INVENTA + DEVICE_ENDPOINT + USER_FOR_DEVICE + DEVICE_DETAIL_ID);

    }

    public static Response postInsertDeviceNote(DeviceNotes deviceNotes) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(deviceNotes)
                .when()
                .post(BASE_ENDPOINT_INVENTA + "/devices/insertNote");

    }

    public static Response postInsertDeviceTag(DeviceTag deviceTag) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(deviceTag)
                .when()
                .post(BASE_ENDPOINT_INVENTA + "/devices/insertTag");

    }


}
