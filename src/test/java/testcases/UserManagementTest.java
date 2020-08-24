package testcases;

import api.UserManagement;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
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
    @Title("Post Create Role")
    public void postCreateRole(){
        Role role = new Role("Automation_Role_"+value+"1", "This is Test Role Created By new Regression Script", true, "Automation Script", Collections.singletonList(PERMISSION_ID));
        Response response = UserManagement.postCreateRole(role);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }
    @Test
    @Title("Get All Role List")
    public void getAllRole() {
        Response response = UserManagement.getAllRole();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }


    @Ignore
    @Test
    @Title("Put Update Role By Id")
    public void putUpdateRole(){
        Role role = new Role("Update_Automation_Role_"+value+"1", "Updated By Regression new Script", true, "Automation Script", Collections.singletonList(PERMISSION_ID));
        Response response = UserManagement.updateRole(role);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Role Details By Id")
    public void getRoleDetails() {
        Response response = UserManagement.getRoleDetails();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Ignore
    @Test
    @Title("Delete Role")
    public void deleteRole() throws IOException {
        //exception: role associate with user
        HttpDelete delete = new HttpDelete(BASE_ENDPOINT_INVENTA + ROLE_ENDPOINT + DELETE_ROLE + "5f2977fde4aa4d358de5ee3f")  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    @Title("Get All Permission")
    public void getAllPermission() {
        Response response = UserManagement.getAllPermission();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Permission Details By Id")
    public void getPermissionDetails() {
        Response response = UserManagement.getPermissionDetails();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Ignore
    @Test
    @Title("Get Permission Details By Id")
    public void deletePermission() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT_INVENTA + PERMISSION_ENDPOINT + DELETE_PERMISSION + "5f22b8856d329947e1949a19")  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, HttpStatus.SC_OK);
    }

    @Test
    @Title("Get All Modules List")
    public void getAllModules() {

        Response response = UserManagement.getAllModules();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Role Modules By ADMIN Detail")
    public void getRoleModules() {
        Response response = UserManagement.getRoleModules();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }
    @Test
    @Title("Get Role Permission By Role")
    public void getRolePermission() {
        Response response = UserManagement.getRolePermission();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get User Modules Details By User Id")
    public void getUserModules() {
        Response response = UserManagement.getUserModules();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Post Application Login")
    public void postLogin() {
        Login login = new Login(USERNAME,PASSWORD);
        Response response = UserManagement.postLogin(login);
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }


    @Test
    @Title("Create New User in the Application")
    public void testA_PostCreateUser(){
        isPreviousTestPass = false;

        AdminUser adminUser = new AdminUser.Builder()
                .setEmailAddress(emailAddress)
                .setPhone(phoneNumber)
                .setUserName(userName)
                .setFirstName(firstName)
                .setLastName(lastName)
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
    @Title("Update User Information")
    public void testB_PutUpdateAdminUser(){
        Assume.assumeTrue(isPreviousTestPass==true);
        isPreviousTestPass = false;
        AdminUser adminUser = new AdminUser.Builder()
                .set_id(ADMIN_USER_ID)
                .setEmailAddress(emailAddress)
                .setPhone(phoneNumber)
                .setUserName(userName)
                .setFirstName(firstName)
                .setLastName(lastName)
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
    @Title("Delete User Information")
    public void testC_DeleteAdminUser(){
        Assume.assumeTrue(isPreviousTestPass==true);
        isPreviousTestPass = false;
        Response response = UserManagement.deleteAdminUser();
        if(response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get All Admin User List")
    public void getAllAdminUser() {
        Response response = UserManagement.getAllAdminUser();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Get Admin User Details By Id")
    public void getAdminUserDetail() {
        Response response = UserManagement.getAdminUserDetail();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }


    @Test
    @Title("Get All Admin User Name")
    public void getAllAdminUserName(){
        Response response = UserManagement.getAllAdminUserName();
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

}
