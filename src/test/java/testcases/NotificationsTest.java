package testcases;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseTest;

import java.io.IOException;

import static constants.NotificationControllerConstants.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

@RunWith(SerenityRunner.class)
public class NotificationsTest extends BaseTest {

    @Test
    @Title("Get All Notification")
    public void getAllNotifications() {
        given().
                spec(requestSpec).
                when().
                get(NOTIFICATION).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Notification by Id")
    public void getNotificationById() throws IOException {
        String notificationId;
        notificationId = getIdFromURL(NOTIFICATION_QUERY);
        given().
                spec(requestSpec).
                when().
                get(NOTIFICATION + notificationId).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Unread Notification Count")
    public void getUnreadNotificationCount() {
        given().
                spec(requestSpec).
                when().
                get(NOTIFICATION + UNREAD_NOTIFICATION_COUNT).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Mark All Read Notification")
    public void getMarkAllReadNotification() {
        given().
                spec(requestSpec).
                when().
                get(NOTIFICATION + READ_NOTIFICATION).
                then().
                assertThat().
                statusCode(SC_OK);
    }

    @Test
    @Title("Get Top Notification")
    public void geTopNotifications() {
        given().
                spec(requestSpec).
                when().
                get(NOTIFICATION + TOP_NOTIFICATION).
                then().
                spec(responseSpec);
    }


}
