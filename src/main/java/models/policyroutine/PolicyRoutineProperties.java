package models.policyroutine;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@Builder
public class PolicyRoutineProperties {

    @JsonProperty
    private String username;

    @JsonProperty
    private String password;


}
