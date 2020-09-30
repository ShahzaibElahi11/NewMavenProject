package testcases;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import models.devices.DeviceNotes;
import models.devices.DeviceTag;
import org.junit.runner.RunWith;
import utils.BaseTest;

import java.io.IOException;
import java.util.Collections;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.apache.http.HttpStatus.*;

@RunWith(SerenityRunner.class)
public class DeviceDetailsTest extends BaseTest {

    public static String DEVICE_DETAIL_ID = "";

    // rethink
    static {
        try {
            DEVICE_DETAIL_ID = getIdFromURL("http://inventaserver:9092/devices/getAllDevices?page=0&size=1&sortBy=_id");
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
    @Title("Get Hard Drive Details By Device Id")
    public void getDrivesDetailsById() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + DRIVE_DETAILS + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Operating System Patches Details By Device Id")
    public void getOSPatchesDetailsById() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + OS_PATCHES + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec);

    }

    @Test
    @Title("Get Running Processes Details By Device Id")
    public void getRunningProcessesDetailsById() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + RUNNING_PROCESSES + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Installed Software Details By Device Id")
    public void getInstalledSoftwareDetailsById() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + INSTALLED_SOFTWARE + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Installed Software Details By Device Id")
    public void getOSDetailsById() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + OS_INFO + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Device User Details By Device Id")
    public void getUserDetailsById() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + USER_DETAILS_BY_ID + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Network Interface Details By Device Id")
    public void getNetworkInterfacesDetailsById() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + NETWORK_INTERFACE + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Shared Folders Details By Device Id")
    public void getSharedFoldersDetailsById() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + SHARED_FOLDER + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Device Note By Device Id")
    public void getDeviceNoteDetailsById() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + DEVICE_NOTE + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Device Tags By Device Id")
    public void getDeviceTagDetailsById() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + DEVICE_TAG + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec);
    }

    @Test //extra
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
    @Title("Post Insert Tags on Device")
    public void postInsertDeviceTag() {
        DeviceTag deviceTag = new DeviceTag("Automation_Device_Tag_Number_" + value + "1", Collections.singletonList(DEVICE_DETAIL_ID));
        given().
                spec(requestSpec).
                and().
                body(deviceTag).
                when().
                post(DEVICE_ENDPOINT + INSERT_TAG).
                then().
                assertThat().
                statusCode(SC_OK);
    }

    @Test
    @Title("Post Insert Note on Device")
    public void postInsertDeviceNote() {
        DeviceNotes deviceNotes = new DeviceNotes("Automation_Notes_#_" + value + "", "" + DEVICE_DETAIL_ID);
        given().
                spec(requestSpec).
                and().
                body(deviceNotes).
                when().
                post(DEVICE_ENDPOINT + INSERT_NOTE).
                then().
                assertThat().
                statusCode(SC_OK);
    }

    @Test
    @Title("Get All Device Tags")
    public void getAllTags() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + ALL_TAGS).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Load Balancer Rules Details By Device Id")
    public void getLoadBalancerRulesForDevice() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + LOAD_BALANCER_RULE + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec);
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
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + DEVICE_HARDWARE + DEVICE_DETAIL_ID).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get User for Device Details By Device Id")
    public void getUsersForDevice() {
        given().
                spec(requestSpec).
                when().
                get(DEVICE_ENDPOINT + USER_DETAILS_BY_ID + DEVICE_DETAIL_ID).
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


}
