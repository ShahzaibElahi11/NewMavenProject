package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.ldap.AdLogin;
import models.ldap.LdapConfiguration;
import utils.BaseClass;

import static io.restassured.RestAssured.given;

public class LdapApis extends BaseClass {

    public static final String CONFIG_ENDPOINT = "/config/";
    public static final String CONFIG_TYPE = "?type=ldap";
    public static final String AD_LOGIN = "/ad/login/";


    public static Response postLdapConfiguration(LdapConfiguration ldapConfiguration) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(ldapConfiguration)
                .when()
                .post(BASE_ENDPOINT + CONFIG_ENDPOINT);

    }

    public static Response getLDAPConfiguration() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .get(BASE_ENDPOINT + CONFIG_ENDPOINT + CONFIG_TYPE);
    }

    public static Response postAdLogin(AdLogin adLogin) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + token)
                .body(adLogin)
                .when()
                .post(BASE_ENDPOINT + AD_LOGIN);
    }
}
