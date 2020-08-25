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
import utils.BaseClass;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LDAPTest extends BaseClass {

    public static boolean isPreviousTestPass;
    protected static final String LDAP_MACHINE_IP = ApplicationConfiguration.getLdapMachineIp();
    protected static final String LDAP_DOMAIN = ApplicationConfiguration.getLdapDomain();
    protected static final String AD_USERNAME = ApplicationConfiguration.getAdUsername();
    protected static final String AD_PASSWORD = ApplicationConfiguration.getAdPassword();


    @Test
    @Title("Post LDAP Configuration")
    public void testA_PostConfigureLDAP() {
        isPreviousTestPass = false;
        LdapConfiguration ldapConfiguration = new LdapConfiguration(LDAP_MACHINE_IP, LDAP_DOMAIN, ROLE_ID);
        Response response = Ldap.postLdapConfiguration(ldapConfiguration);
        if(response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Post AD Login")
    public void testB_PostADLogin() {
        Assume.assumeTrue(isPreviousTestPass==true);
        isPreviousTestPass = false;
        AdLogin adLogin = new AdLogin(AD_USERNAME, AD_PASSWORD);
        Response response = Ldap.postAdLogin(adLogin);
        if(response.getStatusCode() == HttpStatus.SC_OK)
            isPreviousTestPass = true;
        Assert.assertEquals("Invalid Status in Response: ", response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Title("Get LDAP Configuration")
    public void testC_getLDAPConfiguration() {
        Response response = Ldap.getLDAPConfiguration();
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(equalTo("application/json"))
                .body("data.role", equalTo(ROLE_ID));    }
}
