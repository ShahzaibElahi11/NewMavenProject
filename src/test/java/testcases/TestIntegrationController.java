package testcases;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;
import utils.BaseClass;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestIntegrationController extends BaseClass {

    public static final String DOCKER_ENDPOINT = "/docker/";
    public static final String ACTIVE_MQ = "activemq";


    @Test
    public void GetActiveMQConnectivity(){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + DOCKER_ENDPOINT + ACTIVE_MQ);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));

    }

}
