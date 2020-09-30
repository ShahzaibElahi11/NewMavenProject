package constants;

public class Constants{

    /**
     * AuditLogs  Configuration Constant
     */
    public static final String AUDIT_ENDPOINT = "/audit/";
    public static final String USER_AUDIT = "getUserAudit?username=admininventa&page=0&size=1";
    public static final String AUDIT_DETAIL = "getAuditDetail?id=";
    public static final String ALL_USER_AUDIT_LIST = "getAllAudit?page=0&size=10";
    public static final String ALL_USER_NAME = "/adminUsers/getAllUsername";


    /**
     * Connector Configuration Constant
     */

    public static final String CONNECTOR_ENDPOINT = "/adapters/";
    public static final String CONNECTOR_CONFIGURATION = "active-directory/configure/?type=";
    public static final String CONNECTOR_CONFIGURATION_INSTANCE = "instance/list?source=";

    public static final String DISCOVER = "discover/";

    /**
     * Dashboard Constant
     */
    public static final String DASHBOARD_ENDPOINT = "/query/adapters/count/devices/";
    public static final String CONNECTOR_PARAM = "?adapter=adapter_";
    public static final String OS_DISTRIBUTION = "/query/dist/?field=common.operatingSystem.type";
    public static final String USER_COUNT = "/query/count/users/";
    public static final String ASSETS_TYPE_DISTRIBUTION = "/query/dist/?field=type&match=adapters.adapter_";
    public static final String CLOUD_VS_NON_CLOUD = "/query/pie/?field=adapterProperties&match=CLOUD%20PROVIDER";
    public static final String WMIC = "wmic";
    public static final String AWS = "aws";
    public static final String AZURE = "azure";
    public static final String AD = "ad";
    public static final String ACTIVE_DIRECTORY = "ACTIVE_DIRECTORY";
    public static final String AWS_ENDPOINT = "AWS";
    public static final String AZURE_ENDPOINT = "AZURE";
    public static final String CROWDSTRIKE = "crowdstrike";
    public static final String SHODAN = "shodan";
    public static final String VMWARE_ESXI = "VMWARE_ESXI";

    //will implement current date logic
    public static final String ASSETS_BY_MONTH_DATE = "/query/assets/devices/discovery?startDate=Jul-01-2020&endDate=Sep-16-2020";
    public static final String USER_BY_MONTH_DATE = "/query/assets/users/discovery?startDate=Jul-01-2020&endDate=Sep-16-2020";

    public static final String TOTAL_WINDOWS_ASSETS = "/query/donut/totalAssets?field=common.operatingSystem.type&match=WINDOWS&type=VIRTUAL_MACHINE";
    public static final String TOTAL_LINUX_ASSETS = "/query/donut/totalAssets?field=common.operatingSystem.type&match=LINUX&type=VIRTUAL_MACHINE";
    public static final String TOTAL_CLOUD_ASSETS = "/query/donut/totalAssets?field=adapterProperties&match=CLOUD%20PROVIDER";

    public static final String TOTAL_MISSING_EDR_ASSETS = "/query/donut/missingEdr";
    public static final String TOTAL_ASSETS_DISTRIBUTION = "/query/chart/dist?field=common.source&topCount=100";

    public static final String TOTAL_CLOUD_DEVICE_TYPE_ASSETS = "/query/chart/dist?field=type&topCount=100";
    public static final String USER_DISTRIBUTION = "/query/chart/user/dist?topCount=6&field=common.source";

    public static final String CPU_HEALTH = "/query/healthCheck?check=CPU";
    public static final String MEMORY_HEALTH = "/query/healthCheck?check=MEMORY";
    public static final String DISCOVERY_HEALTH = "/query/healthCheck?check=DISCOVERY";


