package constants;

import utils.BaseTest;

public class DeviceControllerConstants extends BaseTest {

    /**
     * Device Constants
     */
    public static final String DEVICE_ENDPOINT = "/devices/";
    public static final String GET_ALL_DEVICES = "getAllDevices?page=0&size=1";
    public static final String DEVICES_DETAILS = "deviceDetail?_id=";
    public static final String CONNECTOR_LIST_BY_ID = "adapters/list?_id="; //will check later
    public static final String RUNNING_PROCESSES = "processes/running?_id=";
    public static final String INSTALLED_SOFTWARE = "software/installed?_id=";
    public static final String SHARED_FOLDER = "shared/folders?_id=";
    public static final String DEVICE_NOTE_LIST = "getDeviceNoteList?deviceId=";
    public static final String DELETE_DEVICE_NOTE  = "deleteNote?deviceId=";
    public static final String DEVICE_TAG = "getDeviceTag?deviceId=";
    public static final String GENERAL_DETAILS = "general?_id=";
    public static final String CONNECTOR_DATA = "adapter/data?_id=";
    public static final String INSERT_NOTE = "insertNote";
    public static final String INSERT_TAG = "insertTag";
    public static final String ALL_TAGS = "tags/";
    public static final String DEVICE_HARDWARE = "hardware/connected?_id="; //will remove this test case later
    public static final String DEVICE_COMMON_MENU = "getCommonMenu?deviceId=";
    public static final String ALL_CONNECTOR_LIST = "adapters/list/all";
    public static final String ASSET_TYPE_LIST = "typelist";
    public static final String DELETE_DEVICE_SINGLE_TAG = "deleteSingleTag?deviceId=";
    public static final String DELETE_BULK_TAG = "deleteBulkTag";
    public static final String TERM_LISTING = "term/listing?term=";
    public static final String TERM_SUGGESTION = "term/suggest/";


    public static final String CROWDSTRIKE_INCIDENTS = "incidents?_id=";
    public static final String CROWDSTRIKE_SENSOR_UPDATE_POLICY = "sensorUpdatePolicy?_id=";
    public static final String CROWDSTRIKE_PREVENTION_POLICIES = "preventionPolicies?_id=";


    //1 Container - complete
    public static final String CONTAINER_PROTOCOLS = "protocols?_id=";
    public static final String CONTAINER_PORTS = "ports?_id=";
    public static final String CONTAINER_INDEPTH = "containers?_id="; //will change

    //2 Load Balancer - complete
    public static final String LOAD_BALANCER_RULES = "loadbalancer-rules?_id=";
    public static final String BACKEND_POOL = "backendPool?_id=";

    //3 and 4 Public and Private DNS ZONE - complete
    public static final String HOST_ZONE = "hostedZones?_id=";

    //5 Application Gateway - complete
    public static final String HEALTH_PROBE = "healthProbe?_id=";
    public static final String HTTP_SETTING = "httpsSettings?_id=";
    public static final String GATEWAY_RULES = "applicationGatewayRules?_id=";

    //6 Network Security Group - complete
    public static final String FIREWALL_RULES = "firewallRules?_id=";
    public static final String CONNECTED_HARDWARE = "hardware/connected?_id=";

    //7 Storage Account - complete
    public static final String TABLE = "tables?_id=";
    public static final String QUEUES = "queues?_id=";
    public static final String FILE_SHARES = "fileShares?_id=";
    public static final String CONTAINERS = "containers?_id=";


    //8 Traffic Manager - complete
    public static final String TRAFFIC_MANAGER_RULES = "trafficManagerRules?_id=";

    // 9 Virtual Machine - completed
    public static final String SUMMARY = "summary?_id=";
    public static final String OS_INFORMATION = "os/info?_id=";
    public static final String CPU_INFO = "cpu?_id=";
    public static final String HARD_DRIVE_DETAIL = "drives?_id=";
    public static final String LOCAL_USER_DETAIL = "users?_id=";
    public static final String NETWORK_INTERFACES = "network/interfaces?_id=";
    public static final String INSTALLED_AGENTS = "installedAgents?_id="; //Extensions
    public static final String ASSET_TAGS = "asset/tags?_id=";

    //10 Virtual Network - completed
    public static final String CONNECTED_DEVICE = "connectedDevices?_id=";
    public static final String SUBNET = "subnets?_id=";

    //11 IP Address - completed


    /**
     * Device Queries
     */
    public static final String DEVICE_NOTE_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/devices/getDeviceNoteList?deviceId=";
    public static final String GET_DEVICE_ID_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + DEVICE_ENDPOINT+ GET_ALL_DEVICES;

    /**
     * CrowdStrike and Azure Assets Query
     */

