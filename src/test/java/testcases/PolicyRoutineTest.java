package testcases;

import api.PolicyRoutines;
import io.restassured.response.Response;
import models.policyroutine.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
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
    @Title("Create New Policy Routine")
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
        Response response = PolicyRoutines.postPolicyRoutine(policyRoutine);
        if(response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }


    @Test
    @Title("Update Policy Routine")
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
        Response response = PolicyRoutines.updatePolicyRoutine(policyRoutine);
        if(response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }


    @Test
    @Title("Delete Policy Routine")
    public void testC_DeletePolicyRoutine() {
        Assume.assumeTrue(isPreviousTestPass==true);
        isPreviousTestPass = false;
        Response response = PolicyRoutines.deletePolicyRoutine();
        if(response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Display All Policy Routine Data")
    public void getPolicyRoutineAllData() {
        Response response = PolicyRoutines.getPolicyRoutineAllData();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }


    @Test
    @Title("Get Policy Routine Action")
    public void getPolicyRoutineActions() {
        Response response = PolicyRoutines.getPolicyRoutineActions();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Policy Routine Action on Devices")
    public void getPolicyRoutineDeviceActions() {
        Response response = PolicyRoutines.getPolicyRoutineDeviceActions();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }


    @Test
    @Title("Get Policy Routine Action on Users")
    public void getPolicyRoutineUserActions() {
        Response response = PolicyRoutines.getPolicyRoutineUserActions();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Policy Routine Table")
    public void getPolicyRoutineTable(){
        Response response = PolicyRoutines.getPolicyRoutineTable();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }


    @Test
    @Title("Get Policy Routine Table With Filter")
    public void getPolicyRoutineTableWithFilter(){
        Response response = PolicyRoutines.getPolicyRoutineTableWithFilter();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Policy Routine Summary")
    public void getPolicyRoutineSummary(){
        Response response = PolicyRoutines.getPolicyRoutineSummary();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }


    @Test
    @Title("Post Policy Routine Enforce on Devices")
    public void postEnforcePolicyOnDevice() {
        EnforcePolicyOnDevice enforcePolicyOnDevice = new EnforcePolicyOnDevice("MSEDGEWIN10-5.inventa12.com");
        Response response = PolicyRoutines.postEnforcePolicyDevice(enforcePolicyOnDevice);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Post Policy Routine Enforce on Users")
    public void postEnforcePolicyOnUser() {

        EnforcePolicyOnUser enforcePolicyOnUser = new EnforcePolicyOnUser("filyas@netpace.com");
        Response response = PolicyRoutines.postEnforcePolicyUser(enforcePolicyOnUser);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Policy Routine Action Pair")
    public void getActionsPair(){
        Response response = PolicyRoutines.getActionsPair();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Policy Routine Details By Id")
    public void getPolicyRoutineById(){
        Response response = PolicyRoutines.getPolicyRoutineById();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }


}
