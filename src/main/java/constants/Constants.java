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
    public static final String AD = "ad";
    public static final String AZURE = "azure";


    /**
     * Device Constants
     */
    public static final String DEVICE_ENDPOINT = "/devices/";
    public static final String GET_ALL_DEVICES = "getAllDevices?page=0&size=10";
    public static final String DEVICES_DETAILS = "deviceDetail?_id=";
    public static final String CONNECTOR_LIST_BY_ID = "adapters/list?_id=";
    public static final String DRIVE_DETAILS = "drives?_id=";
    public static final String OS_PATCHES = "os/patches/installed?_id=";
    public static final String RUNNING_PROCESSES = "processes/running?_id=";
    public static final String INSTALLED_SOFTWARE = "software/installed?_id=";
    public static final String OS_INFO = "os/info?_id=";
    public static final String USER_DETAILS_BY_ID = "users?_id=";
    public static final String NETWORK_INTERFACE = "network/interfaces?_id=";
    public static final String SHARED_FOLDER = "shared/folders?_id=";
    public static final String DEVICE_NOTE = "getDeviceNote?deviceId=";
    public static final String DEVICE_TAG = "getDeviceTag?deviceId=";
    public static final String GENERAL_DETAILS = "general?_id=";
    public static final String CONNECTOR_DATA = "adapter/data?_id=";
    public static final String INSERT_NOTE = "insertNote";
    public static final String INSERT_TAG = "insertTag";
    public static final String ALL_TAGS = "tags/";
    public static final String LOAD_BALANCER_RULE = "loadbalancer-rules?_id=";
    public static final String DEVICE_HARDWARE = "hardware/connected?_id=";

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

}
