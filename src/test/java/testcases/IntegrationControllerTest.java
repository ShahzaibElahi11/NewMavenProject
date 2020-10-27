package testcases;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseTest;

import static constants.GeneralControllerConstants.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;

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
                statusCode(SC_OK);
    }
}
