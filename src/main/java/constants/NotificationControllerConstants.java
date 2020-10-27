package constants;

import utils.BaseTest;

public class NotificationControllerConstants extends BaseTest {

    public static final String NOTIFICATION = "/notifications/";
    public static final String UNREAD_NOTIFICATION_COUNT = "count/unread";
    public static final String READ_NOTIFICATION = "mark/read";
    public static final String TOP_NOTIFICATION = "top";

    public static final String NOTIFICATION_QUERY = BASE_ENDPOINT + ":" + INVENTA_PORT + "/notifications/?page=0&size=1";

}
