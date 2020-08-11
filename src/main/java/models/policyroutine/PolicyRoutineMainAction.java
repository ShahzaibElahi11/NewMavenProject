package models.policyroutine;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PolicyRoutineMainAction {

    @JsonProperty
    private String action;

    @JsonProperty
    private PolicyRoutineProperties properties;

    //Getter
    public String getAction() {
        return action;
    }

    public PolicyRoutineProperties getProperties() {
        return properties;
    }

    // default constructor required by Jackson
    public PolicyRoutineMainAction() { }

    public PolicyRoutineMainAction(String action, PolicyRoutineProperties properties) {
        this.action = action;
        this.properties = properties;
    }

    public static class Builder {
        private String action;
        private PolicyRoutineProperties properties;

        public Builder setAction(String action) {
            this.action = action;
            return this;
        }

        public Builder setProperties(PolicyRoutineProperties properties) {
            this.properties = properties;
            return this;

        }

        public PolicyRoutineMainAction build(){
            return new PolicyRoutineMainAction(action, properties);
    }

    }

    }

