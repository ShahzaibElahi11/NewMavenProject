package testcases;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Test;
import models.devices.DeviceNotes;
import models.devices.DeviceTag;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import utils.BaseTest;

import java.io.IOException;
import java.util.Collections;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeviceDetailsTest extends BaseTest {

    public static boolean isPreviousTestPass;
    public static final String SINGLE_TAG_NAME = "Automation_Device_Tag_Number_" + value + "1";

    //http://inventaserver:9092/devices/removeDiscoveredDevice?_id=5f891e11b2256b227f8677de

    public static String DEVICE_DETAIL_ID = "";

    // rethink
    static {
        try {
            DEVICE_DETAIL_ID = getIdFromURL("http://inventaserver:9092/devices/getAllDevices?page=0&size=1");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    @Title("Get All Device List")
    public void getAllDevices() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + GET_ALL_DEVICES).
                then().
                spec(responseSpec).
                and().
                body("data.content[0]._id", equalTo(DEVICE_DETAIL_ID));
    }

    @Test
    @Title("Get Device Details By Device Id")
    public void getDevicesDetailsById() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + DEVICES_DETAILS + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec).
                and().
                body("data._id", equalTo(DEVICE_DETAIL_ID));
    }

    @Test
    @Title("Get Device with Connectors List By Device Id")
    public void getDeviceConnectorsList() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + CONNECTOR_LIST_BY_ID + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get General Details By Device Id")
    public void getGeneralDetailsById() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + GENERAL_DETAILS + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec).
                and().
                body("data._id", equalTo(DEVICE_DETAIL_ID));
    }

    @Test
    @Title("Get Connector Details By Device Id")
    public void getConnectorDetailsById() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + CONNECTOR_DATA + DEVICE_DETAIL_ID + "&adapter").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Device Common Menu Details By Device Id")
    public void getCommonMenuDetailsById() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + DEVICE_COMMON_MENU + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Post Insert Tags on Device")
    public void testA_postInsertDeviceTag() {
        isPreviousTestPass = false;

        DeviceTag deviceTag = new DeviceTag("Automation_Device_Tag_Number_" + value + "1", Collections.singletonList(DEVICE_DETAIL_ID));
        Response response = given().
                spec(requestSpec).
                and().
                body(deviceTag).
                when().
                post(DEVICE_ENDPOINT + INSERT_TAG);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                assertThat().
                statusCode(SC_OK);
    }

    @Test
    @Title("Get All Device Tags")
    public void testB_getAllTags() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ALL_TAGS).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get Device Tags By Device Id")
    public void testC_getDeviceTagDetailsById() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + DEVICE_TAG + DEVICE_DETAIL_ID);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec).
                and()
                .body("data.tags[0]", equalTo("Automation_Device_Tag_Number_" + value + "1"));
    }


    @Test // Not throw exception if tag name not exist.
    @Title("Delete Device Single Tag")
    public void testD_deleteDeviceSingleTag() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = given().
                spec(requestSpec).
                when().
                delete(DEVICE_ENDPOINT + DELETE_DEVICE_SINGLE_TAG + DEVICE_DETAIL_ID + "&tag=" + SINGLE_TAG_NAME);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                assertThat().
                statusCode(SC_OK);
    }

    @Test // issue - not complete. also postman issue
    @Title("Delete Device Bulk Tag")
    public void testE_deleteDeviceBukTag() {
        DeviceTag deleteDeviceTag = new DeviceTag(Collections.singletonList(DEVICE_DETAIL_ID));
        given().
                spec(requestSpec).
                and().
                body(deleteDeviceTag).
                when().
                delete(DEVICE_ENDPOINT + DELETE_BULK_TAG).
                then().
                spec(responseSpec).
                and().
                body("data.message", equalTo("Delete tag success"));

    }

    @Test
    @Title("Post Insert Note on Device")
    public void testF_postInsertDeviceNote() {
        isPreviousTestPass = false;
        DeviceNotes deviceNotes = new DeviceNotes("Automation_Notes_#_" + value + "", "" + DEVICE_DETAIL_ID);
        Response response = given().
                spec(requestSpec).
                and().
                body(deviceNotes).
                when().
                post(DEVICE_ENDPOINT + INSERT_NOTE);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                assertThat().
                statusCode(SC_OK);
    }

    @Test
    @Title("Get Device Note By Device Id")
    public void testG_getDeviceNoteDetailsById() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + DEVICE_NOTE + DEVICE_DETAIL_ID);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec).
                and()
                .body("data.note", equalTo("Automation_Notes_#_" + value));
    }


    @Test
    @Title("Delete Device Note Tag")
    public void testH_deleteDeviceNote() {
        given().
                spec(requestSpec).
                when().
                delete(DEVICE_ENDPOINT + DELETE_DEVICE_NOTE + DEVICE_DETAIL_ID).
                then().
                assertThat().
                statusCode(SC_OK);
    }

    @Test
    @Title("Get Hardware Details By Device Id")
    public void getConnectedHardwareForDevice() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + DEVICE_HARDWARE + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec);
    }

    /**
     * Adapter Wise Test Cases
     */

    @Test
    @Title("Get CrowdStrike Incident Details By Device Id")
    public void getCrowdStrikeIncident() throws IOException {
        String crowdStrikeDeviceId;
        crowdStrikeDeviceId = getIdFromURL(CROWDSTRIKE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + CROWDSTRIKE_INCIDENTS + crowdStrikeDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get CrowdStrike Sensor Update Policy Details By Device Id")
    public void getCrowdStrikeSensorUpdatePolicy() throws IOException {
        String crowdStrikeDeviceId;
        crowdStrikeDeviceId = getIdFromURL(CROWDSTRIKE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + CROWDSTRIKE_SENSOR_UPDATE_POLICY + crowdStrikeDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get CrowdStrike Prevention Policies Details By Device Id")
    public void getCrowdStrikePreventionPolicies() throws IOException {
        String crowdStrikeDeviceId;
        crowdStrikeDeviceId = getIdFromURL(CROWDSTRIKE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + CROWDSTRIKE_PREVENTION_POLICIES + crowdStrikeDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Container Summary Details By Device Id")
    public void getAzureContainerSummaryDetails() throws IOException {
        String azureContainerDeviceId;
        azureContainerDeviceId = getIdFromURL(AZURE_CONTAINER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + azureContainerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Container Local User Details By Device Id")
    public void getAzureContainerUserDetails() throws IOException {
        String azureContainerDeviceId;
        azureContainerDeviceId = getIdFromURL(AZURE_CONTAINER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + LOCAL_USER_DETAIL + azureContainerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Container Protocol Details By Device Id")
    public void getAzureContainerProtocolDetails() throws IOException {
        String azureContainerDeviceId;
        azureContainerDeviceId = getIdFromURL(AZURE_CONTAINER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + CONTAINER_PROTOCOLS + azureContainerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Container Port Details By Device Id")
    public void getAzureContainerPortDetails() throws IOException {
        String azureContainerDeviceId;
        azureContainerDeviceId = getIdFromURL(AZURE_CONTAINER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + CONTAINER_PORTS + azureContainerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Container In-Depth Details By Device Id")
    public void getAzureContainerInDepthDetails() throws IOException {
        String azureContainerDeviceId;
        azureContainerDeviceId = getIdFromURL(AZURE_CONTAINER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + CONTAINER_INDEPTH + azureContainerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Container Asset Tags Details By Device Id")
    public void getAzureContainerTagsDetails() throws IOException {
        String azureContainerDeviceId;
        azureContainerDeviceId = getIdFromURL(AZURE_CONTAINER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + azureContainerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Load Balancer Summary Details By Device Id")
    public void getAzureLoadBalancerSummaryDetails() throws IOException {
        String azureLoadBalancerDeviceId;
        azureLoadBalancerDeviceId = getIdFromURL(AZURE_LOADBALANCER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + azureLoadBalancerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Load Balancer Local User Details By Device Id")
    public void getAzureLoadBalancerUserDetails() throws IOException {
        String azureLoadBalancerDeviceId;
        azureLoadBalancerDeviceId = getIdFromURL(AZURE_LOADBALANCER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + LOCAL_USER_DETAIL + azureLoadBalancerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Load Balancer Rule Details By Device Id")
    public void getAzureLoadBalancerRuleDetails() throws IOException {
        String azureLoadBalancerDeviceId;
        azureLoadBalancerDeviceId = getIdFromURL(AZURE_LOADBALANCER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + LOAD_BALANCER_RULES + azureLoadBalancerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Load Balancer Backend Pool Details By Device Id")
    public void getAzureLoadBalancerBackendPoolDetails() throws IOException {
        String azureLoadBalancerDeviceId;
        azureLoadBalancerDeviceId = getIdFromURL(AZURE_LOADBALANCER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + BACKEND_POOL + azureLoadBalancerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Load Balancer Asset Tags Details By Device Id")
    public void getAzureLoadBalancerAssetTagsDetails() throws IOException {
        String azureLoadBalancerDeviceId;
        azureLoadBalancerDeviceId = getIdFromURL(AZURE_LOADBALANCER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + azureLoadBalancerDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get Azure Private Host Summary Details By Device Id")
    public void getAzurePrivateHostSummaryDetails() throws IOException {
        String azurePrivateHostDeviceId;
        azurePrivateHostDeviceId = getIdFromURL(AZURE_PRIVATE_DNS_ZONE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + azurePrivateHostDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Private Host Local User Details By Device Id")
    public void getAzurePrivateHostUserDetails() throws IOException {
        String azurePrivateHostDeviceId;
        azurePrivateHostDeviceId = getIdFromURL(AZURE_PRIVATE_DNS_ZONE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + LOCAL_USER_DETAIL + azurePrivateHostDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Private Host Zone Details By Device Id")
    public void getAzurePrivateHostZoneDetails() throws IOException {
        String azurePrivateHostDeviceId;
        azurePrivateHostDeviceId = getIdFromURL(AZURE_PRIVATE_DNS_ZONE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + HOST_ZONE + azurePrivateHostDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Private Host Asset Tags Details By Device Id")
    public void getAzurePrivateHostAssetTagsDetails() throws IOException {
        String azurePrivateHostDeviceId;
        azurePrivateHostDeviceId = getIdFromURL(AZURE_PRIVATE_DNS_ZONE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + azurePrivateHostDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Public Host Summary Details By Device Id")
    public void getAzurePublicHostSummaryDetails() throws IOException {
        String azurePublicHostDeviceId;
        azurePublicHostDeviceId = getIdFromURL(AZURE_PUBLIC_DNS_ZONE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + azurePublicHostDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Public Host Local User Details By Device Id")
    public void getAzurePublicHostUserDetails() throws IOException {
        String azurePublicHostDeviceId;
        azurePublicHostDeviceId = getIdFromURL(AZURE_PUBLIC_DNS_ZONE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + LOCAL_USER_DETAIL + azurePublicHostDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Public Host Zone Details By Device Id")
    public void getAzurePublicHostZoneDetails() throws IOException {
        String azurePublicHostDeviceId;
        azurePublicHostDeviceId = getIdFromURL(AZURE_PUBLIC_DNS_ZONE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + HOST_ZONE + azurePublicHostDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Public Host Asset Tags Details By Device Id")
    public void getAzurePublicHostAssetTagsDetails() throws IOException {
        String azurePublicHostDeviceId;
        azurePublicHostDeviceId = getIdFromURL(AZURE_PUBLIC_DNS_ZONE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + azurePublicHostDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Application Gateway Summary Details By Device Id")
    public void getAzureApplicationGatewaySummaryDetails() throws IOException {
        String azureApplicationGatewayDeviceId;
        azureApplicationGatewayDeviceId = getIdFromURL(AZURE_APPLICATION_GATEWAY_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + azureApplicationGatewayDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Application Gateway Local User Details By Device Id")
    public void getAzureApplicationGatewayUserDetails() throws IOException {
        String azureApplicationGatewayDeviceId;
        azureApplicationGatewayDeviceId = getIdFromURL(AZURE_APPLICATION_GATEWAY_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + LOCAL_USER_DETAIL + azureApplicationGatewayDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Application Gateway Backend Pool Details By Device Id")
    public void getAzureApplicationGatewayBackendPoolDetails() throws IOException {
        String azureApplicationGatewayDeviceId;
        azureApplicationGatewayDeviceId = getIdFromURL(AZURE_APPLICATION_GATEWAY_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + BACKEND_POOL + azureApplicationGatewayDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Application Gateway Health Probe Details By Device Id")
    public void getAzureApplicationGatewayHealthProbeDetails() throws IOException {
        String azureApplicationGatewayDeviceId;
        azureApplicationGatewayDeviceId = getIdFromURL(AZURE_APPLICATION_GATEWAY_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + HEALTH_PROBE + azureApplicationGatewayDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Application Gateway HTTP Setting Details By Device Id")
    public void getAzureApplicationGatewayHttpSettingDetails() throws IOException {
        String azureApplicationGatewayDeviceId;
        azureApplicationGatewayDeviceId = getIdFromURL(AZURE_APPLICATION_GATEWAY_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + HTTP_SETTING + azureApplicationGatewayDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Application Gateway Rules Details By Device Id")
    public void getAzureApplicationGatewayRulesDetails() throws IOException {
        String azureApplicationGatewayDeviceId;
        azureApplicationGatewayDeviceId = getIdFromURL(AZURE_APPLICATION_GATEWAY_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + GATEWAY_RULES + azureApplicationGatewayDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Application Gateway Asset Tag Details By Device Id")
    public void getAzureApplicationGatewaAssetTagsDetails() throws IOException {
        String azureApplicationGatewayDeviceId;
        azureApplicationGatewayDeviceId = getIdFromURL(AZURE_APPLICATION_GATEWAY_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + azureApplicationGatewayDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Network Security Group Summary Details By Device Id")
    public void getAzureNSGSummaryDetails() throws IOException {
        String azureNsgDeviceId;
        azureNsgDeviceId = getIdFromURL(AZURE_NETWORK_SECURITY_GROUP_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + azureNsgDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Network Security Local User Details By Device Id")
    public void getAzureNSGUserDetails() throws IOException {
        String azureNsgDeviceId;
        azureNsgDeviceId = getIdFromURL(AZURE_NETWORK_SECURITY_GROUP_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + LOCAL_USER_DETAIL + azureNsgDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Network Security Asset Tags Details By Device Id")
    public void getAzureNSGAssetTagDetails() throws IOException {
        String azureNsgDeviceId;
        azureNsgDeviceId = getIdFromURL(AZURE_NETWORK_SECURITY_GROUP_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + azureNsgDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get Azure Network Security Group Firewall In Bound Rules Details By Device Id")
    public void getAzureNSGFirewallInBoundRulesDetails() throws IOException {
        String azureNsgDeviceId;
        azureNsgDeviceId = getIdFromURL(AZURE_NETWORK_SECURITY_GROUP_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + FIREWALL_RULES + azureNsgDeviceId + "&direction=Inbound").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Network Security Group Firewall Out Bound Rules Details By Device Id")
    public void getAzureNSGFirewallOutBoundRulesDetails() throws IOException {
        String azureNsgDeviceId;
        azureNsgDeviceId = getIdFromURL(AZURE_NETWORK_SECURITY_GROUP_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + FIREWALL_RULES + azureNsgDeviceId + "&direction=Outbound").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Network Security Group Connected Hardware Details By Device Id")
    public void getAzureNSGConnectedHardwareDetails() throws IOException {
        String azureNsgDeviceId;
        azureNsgDeviceId = getIdFromURL(AZURE_NETWORK_SECURITY_GROUP_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + CONNECTED_HARDWARE + azureNsgDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Storage Account Summary Details By Device Id")
    public void getAzureStorageAccountSummaryDetails() throws IOException {
        String azureStorageAccountDeviceId;
        azureStorageAccountDeviceId = getIdFromURL(AZURE_STORAGE_ACCOUNT_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + azureStorageAccountDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Storage Account Local User Details By Device Id")
    public void getAzureStorageAccountUserDetails() throws IOException {
        String azureStorageAccountDeviceId;
        azureStorageAccountDeviceId = getIdFromURL(AZURE_STORAGE_ACCOUNT_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + LOCAL_USER_DETAIL + azureStorageAccountDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Storage Account Asset Tags Details By Device Id")
    public void getAzureStorageAccountAssetTagsDetails() throws IOException {
        String azureStorageAccountDeviceId;
        azureStorageAccountDeviceId = getIdFromURL(AZURE_STORAGE_ACCOUNT_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + azureStorageAccountDeviceId).
                then().
                spec(responseSpec);

    }


    @Test
    @Title("Get Azure Storage Account Table Details By Device Id")
    public void getAzureStorageAccountTableDetails() throws IOException {
        String azureStorageAccountDeviceId;
        azureStorageAccountDeviceId = getIdFromURL(AZURE_STORAGE_ACCOUNT_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + TABLE + azureStorageAccountDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Storage Queues Details By Device Id")
    public void getAzureStorageAccountQueuesDetails() throws IOException {
        String azureStorageAccountDeviceId;
        azureStorageAccountDeviceId = getIdFromURL(AZURE_STORAGE_ACCOUNT_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + QUEUES + azureStorageAccountDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Storage File Share Details By Device Id")
    public void getAzureStorageAccountFileShareDetails() throws IOException {
        String azureStorageAccountDeviceId;
        azureStorageAccountDeviceId = getIdFromURL(AZURE_STORAGE_ACCOUNT_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + FILE_SHARES + azureStorageAccountDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Storage Container Details By Device Id")
    public void getAzureStorageAccountContainerDetails() throws IOException {
        String azureStorageAccountDeviceId;
        azureStorageAccountDeviceId = getIdFromURL(AZURE_STORAGE_ACCOUNT_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + CONTAINERS + azureStorageAccountDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Virtual Machine Summary Details By Device Id")
    public void getAzureVirtualMachineSummaryDetails() throws IOException {
        String azureVirtualMachineDeviceId;
        azureVirtualMachineDeviceId = getIdFromURL(AZURE_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + azureVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get Azure Virtual Machine Operating System Details By Device Id")
    public void getAzureVirtualMachineOperatingSystemDetails() throws IOException {
        String azureVirtualMachineDeviceId;
        azureVirtualMachineDeviceId = getIdFromURL(AZURE_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + OS_INFORMATION + azureVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Virtual Machine CPU Details By Device Id")
    public void getAzureVirtualMachineCpuDetails() throws IOException {
        String azureVirtualMachineDeviceId;
        azureVirtualMachineDeviceId = getIdFromURL(AZURE_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + CPU_INFO + azureVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Virtual Machine Hard Drive Details By Device Id")
    public void getAzureVirtualMachineHardDriveDetails() throws IOException {
        String azureVirtualMachineDeviceId;
        azureVirtualMachineDeviceId = getIdFromURL(AZURE_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + HARD_DRIVE_DETAIL + azureVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Virtual Machine User Details By Device Id")
    public void getAzureVirtualMachineUserDetails() throws IOException {
        String azureVirtualMachineDeviceId;
        azureVirtualMachineDeviceId = getIdFromURL(AZURE_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + LOCAL_USER_DETAIL + azureVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Virtual Machine Network Interfaces Details By Device Id")
    public void getAzureVirtualMachineNetworkInterfacesDetails() throws IOException {
        String azureVirtualMachineDeviceId;
        azureVirtualMachineDeviceId = getIdFromURL(AZURE_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + NETWORK_INTERFACES + azureVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Virtual Machine Inbound Firewall Rules Details By Device Id")
    public void getAzureVirtualMachineInboundFirewallRulesDetails() throws IOException {
        String azureVirtualMachineDeviceId;
        azureVirtualMachineDeviceId = getIdFromURL(AZURE_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + FIREWALL_RULES + azureVirtualMachineDeviceId + "&direction=Inbound").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Virtual Machine Outbound Firewall Rules Details By Device Id")
    public void getAzureVirtualMachineOutboundFirewallRulesDetails() throws IOException {
        String azureVirtualMachineDeviceId;
        azureVirtualMachineDeviceId = getIdFromURL(AZURE_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + FIREWALL_RULES + azureVirtualMachineDeviceId + "&direction=Outbound").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Virtual Machine Installed Agents Details By Device Id")
    public void getAzureVirtualMachineInstalledAgentsDetails() throws IOException {
        String azureVirtualMachineDeviceId;
        azureVirtualMachineDeviceId = getIdFromURL(AZURE_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + INSTALLED_AGENTS + azureVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Virtual Machine Asset Tags Details By Device Id")
    public void getAzureVirtualMachineAssetTagsDetails() throws IOException {
        String azureVirtualMachineDeviceId;
        azureVirtualMachineDeviceId = getIdFromURL(AZURE_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + azureVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Virtual Network Summary Details By Device Id")
    public void getAzureVirtualNetworkSummaryDetails() throws IOException {
        String azureVirtualNetworkDeviceId;
        azureVirtualNetworkDeviceId = getIdFromURL(AZURE_VIRTUAL_NETWORK_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + azureVirtualNetworkDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Virtual Network User Details By Device Id")
    public void getAzureVirtualNetworkUserDetails() throws IOException {
        String azureVirtualNetworkDeviceId;
        azureVirtualNetworkDeviceId = getIdFromURL(AZURE_VIRTUAL_NETWORK_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + LOCAL_USER_DETAIL + azureVirtualNetworkDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Virtual Network Subnet Details By Device Id")
    public void getAzureVirtualNetworkSubnetDetails() throws IOException {
        String azureVirtualNetworkDeviceId;
        azureVirtualNetworkDeviceId = getIdFromURL(AZURE_VIRTUAL_NETWORK_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUBNET + azureVirtualNetworkDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Virtual Network Connected Device Details By Device Id")
    public void getAzureVirtualNetworkConnectedDeviceDetails() throws IOException {
        String azureVirtualNetworkDeviceId;
        azureVirtualNetworkDeviceId = getIdFromURL(AZURE_VIRTUAL_NETWORK_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + CONNECTED_DEVICE + azureVirtualNetworkDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Virtual Network Asset Tags Details By Device Id")
    public void getAzureVirtualNetworkAssetTagsDetails() throws IOException {
        String azureVirtualNetworkDeviceId;
        azureVirtualNetworkDeviceId = getIdFromURL(AZURE_VIRTUAL_NETWORK_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + azureVirtualNetworkDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure IP Address Summary Details By Device Id")
    public void getAzureIpAddressSummaryDetails() throws IOException {
        String azureIpAddressDeviceId;
        azureIpAddressDeviceId = getIdFromURL(AZURE_IP_ADDRESS_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + azureIpAddressDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure IP Address Local User Details By Device Id")
    public void getAzureIpAddressUserDetails() throws IOException {
        String azureIpAddressDeviceId;
        azureIpAddressDeviceId = getIdFromURL(AZURE_IP_ADDRESS_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + LOCAL_USER_DETAIL + azureIpAddressDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure IP Address Asset Tags Details By Device Id")
    public void getAzureIpAddressAssetTagsDetails() throws IOException {
        String azureIpAddressDeviceId;
        azureIpAddressDeviceId = getIdFromURL(AZURE_IP_ADDRESS_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + azureIpAddressDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Traffic Manager Summary Details By Device Id")
    public void getAzureTrafficManagerSummaryDetails() throws IOException {
        String azureTrafficManagerDeviceId;
        azureTrafficManagerDeviceId = getIdFromURL(AZURE_TRAFFIC_MANAGER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + azureTrafficManagerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Traffic Manager Local User Details By Device Id")
    public void getAzureTrafficManagerUserDetails() throws IOException {
        String azureTrafficManagerDeviceId;
        azureTrafficManagerDeviceId = getIdFromURL(AZURE_TRAFFIC_MANAGER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + LOCAL_USER_DETAIL + azureTrafficManagerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Traffic Manager Rules Details By Device Id")
    public void getAzureTrafficManagerRulesDetails() throws IOException {
        String azureTrafficManagerDeviceId;
        azureTrafficManagerDeviceId = getIdFromURL(AZURE_TRAFFIC_MANAGER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + TRAFFIC_MANAGER_RULES + azureTrafficManagerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Azure Traffic Manager Asset Tags Details By Device Id")
    public void getAzureTrafficManagerAssetTagssDetails() throws IOException {
        String azureTrafficManagerDeviceId;
        azureTrafficManagerDeviceId = getIdFromURL(AZURE_TRAFFIC_MANAGER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + azureTrafficManagerDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get AWS Container Summary Details By Device Id")
    public void getAwsContainerSummaryDetails() throws IOException {
        String awsContainerDeviceId;
        awsContainerDeviceId = getIdFromURL(AWS_CONTAINER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsContainerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Container Network Interface Details By Device Id")
    public void getAwsContainerNetworkInterfaceDetails() throws IOException {
        String awsContainerDeviceId;
        awsContainerDeviceId = getIdFromURL(AWS_CONTAINER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + NETWORK_INTERFACES + awsContainerDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get AWS Database Instance Summary Details By Device Id")
    public void getAwsDatabaseInstanceSummaryDetails() throws IOException {
        String awsDatabaseInstanceDeviceId;
        awsDatabaseInstanceDeviceId = getIdFromURL(AWS_CONTAINER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsDatabaseInstanceDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Database Instance Inbound Firewall Rule Details By Device Id")
    public void getAwsDatabaseInstanceInboundFirewallRuleDetails() throws IOException {
        String awsDatabaseInstanceDeviceId;
        awsDatabaseInstanceDeviceId = getIdFromURL(AWS_DATABASE_INSTANCE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + FIREWALL_RULES + awsDatabaseInstanceDeviceId + "&direction=Inbound").
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get AWS Database Instance Outbound Firewall Rule Details By Device Id")
    public void getAwsDatabaseInstanceOutboundFirewallRuleDetails() throws IOException {
        String awsDatabaseInstanceDeviceId;
        awsDatabaseInstanceDeviceId = getIdFromURL(AWS_DATABASE_INSTANCE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + FIREWALL_RULES + awsDatabaseInstanceDeviceId + "&direction=Outbound").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Database Instance Attachment Details By Device Id")
    public void getAwsDatabaseInstanceAttachmentsDetails() throws IOException {
        String awsDatabaseInstanceDeviceId;
        awsDatabaseInstanceDeviceId = getIdFromURL(AWS_DATABASE_INSTANCE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ATTACHMENTS + awsDatabaseInstanceDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Database Instance Subnet Group Details By Device Id")
    public void getAwsDatabaseInstanceSubnetGroupDetails() throws IOException {
        String awsDatabaseInstanceDeviceId;
        awsDatabaseInstanceDeviceId = getIdFromURL(AWS_DATABASE_INSTANCE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUBNET_GROUP + awsDatabaseInstanceDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Internet Gateway Summary Details By Device Id")
    public void getAwsInternetGatewaySummaryDetails() throws IOException {
        String awsInternetGatewayDeviceId;
        awsInternetGatewayDeviceId = getIdFromURL(AWS_INTERNET_GATEWAY_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsInternetGatewayDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Internet Gateway Asset Tag Details By Device Id")
    public void getAwsInternetGatewayAssetTagDetails() throws IOException {
        String awsInternetGatewayDeviceId;
        awsInternetGatewayDeviceId = getIdFromURL(AWS_INTERNET_GATEWAY_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + awsInternetGatewayDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Internet Gateway Attachments Details By Device Id")
    public void getAwsInternetGatewayAttachmentsDetails() throws IOException {
        String awsInternetGatewayDeviceId;
        awsInternetGatewayDeviceId = getIdFromURL(AWS_INTERNET_GATEWAY_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ATTACHMENTS + awsInternetGatewayDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Lambda Function Summary Details By Device Id")
    public void getAwsLambdaFunctionSummaryDetails() throws IOException {
        String awsLambdaFunctionDeviceId;
        awsLambdaFunctionDeviceId = getIdFromURL(AWS_LAMBDA_FUNCTION_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsLambdaFunctionDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get AWS Lambda Function Attachment Details By Device Id")
    public void getAwsLambdaFunctionAttachmentDetails() throws IOException {
        String awsLambdaFunctionDeviceId;
        awsLambdaFunctionDeviceId = getIdFromURL(AWS_LAMBDA_FUNCTION_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ATTACHMENTS + awsLambdaFunctionDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Load Balancer Summary Details By Device Id")
    public void getAwsLoadBalancerSummaryDetails() throws IOException {
        String awsLoadBalancerDeviceId;
        awsLoadBalancerDeviceId = getIdFromURL(AWS_LOAD_BALANCER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsLoadBalancerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Load Balancer Rules Details By Device Id")
    public void getAwsLoadBalancerRulesDetails() throws IOException {
        String awsLoadBalancerDeviceId;
        awsLoadBalancerDeviceId = getIdFromURL(AWS_LOAD_BALANCER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + LOAD_BALANCER_RULES + awsLoadBalancerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Load Balancer Attachment Details By Device Id")
    public void getAwsLoadBalancerAttachmentDetails() throws IOException {
        String awsLoadBalancerDeviceId;
        awsLoadBalancerDeviceId = getIdFromURL(AWS_LOAD_BALANCER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ATTACHMENTS + awsLoadBalancerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Load Balancer Target Details By Device Id")
    public void getAwsLoadBalancerTargetDetails() throws IOException {
        String awsLoadBalancerDeviceId;
        awsLoadBalancerDeviceId = getIdFromURL(AWS_LOAD_BALANCER_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + LOADBALANCER_TARGETS + awsLoadBalancerDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Nat Gateway Summary Details By Device Id")
    public void getAwsNatGatewaySummaryDetails() throws IOException {
        String awsNetGatewayDeviceId;
        awsNetGatewayDeviceId = getIdFromURL(AWS_NAT_GATEWAY_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsNetGatewayDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Nat Gateway Asset Tags Details By Device Id")
    public void getAwsNatGatewayAssetTagsDetails() throws IOException {
        String awsNetGatewayDeviceId;
        awsNetGatewayDeviceId = getIdFromURL(AWS_NAT_GATEWAY_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + awsNetGatewayDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Nat Gateway Attachments Details By Device Id")
    public void getAwsNatGatewayAttachmentsDetails() throws IOException {
        String awsNetGatewayDeviceId;
        awsNetGatewayDeviceId = getIdFromURL(AWS_NAT_GATEWAY_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ATTACHMENTS + awsNetGatewayDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Network Access Control List Summary Details By Device Id")
    public void getAwsNetworkAccessControlListSummaryDetails() throws IOException {
        String awsNetworkAccessControlListDeviceId;
        awsNetworkAccessControlListDeviceId = getIdFromURL(AWS_NETWORK_ACCESS_CONTROL_LIST_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsNetworkAccessControlListDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Network Access Control List Attachment Details By Device Id")
    public void getAwsNetworkAccessControlListAttachmentDetails() throws IOException {
        String awsNetworkAccessControlListDeviceId;
        awsNetworkAccessControlListDeviceId = getIdFromURL(AWS_NETWORK_ACCESS_CONTROL_LIST_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ATTACHMENTS + awsNetworkAccessControlListDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Network Access Control List Asset Tags Details By Device Id")
    public void getAwsNetworkAccessControlListAssetTagsDetails() throws IOException {
        String awsNetworkAccessControlListDeviceId;
        awsNetworkAccessControlListDeviceId = getIdFromURL(AWS_NETWORK_ACCESS_CONTROL_LIST_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + awsNetworkAccessControlListDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Network Access Control List Entries Details By Device Id")
    public void getAwsNetworkAccessControlListEntriesDetails() throws IOException {
        String awsNetworkAccessControlListDeviceId;
        awsNetworkAccessControlListDeviceId = getIdFromURL(AWS_NETWORK_ACCESS_CONTROL_LIST_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ENTRIES + awsNetworkAccessControlListDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Network Security Group Summary Details By Device Id")
    public void getAwsNetworkSecurityGroupSummaryDetails() throws IOException {
        String awsNetworkSecurityGroupDeviceId;
        awsNetworkSecurityGroupDeviceId = getIdFromURL(AWS_NETWORK_SECURITY_GROUP_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsNetworkSecurityGroupDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Network Security Group Asset Tags Details By Device Id")
    public void getAwsNetworkSecurityGroupAssetTagsDetails() throws IOException {
        String awsNetworkSecurityGroupDeviceId;
        awsNetworkSecurityGroupDeviceId = getIdFromURL(AWS_NETWORK_SECURITY_GROUP_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + awsNetworkSecurityGroupDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Network Security Group Attachments Details By Device Id")
    public void getAwsNetworkSecurityGroupAttachmentsDetails() throws IOException {
        String awsNetworkSecurityGroupDeviceId;
        awsNetworkSecurityGroupDeviceId = getIdFromURL(AWS_NETWORK_SECURITY_GROUP_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ATTACHMENTS + awsNetworkSecurityGroupDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Network Security Group Inbound Firewall Rule Details By Device Id")
    public void getAwsNetworkSecurityGroupInboundFirewallRuleDetails() throws IOException {
        String awsNetworkSecurityGroupDeviceId;
        awsNetworkSecurityGroupDeviceId = getIdFromURL(AWS_NETWORK_SECURITY_GROUP_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + FIREWALL_RULES + awsNetworkSecurityGroupDeviceId + "&direction=Inbound").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Network Security Group Outbound Firewall Rule Details By Device Id")
    public void getAwsNetworkSecurityGroupOutboundFirewallRuleDetails() throws IOException {
        String awsNetworkSecurityGroupDeviceId;
        awsNetworkSecurityGroupDeviceId = getIdFromURL(AWS_NETWORK_SECURITY_GROUP_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + FIREWALL_RULES + awsNetworkSecurityGroupDeviceId + "&direction=Outbound").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Route 53 DNS Records Summary Details By Device Id")
    public void getAwsRoute53DNSRecordsSummaryDetails() throws IOException {
        String awsRoute53DNSRecordsDeviceId;
        awsRoute53DNSRecordsDeviceId = getIdFromURL(AWS_ROUTE_53_DNS_RECORDS_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsRoute53DNSRecordsDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Route 53 DNS Records In-Depth Details By Device Id")
    public void getAwsRoute53DNSRecordsInDepthDetails() throws IOException {
        String awsRoute53DNSRecordsDeviceId;
        awsRoute53DNSRecordsDeviceId = getIdFromURL(AWS_ROUTE_53_DNS_RECORDS_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + DNS_RECORDS + awsRoute53DNSRecordsDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get AWS S3 Bucket Summary Details By Device Id")
    public void getAwsS3BucketSummaryDetails() throws IOException {
        String awsS3BucketDeviceId;
        awsS3BucketDeviceId = getIdFromURL(AWS_S3_BUCKET_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsS3BucketDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS S3 Bucket Access Control List Details By Device Id")
    public void getAwsS3BucketAccessControlListDetails() throws IOException {
        String awsS3BucketDeviceId;
        awsS3BucketDeviceId = getIdFromURL(AWS_S3_BUCKET_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + BUCKET_ACL + awsS3BucketDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Virtual Machine Summary Details By Device Id")
    public void getAwsVirtualMachineSummaryDetails() throws IOException {
        String awsVirtualMachineDeviceId;
        awsVirtualMachineDeviceId = getIdFromURL(AWS_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Virtual Machine Operating System Details By Device Id")
    public void getAwsVirtualMachineOperatingSystemDetails() throws IOException {
        String awsVirtualMachineDeviceId;
        awsVirtualMachineDeviceId = getIdFromURL(AWS_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + OS_INFORMATION + awsVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Virtual Machine CPU Details By Device Id")
    public void getAwsVirtualMachineCpuDetails() throws IOException {
        String awsVirtualMachineDeviceId;
        awsVirtualMachineDeviceId = getIdFromURL(AWS_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + CPU_INFO + awsVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Virtual Machine Hard Drive Details By Device Id")
    public void getAwsVirtualMachineHardDriveDetails() throws IOException {
        String awsVirtualMachineDeviceId;
        awsVirtualMachineDeviceId = getIdFromURL(AWS_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + HARD_DRIVE_DETAIL + awsVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Virtual Machine Network Interfaces Details By Device Id")
    public void getAwsVirtualMachineNetworkInterfacesDetails() throws IOException {
        String awsVirtualMachineDeviceId;
        awsVirtualMachineDeviceId = getIdFromURL(AWS_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + NETWORK_INTERFACES + awsVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get AWS Virtual Machine Inbound Firewall Rule Details By Device Id")
    public void getAwsVirtualMachineInboundFirewallRuleDetails() throws IOException {
        String awsVirtualMachineDeviceId;
        awsVirtualMachineDeviceId = getIdFromURL(AWS_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + FIREWALL_RULES + awsVirtualMachineDeviceId + "&direction=Inbound").
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get AWS Virtual Machine Outbound Firewall Rule Details By Device Id")
    public void getAwsVirtualMachineOutboundFirewallRuleDetails() throws IOException {
        String awsVirtualMachineDeviceId;
        awsVirtualMachineDeviceId = getIdFromURL(AWS_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + FIREWALL_RULES + awsVirtualMachineDeviceId + "&direction=Outbound").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Virtual Machine Asset Tag Details By Device Id")
    public void getAwsVirtualMachineAssetTagDetails() throws IOException {
        String awsVirtualMachineDeviceId;
        awsVirtualMachineDeviceId = getIdFromURL(AWS_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + awsVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Virtual Machine Attachment Details By Device Id")
    public void getAwsVirtualMachineAttachmentDetails() throws IOException {
        String awsVirtualMachineDeviceId;
        awsVirtualMachineDeviceId = getIdFromURL(AWS_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ATTACHMENTS + awsVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Virtual Machine Attached Role Details By Device Id")
    public void getAwsVirtualMachineAttachedRoleDetails() throws IOException {
        String awsVirtualMachineDeviceId;
        awsVirtualMachineDeviceId = getIdFromURL(AWS_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ATTACHED_ROLES + awsVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get AWS VPC Peering Connection Summary Details By Device Id")
    public void getAwsVPCPeeringConnectionSummaryDetails() throws IOException {
        String awsVPCPeeringConnectionDeviceId;
        awsVPCPeeringConnectionDeviceId = getIdFromURL(AWS_VPC_PEERING_CONNECTION_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsVPCPeeringConnectionDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS VPC Peering Connection Asset Tag Details By Device Id")
    public void getAwsVPCPeeringConnectionAssetTagDetails() throws IOException {
        String awsVPCPeeringConnectionDeviceId;
        awsVPCPeeringConnectionDeviceId = getIdFromURL(AWS_VPC_PEERING_CONNECTION_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + awsVPCPeeringConnectionDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS VPC Peering Connection Requester Peer Details By Device Id")
    public void getAwsVPCPeeringConnectionRequesterPeerDetails() throws IOException {
        String awsVPCPeeringConnectionDeviceId;
        awsVPCPeeringConnectionDeviceId = getIdFromURL(AWS_VPC_PEERING_CONNECTION_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + REQUESTER_PEER + awsVPCPeeringConnectionDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get AWS VPC Peering Connection Accepter Peer Details By Device Id")
    public void getAwsVPCPeeringConnectionAccepterPeerDetails() throws IOException {
        String awsVPCPeeringConnectionDeviceId;
        awsVPCPeeringConnectionDeviceId = getIdFromURL(AWS_VPC_PEERING_CONNECTION_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ACCEPTER_PEER + awsVPCPeeringConnectionDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Workspace Summary Details By Device Id")
    public void getAwsWorkspaceSummaryDetails() throws IOException {
        String awsWorkspaceDeviceId;
        awsWorkspaceDeviceId = getIdFromURL(AWS_WORKSPACES_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsWorkspaceDeviceId).
                then().
                spec(responseSpec);
    }


/*
    @Test
    @Title("Get AWS IP Address Summary Details By Device Id")
    public void getAwsIpAddressSummaryDetails() throws IOException {
        String awsIpAddressDeviceId;
        awsIpAddressDeviceId = getIdFromURL(AWS_IP_ADDRESS_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsIpAddressDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS IP Address Asset Tags Details By Device Id")
    public void getAwsIpAddressAssetTagsDetails() throws IOException {
        String awsIpAddressDeviceId;
        awsIpAddressDeviceId = getIdFromURL(AWS_IP_ADDRESS_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + awsIpAddressDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get AWS IP Address Attachment Details By Device Id")
    public void getAwsIpAddressAttachmentDetails() throws IOException {
        String awsIpAddressDeviceId;
        awsIpAddressDeviceId = getIdFromURL(AWS_IP_ADDRESS_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ATTACHMENTS + awsIpAddressDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get AWS Route Table Summary Details By Device Id")
    public void getAwsRouteTableSummaryDetails() throws IOException {
        String awsRouteTablesDeviceId;
        awsRouteTablesDeviceId = getIdFromURL(AWS_ROUTE_TABLE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsRouteTablesDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Route Table Asset Tags Details By Device Id")
    public void getAwsRouteTableAssetTagsDetails() throws IOException {
        String awsRouteTablesDeviceId;
        awsRouteTablesDeviceId = getIdFromURL(AWS_ROUTE_TABLE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + awsRouteTablesDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Route Table Attachments Details By Device Id")
    public void getAwsRouteTableAttachmentsDetails() throws IOException {
        String awsRouteTablesDeviceId;
        awsRouteTablesDeviceId = getIdFromURL(AWS_ROUTE_TABLE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ATTACHMENTS + awsRouteTablesDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Route Table Entries Details By Device Id")
    public void getAwsRouteTableEntriesDetails() throws IOException {
        String awsRouteTablesDeviceId;
        awsRouteTablesDeviceId = getIdFromURL(AWS_ROUTE_TABLE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ENTRIES + awsRouteTablesDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get AWS Subnet Summary Details By Device Id")
    public void getAwsSubnetSummaryDetails() throws IOException {
        String awsSubnetDeviceId;
        awsSubnetDeviceId = getIdFromURL(AWS_SUBNET_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsSubnetDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Subnet Asset Tags Details By Device Id")
    public void getAwsSubnetAssetTagsDetails() throws IOException {
        String awsSubnetDeviceId;
        awsSubnetDeviceId = getIdFromURL(AWS_SUBNET_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + awsSubnetDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Virtual Network Summary Details By Device Id")
    public void getAwsVirtualNetworkSummaryDetails() throws IOException {
        String awsVirtualNetworkDeviceId;
        awsVirtualNetworkDeviceId = getIdFromURL(AWS_VIRTUAL_NETWORK_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsVirtualNetworkDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Virtual Network Asset Tag Details By Device Id")
    public void getAwsVirtualNetworkAssetTagDetails() throws IOException {
        String awsVirtualNetworkDeviceId;
        awsVirtualNetworkDeviceId = getIdFromURL(AWS_VIRTUAL_NETWORK_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + awsVirtualNetworkDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Volume Summary Details By Device Id")
    public void getAwsVolumeSummaryDetails() throws IOException {
        String awsVolumeDeviceId;
        awsVolumeDeviceId = getIdFromURL(AWS_VOLUME_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + awsVolumeDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Volume Hard Drive Details By Device Id")
    public void getAwsVolumeHardDriveDetails() throws IOException {
        String awsVolumeDeviceId;
        awsVolumeDeviceId = getIdFromURL(AWS_VOLUME_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + HARD_DRIVE_DETAIL + awsVolumeDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get AWS Volume Asset Tag Details By Device Id")
    public void getAwsVolumeAssetTagDetails() throws IOException {
        String awsVolumeDeviceId;
        awsVolumeDeviceId = getIdFromURL(AWS_VOLUME_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ASSET_TAGS + awsVolumeDeviceId).
                then().
                spec(responseSpec);
    }
*/

    @Test
    @Title("Get VMware ESXi Virtual Machine Summary Details By Device Id")
    public void getVmwareEsxiVirtualMachineSummaryDetails() throws IOException {
        String VmwareEsxiVirtualMachineDeviceId;
        VmwareEsxiVirtualMachineDeviceId = getIdFromURL(VMWARE_ESXI_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + VmwareEsxiVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get VMware ESXi Virtual Machine Network Interface Details By Device Id")
    public void getVmwareEsxiVirtualMachineNetworkInterfaceDetails() throws IOException {
        String VmwareEsxiVirtualMachineDeviceId;
        VmwareEsxiVirtualMachineDeviceId = getIdFromURL(VMWARE_ESXI_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + NETWORK_INTERFACES + VmwareEsxiVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get VMware ESXi Virtual Machine Datastore Details By Device Id")
    public void getVmwareEsxiVirtualMachineDatastoreDetails() throws IOException {
        String VmwareEsxiVirtualMachineDeviceId;
        VmwareEsxiVirtualMachineDeviceId = getIdFromURL(VMWARE_ESXI_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + DATASTORES + VmwareEsxiVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get VMware ESXi Virtual Machine Network Details By Device Id")
    public void getVmwareEsxiVirtualMachineNetworkDetails() throws IOException {
        String VmwareEsxiVirtualMachineDeviceId;
        VmwareEsxiVirtualMachineDeviceId = getIdFromURL(VMWARE_ESXI_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + NETWORKS + VmwareEsxiVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get VMware ESXi Virtual Machine Disk Details By Device Id")
    public void getVmwareEsxiVirtualMachineDiskDetails() throws IOException {
        String VmwareEsxiVirtualMachineDeviceId;
        VmwareEsxiVirtualMachineDeviceId = getIdFromURL(VMWARE_ESXI_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + DISKS + VmwareEsxiVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get VMware ESXi Virtual Machine Snapshots Details By Device Id")
    public void getVmwareEsxiVirtualMachineSnapshotDetails() throws IOException {
        String VmwareEsxiVirtualMachineDeviceId;
        VmwareEsxiVirtualMachineDeviceId = getIdFromURL(VMWARE_ESXI_VIRTUAL_MACHINE_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SNAPSHOTS + VmwareEsxiVirtualMachineDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get VMware ESXi Host Summary Details By Device Id")
    public void getVmwareEsxiHostSummaryDetails() throws IOException {
        String VmwareEsxiHostDeviceId;
        VmwareEsxiHostDeviceId = getIdFromURL(VMWARE_ESXI_HOST_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + VmwareEsxiHostDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get VMware ESXi Host Datastore Details By Device Id")
    public void getVmwareEsxiHostDatastoreDetails() throws IOException {
        String VmwareEsxiHostDeviceId;
        VmwareEsxiHostDeviceId = getIdFromURL(VMWARE_ESXI_HOST_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + DATASTORES + VmwareEsxiHostDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get VMware ESXi Host Networks Details By Device Id")
    public void getVmwareEsxiHostNetworksDetails() throws IOException {
        String VmwareEsxiHostDeviceId;
        VmwareEsxiHostDeviceId = getIdFromURL(VMWARE_ESXI_HOST_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + NETWORKS + VmwareEsxiHostDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get VMware ESXi Host Attached Virtual Machine Details By Device Id")
    public void getVmwareEsxiHostVirtualMachineDetails() throws IOException {
        String VmwareEsxiHostDeviceId;
        VmwareEsxiHostDeviceId = getIdFromURL(VMWARE_ESXI_HOST_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + VIRTUAL_MACHINE + VmwareEsxiHostDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get VMware ESXi Host Storage Adapter Details By Device Id")
    public void getVmwareEsxiHostStorageAdapterDetails() throws IOException {
        String VmwareEsxiHostDeviceId;
        VmwareEsxiHostDeviceId = getIdFromURL(VMWARE_ESXI_HOST_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + STORAGE_ADAPTERS + VmwareEsxiHostDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get VMware ESXi Host Storage Device Details By Device Id")
    public void getVmwareEsxiHostStorageDeviceDetails() throws IOException {
        String VmwareEsxiHostDeviceId;
        VmwareEsxiHostDeviceId = getIdFromURL(VMWARE_ESXI_HOST_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + STORAGE_DEVICES + VmwareEsxiHostDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get VMware ESXi Host Physical Network Interface Card Details By Device Id")
    public void getVmwareEsxiHostPhysicalNetworkInterfaceCardDeviceDetails() throws IOException {
        String VmwareEsxiHostDeviceId;
        VmwareEsxiHostDeviceId = getIdFromURL(VMWARE_ESXI_HOST_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + PHYSICAL_NETWORK_INTERFACE_CARDS + VmwareEsxiHostDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get VMware ESXi Host Virtual Network Interface Cards Details By Device Id")
    public void getVmwareEsxiHostVirtualNetworkInterfaceCardDeviceDetails() throws IOException {
        String VmwareEsxiHostDeviceId;
        VmwareEsxiHostDeviceId = getIdFromURL(VMWARE_ESXI_HOST_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + VIRTUAL_NETWORK_INTERFACE_CARDS + VmwareEsxiHostDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Shodan Device Summary Details By Device Id")
    public void getShodanDeviceSummaryDetails() throws IOException {
        String shodanDeviceId;
        shodanDeviceId = getIdFromURL(SHODAN_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + shodanDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get Shodan Installed Software Details By Device Id")
    public void getShodanInstalledSoftwareDetails() throws IOException {
        String shodanDeviceId;
        shodanDeviceId = getIdFromURL(SHODAN_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + INSTALLED_SOFTWARE + shodanDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Shodan Open Ports Details By Device Id")
    public void getShodanOpenPortsDetails() throws IOException {
        String shodanDeviceId;
        shodanDeviceId = getIdFromURL(SHODAN_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + OPEN_PORTS + shodanDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Shodan Vulnerabilities Details By Device Id")
    public void getShodanVulnerabilitiesDetails() throws IOException {
        String shodanDeviceId;
        shodanDeviceId = getIdFromURL(SHODAN_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + VULNERABILITIES + shodanDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get WMIC Summary Details By Device Id")
    public void getWmicSummaryDetails() throws IOException {
        String wmicDeviceId;
        wmicDeviceId = getIdFromURL(WMIC_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SUMMARY + wmicDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get WMIC Operating System Details By Device Id")
    public void getWmicOperatingSystemDetails() throws IOException {
        String wmicDeviceId;
        wmicDeviceId = getIdFromURL(WMIC_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + OS_INFORMATION + wmicDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get WMIC Processes Details By Device Id")
    public void getWmicProcessesDetails() throws IOException {
        String wmicDeviceId;
        wmicDeviceId = getIdFromURL(WMIC_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + RUNNING_PROCESSES + wmicDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get WMIC Hard Drive Details By Device Id")
    public void getWmicHardDriveDetails() throws IOException {
        String wmicDeviceId;
        wmicDeviceId = getIdFromURL(WMIC_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + HARD_DRIVE_DETAIL + wmicDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get WMIC Installed Software Details By Device Id")
    public void getWmicInstalledSoftwareDetails() throws IOException {
        String wmicDeviceId;
        wmicDeviceId = getIdFromURL(WMIC_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + INSTALLED_SOFTWARE + wmicDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get WMIC Access Control Details By Device Id")
    public void getWmicAccessControlDetails() throws IOException {
        String wmicDeviceId;
        wmicDeviceId = getIdFromURL(WMIC_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + LOCAL_USER_DETAIL + wmicDeviceId).
                then().
                spec(responseSpec);
    }


    @Test
    @Title("Get WMIC Network Interface Details By Device Id")
    public void getWmicNetworkInterfaceDetails() throws IOException {
        String wmicDeviceId;
        wmicDeviceId = getIdFromURL(WMIC_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + NETWORK_INTERFACES + wmicDeviceId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get WMIC Shared Folder Details By Device Id")
    public void getWmiSharedFolderDetails() throws IOException {
        String wmicDeviceId;
        wmicDeviceId = getIdFromURL(WMIC_QUERY);
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SHARED_FOLDER + wmicDeviceId).
                then().
                spec(responseSpec);
    }

}
