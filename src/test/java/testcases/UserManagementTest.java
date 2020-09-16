package testcases;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import models.usermanagement.AdminUser;
import models.usermanagement.Login;
import models.usermanagement.Role;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import utils.ApplicationConfiguration;
import utils.BaseTest;

import java.io.IOException;
import java.util.Collections;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.apache.http.HttpStatus.*;


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
        given().
                spec(requestSpec).
                when().
                get(PERMISSION_ENDPOINT + GET_ALL_PERMISSION).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Permission Details By Id")
    public void getPermissionDetails() {
        given().
                spec(requestSpec).
                when().
                get(PERMISSION_ENDPOINT + PERMISSION_DETAILS + PERMISSION_ID).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get All Modules List")
    public void getAllModules() {
        given().
                spec(requestSpec).
                when().
                get(PERMISSION_ENDPOINT + GET_ALL_MODULES).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Role Modules By ADMIN Detail")
    public void getRoleModules() {
        given().
                spec(requestSpec).
                when().
                get(PERMISSION_ENDPOINT + GET_ROLE_MODULES + "ADMIN").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Role Permission By Role")
    public void getRolePermission() {
        given().
                spec(requestSpec).
                when().
                get(PERMISSION_ENDPOINT + GET_ROLE_PERMISSION + "dashboard&role=ADMIN").
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get User Modules Details By User Id")
    public void getUserModules() {
        given().
                spec(requestSpec).
                when().
                get(PERMISSION_ENDPOINT + GET_USER_MODULES + ADMIN_USER_ID).
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Post Application Login")
    public void postLogin() {
        Login login = new Login(USERNAME, PASSWORD);
        given().
                spec(requestSpec).
                and().
                body(login).
                when().
                post("/login").
                then().
                assertThat().
                body("username", equalTo("admininventa")).
                statusCode(SC_OK);
    }

    @Test
    @Title("Create New User in the Application")
    public void testA_PostCreateUser() {
        isPreviousTestPass = false;
        AdminUser adminUser =  AdminUser.builder()
                .emailAddress(emailAddress)
                .phone(phoneNumber)
                .userName(userName)
                .firstName(firstName)
                .lastName(lastName)
                .password("password123")
                .passwordConfirm("password123")
                .roleIds(ADMIN_ROLE_ID)
                .userType("OPERATOR")
                .status(true)
                .build();


        Response response = given().
                spec(requestSpec).
                and().
                body(adminUser).
                when().
                post(ADMIN_USER_ENDPOINT + CREATE_ADMIN_USER);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Update User Information")
    public void testB_PutUpdateAdminUser() throws IOException {
        String CURRENT_ADMIN_USER_ID = "";
        CURRENT_ADMIN_USER_ID = getIdFromURL("http://inventaserver:9092/adminUsers/getAllAdminUsers?page=0&size=1&sort=dateCreated,desc");

        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        AdminUser adminUser = AdminUser.builder()
                ._id(CURRENT_ADMIN_USER_ID)
                .emailAddress(emailAddress)
                .phone(phoneNumber)
                .userName(userName)
                .firstName("Update "+firstName)
                .lastName(lastName)
                .password("password123")
                .passwordConfirm("password123")
                .roleIds(ADMIN_ROLE_ID)
                .userType("OPERATOR")
                .status(true)
                .build();

        Response response = given().
                spec(requestSpec).
                and().
                body(adminUser).
                when().
                put(ADMIN_USER_ENDPOINT + UPDATE_ADMIN_USER + CURRENT_ADMIN_USER_ID);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec);

    }

    @Test
    @Title("Get Admin User Details By Id")
    public void testC_getAdminUserDetail() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = given().
                spec(requestSpec).
                when().
                get(ADMIN_USER_ENDPOINT + ADMIN_USER_DETAILS + ADMIN_USER_ID);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec).
                body("data._id", equalTo(ADMIN_USER_ID));
    }

    @Test
    @Title("Delete User Information")
    public void testD_DeleteAdminUser() throws IOException {
        String CURRENT_DELETE_ADMIN_USER_ID  = "";
        CURRENT_DELETE_ADMIN_USER_ID = getIdFromURL("http://inventaserver:9092/adminUsers/getAllAdminUsers?page=0&size=1&sort=dateModified,desc");

                given().
                spec(requestSpec).
                when().
                delete(ADMIN_USER_ENDPOINT + DELETE_ADMIN_USER + CURRENT_DELETE_ADMIN_USER_ID).
                then().
                assertThat().
                statusCode(SC_OK);

    }

    @Test
    @Title("Get All Admin User List")
    public void testE_getAllAdminUser() {
        given().
                spec(requestSpec).
                when().
                get(ADMIN_USER_ENDPOINT + GET_ALL_ADMIN_USER + PAGINATION_PARAMETER).
                then().
                spec(responseSpec).
                and().
                body("data.content[0].userName", equalTo("admininventa"));
    }

    @Test
    @Title("Get All Admin User Name")
    public void testF_getAllAdminUserName() {
        given().
                spec(requestSpec).
                when().
                get(ADMIN_USER_ENDPOINT + ALL_ADMIN_USERNAME).
                then().
                spec(responseSpec).
                and().
                body("data.username[0]", equalTo("admininventa"));
    }

    @Test
    @Title("Post Create Role")
    public void testG_postCreateRole() {
        isPreviousTestPass = false;
        Role role = new Role("Automation_Role_" + value + "1", "This is Test Role Created By new Regression Script", true, "Automation Script", Collections.singletonList(PERMISSION_ID));
        Response response = given().
                spec(requestSpec).
                and().
                body(role).
                when().
                post(ROLE_ENDPOINT + CREATE_ROLE);

        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec);
    }

    @Test
    @Title("Get Role Details By Id")
    public void testH_getRoleDetails() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = given().
                spec(requestSpec).
                when().
                get(ROLE_ENDPOINT + ROLE_DETAILS + ROLE_ID);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec).
                and().
                body("data._id", equalTo(ROLE_ID));

    }

    @Test
    @Title("Put Update Role By Id")
    public void testI_putUpdateRole() throws IOException {
        String CURRENT_ROLE_ID = "";
        CURRENT_ROLE_ID = getIdFromURL("http://inventaserver:9092/role/getAllRole?page=0&size=1&sort=dateCreated,desc");

        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Role role = new Role("Update_Automation_Role_" + value + "1", "Updated By Regression new Script", true, "Automation Script", Collections.singletonList(PERMISSION_ID), CURRENT_ROLE_ID);
        Response response = given().
                spec(requestSpec).
                and().
                body(role).
                when().
                put(ROLE_ENDPOINT + UPDATE_ROLE + CURRENT_ROLE_ID);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec);
    }
    @Test
    @Title("Delete Role")
    public void testJ_deleteRole() throws IOException {
        String CURRENT_DELETE_ROLE_ID = "";
        CURRENT_DELETE_ROLE_ID = getIdFromURL("http://inventaserver:9092/role/getAllRole?page=0&size=1&sort=dateModified,desc");

        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = given().
                spec(requestSpec).
                when().
                delete(ROLE_ENDPOINT + DELETE_ROLE + CURRENT_DELETE_ROLE_ID);

        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                assertThat().
                statusCode(SC_OK);
//                and().
//                body("data.message", equalTo("Delete Success"));

    }

    @Test
    @Title("Get All Role List")
    public void testK_getAllRole() {
        given().
                spec(requestSpec).
                when().
                get(ROLE_ENDPOINT + GET_ALL_ROLE).
                then().
                spec(responseSpec);
    }


}
