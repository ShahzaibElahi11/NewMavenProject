package models.policyroutine;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@AllArgsConstructor
@Builder
public class PolicyRoutineMainAction {

    @JsonProperty
    private String action;

    @JsonProperty
    private PolicyRoutineProperties properties;

}