    /**
     * Device Constants
     */
    public static final String DEVICE_ENDPOINT = "/devices/";
    public static final String GET_ALL_DEVICES = "getAllDevices?page=0&size=10";
    public static final String DEVICES_DETAILS = "deviceDetail?_id=";
    public static final String CONNECTOR_LIST_BY_ID = "adapters/list?_id=";
    public static final String DRIVE_DETAILS = "drives?_id="; //will remove this test case later
    public static final String OS_PATCHES = "os/patches/installed?_id=";
    public static final String RUNNING_PROCESSES = "processes/running?_id=";
    public static final String INSTALLED_SOFTWARE = "software/installed?_id=";
    public static final String OS_INFO = "os/info?_id=";  //will remove this test case later
    public static final String USER_DETAILS_BY_ID = "users?_id="; //will remove this test case later
    public static final String NETWORK_INTERFACE = "network/interfaces?_id=";
    public static final String SHARED_FOLDER = "shared/folders?_id=";
    public static final String DEVICE_NOTE = "getDeviceNote?deviceId=";
    public static final String DEVICE_TAG = "getDeviceTag?deviceId=";
    public static final String GENERAL_DETAILS = "general?_id=";
    public static final String CONNECTOR_DATA = "adapter/data?_id=";
    public static final String INSERT_NOTE = "insertNote";
    public static final String INSERT_TAG = "insertTag";
    public static final String ALL_TAGS = "tags/";
    public static final String LOAD_BALANCER_RULE = "loadbalancer-rules?_id=";  //will remove this test case later
    public static final String DEVICE_HARDWARE = "hardware/connected?_id="; //will remove this test case later

    //http://inventaserver:9092/devices/getCommonMenu?deviceId=5f5b5a7217bb352246d6b68a
    //http://inventaserver:9092/permission/getUserPermission?userId=5f60dfe75af94a27e29cfe97&module=asset
    //http://inventaserver:9092/policy-routine/set/device/5f5b5a7217bb352246d6b68a

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


    //8 Traffic Manager - remaining
    public static final String TRAFFIC_MANAGER_RULES = "trafficManagerRules?_id=";
    public static final String SUBNET = "subnets?_id=";

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

    //11 IP Address - completed



    /**
     * LDAP Constants
     */

    public static final String CONFIG_ENDPOINT = "/config/";
    public static final String CONFIG_TYPE = "?type=ldap";
    public static final String AD_LOGIN = "/ad/login/";

    /**
     * Policy Routine Constants
     */
    public static final String POLICY_ROUTINE = "/policy-routine/";
    public static final String PR_ACTION = "actions";
    public static final String PR_TABLE = "table/?page=0&size=10";

    //re-think
    public static final String PR_FILTER_NAME = "TEST_FILTER";

    /**
     * Query Wizard Constants
     */
    public static final String QUERY_ENDPOINT = "/query/devices/?query=";
    public static final String EQUAL_OPERATOR = "(type%20==%20\"VIRTUAL_MACHINE\")";
    public static final String NOT_EQUAL_OPERATOR = "(not%20type===%20\"VIRTUAL_MACHINE=%20\")";
    public static final String EXIST_OPERATOR_TRUE = "(adapters.adapter_azure==exists(true))";
    public static final String EXIST_OPERATOR_FALSE = "(adapters.adapter_azure==exists(false))";
    public static final String START_WITH_OPERATOR = "(common.ipAddress==starts(\"172.\"))";
    public static final String END_WITH_OPERATOR = "(common.ipAddress==ends(\".7\"))";
    public static final String IN_OPERATOR = "(common.hostName%20==%20in(\"QA-Instance2-up,%20Inventa-Zone1-nsg\"))";
    public static final String CONTAIN_OPERATOR = "(common.ipAddress==contains(\"16.0\"))";
    public static final String AND_OPERATOR = "(type==\"VIRTUAL_MACHINE\")and(common.hostName==\"App1Web2\")";
    public static final String OR_OPERATOR = "(not%20type==\"VIRTUAL_MACHINE\")or(common.hostName==\"App1Web2\")";
    public static final String DETAIL_QUERY = "(adapters.adapter_ad.dNSHostName==\"DESKTOP-7DN8B20.inventa.local\")";
    public static final String STATEMENT_QUERY = "(((adapters.adapter_azure.location%20==%20starts(\"east\"))and" +
            "(adapters.adapter_azure.Type%20==%20\"Storage%20Account\"))and((adapters.adapter_azure.name%20==%20\"inventargdiag\")))";

