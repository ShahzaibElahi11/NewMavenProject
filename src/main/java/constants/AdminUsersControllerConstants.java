package constants;

import utils.BaseTest;

public class AdminUsersControllerConstants extends BaseTest {

    public static final String ADMIN_USER_ENDPOINT = "/adminUsers/";
    public static final String CREATE_ADMIN_USER = "createUser";
    public static final String GET_ALL_ADMIN_USER = "getAllAdminUsers";
    public static final String ADMIN_USER_DETAILS = "getAdminUserDetail?_id=";
    public static final String UPDATE_ADMIN_USER = "updateUser?id=";
    public static final String DELETE_ADMIN_USER = "deleteAdminUser?_id=";
    public static final String ALL_ADMIN_USERNAME = "getAllUsername";
    public static final String ADMIN_USER_SAVED_VIEW = "getUserSavedView";
    public static final String ADMIN_USER_CHANGE_PASSWORD = "changePassword";

    public static final String GET_ADMIN_USER_ID = BASE_ENDPOINT + ":" + INVENTA_PORT + "/adminUsers/getAllAdminUsers?page=0&size=1&sort=dateCreated,desc";
    public static final String DELETE_ADMIN_USER_ID = BASE_ENDPOINT + ":" + INVENTA_PORT + "/adminUsers/getAllAdminUsers?page=0&size=1&sort=dateModified,desc";
    public static final String PAGINATION_PARAMETER = "?page=0&size=100";

    private AdminUsersControllerConstants() { }
}
