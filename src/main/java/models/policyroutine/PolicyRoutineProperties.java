package models.policyroutine;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PolicyRoutineProperties {

    @JsonProperty
    private String username;

    @JsonProperty
    private String password;


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public PolicyRoutineProperties() {
    }

    public PolicyRoutineProperties(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static class Builder {
        private String username;
        private String password;

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;

        }


        public PolicyRoutineProperties build() {
            return new PolicyRoutineProperties(username, password);

        }
    }


}
