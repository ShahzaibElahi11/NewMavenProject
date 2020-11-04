package constants;

import utils.BaseTest;

public class AuditControllerConstants extends BaseTest {

    /**
     * AuditLogs  Configuration Constant
     */
    public static final String AUDIT_ENDPOINT = "/audit/";
    public static final String USER_AUDIT = "getUserAudit?username=admininventa&page=0&size=1";
    public static final String AUDIT_DETAIL = "getAuditDetail?id=";
    public static final String ALL_USER_AUDIT_LIST = "getAllAudit?page=0&size=10";

    public static final String GET_AUDIT_ID = BASE_ENDPOINT + ":" + INVENTA_PORT + "/audit/getAllAudit?page=0&size=1&sort=dateCreated,desc";

    private AuditControllerConstants() { }
}
