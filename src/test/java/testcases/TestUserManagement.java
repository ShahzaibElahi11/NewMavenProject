package testcases;

import api.Apis;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import models.AdminUser;
import models.Login;
import models.Role;
import utils.BaseClass;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class TestUserManagement extends BaseClass {
    public static final String ROLE_ENDPOINT = "/role/";
    public static final String CREATE_ROLE = "createRole";
    public static final String GET_ALL_ROLE = "getAllRole";
    public static final String ROLE_DETAILS = "getRoleDetail?id=";
    public static final String UPDATE_ROLE = "updateRole?id=";
    public static final String DELETE_ROLE = "deleteRole?id=";

    public static final String PERMISSION_ENDPOINT = "/permission/";
    public static final String CREATE_PERMISSION = "createPermission";
    public static final String GET_ALL_PERMISSION = "getAllPermission";
    public static final String PERMISSION_DETAILS = "getPermissionDetail?id=";
    public static final String UPDATE_PERMISSION = "updatePermission?id=";
    public static final String DELETE_PERMISSION  = "deletePermission?id=";

    public static final String GET_ALL_MODULES = "getAllModules";
    public static final String GET_ROLE_MODULES = "getRoleModules?role=";
    public static final String GET_ROLE_PERMISSION = "getRolePermission?module=";
    public static final String GET_USER_MODULES = "getUserModules?userId=";

    public final static String ADMIN_USER_ENDPOINT = "/adminUsers/";
    public static final String CREATE_ADMIN_USER = "createUser";
    public static final String GET_ALL_ADMIN_USER = "getAllAdminUsers";
    public static final String ADMIN_USER_DETAILS = "getAdminUserDetail?_id=";
    public static final String UPDATE_ADMIN_USER = "updateUser?id=";
    public static final String DELETE_ADMIN_USER  = "deleteAdminUser?_id=";
    public static final String ALL_ADMIN_USERNAME = "getAllUsername";


    public final static String LOGIN = "/login";
    public static final String PAGINATION_PARAMETER = "?page=0&size=100";



    @Test
    public void PostCreateRole()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + ROLE_ENDPOINT + CREATE_ROLE);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{ \"title\":\"AutomationRole_" + value + "\" , \"description\":\"This is Test Role Created By Regression Script \", \"status\":true, \"createdBy\":\"Automation Script\", \"permissionIds\":[\""+ PERMISSION_ID + "\"]}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public  void PostCreateRoleNew(){
        Role role = new Role("Automation_Role_"+value+"1", "This is Test Role Created By new Regression Script", true, "Automation Script", Collections.singletonList(PERMISSION_ID));
        Response response = Apis.postCreateRole(role);
        assertThat(response.getStatusCode(), equalTo(200));


    }
    @Test
    public void GetAllRole() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + ROLE_ENDPOINT + GET_ALL_ROLE);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void PutUpdateRole()throws IOException {

        HttpPut request = new HttpPut(BASE_ENDPOINT + ROLE_ENDPOINT + UPDATE_ROLE + ROLE_ID);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = " { \"title\": \"Role_Update_" + value + "\", \"description\": \"Role has been updated through old Automation.\", \"permissionIds\":[\""+ PERMISSION_ID +"\"]}";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void PutUpdateRoleNew(){
        Role role = new Role("Update_Automation_Role_"+value+"1", "Updated By Regression new Script", true, "Automation Script", Collections.singletonList(PERMISSION_ID));
        Response response = Apis.updateRole(role);
        assertThat(response.getStatusCode(), equalTo(200));

    }

    @Test
    public void GetRoleDetails() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + ROLE_ENDPOINT + ROLE_DETAILS + ROLE_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test(enabled = false)
    public void DeleteRole() throws IOException {
        //exception: role associate with user
        PostCreateRole();
        HttpDelete delete = new HttpDelete(BASE_ENDPOINT + ROLE_ENDPOINT + DELETE_ROLE + "5f2977fde4aa4d358de5ee3f")  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }


    @Test(enabled = false) //Currently not used in website as per siraj.
    public void PostCreatePermission()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + PERMISSION_ENDPOINT + CREATE_PERMISSION);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json ="{ \"title\": \"Auto_Permission_" + value + "\", \"description\": \"Create Permission through Automation.\", \"module\": \"dashboard\" }";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void GetAllPermission() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + PERMISSION_ENDPOINT + GET_ALL_PERMISSION);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetPermissionDetails() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + PERMISSION_ENDPOINT + PERMISSION_DETAILS + PERMISSION_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test(enabled = false) //Currently not used in website asp per siraj.
    public void PutUpdatePermission()throws IOException {

        HttpPut request = new HttpPut(BASE_ENDPOINT + PERMISSION_ENDPOINT + UPDATE_PERMISSION + PERMISSION_ID);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{ \"title\": \"UpdatePermission_" + value + "\", \"description\": \"Update Permission through Automation.\", \"module\": \"dashboard\" }";

        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test(enabled = false)
    public void DeletePermission() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT + PERMISSION_ENDPOINT + DELETE_PERMISSION + "5f22b8856d329947e1949a19")  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }


    /**
     * new added
     */

    @Test
    public void GetAllModules() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + PERMISSION_ENDPOINT + GET_ALL_MODULES);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetRoleModules() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + PERMISSION_ENDPOINT + GET_ROLE_MODULES + "ADMIN");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }
    @Test
    public void GetRolePermission() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + PERMISSION_ENDPOINT + GET_ROLE_PERMISSION +"dashboard&role=ADMIN");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetUserModules() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + PERMISSION_ENDPOINT + GET_USER_MODULES + ADMIN_USER_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }


    @Test
    public void PostLogin()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + LOGIN);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{\"username\":\"admininventa\",\"password\":\"admin\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void PostLoginNew() {
        Login login = new Login("admininventa", "admin");
        Response response = Apis.postLogin(login);
        assertThat(response.getStatusCode(), equalTo(200));
    }

    /**
     * Pending - not implement because of static value
     * localhost:9090/adminUsers/changeUserPassword
     */

    @Test
    public void PostCreateUser()throws IOException {

        HttpPost request = new HttpPost(BASE_ENDPOINT + ADMIN_USER_ENDPOINT + CREATE_ADMIN_USER);
        String auth = new String();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);

        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
        request.setHeader("Authorization", "Bearer " + token);

        String json = "{ \"emailAddress\": \"automation2"+value+"@gmail.com\", \"phone\":\"2"+value+"\", \"userName\":\"Automation_User_2"+value+"\", \"password\":\"password123\", \"passwordConfirm\":\"password123\", \"roleIds\":\""+ ROLE_ID +"\", \"firstName\": \"Automation_Test_User_Name_"+value+" \", \"lastName\": \"User\", \"userType\": \"OPERATOR\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        // Send
        response = client.execute(request);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void PostCreateUserNew(){
        AdminUser adminUser = new AdminUser( "Automation"+value+"@gmail.com", "000"+value+"333", "AutomationUser1"+value+"1", "password123", "password123", ROLE_ID, "firstName"+value+"1", "lastName"+value+"1", "OPERATOR");
        Response response = Apis.postCreateUser(adminUser);
        assertThat(response.getStatusCode(), equalTo(200));

    }
    @Test
    public void GetAllAdminUser() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + ADMIN_USER_ENDPOINT + GET_ALL_ADMIN_USER + PAGINATION_PARAMETER);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetAdminUserDetail() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + ADMIN_USER_ENDPOINT + ADMIN_USER_DETAILS + ADMIN_USER_ID);
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test(enabled = false)
    public void PutUpdateAdminUser()throws IOException {

        HttpPut request = new HttpPut(BASE_ENDPOINT + ADMIN_USER_ENDPOINT + UPDATE_ADMIN_USER + ADMIN_USER_ID);
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

    @Test(enabled = false)
    public void DeleteAdminUser() throws IOException {

        HttpDelete delete = new HttpDelete(BASE_ENDPOINT + ADMIN_USER_ENDPOINT + DELETE_ADMIN_USER + "pls insert id")  ;
        delete.setHeader("Authorization", "Bearer " + token);
        response = client.execute(delete);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }

    @Test
    public void GetAllAdminUserName() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + ADMIN_USER_ENDPOINT + ALL_ADMIN_USERNAME );
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }


    @Test
    public void GetUserAdaptersList() throws IOException {

        HttpGet get = new HttpGet("http://inventaserver:9092/role/getAllRole?page=0&size=1");
        get.setHeader("Authorization", "Bearer " + token);
        response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(actualStatus, 200);
    }
}
