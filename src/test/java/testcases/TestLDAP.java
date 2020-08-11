package testcases;

import api.LdapApis;
import io.restassured.response.Response;
import models.ldap.LdapConfiguration;
import org.apache.http.HttpStatus;
import models.ldap.AdLogin;
import org.junit.Test;
import utils.ApplicationConfiguration;
import utils.BaseClass;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestLDAP extends BaseClass {


    protected static final String LDAP_MACHINE_IP = ApplicationConfiguration.getLdapMachineIp();
    protected static final String LDAP_DOMAIN = ApplicationConfiguration.getLdapDomain();
    protected static final String AD_USERNAME = ApplicationConfiguration.getAdUsername();
    protected static final String AD_PASSWORD = ApplicationConfiguration.getAdPassword();


    @Test
    public void PostConfigureLDAP() {
        LdapConfiguration ldapConfiguration = new LdapConfiguration(LDAP_MACHINE_IP, LDAP_DOMAIN, ROLE_ID);
        Response response = LdapApis.postLdapConfiguration(ldapConfiguration);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void GetLDAPConfiguration() {
        Response response = LdapApis.getLDAPConfiguration();
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_OK));
    }


    @Test
    public void PostADLogin() {
        //
        AdLogin adLogin = new AdLogin(AD_USERNAME, AD_PASSWORD);
        Response response = LdapApis.postAdLogin(adLogin);
        assertThat(response.getStatusCode(), equalTo(200));
    }
}
