package testcases;

import api.PolicyRoutineApis;
import io.restassured.response.Response;
import models.policyroutine.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import utils.BaseClass;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PolicyRoutineTest extends BaseClass {

    public static boolean isPreviousTestPass;

    //Update Post Method Using Builder Class
    @Test
    public void testA_PostCreatePolicyRoutine() {
        isPreviousTestPass = false;
        PolicyRoutineProperties policyRoutineProperties = new PolicyRoutineProperties.Builder()
            .setUsername("test")
            .setPassword("password123")
            .build();
        PolicyRoutineMainAction policyRoutineMainAction = new PolicyRoutineMainAction.Builder()
                .setAction("RC02")
                .setProperties(policyRoutineProperties)
                .build();
        PolicyRoutine policyRoutine = new PolicyRoutine.Builder()
                .setName("Automation Policy Routine # "+value)
                .setMainAction(policyRoutineMainAction)
                .build();
        Response response = PolicyRoutineApis.postPolicyRoutine(policyRoutine);
        if(response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }


    @Test
    public void testB_PutPolicyRoutineNew(){
        Assume.assumeTrue(isPreviousTestPass==true);
        isPreviousTestPass = false;
        PolicyRoutineProperties policyRoutineProperties = new PolicyRoutineProperties.Builder()
                .setUsername("test")
                .setPassword("password123")
                .build();
        PolicyRoutineMainAction policyRoutineMainAction = new PolicyRoutineMainAction.Builder()
                .setAction("RC02")
                .setProperties(policyRoutineProperties)
                .build();
        PolicyRoutine policyRoutine = new PolicyRoutine.Builder()
                .setName("Update1_Automation Policy Routine # "+value)
                .setMainAction(policyRoutineMainAction)
                .build();
        Response response = PolicyRoutineApis.updatePolicyRoutine(policyRoutine);
        if(response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }


    @Test
    public void testC_DeletePolicyRoutine() {
        Assume.assumeTrue(isPreviousTestPass==true);
        isPreviousTestPass = false;
        Response response = PolicyRoutineApis.deletePolicyRoutine();
        if(response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetPolicyRoutineAllData() {

        Response response = PolicyRoutineApis.getPolicyRoutineAllData();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }


    @Test
    public void GetPolicyRoutineActions() {
        Response response = PolicyRoutineApis.getPolicyRoutineActions();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetPolicyRoutineDeviceActions() {
        Response response = PolicyRoutineApis.getPolicyRoutineDeviceActions();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }


    @Test
    public void GetPolicyRoutineUserActions() {
        Response response = PolicyRoutineApis.getPolicyRoutineUserActions();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetPolicyRoutineTable(){
        Response response = PolicyRoutineApis.getPolicyRoutineTable();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }


    @Test
    public void GetPolicyRoutineTableWithFilter(){
        Response response = PolicyRoutineApis.getPolicyRoutineTableWithFilter();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetPolicyRoutineSummary(){
        Response response = PolicyRoutineApis.getPolicyRoutineSummary();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }


    @Test
    public void PostEnforcePolicyOnDevice() {
        EnforcePolicyOnDevice enforcePolicyOnDevice = new EnforcePolicyOnDevice("MSEDGEWIN10-5.inventa12.com");

        Response response = PolicyRoutineApis.postEnforcePolicyDevice(enforcePolicyOnDevice);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void PostEnforcePolicyOnUser() {

        EnforcePolicyOnUser enforcePolicyOnUser = new EnforcePolicyOnUser("filyas@netpace.com");
        Response response = PolicyRoutineApis.postEnforcePolicyUser(enforcePolicyOnUser);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetActionsPair(){
        Response response = PolicyRoutineApis.getActionsPair();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetPolicyRoutineById(){
        Response response = PolicyRoutineApis.getPolicyRoutineById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }


}
