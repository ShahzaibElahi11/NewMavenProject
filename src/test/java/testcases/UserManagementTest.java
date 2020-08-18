package testcases;

import api.UserManagement;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;

import models.usermanagement.AdminUser;
import models.usermanagement.Login;
import models.usermanagement.Role;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import utils.ApplicationConfiguration;
import utils.BaseClass;

import java.io.IOException;
import java.util.Collections;

import static junit.framework.TestCase.assertEquals;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserManagementTest extends BaseClass {
    public static final String ROLE_ENDPOINT = "/role/";

    public static final String DELETE_ROLE = "deleteRole?id=";

    public static final String PERMISSION_ENDPOINT = "/permission/";

    public static final String DELETE_PERMISSION  = "deletePermission?id=";


    protected static final String USERNAME = ApplicationConfiguration.getUSERNAME();
    protected static final String PASSWORD = ApplicationConfiguration.getPASSWORD();

    public static boolean isPreviousTestPass;



    @Test
    public  void PostCreateRole(){
        Role role = new Role("Automation_Role_"+value+"1", "This is Test Role Created By new Regression Script", true, "Automation Script", Collections.singletonList(PERMISSION_ID));
        Response response = UserManagement.postCreateRole(role);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }
    @Test
    public void GetAllRole() {
        Response response = UserManagement.getAllRole();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }


    @Ignore
    @Test
    public void PutUpdateRole(){
        Role role = new Role("Update_Automation_Role_"+value+"1", "Updated By Regression new Script", true, "Automation Script", Collections.singletonList(PERMISSION_ID));
        Response response = UserManagement.updateRole(role);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetRoleDetails() {

        Response response = UserManagement.getRoleDetails();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Ignore
    @Test
    public void DeleteRole() throws IOException {
        //exception: role associate with user
        HttpDelete delete = new HttpDelete(BASE_ENDPOINT_INVENTA + ROLE_ENDPOINT + DELETE_ROLE + "5f2977fde4aa4d358de5ee3f")  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetAllPermission() {

        Response response = UserManagement.getAllPermission();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetPermissionDetails() {

        Response response = UserManagement.getPermissionDetails();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Ignore
    @Test
    public void DeletePermission() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT_INVENTA + PERMISSION_ENDPOINT + DELETE_PERMISSION + "5f22b8856d329947e1949a19")  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, HttpStatus.SC_OK);
    }

    @Test
    public void GetAllModules() {

        Response response = UserManagement.getAllModules();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetRoleModules() {
        Response response = UserManagement.getRoleModules();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }
    @Test
    public void GetRolePermission() {
        Response response = UserManagement.getRolePermission();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void GetUserModules() {
        Response response = UserManagement.getUserModules();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }


    @Test
    public void PostLogin() {
        Login login = new Login(USERNAME,PASSWORD);
        Response response = UserManagement.postLogin(login);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }


    @Test
    public void testA_PostCreateUser(){
        isPreviousTestPass = false;

        AdminUser adminUser = new AdminUser.Builder()
                .setEmailAddress("1_Automation"+value+"1@gmail.com")
                .setPhone("000"+value+"333")
                .setUserName("AutomationUser1"+value+"1")
                .setFirstName("firstName "+randomString)
                .setLastName("lastName "+randomString)
                .setPassword("password123")
                .setPasswordConfirm("password123")
                .setRoleIds(ROLE_ID)
                .setUserType("OPERATOR")
                .setStatus(true)
                .build();
        Response response = UserManagement.postCreateUser(adminUser);
        if(response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void testB_PutUpdateAdminUser(){
        Assume.assumeTrue(isPreviousTestPass==true);
        isPreviousTestPass = false;
        AdminUser adminUser = new AdminUser.Builder()
                .set_id(ADMIN_USER_ID)
                .setEmailAddress("UpdateAutomation"+value+"1@gmail.com")
                .setPhone("000"+value+"333")
                .setUserName("UpdateUser1"+value+"1")
                .setFirstName("UpdatefirstName "+randomString)
                .setLastName("UpdatelastName "+randomString)
                .setPassword("password123")
                .setPasswordConfirm("password123")
                .setRoleIds(ROLE_ID)
                .setUserType("OPERATOR")
                .setStatus(true)
                .build();

        Response response = UserManagement.updateAdminUser(adminUser);
        if(response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);


    }
    @Test
    public void testC_DeleteAdminUser(){
        Assume.assumeTrue(isPreviousTestPass==true);
        isPreviousTestPass = false;
        Response response = UserManagement.deleteAdminUser();
        if(response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetAllAdminUser() {
        Response response = UserManagement.getAllAdminUser();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void GetAdminUserDetail() {
        Response response = UserManagement.getAdminUserDetail();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }


    @Test
    public void GetAllAdminUserName(){

        Response response = UserManagement.getAllAdminUserName();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

}