    public static final String SAVED_QUERY = "/saved-query/";
    public static final String SAVED_QUERY_PAGINATION = "page=0&size=10";

    public static final String ALL_DEVICE_FIELDS = "/query/fields/all/?fieldEntity=devices&field=adapters.adapter_";
    public static final String ALL_USER_FIELDS = "/query/fields/all/?fieldEntity=users&field=adapters.adapter_";

    public static final String TYPE_DEVICE_FIELDS = "/query/fields/type/?fieldEntity=devices&field=adapters.adapter_";


    /**
     * User Management Constants
     */
    public static final String ROLE_ENDPOINT = "/role/";
    public static final String CREATE_ROLE = "createRole";
    public static final String GET_ALL_ROLE = "getAllRole";
    public static final String ROLE_DETAILS = "getRoleDetail?id=";
    public static final String UPDATE_ROLE = "updateRole?id=";
    public static final String DELETE_ROLE = "deleteRole?id=";

    public static final String PERMISSION_ENDPOINT = "/permission/";
    public static final String GET_ALL_PERMISSION = "getAllPermission";
    public static final String PERMISSION_DETAILS = "getPermissionDetail?id=";

    public static final String GET_ALL_MODULES = "getAllModules";
    public static final String GET_ROLE_MODULES = "getRoleModules?role=";
    public static final String GET_ROLE_PERMISSION = "getRolePermission?module=";
    public static final String GET_USER_MODULES = "getUserModules?userId=";

    public final static String ADMIN_USER_ENDPOINT = "/adminUsers/";
    public static final String CREATE_ADMIN_USER = "createUser";
    public static final String GET_ALL_ADMIN_USER = "getAllAdminUsers";
    public static final String ADMIN_USER_DETAILS = "getAdminUserDetail?_id=";
    public static final String UPDATE_ADMIN_USER = "updateUser?id=";
    public static final String DELETE_ADMIN_USER = "deleteAdminUser?_id=";
    public static final String ALL_ADMIN_USERNAME = "getAllUsername";

    public final static String LOGIN = "/login";
    public static final String PAGINATION_PARAMETER = "?page=0&size=100";

    /**
     * Discover User Constants
     */

    public static final String USER_ENDPOINT = "/users/";
    public static final String PAGINATION = "?page=0&size=1&sort=dateCreated,desc";
    public static final String ALL_USERS = "getAllUsers";
    public static final String USER_DETAIL = "userDetail?_id=";
    public static final String USER_TAG = "getUserTag?userId=";
    public static final String USER_NOTE = "getUserNote?userId=";


    public static final String DELETE_SINGLE_TAG = "deleteSingleTag/?userId=";
    public static final String DELETE_BULK_TAG = "deleteBulkTag";
    public static final String DELETE_NOTE = "deleteNote?userId=";

    /**
     * Integration Controller Constants
     */

    public static final String DOCKER_ENDPOINT = "/docker/";
    public static final String ACTIVE_MQ = "activemq";

