package models.policyroutine;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PolicyRoutine {

    @JsonProperty
    private String name;

    @JsonProperty
    private PolicyRoutineMainAction mainAction;

    public PolicyRoutine(String name, PolicyRoutineMainAction mainAction) {
        this.name = name;
        this.mainAction = mainAction;
    }
}
