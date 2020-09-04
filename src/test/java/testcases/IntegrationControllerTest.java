package testcases;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseTest;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;


@RunWith(SerenityRunner.class)
public class IntegrationControllerTest extends BaseTest {


    @Test
    @Title("Get Active MQ Connection")
    public void getActiveMQConnectivity() {
        given().
                spec(requestSpec).
                when().
                get(DOCKER_ENDPOINT + ACTIVE_MQ).
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK);
    }
}
