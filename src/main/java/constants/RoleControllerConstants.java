package constants;

import utils.BaseTest;

public class RoleControllerConstants extends BaseTest {

    /**
     * Role Controller Constants
     */
    public static final String ROLE_ENDPOINT = "/role/";
    public static final String CREATE_ROLE = "createRole";
    public static final String GET_ALL_ROLE = "getAllRole";
    public static final String ROLE_DETAILS = "getRoleDetail?id=";
    public static final String UPDATE_ROLE = "updateRole?id=";
    public static final String DELETE_ROLE = "deleteRole?id=";
    public static final String ROLE_DETAILS_BY_USER_ID = "getUserRole?userId=";

    public static final String GET_ROLE_ID = BASE_ENDPOINT + ":" + INVENTA_PORT + "/role/getAllRole?page=0&size=1";
    public static final String PUT_ROLE_ID = BASE_ENDPOINT + ":" + INVENTA_PORT + "/role/getAllRole?page=0&size=1&sort=dateCreated,desc";
    public static final String DELETE_ROLE_ID = BASE_ENDPOINT + ":" + INVENTA_PORT + "/role/getAllRole?page=0&size=1&sort=dateModified,desc";
    public static final String GET_ROLE_ID_FOR_USER = BASE_ENDPOINT + ":" + INVENTA_PORT + "/role/getAllRole?page=0&size=1";

}
