package testcases;

import api.AuditApis;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;
import utils.BaseClass;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestUserAuditLogs extends BaseClass {

    @Test
    public void GetUserAudit(){
        Response response = AuditApis.getUserAudit();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }

    @Test
    public void GetAuditDetail(){

        Response response = AuditApis.getAuditDetail();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetAllUserAuditList(){

        Response response = AuditApis.getAllUserAuditList();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetAllUsersName(){

        Response response = AuditApis.getAllUsersName();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }


}
