package testcases;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import models.usermanagement.AdminUser;
import models.usermanagement.ChangePassword;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import utils.BaseTest;

import java.io.IOException;

import static constants.AdminUsersControllerConstants.*;
import static constants.PermissionControllerConstants.USER_PERMISSION;
import static constants.RoleControllerConstants.GET_ROLE_ID_FOR_USER;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminUsersControllerTest extends BaseTest {

    public static boolean isPreviousTestPass;

    //Using Faker Library for generating data

    Faker faker = new Faker();
    protected final String userName = faker.name().username();
    protected final String firstName = faker.name().firstName();
    protected final String lastName = faker.name().lastName();
    protected final String emailAddress = faker.internet().emailAddress();
    protected final String phoneNumber = faker.phoneNumber().cellPhone();
    protected final String randomNnumber = String.valueOf(faker.number().randomNumber()); //will use later.


    /*******************************************************
     * Create a new Admin User object that represents a Inventa Application User
     * POST this object to /adminUsers/createUser
     * Fetch Role Id from /role/getAllRole
     * Verify that the response HTTP status code is equal to 200
     * Verify that the response Content Type  is equal to JSON
     * Verify that the response is in the Body Meta.Status is equal to Success
     ******************************************************/
    @Test
    @Title("Create New Admin User in the Application")
    public void testA_PostCreateUser() throws IOException {
        String adminRoleId;
        adminRoleId = getIdFromURL(GET_ROLE_ID_FOR_USER);

        isPreviousTestPass = false;
        AdminUser adminUser = AdminUser.builder()
                .emailAddress(emailAddress)
                .phone(phoneNumber)
                .userName(userName)
                .firstName(firstName)
                .lastName(lastName)
                .password("password123")
                .passwordConfirm("password123")
                .roleIds(adminRoleId)
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

    /*******************************************************
     * Update a newly Created Admin User object that represents a Inventa Application User
     * PUT this object to /adminUsers/updateUser?id=ID
     * Fetch Role Id from /role/getAllRole
     * Fetch Admin User Id from /adminUsers/getAllAdminUsers
     * Using assumeTrue to verify previous testCase Pass or Fail, if Previous test failed current test will be Skip.
     * Verify that the response HTTP status code is equal to 200
     * Verify that the response Content Type  is equal to JSON
     * Verify that the response is in the Body Meta.Status is equal to Success
     ******************************************************/
    @Test
    @Title("Update Newly User Information in the Application")
    public void testB_PutUpdateAdminUser() throws IOException {
        String currentAdminId;
        String adminRoleId;
        currentAdminId = getIdFromURL(GET_ADMIN_USER_ID);
        adminRoleId = getIdFromURL(GET_ROLE_ID_FOR_USER);

        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        AdminUser adminUser = AdminUser.builder()
                ._id(currentAdminId)
                .emailAddress(emailAddress)
                .phone(phoneNumber)
                .userName(userName)
                .firstName("Update " + firstName)
                .lastName(lastName)
                .password("password123")
                .passwordConfirm("password123")
                .roleIds(adminRoleId)
                .userType("OPERATOR")
                .status(true)
                .build();

        Response response = given().
                spec(requestSpec).
                and().
                body(adminUser).
                when().
                put(ADMIN_USER_ENDPOINT + UPDATE_ADMIN_USER + currentAdminId);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec);

    }

    /*******************************************************
     * Send a GET request to /adminUsers/getAdminUserDetail?_id=adminUserId
     * Fetch Admin User Id from /adminUsers/getAllAdminUsers
     * Using assumeTrue to verify previous testcase Pass or Fail, if previous test failed, so current test will be Skip.
     * and check that the response has HTTP status code 200
     * and check that the response is in JSON format
     * and check that the response is in the Body Meta.Status is equal to Success
     * and check that the latest created Admin User id associated with the in the list
     * returned is equal to 'adminUserId'
     ******************************************************/
    @Test
    @Title("Get Admin User Details By Id")
    public void testC_getAdminUserDetail() throws IOException {
        String adminUserId;
        adminUserId = getIdFromURL(GET_ADMIN_USER_ID);
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Response response = given().
                spec(requestSpec).
                when().
                get(ADMIN_USER_ENDPOINT + ADMIN_USER_DETAILS + adminUserId);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                spec(responseSpec).
                /*******************************************************
                 * Use a Hamcrest equalTo Method to verify that the data of
                 * the 1st id in the list equals newly created user id
                 ******************************************************/
                body("data._id", equalTo(adminUserId));
    }

    /*******************************************************
     * Update a newly Created Admin User Password that represents a Inventa Application User
     * PUT this object to /adminUsers/changePassword
     * Fetch Admin User Id from /adminUsers/getAllAdminUsers
     * Using assumeTrue to verify previous testcase Pass or Fail, if previous test failed, so current test will be Skip.
     * Verify that the response HTTP status code is equal to 200
     * Verify that the response Content Type  is equal to JSON
     * Verify that the response is in the Body Meta.Status is equal to Success
     ******************************************************/
    @Test
    @Title("Put Password Change of Newly Created User")
    public void testD_putPasswordChange() throws IOException {
        String currentAdminId;
        currentAdminId = getIdFromURL(GET_ADMIN_USER_ID);
        ChangePassword changePassword = ChangePassword.builder()
                .userId(currentAdminId)
                .newPassword("Pass123")
                .confirmPassword("Pass123")
                .build();
        given().
                spec(requestSpec).
                and().
                body(changePassword).
                when().
                put(ADMIN_USER_ENDPOINT + ADMIN_USER_CHANGE_PASSWORD).
                then().
                spec(responseSpec);

    }

    /*******************************************************
     * Delete a newly Created Admin User that represents a Inventa Application User
     * Delete this object to /adminUsers/deleteAdminUser?_id=
     * Verify that the response HTTP status code is equal to 200
     ******************************************************/
    @Test
    @Title("Delete Newly Created Admin User")
    public void testE_DeleteAdminUser() throws IOException {
        String currentDeleteAdminUserId;
        currentDeleteAdminUserId = getIdFromURL(DELETE_ADMIN_USER_ID);

        given().
                spec(requestSpec).
                when().
                delete(ADMIN_USER_ENDPOINT + DELETE_ADMIN_USER + currentDeleteAdminUserId).
                then().
                assertThat().
                statusCode(SC_OK);

    }

    /*******************************************************
     * Send a GET request to /adminUsers/getAllAdminUsers?page=0&size=100
     * and check that the response has HTTP status code 200
     * and check that the response is in JSON format
     * and check that the response is in the Body Meta.Status is equal to Success
     * and check that the username associated with the first place
     *  in the list returned is equal to 'admininventa'
     ******************************************************/
    @Test
    @Title("Get All Admin User List")
    public void testF_getAllAdminUser() {
        given().
                spec(requestSpec).
                when().
                get(ADMIN_USER_ENDPOINT + GET_ALL_ADMIN_USER + PAGINATION_PARAMETER).
                then().
                spec(responseSpec).
                and().
                /*******************************************************
                 * Use a Hamcrest equalTo method to verify that the content of
                 * the 1st UserName in the list equals 'admininventa'
                 ******************************************************/
                        body("data.content[0].userName", equalTo("admininventa"));
    }

    /*******************************************************
     * Send a GET request to /adminUsers/getAllUsername
     * and check that the response has HTTP status code 200
     * and check that the response is in JSON format
     * and check that the response is in the body Meta.Status is equal to Success
     * and check that the username associated with the first place
     *  in the list returned is equal to 'admininventa'
     ******************************************************/
    @Test
    @Title("Get All Admin User Name")
    public void testG_getAllAdminUserName() {
        given().
                spec(requestSpec).
                when().
                get(ADMIN_USER_ENDPOINT + ALL_ADMIN_USERNAME).
                then().
                spec(responseSpec).
                and().
                /*******************************************************
                 * Use a Hamcrest equalTo method to verify that the data of
                 * the 1st UserName in the list equals 'admininventa'
                 ******************************************************/
                        body("data.username[0]", equalTo("admininventa"));
    }

    /*******************************************************
     * Send a GET request to getUserSavedView with admin user id from Device/Asset Page
     * and check that the response has HTTP status code 200
     * and check that the response is in JSON format
     * and check that the response is in the body Meta.Status is equal to Success
     ******************************************************/
    @Test
    @Title("Get Customize View of Asset Page By User Id")
    public void getAssetPageUserSavedView() throws IOException {
        String adminUserId;
        adminUserId = getIdFromURL(GET_ADMIN_USER_ID);
        given().
                spec(requestSpec).
                when().
                get(ADMIN_USER_ENDPOINT + ADMIN_USER_SAVED_VIEW + "?userId=" + adminUserId + "&fieldEntity=devices").
                then().
                spec(responseSpec);
    }

    /*******************************************************
     * Send a GET request to /getUserSavedView with admin user id from User page
     * and check that the response has HTTP status code 200
     * and check that the response is in JSON format
     * and check that the response is in the body Meta.Status is equal to Success
     ******************************************************/
    @Test
    @Title("Get Customize View of Users Page By User Id")
    public void getUserPageUserSavedView() throws IOException {
        String adminUserId;
        adminUserId = getIdFromURL(GET_ADMIN_USER_ID);
        given().
                spec(requestSpec).
                when().
                get(ADMIN_USER_ENDPOINT + ADMIN_USER_SAVED_VIEW + "?userId=" + adminUserId + "&fieldEntity=users").
                then().
                spec(responseSpec);

    }

    /*******************************************************
     * Send a GET request to /adminUsers/getUserPermission
     * and check that the response has HTTP status code 200
     * and check that the response is in JSON format
     * and check that the response is in the body Meta.Status is equal to Success
     ******************************************************/
    @Test
    @Title("Get All User Permission")
    public void getUserPermission() {
        given().
                spec(requestSpec).
                when().
                get(ADMIN_USER_ENDPOINT + USER_PERMISSION).
                then().
                spec(responseSpec);

    }


}
