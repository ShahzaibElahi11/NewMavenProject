package models;

import com.fasterxml.jackson.annotation.JsonProperty;

//        String json = "{\"name\": \"Automation Policy Routine # " + value + "\",\"mainAction\": {\"action\": \"RC02\", \"properties\": {\"user\": \"user1\", \"password\":\"ppp\"}},\"successCount\": 1}";
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
