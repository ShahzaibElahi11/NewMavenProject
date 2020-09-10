package models.policyroutine;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EnforcePolicyOnDevice {

    @JsonProperty
    private String hostName;
}
