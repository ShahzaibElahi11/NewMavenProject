package testcases;

import api.UserManagement;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.http.HttpStatus;

import models.usermanagement.AdminUser;
import models.usermanagement.Login;
import models.usermanagement.Role;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import utils.ApplicationConfiguration;
import utils.BaseAPI;
import utils.BaseTest;

import java.io.IOException;
import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static utils.BaseAPI.getIdFromPermissionURL;
import static utils.BaseAPI.getIdFromURL;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserManagementTest extends BaseTest {

    //Fake Class
    Faker faker = new Faker();
    protected final String userName = faker.name().username();

    protected final String firstName = faker.name().firstName();
    protected final String lastName = faker.name().lastName();
    protected final String emailAddress = faker.internet().emailAddress();
    protected final String phoneNumber = faker.phoneNumber().cellPhone();
    protected final String randomNnumber = String.valueOf(faker.number().randomNumber()); //will use later.

    protected static final String USERNAME = ApplicationConfiguration.getUSERNAME();
    protected static final String PASSWORD = ApplicationConfiguration.getPASSWORD();
    public static boolean isPreviousTestPass;

    @Test
    @Title("Get All Permission")
    public void getAllPermission() {
        Response response = UserManagement.getAllPermission();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Permission Details By Id")
    public void getPermissionDetails() {
        Response response = UserManagement.getPermissionDetails();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get All Modules List")
    public void getAllModules() {

        Response response = UserManagement.getAllModules();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Role Modules By ADMIN Detail")
    public void getRoleModules() {
        Response response = UserManagement.getRoleModules();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get Role Permission By Role")
    public void getRolePermission() {
        Response response = UserManagement.getRolePermission();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Get User Modules Details By User Id")
    public void getUserModules() {
        Response response = UserManagement.getUserModules();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }

    @Test
    @Title("Post Application Login")
    public void postLogin() {
        Login login = new Login(USERNAME, PASSWORD);
        Response response = UserManagement.postLogin(login);
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json;charset=ISO-8859-1"))
                .body("username", equalTo("admininventa"));
    }

    @Test
    @Title("Create New User in the Application")
    public void testA_PostCreateUser() {
        isPreviousTestPass = false;
        AdminUser adminUser = new AdminUser.Builder()
                .setEmailAddress(emailAddress)
                .setPhone(phoneNumber)
                .setUserName(userName)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPassword("password123")
                .setPasswordConfirm("password123")
                .setRoleIds(ADMIN_ROLE_ID)
                .setUserType("OPERATOR")
                .setStatus(true)
                .build();
        Response response = UserManagement.postCreateUser(adminUser);
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Update User Information")
    public void testB_PutUpdateAdminUser() throws IOException {

        String CURRENT_ADMIN_USER_ID = "";

        CURRENT_ADMIN_USER_ID = getIdFromURL("http://inventaserver:9092/adminUsers/getAllAdminUsers?page=0&size=1&sort=dateCreated,desc");

        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        AdminUser adminUser = new AdminUser.Builder()
                .set_id(CURRENT_ADMIN_USER_ID)
                .setEmailAddress(emailAddress)
                .setPhone(phoneNumber)
                .setUserName(userName)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPassword("password123")
                .setPasswordConfirm("password123")
                .setRoleIds(ADMIN_ROLE_ID)
                .setUserType("OPERATOR")
                .setStatus(true)
                .build();

        Response response = UserManagement.updateAdminUser(adminUser);
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Admin User Details By Id")
    public void testC_getAdminUserDetail() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = UserManagement.getAdminUserDetail();
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data._id", equalTo(ADMIN_USER_ID), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Delete User Information")
    public void testD_DeleteAdminUser() throws IOException {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = UserManagement.deleteAdminUser();
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get All Admin User List")
    public void testE_getAllAdminUser() {
        Response response = UserManagement.getAllAdminUser();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data.content[0].userName", equalTo("admininventa"), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Get All Admin User Name")
    public void testF_getAllAdminUserName() {
        Response response = UserManagement.getAllAdminUserName();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data.username[0]", equalTo("admininventa"), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Post Create Role")
    public void testG_postCreateRole() {
        isPreviousTestPass = false;
        Role role = new Role("Automation_Role_" + value + "1", "This is Test Role Created By new Regression Script", true, "Automation Script", Collections.singletonList(PERMISSION_ID));
        Response response = UserManagement.postCreateRole(role);
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get Role Details By Id")
    public void testH_getRoleDetails() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = UserManagement.getRoleDetails();
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data._id", equalTo(ROLE_ID), "meta.status", equalTo("success"));
    }

    @Test
    @Title("Put Update Role By Id")
    public void testI_putUpdateRole() throws IOException {

        String CURRENT_ROLE_ID = "";

        CURRENT_ROLE_ID = getIdFromURL("http://inventaserver:9092/role/getAllRole?page=0&size=1&sort=dateCreated,desc");
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Role role = new Role("Update_Automation_Role_" + value + "1", "Updated By Regression new Script", true, "Automation Script", Collections.singletonList(PERMISSION_ID), CURRENT_ROLE_ID);
        Response response = UserManagement.updateRole(role);
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    @Title("Delete Role")
    public void testJ_deleteRole() throws IOException {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = UserManagement.deleteRole();
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data.message", equalTo("Delete Success"), "meta.status", equalTo("success"));

    }

    @Test
    @Title("Get All Role List")
    public void testK_getAllRole() {
        Response response = UserManagement.getAllRole();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("meta.status", equalTo("success"));
    }


}