    public static final String CROWDSTRIKE_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=((adapters.adapter_crowdstrike.status%20==%20exists(true))and(adapters.adapter_crowdstrike.hostname%20==%20%22TESTBENCH%22))";
    public static final String AZURE_CONTAINER_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT +  "/query/devices/?query=(adapters.adapter_azure.Container%20Instance::Status%20==%20exists(true))&page=0&size=1";
    public static final String AZURE_LOADBALANCER_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_azure.Load%20Balancer::Type%20==%20exists(true))&page=0&size=1";
    public static final String AZURE_PRIVATE_DNS_ZONE_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_azure.Private%20DNS%20Zones::Id%20==%20exists(true))&page=0&size=1";
    public static final String AZURE_PUBLIC_DNS_ZONE_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_azure.Public%20DNS%20Zones::Type%20==%20exists(true))&page=0&size=1";
    public static final String AZURE_APPLICATION_GATEWAY_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(common.hostName%20==%20%22AppGwPubIP%22)&page=0&size=1";
    public static final String AZURE_NETWORK_SECURITY_GROUP_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_azure.Network%20Security%20Group::Type%20==%20exists(true))&page=0&size=1";
    public static final String AZURE_STORAGE_ACCOUNT_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_azure.Type%20==%20%22STORAGE_ACCOUNT%22)&page=0&size=1";
    public static final String AZURE_VIRTUAL_MACHINE_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_azure.Virtual%20Machine::Status%20==%20exists(true))&page=0&size=1";
    public static final String AZURE_VIRTUAL_NETWORK_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_azure.Virtual%20Network::Type%20==%20exists(true))&page=0&size=1";
    public static final String AZURE_IP_ADDRESS_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_azure.Public%20IP%20Address::Type%20==%20exists(true))&page=0&size=1";
    public static final String AZURE_TRAFFIC_MANAGER_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_azure.Traffic%20Manager%20Profile::Status%20==%20exists(true))&page=0&size=1";


    /**
     * AWS Aggregated Tab Constants
     */

    public static final String ATTACHMENTS = "attachments?_id=";
    public static final String SUBNET_GROUP = "db/subnet?_id=";
    public static final String LOADBALANCER_TARGETS = "lb/targets?_id=";
    public static final String ENTRIES = "entries?_id=";
    public static final String DNS_RECORDS = "dns/records?_id=";
    public static final String BUCKET_ACL = "bucket-acl?_id=";
    public static final String ATTACHED_ROLES = "roles?_id=";
    public static final String REQUESTER_PEER = "vpc/requester?_id=";
    public static final String ACCEPTER_PEER = "vpc/accepter?_id=";


    /**
     * AWS Asset Type Queries
     */
    public static final String AWS_CONTAINER_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT +  "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22CONTAINER%22)&page=0&size=1";
    public static final String AWS_DATABASE_INSTANCE_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22DATABASE_INSTANCE%22)&page=0&size=1";
    public static final String AWS_INTERNET_GATEWAY_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22INTERNET_GATEWAY%22)&page=0&size=1";
    public static final String AWS_IP_ADDRESS_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22IP_ADDRESS%22)&page=0&size=1";
    public static final String AWS_LAMBDA_FUNCTION_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22LAMBDA_FUNCTION%22)&page=0&size=1";
    public static final String AWS_LOAD_BALANCER_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22LOAD_BALANCER%22)&page=0&size=1";
    public static final String AWS_NAT_GATEWAY_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22NAT_GATEWAY%22)&page=0&size=1";
    public static final String AWS_NETWORK_ACCESS_CONTROL_LIST_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22NETWORK_ACCESS_CONTROL_LIST%22)&page=0&size=1";
    public static final String AWS_NETWORK_SECURITY_GROUP_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22NETWORK_SECURITY_GROUP%22)&page=0&size=1";
    public static final String AWS_ROUTE_53_DNS_RECORDS_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20ends(%22ROUTE_53_DNS_RECORDS%22))&page=0&size=1";
    public static final String AWS_ROUTE_TABLE_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22ROUTE_TABLE%22)&page=0&size=1";
    public static final String AWS_S3_BUCKET_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22S3_BUCKET%22)&page=0&size=1";
    public static final String AWS_SUBNET_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22SUBNET%22)&page=0&size=1";
    public static final String AWS_VIRTUAL_MACHINE_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22VIRTUAL_MACHINE%22)&page=0&size=1";
    public static final String AWS_VIRTUAL_NETWORK_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22VIRTUAL_NETWORK%22)&page=0&size=1";
    public static final String AWS_VOLUME_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22VOLUME%22)&page=0&size=1";
    public static final String AWS_VPC_PEERING_CONNECTION_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22VPC_PEERING_CONNECTION%22)&page=0&size=1";
    public static final String AWS_WORKSPACES_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_aws.Asset%20Type%20==%20%22WORKSPACES%22)&page=0&size=1";

    /**
     * VMware_ESXi Asset Type Queries
     */
    public static final String VMWARE_ESXI_VIRTUAL_MACHINE_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_vmware_esxi.type%20==%20%22VIRTUAL_MACHINE%22)&page=0&size=1";
    public static final String VMWARE_ESXI_HOST_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_vmware_esxi.type%20==%20%22HOST%22)&page=0&size=1";


    /**
     * VMware_ESXi Aggregated Tab Constant
     */
    public static final String DATASTORES = "datastores?_id=";
    public static final String NETWORKS = "networks?_id=";
    public static final String DISKS = "disks?_id=";
    public static final String SNAPSHOTS = "snapshots?_id=";
    public static final String VIRTUAL_MACHINE = "vms?_id=";
    public static final String STORAGE_ADAPTERS = "storageAdapters?_id=";
    public static final String STORAGE_DEVICES = "storageDevices?_id=";
    public static final String PHYSICAL_NETWORK_INTERFACE_CARDS = "physicalNics?_id=";
    public static final String VIRTUAL_NETWORK_INTERFACE_CARDS = "virtualNics?_id=";

    /**
     * Shodan Query
     */
    public static final String SHODAN_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_shodan.asn%20==%20exists(true))&page=0&size=1";

    /**
     * VMware_ESXi Aggregated Tab Constant
     */
    public static final String OPEN_PORTS = "openports?_id=";
    public static final String VULNERABILITIES =  "vulnerabilities?_id=";

    /**
     * WMIC Query
     */
    public static final String WMIC_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/devices/?query=(adapters.adapter_wmic.IP%20Address%20==%20exists(true))&page=0&size=1";



}
