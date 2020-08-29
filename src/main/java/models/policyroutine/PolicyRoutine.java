package models.policyroutine;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PolicyRoutine {

    @JsonProperty
    private String name;

    @JsonProperty
    private PolicyRoutineMainAction mainAction;


    public String getName() {
        return name;
    }

    public PolicyRoutineMainAction getMainAction() {
        return mainAction;
    }

    // default constructor required by Jackson
    public PolicyRoutine() {
    }

    public PolicyRoutine(String name, PolicyRoutineMainAction mainAction) {
        this.name = name;
        this.mainAction = mainAction;
    }

    //Add Builder Class
    public static class Builder {

        private String name;
        private PolicyRoutineMainAction mainAction;


        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMainAction(PolicyRoutineMainAction mainAction) {
            this.mainAction = mainAction;
            return this;
        }


        public PolicyRoutine build() {
            return new PolicyRoutine(name, mainAction);
        }
    }


}
