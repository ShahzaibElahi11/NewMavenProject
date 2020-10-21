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

import static constants.Constants.*;
import static constants.Constants.ALL_ADMIN_USERNAME;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminUsersControllerTest extends BaseTest {

    public static boolean isPreviousTestPass;
    //Fake Class
    Faker faker = new Faker();
    protected final String userName = faker.name().username();
    protected final String firstName = faker.name().firstName();
    protected final String lastName = faker.name().lastName();
    protected final String emailAddress = faker.internet().emailAddress();
    protected final String phoneNumber = faker.phoneNumber().cellPhone();
    protected final String randomNnumber = String.valueOf(faker.number().randomNumber()); //will use later.

    @Test
    @Title("Create New User in the Application")
    public void testA_PostCreateUser() throws IOException  {
        String adminRoleId;
        adminRoleId = getIdFromURL(GET_ROLE_ID_FOR_USER);

        isPreviousTestPass = false;
        AdminUser adminUser =  AdminUser.builder()
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

    @Test
    @Title("Update User Information")
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
                .firstName("Update "+firstName)
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
                body("data._id", equalTo(adminUserId));
    }

    @Test
    @Title("Get All User Permission")
    public void testD_putPasswordChange() throws IOException {
        String currentAdminId;
        currentAdminId = getIdFromURL(GET_ADMIN_USER_ID);
        ChangePassword changePassword =  ChangePassword.builder()
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


    @Test
    @Title("Delete User Information")
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
                body("data.content[0].userName", equalTo("admininventa"));
    }

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
                body("data.username[0]", equalTo("admininventa"));
    }

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
