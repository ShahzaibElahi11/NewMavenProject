package testcases;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseClass;
import static io.restassured.RestAssured.given;


@RunWith(SerenityRunner.class)
public class IntegrationControllerTest extends BaseClass {

    public static final String DOCKER_ENDPOINT = "/docker/";
    public static final String ACTIVE_MQ = "activemq";


    @Test
    @Title("Get Active MQ Connection")
    public void getActiveMQConnectivity(){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + DOCKER_ENDPOINT + ACTIVE_MQ);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }
}
