package constants;

import utils.BaseTest;

public class UserControllerConstants extends BaseTest {

    /**
     * Discover User Constants
     */

    public static final String USER_ENDPOINT = "/users/";
    public static final String PAGINATION = "?page=0&size=1&sort=dateCreated,desc";
    public static final String ALL_USERS = "getAllUsers";
    public static final String USER_DETAIL = "userDetail?_id=";
    public static final String USER_TAG = "getUserTag?userId=";
    public static final String USER_NOTE = "getUserNote?userId=";
    public static final String USER_GROUPS = "groups?_id=";
    public static final String USER_POLICIES = "policies?_id=";
    public static final String USER_COMMON_MENU = "getCommonMenu?userId=";

    public static final String DELETE_USER_SINGLE_TAG = "deleteSingleTag/?userId=";
    public static final String DELETE_USER_NOTE = "deleteNote?userId=";
    public static final String USER_NOTE_LIST = "getUserNoteList?userId=";


    public static final String GET_USER_ID = BASE_ENDPOINT + ":" + INVENTA_PORT + "/users/getAllUsers/?page=0&size=1&sort=dateCreated,desc";
    public static final String USER_NOTE_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/users/getUserNoteList?userId=";


    /**
     * Active Directory User Aggregated Tab Constant
     */
    public static final String AD_USER_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/query/users/?query=(adapters.adapter_ad.CN%20==%20exists(true))&page=0&size=1";

    private UserControllerConstants() { }
}
