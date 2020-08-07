package models;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PolicyRoutineMainAction {

    @JsonProperty
    private String action;

    public PolicyRoutineMainAction(String action) {
        this.action = action;
    }
}

