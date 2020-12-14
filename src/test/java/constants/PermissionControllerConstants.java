package constants;

import utils.BaseTest;

public class PermissionControllerConstants extends BaseTest {


    public static final String PERMISSION_ENDPOINT = "/permission/";
    public static final String GET_ALL_PERMISSION = "getAllPermission";
    public static final String PERMISSION_DETAILS = "getPermissionDetail?id=";

    public static final String GET_ALL_MODULES = "getAllModules";
    public static final String GET_ROLE_MODULES = "getRoleModules?role=";
    public static final String GET_ROLE_PERMISSION = "getRolePermission?module=";
    public static final String GET_USER_MODULES = "getUserModules?userId=";
    public static final String USER_PERMISSION = "getUserPermission";

    public static final String GET_PERMISSION_ID = BASE_ENDPOINT + ":" + INVENTA_PORT + "/permission/getAllPermission";
    public static final String GET_DEVICE_ID = BASE_ENDPOINT + ":" + INVENTA_PORT + "/devices/getAllDevices?page=0&size=1&sortBy=_id";

    private PermissionControllerConstants() { }
}

