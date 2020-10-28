package testcases;

import io.restassured.response.Response;
import models.systemconfiguration.LdapConfiguration;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import models.systemconfiguration.Login;
import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import utils.ApplicationConfiguration;
import utils.BaseTest;


import java.io.IOException;

import static constants.ConfigControllerConstants.*;
import static constants.RoleControllerConstants.GET_ROLE_ID;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.apache.http.HttpStatus.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LDAPControllerTest extends BaseTest {

    public static boolean isPreviousTestPass;
    protected static final String LDAP_MACHINE_IP = ApplicationConfiguration.getLdapMachineIp();
    protected static final String LDAP_DOMAIN = ApplicationConfiguration.getLdapDomain();
    protected static final String AD_USERNAME = ApplicationConfiguration.getLdapUsername();
    protected static final String AD_PASSWORD = ApplicationConfiguration.getLdapPassword();
    protected static final String USERNAME = ApplicationConfiguration.getUsername();
    protected static final String PASSWORD = ApplicationConfiguration.getPassword();

    @Test
    @Title("Post LDAP Configuration")
    public void testA_PostConfigureLDAP() throws IOException {
        isPreviousTestPass = false;
        String roleId;
        roleId = getIdFromURL(GET_ROLE_ID);
        LdapConfiguration ldapConfiguration = new LdapConfiguration(LDAP_MACHINE_IP, LDAP_DOMAIN, roleId);
        Response response = given().
                spec(requestSpec).
                and().
                body(ldapConfiguration).
                when().
                post(CONFIG_ENDPOINT);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                assertThat().
                statusCode(SC_OK);
    }


    @Test
    @Title("Post AD Login")
    public void testB_PostADLogin() {
        Assume.assumeTrue(isPreviousTestPass == true);
        isPreviousTestPass = false;
        Login adLogin = new Login(AD_USERNAME, AD_PASSWORD);
        Response response = given().
                spec(requestSpec).
                and().
                body(adLogin).
                when().
                post(AD_LOGIN);
        if (response.getStatusCode() == SC_OK)
            isPreviousTestPass = true;
        response.
                then().
                assertThat().
                statusCode(SC_OK);
    }

    @Test
    @Title("Get LDAP Configuration")
    public void testC_getLDAPConfiguration() throws IOException {
        String roleId;
        roleId = getIdFromURL(GET_ROLE_ID);
        given().
                spec(requestSpec).
                when().
                get(CONFIG_ENDPOINT + CONFIG_TYPE + LDAP).
                then().
                spec(responseSpec).
                and().
                body("data.role", equalTo(roleId));
    }

    @Test
    @Title("Post AD Login")
    public void testD_applicationLogin() {
        Login login = new Login(USERNAME, PASSWORD);
        given().
                spec(requestSpec).
                and().
                body(login).
                when().
                post(LOGIN).
                then().
                assertThat().
                statusCode(SC_OK);
    }


}

