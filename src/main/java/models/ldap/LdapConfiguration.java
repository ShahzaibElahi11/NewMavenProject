package models.ldap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LdapConfiguration {

    @JsonProperty("ldap.url")
    private String url;

    @JsonProperty("ldap.domain")
    private String domain;

    @JsonProperty("ldap.role")
    private String role;

    public LdapConfiguration(String url, String domain, String role) {
        this.url = url;
        this.domain = domain;
        this.role = role;
    }
}
