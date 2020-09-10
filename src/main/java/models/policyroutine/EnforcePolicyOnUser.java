package models.policyroutine;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EnforcePolicyOnUser {

    @JsonProperty
    private String name;

}
