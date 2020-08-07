package testcases;

import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;
import utils.BaseClass;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class TestIntegrationController extends BaseClass {

    public static final String DOCKER_ENDPOINT = "/docker/";
    public static final String ACTIVE_MQ = "activemq";
    public static final String MONGO = "mongo";


    @Test
    public void GetActiveMQConnectivity() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + DOCKER_ENDPOINT + ACTIVE_MQ);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test(enabled = false)
    public void GetMongoConnectivity() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + DOCKER_ENDPOINT + ACTIVE_MQ);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

}
