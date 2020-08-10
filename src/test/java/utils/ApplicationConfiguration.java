package utils;

public class ApplicationConfiguration {


    public static final String baseURL_InventaService = DefaultConfiguration.getProperty("baseURL_InventaService");
    public static final String baseURL_AdapterService = DefaultConfiguration.getProperty("baseURL_AdapterService");

    public static final String secretKey = DefaultConfiguration.getProperty("secretKey");
    public static final String expirationTime = DefaultConfiguration.getProperty("expirationTime");
    public static final String subject = DefaultConfiguration.getProperty("subject");

    public static final String LDAP_MACHINE_IP = DefaultConfiguration.getProperty("ldapIP");
    public static final String LDAP_DOMAIN = DefaultConfiguration.getProperty("ldapDomain");

    public static final String AD_USERNAME = DefaultConfiguration.getProperty("ldapUsername");
    public static final String AD_PASSWORD = DefaultConfiguration.getProperty("ldapPassword");

    public static final String USERNAME = DefaultConfiguration.getProperty("username");
    public static final String PASSWORD = DefaultConfiguration.getProperty("password");

    public static final String AWS_KEY_ID = DefaultConfiguration.getProperty("accessKeyId");
    public static final String AWS_SECRET_KEY = DefaultConfiguration.getProperty("accessKeySecret");




    public static String getBaseURL_InventaService() {
        return baseURL_InventaService;
    }

    public static String getBaseURL_AdapterService() {
        return baseURL_AdapterService;
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

    public static String getAwsKeyId() {
        return AWS_KEY_ID;
    }

    public static String getAwsSecretKey() {
        return AWS_SECRET_KEY;
    }
}
