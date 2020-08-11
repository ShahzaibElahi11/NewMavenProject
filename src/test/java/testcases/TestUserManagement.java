package testcases;

import api.UserManagementApis;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import models.usermanagement.AdminUser;
import models.usermanagement.Login;
import models.usermanagement.Role;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import utils.ApplicationConfiguration;
import utils.BaseClass;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestUserManagement extends BaseClass {
    public static final String ROLE_ENDPOINT = "/role/";

    public static final String DELETE_ROLE = "deleteRole?id=";

    public static final String PERMISSION_ENDPOINT = "/permission/";

    public static final String UPDATE_PERMISSION = "updatePermission?id=";
    public static final String DELETE_PERMISSION  = "deletePermission?id=";


    public final static String ADMIN_USER_ENDPOINT = "/adminUsers/";

    public static final String UPDATE_ADMIN_USER = "updateUser?id=";
    public static final String DELETE_ADMIN_USER  = "deleteAdminUser?_id=";


    protected static final String USERNAME = ApplicationConfiguration.getUSERNAME();
    protected static final String PASSWORD = ApplicationConfiguration.getPASSWORD();



    @Test
    public  void PostCreateRole(){
        Role role = new Role("Automation_Role_"+value+"1", "This is Test Role Created By new Regression Script", true, "Automation Script", Collections.singletonList(PERMISSION_ID));
        Response response = UserManagementApis.postCreateRole(role);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));


    }
    @Test
    public void GetAllRole() {
        Response response = UserManagementApis.getAllRole();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }


    @Ignore
    @Test
    public void PutUpdateRole(){
        Role role = new Role("Update_Automation_Role_"+value+"1", "Updated By Regression new Script", true, "Automation Script", Collections.singletonList(PERMISSION_ID));
        Response response = UserManagementApis.updateRole(role);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));

    }

    @Test
    public void GetRoleDetails() {

        Response response = UserManagementApis.getRoleDetails();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
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

        Response response = UserManagementApis.getAllPermission();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetPermissionDetails() {

        Response response = UserManagementApis.getPermissionDetails();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Ignore
    @Test
    public void DeletePermission() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT_INVENTA + PERMISSION_ENDPOINT + DELETE_PERMISSION + "5f22b8856d329947e1949a19")  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetAllModules() {

        Response response = UserManagementApis.getAllModules();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetRoleModules() {
        Response response = UserManagementApis.getRoleModules();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }
    @Test
    public void GetRolePermission() {
        Response response = UserManagementApis.getRolePermission();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetUserModules() {
        Response response = UserManagementApis.getUserModules();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }


    @Test
    public void PostLogin() {
        Login login = new Login(USERNAME,PASSWORD);
        Response response = UserManagementApis.postLogin(login);
        assertThat(response.getStatusCode(), equalTo(200));
    }


    @Test
    public void PostCreateUser(){
        AdminUser adminUser = new AdminUser( "Automation"+value+"1@gmail.com", "000"+value+"333", "AutomationUser1"+value+"1", "password123", "password123", ROLE_ID, "firstName"+value+"1", "lastName"+value+"1", "OPERATOR");
        Response response = UserManagementApis.postCreateUser(adminUser);
        assertThat(response.getStatusCode(), equalTo(200));

    }
    @Test
    public void GetAllAdminUser() {
        Response response = UserManagementApis.getAllAdminUser();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }

    @Test
    public void GetAdminUserDetail() {
        Response response = UserManagementApis.getAdminUserDetail();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }
    @Ignore
    @Test
    public void PutUpdateAdminUser()throws IOException {

        HttpPut request = new HttpPut(BASE_ENDPOINT_INVENTA + ADMIN_USER_ENDPOINT + UPDATE_ADMIN_USER + ADMIN_USER_ID);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{ \"emailAddress\": \"automation1"+value+"@gmail.com\", \"phone\":\"11"+value+"\", \"userName\":\"UpdateUser_"+value+"\", \"password\":\"password123\", \"passwordConfirm\":\"password123\", \"roleIds\":\"5eebacdbf3f21b3706abf17a\", \"firstName\": \"Update_Name_"+value+" \", \"lastName\": \"User\"}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }
    @Ignore
    @Test
    public void DeleteAdminUser() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT_INVENTA + ADMIN_USER_ENDPOINT + DELETE_ADMIN_USER + "pls insert id")  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetAllAdminUserName() throws IOException {

        Response response = UserManagementApis.getAllAdminUserName();
        assertThat(response.getStatusCode(),equalTo(HttpStatus.SC_OK));

    }

}
