package testcases;

import api.Ldap;
import io.restassured.response.Response;
import models.ldap.LdapConfiguration;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.http.HttpStatus;
import models.ldap.AdLogin;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import utils.ApplicationConfiguration;
import utils.BaseTest;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static utils.BaseAPI.getIdFromURL;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LDAPTest extends BaseTest {

    public static boolean isPreviousTestPass;
    protected static final String LDAP_MACHINE_IP = ApplicationConfiguration.getLdapMachineIp();
    protected static final String LDAP_DOMAIN = ApplicationConfiguration.getLdapDomain();
    protected static final String AD_USERNAME = ApplicationConfiguration.getAdUsername();
    protected static final String AD_PASSWORD = ApplicationConfiguration.getAdPassword();

    public static String ROLE_ID;

    static {
        try {
            ROLE_ID = getIdFromURL("http://inventaserver:9092/role/getAllRole?page=0&size=1&sort=dateCreated,desc");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Title("Post LDAP Configuration")
    public void testA_PostConfigureLDAP() {
        isPreviousTestPass = false;
        LdapConfiguration ldapConfiguration = new LdapConfiguration(LDAP_MACHINE_IP, LDAP_DOMAIN, ROLE_ID);
        Response response = Ldap.postLdapConfiguration(ldapConfiguration);
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Post AD Login")
    public void testB_PostADLogin() {
        Assume.assumeTrue(isPreviousTestPass == false);
        isPreviousTestPass = false;
        AdLogin adLogin = new AdLogin(AD_USERNAME, AD_PASSWORD);
        Response response = Ldap.postAdLogin(adLogin);
        if (response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json;charset=ISO-8859-1"))
                .body("username", equalTo("shahzaib1"));
    }

    @Test
    @Title("Get LDAP Configuration")
    public void testC_getLDAPConfiguration() {
        Response response = Ldap.getLDAPConfiguration();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data.role", equalTo(ROLE_ID));
    }
}
