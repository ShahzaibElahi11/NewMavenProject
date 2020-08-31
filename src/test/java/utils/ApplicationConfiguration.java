package utils;

public class ApplicationConfiguration {


    private static final String baseURL_InventaService = DefaultConfiguration.getProperty("baseURL_InventaService");
    private static final String baseURL_ConnectorService = DefaultConfiguration.getProperty("baseURL_ConnectorService");

    private static final String secretKey = DefaultConfiguration.getProperty("secretKey");
    private static final String expirationTime = DefaultConfiguration.getProperty("expirationTime");
    private static final String subject = DefaultConfiguration.getProperty("subject");

    private static final String LDAP_MACHINE_IP = DefaultConfiguration.getProperty("ldapIP");
    private static final String LDAP_DOMAIN = DefaultConfiguration.getProperty("ldapDomain");

    private static final String AD_USERNAME = DefaultConfiguration.getProperty("ldapUsername");
    private static final String AD_PASSWORD = DefaultConfiguration.getProperty("ldapPassword");

    private static final String USERNAME = DefaultConfiguration.getProperty("username");
    private static final String PASSWORD = DefaultConfiguration.getProperty("password");

    private static final String AWS_KEY_ID = DefaultConfiguration.getProperty("accessKeyId");
    private static final String AWS_SECRET_KEY = DefaultConfiguration.getProperty("accessKeySecret");

    private static final String AUDIT_ENDPOINT = DefaultConfiguration.getProperty("auditEndpoint");
    private static final String USER_AUDIT = DefaultConfiguration.getProperty("getUserAudit");
    private static final String AUDIT_DETAIL = DefaultConfiguration.getProperty("getAuditDetail");
    private static final String ALL_USER_AUDIT_LIST = DefaultConfiguration.getProperty("getAllUserAuditList");
    private static final String ALL_USER_NAME = DefaultConfiguration.getProperty("getAllUsersName");

    private static final String CONNECTOR_ENDPOINT = DefaultConfiguration.getProperty("connectorEndpoint");
    private static final String CONNECTOR_CONFIGURATION = DefaultConfiguration.getProperty("connectorConfiguration");
    private static final String DISCOVER =DefaultConfiguration.getProperty("discover");
    private static final String AWS = DefaultConfiguration.getProperty("aws");
    private static final String AD = DefaultConfiguration.getProperty("ad");
    private static final String AZURE = DefaultConfiguration.getProperty("azure");

    private static final String DASHBOARD_ENDPOINT = DefaultConfiguration.getProperty("dashboardEndpoint");
    private static final String CONNECTOR_PARAM = DefaultConfiguration.getProperty("connectorQueryParam");
    private static final String OS_DISTRIBUTION = DefaultConfiguration.getProperty("operatingSystemDistribution");
    private static final String USER_COUNT = DefaultConfiguration.getProperty("userCount");
    private static final String ASSETS_TYPE_DISTRIBUTION = DefaultConfiguration.getProperty("assetsTypeDistribution");
    private static final String CLOUD_VS_NON_CLOUD = DefaultConfiguration.getProperty("cloudVsNonCloud");
    private static final String WMIC = DefaultConfiguration.getProperty("wmic");



    public static String getBaseURL_InventaService() {
        return baseURL_InventaService;
    }

    public static String getBaseURL_ConnectorService() {
        return baseURL_ConnectorService;
    }

    public static String getSecretKey() {
        return secretKey;
    }

    public static String getExpirationTime() {
        return expirationTime;
    }

    public static String getSubject() {
        return subject;
    }


    public static String getLdapMachineIp() {
        return LDAP_MACHINE_IP;
    }

    public static String getLdapDomain() {
        return LDAP_DOMAIN;
    }

    public static String getAdUsername() {
        return AD_USERNAME;
    }

    public static String getAdPassword() {
        return AD_PASSWORD;
    }

    public static String getUSERNAME() { return USERNAME; }

    public static String getPASSWORD() { return PASSWORD; }

    public static String getAwsKeyId() { return AWS_KEY_ID; }

    public static String getAwsSecretKey() {
        return AWS_SECRET_KEY;
    }

    public static String getAuditEndpoint() { return AUDIT_ENDPOINT; }

    public static String getUserAudit() { return USER_AUDIT; }

    public static String getAuditDetail() { return AUDIT_DETAIL; }

    public static String getAllUserAuditList() { return ALL_USER_AUDIT_LIST; }

    public static String getAllUserName() { return ALL_USER_NAME; }

    public static String getConnectorEndpoint() { return CONNECTOR_ENDPOINT; }

    public static String getConnectorConfiguration() { return CONNECTOR_CONFIGURATION; }

    public static String getDISCOVER() { return DISCOVER; }

    public static String getAWS() { return AWS; }

    public static String getAD() { return AD; }

    public static String getAZURE() { return AZURE; }

    public static String getDashboardEndpoint() { return DASHBOARD_ENDPOINT; }

    public static String getConnectorParam() { return CONNECTOR_PARAM; }

    public static String getOsDistribution() { return OS_DISTRIBUTION; }

    public static String getUserCount() { return USER_COUNT; }

    public static String getAssetsTypeDistribution() { return ASSETS_TYPE_DISTRIBUTION; }

    public static String getCloudVsNonCloud() { return CLOUD_VS_NON_CLOUD; }

    public static String getWMIC() { return WMIC; }
}
