package testcases;

import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;
import utils.BaseClass;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class TestUserAuditLogs extends BaseClass {

    @Test
    public void GetUserAudit() throws IOException {
        //https://netpace.atlassian.net/browse/VIN-1268
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/audit/getUserAudit?username=admininventa");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetAuditDetail() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/audit/getAuditDetail?id=" + AUDIT_DETAIL_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetAllUserAuditList() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/audit/getAllAudit?page=0&size=100");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetAllUsersName() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/adminUsers/getAllUsername");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }


}
