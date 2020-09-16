package testcases;

import models.ldap.LdapConfiguration;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import models.ldap.AdLogin;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import utils.ApplicationConfiguration;
import utils.BaseTest;


import static constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.apache.http.HttpStatus.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LDAPTest extends BaseTest {

    public static boolean isPreviousTestPass;
    protected static final String LDAP_MACHINE_IP = ApplicationConfiguration.getLdapMachineIp();
    protected static final String LDAP_DOMAIN = ApplicationConfiguration.getLdapDomain();
    protected static final String AD_USERNAME = ApplicationConfiguration.getAdUsername();
    protected static final String AD_PASSWORD = ApplicationConfiguration.getAdPassword();


    @Test
    @Title("Post LDAP Configuration")
    public void testA_PostConfigureLDAP() {
        LdapConfiguration ldapConfiguration = new LdapConfiguration(LDAP_MACHINE_IP, LDAP_DOMAIN, ROLE_ID);
        given().
                spec(requestSpec).
                and().
                body(ldapConfiguration).
                when().
                post(CONFIG_ENDPOINT).
                then().
                assertThat().
                statusCode(SC_OK);
    }


    @Test
    @Title("Post AD Login")
    public void testB_PostADLogin() {
        AdLogin adLogin = new AdLogin(AD_USERNAME, AD_PASSWORD);
        given().
                spec(requestSpec).
                and().
                body(adLogin).
                when().
                post(AD_LOGIN).
                then().
                assertThat().
                statusCode(SC_OK);



    }

    @Test
    @Title("Get LDAP Configuration")
    public void testC_getLDAPConfiguration() {
        given().
                spec(requestSpec).
                when().
                get(CONFIG_ENDPOINT + CONFIG_TYPE).
                then().
                spec(responseSpec).
                and().
                body("data.role", equalTo(ROLE_ID));

    }


    //I will implement on assume test Strategy

}

