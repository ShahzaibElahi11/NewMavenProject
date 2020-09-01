package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.ldap.AdLogin;
import models.ldap.LdapConfiguration;
import utils.BaseAPI;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

public class Ldap extends BaseAPI {

    public static Response postLdapConfiguration(LdapConfiguration ldapConfiguration) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(ldapConfiguration)
                .when()
                .post(BASE_ENDPOINT_INVENTA + CONFIG_ENDPOINT);

    }

    public static Response getLDAPConfiguration() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(BASE_ENDPOINT_INVENTA + CONFIG_ENDPOINT + CONFIG_TYPE);
    }

    public static Response postAdLogin(AdLogin adLogin) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(adLogin)
                .when()
                .post(BASE_ENDPOINT_INVENTA + AD_LOGIN);
    }
}
