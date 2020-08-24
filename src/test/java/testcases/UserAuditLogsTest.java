package testcases;

import api.AuditLogs;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.BaseClass;

@RunWith(SerenityRunner.class)
public class UserAuditLogsTest extends BaseClass {

    @Test
    @Title("Get User Audit Details By UserName")
    public void getUserAudit(){
        Response response = AuditLogs.getUserAudit();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get User Audit Details By Id")
    public void getAuditDetail(){

        Response response = AuditLogs.getAuditDetail();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get User Audit Details List")
    public void getAllUserAuditList(){

        Response response = AuditLogs.getAllUserAuditList();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Username List of User Audit")
    public void getAllUsersName(){

        Response response = AuditLogs.getAllUsersName();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }


}
