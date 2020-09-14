package utils;


import java.io.IOException;

import static utils.BaseAPI.getIdFromPermissionURL;
import static utils.BaseAPI.getIdFromURL;

public class BaseTest {

    //I will Create Base Test in this Class

    public static String DEVICE_DETAIL_ID;
    public static String ROLE_ID;
    public static String PR_ID;
    public static String USER_ID;
    public static String ADMIN_USER_ID;
    public static String PERMISSION_ID;
    public static String ADMIN_ROLE_ID = "";


    static {
        try {
            DEVICE_DETAIL_ID = getIdFromURL("http://inventaserver:9092/devices/getAllDevices?page=0&size=1&sortBy=_id");
            ROLE_ID = getIdFromURL("http://inventaserver:9092/role/getAllRole?page=0&size=1&sort=dateCreated,desc");
            PR_ID = getIdFromURL("http://inventaserver:9092/policy-routine/?page=0&size=1&sort=dateCreated,desc");
            USER_ID = getIdFromURL("http://inventaserver:9092/users/getAllUsers/?page=0&size=1&sort=dateCreated,desc");
            ADMIN_USER_ID = getIdFromURL("http://inventaserver:9092/adminUsers/getAllAdminUsers?page=0&size=1&sort=dateCreated,desc");
            PERMISSION_ID = getIdFromPermissionURL("http://inventaserver:9092/permission/getAllPermission");
            ADMIN_ROLE_ID = getIdFromURL("http://inventaserver:9092/role/getAllRole?page=0&size=1");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int value = BaseAPI.value;



}


