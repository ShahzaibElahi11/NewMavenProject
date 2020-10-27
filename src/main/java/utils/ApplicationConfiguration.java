package utils;

public class ApplicationConfiguration {

    private static String inventaBaseURL = DefaultConfiguration.getProperty("inventaBaseURL");

    private static String inventaServicePort = DefaultConfiguration.getProperty("inventaServicePort");
    private static String connectorServicePort = DefaultConfiguration.getProperty("connectorServicePort");

    private static String secretKey = DefaultConfiguration.getProperty("secretKey");
    private static  String expirationTime = DefaultConfiguration.getProperty("expirationTime");
    private static  String subject = DefaultConfiguration.getProperty("subject");

    private static String ldapMachineIp = DefaultConfiguration.getProperty("ldapIP");
    private static String ldapDomain = DefaultConfiguration.getProperty("ldapDomain");

    private static  String ldapUsername = DefaultConfiguration.getProperty("ldapUsername");
    private static  String ldapPassword = DefaultConfiguration.getProperty("ldapPassword");

    private static  String username = DefaultConfiguration.getProperty("username");
    private static  String password = DefaultConfiguration.getProperty("password");

    private static  String awsKeyId = DefaultConfiguration.getProperty("accessKeyId");
    private static  String awsSecretKey = DefaultConfiguration.getProperty("accessKeySecret");


    public static String getInventaBaseUrl() {
        return inventaBaseURL;
    }

    public static String getInventaServicePort() {
        return inventaServicePort;
    }

    public static String getConnectorServicePort() {
        return connectorServicePort;
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
        return ldapMachineIp;
    }

    public static String getLdapDomain() {
        return ldapDomain;
    }

    public static String getLdapUsername() {
        return ldapUsername;
    }

    public static String getLdapPassword() {
        return ldapPassword;
    }

    public static String getUsername() { return username; }

    public static String getPassword() { return password; }

    public static String getAwsKeyId() { return awsKeyId; }

    public static String getAwsSecretKey() {
        return awsSecretKey;
    }

}
