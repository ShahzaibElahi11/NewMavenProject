package testcases;

import api.AuditLogs;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseClass;

@RunWith(SerenityRunner.class)
public class UserAuditLogsTest extends BaseClass {

    @Test
    public void GetUserAudit(){
        Response response = AuditLogs.getUserAudit();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetAuditDetail(){

        Response response = AuditLogs.getAuditDetail();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetAllUserAuditList(){

        Response response = AuditLogs.getAllUserAuditList();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetAllUsersName(){

        Response response = AuditLogs.getAllUsersName();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }


}
