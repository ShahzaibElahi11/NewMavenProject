package models.systemconfiguration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LdapConfiguration {

    @JsonProperty("ldap.url")
    private String url;

    @JsonProperty("ldap.domain")
    private String domain;

    @JsonProperty("ldap.role")
    private String role;

}
