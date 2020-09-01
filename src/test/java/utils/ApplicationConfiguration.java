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




}
