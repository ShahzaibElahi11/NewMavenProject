package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnforcePolicyOnUser {
    @JsonProperty
    private String name;

    public EnforcePolicyOnUser(String name) {
        this.name = name;
    }
}
