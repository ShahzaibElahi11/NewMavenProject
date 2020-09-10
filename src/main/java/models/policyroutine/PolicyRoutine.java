package models.policyroutine;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@Builder
public class PolicyRoutine {

    @JsonProperty
    private String name;

    @JsonProperty
    private PolicyRoutineMainAction mainAction;


}
