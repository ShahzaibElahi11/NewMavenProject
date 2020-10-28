package testcases;

import io.restassured.response.Response;
import models.systemconfiguration.EmailConfiguration;
import models.systemconfiguration.GuiConfiguration;
import models.systemconfiguration.SetUserColumns;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import utils.ApplicationConfiguration;
import utils.BaseTest;

import java.util.Collections;

import static constants.ConfigControllerConstants.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConfigControllerTest extends BaseTest {

    public static boolean isPreviousTestPass;

    protected static final String EMAIL_HOST = ApplicationConfiguration.getEmailHost();
    protected static final int EMAIL_PORT =  Integer.parseInt(ApplicationConfiguration.getEmailPort());
    protected static final String EMAIL_USERNAME = ApplicationConfiguration.getEmailUsername();
    protected static final String EMAIL_PASSWORD = ApplicationConfiguration.getEmailPassword();
    protected static final String SENDER_EMAIL = ApplicationConfiguration.getSenderEmail();

    @Test
    @Title("Post Email Configuration")
    public void testA_postEmailConfiguration() {
        isPreviousTestPass = false;

        EmailConfiguration emailConfiguration = EmailConfiguration.builder()
                .sendEmail(true)
                .emailHost(EMAIL_HOST)
                .port(EMAIL_PORT)
                .username(EMAIL_USERNAME)
                .password(EMAIL_PASSWORD)
                .senderEmail(SENDER_EMAIL)
                .ssl(true)
                .build();

        Response response = given().
                spec(requestSpec).
                and().
                body(emailConfiguration).
                when().
                post(CONFIG_ENDPOINT);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                assertThat().
                statusCode(SC_OK);

    }


    @Test
    @Title("Get Email Setting Configuration")
    public void testB_getEmailConfiguration() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = given().
                spec(requestSpec).
                when().
                get(CONFIG_ENDPOINT +CONFIG_TYPE + MAIL);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec).
                body("data.username", equalTo(EMAIL_USERNAME));
    }

    @Test
    @Title("Post GUI Configuration")
    public void testC_postGuiConfiguration() {
        isPreviousTestPass = false;
        GuiConfiguration guiConfiguration = GuiConfiguration.builder()
                .refreshRate(195) //Refresh Data in seconds
                .displayPerPage(101) //Display Per Page
                .sessionIdleTimeout(31) //Session Idle Timeout in minutes
                .enableSessionTimeout(true)  //Enable session timeout
                .build();

        Response response = given().
                spec(requestSpec).
                and().
                body(guiConfiguration).
                when().
                post(CONFIG_ENDPOINT);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                assertThat().
                statusCode(SC_OK);

    }
    @Test
    @Title("Get GUI Setting Configuration")
    public void testD_getGuiConfiguration() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = given().
                spec(requestSpec).
                when().
                get(CONFIG_ENDPOINT +CONFIG_TYPE + GUI);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec).
                body("data.enableSessionTimeout", equalTo(true));

    }

    @Test
    @Title("Get Discovery Setting Configuration")
    public void getDiscoveryConfiguration() {

        given().
                spec(requestSpec).
                when().
                get(CONFIG_ENDPOINT + CONFIG_TYPE + DISCOVERY).
                then().
                spec(responseSpec);

    }

    /**
    //Remaining Data Retention and LifeCycle Time Test Case, Once Development complete I will cover

    // /config/resetUserColumns
    // /config/setUserColumns

    @Title("Put Set User Columns for Asset Page")
    public void testA_putSetUserColumnsForDevice() {
        SetUserColumns userColumns = SetUserColumns.builder()


                given().
                spec(requestSpec).
                and().
                body(userColumns).
                when().
                put("/config/setUserColumns?userId=5f991c16e8dad56c082bcdf4&fieldEntity=devices").
                then().
                assertThat().
                statusCode(SC_OK);

    }
    **/

}
