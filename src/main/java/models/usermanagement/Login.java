package models.usermanagement;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {
    @JsonProperty
    private String username;

    @JsonProperty
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
