package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdLogin {

    @JsonProperty
    private String username;

    @JsonProperty
    private String password;


    public AdLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