    public static final String CROWDSTRIKE_QUERY = "http://inventaserver:9092/query/devices/?query=((adapters.adapter_crowdstrike.status%20==%20exists(true))and(adapters.adapter_crowdstrike.hostname%20==%20%22TESTBENCH%22))";
    public static final String AZURE_CONTAINER_QUERY = "http://inventaserver:9092/query/devices/?query=(adapters.adapter_azure.Container%20Instance::Status%20==%20exists(true))&page=0&size=1";
    public static final String AZURE_LOADBALANCER_QUERY = "http://inventaserver:9092/query/devices/?query=(adapters.adapter_azure.Load%20Balancer::Type%20==%20exists(true))&page=0&size=1";
    public static final String AZURE_PRIVATE_DNS_ZONE_QUERY = "http://inventaserver:9092/query/devices/?query=(adapters.adapter_azure.Private%20DNS%20Zones::Id%20==%20exists(true))&page=0&size=1";
    public static final String AZURE_PUBLIC_DNS_ZONE_QUERY = "http://inventaserver:9092/query/devices/?query=(adapters.adapter_azure.Public%20DNS%20Zones::Type%20==%20exists(true))&page=0&size=1";
    public static final String AZURE_APPLICATION_GATEWAY_QUERY = "http://inventaserver:9092/query/devices/?query=(common.hostName%20==%20%22AppGwPubIP%22)&page=0&size=1";
    public static final String AZURE_NETWORK_SECURITY_GROUP_QUERY = "http://inventaserver:9092/query/devices/?query=(adapters.adapter_azure.Network%20Security%20Group::Type%20==%20exists(true))&page=0&size=1";
    public static final String AZURE_STORAGE_ACCOUNT_QUERY = "http://inventaserver:9092/query/devices/?query=(adapters.adapter_azure.Type%20==%20%22Storage%20Account%22)&page=0&size=1";
    public static final String AZURE_VIRTUAL_MACHINE_QUERY = "http://inventaserver:9092/query/devices/?query=(adapters.adapter_azure.Virtual%20Machine::Status%20==%20exists(true))&page=0&size=1";
    public static final String AZURE_VIRTUAL_NETWORK_QUERY = "http://inventaserver:9092/query/devices/?query=(adapters.adapter_azure.Virtual%20Network::Type%20==%20exists(true))&page=0&size=1";
    public static final String AZURE_IP_ADDRESS_QUERY = "http://inventaserver:9092/query/devices/?query=(adapters.adapter_azure.Public%20IP%20Address::Type%20==%20exists(true))&page=0&size=1";


    public static final String GET_ROLE_ID = "http://inventaserver:9092/role/getAllRole?page=0&size=1&sort=dateCreated,desc";
    public static final String DELETE_ROLE_ID = "http://inventaserver:9092/role/getAllRole?page=0&size=1&sort=dateModified,desc";
    public static final String GET_ROLE_ID_FOR_USER = "http://inventaserver:9092/role/getAllRole?page=0&size=1";
    public static final String GET_POLICY_ROUTINE_ID = "http://inventaserver:9092/policy-routine/?page=0&size=1&sort=dateCreated,desc";
    public static final String PUT_POLICY_ROUTINE_ID = "http://inventaserver:9092/policy-routine/?page=0&size=1&sort=dateCreated,desc";
    public static final String DELETE_POLICY_ROUTINE_ID = "http://inventaserver:9092/policy-routine/?page=0&size=1&sort=dateModified,desc";
    public static final String GET_DEVICE_ID = "http://inventaserver:9092/devices/getAllDevices?page=0&size=1&sortBy=_id";
    public static final String GET_USER_ID = "http://inventaserver:9092/users/getAllUsers/?page=0&size=1&sort=dateCreated,desc";
    public static final String GET_AUDIT_ID = "http://inventaserver:9092/audit/getAllAudit?page=0&size=1&sort=dateCreated,desc";
    public static final String GET_PERMISSION_ID = "http://inventaserver:9092/permission/getAllPermission";
    public static final String GET_ADMIN_USER_ID = "http://inventaserver:9092/adminUsers/getAllAdminUsers?page=0&size=1&sort=dateCreated,desc";
    public static final String DELETE_ADMIN_USER_ID = "http://inventaserver:9092/adminUsers/getAllAdminUsers?page=0&size=1&sort=dateModified,desc";


}
